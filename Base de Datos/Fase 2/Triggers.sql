/* ORA-00054: resource busy and acquire with NOWAIT specified or timeout expired
alter session set ddl_lock_timeout = 1000; */

/*MAXIMO 6 JUGADORES EN EL EQUIPO*/
CREATE OR REPLACE TRIGGER max_jugadores
BEFORE INSERT ON jugadores
FOR EACH ROW
DECLARE
    num_jugadores NUMBER;
BEGIN
    -- Contar el numero de jugadores en el equipo actual
    SELECT COUNT(*) INTO num_jugadores 
    FROM jugadores WHERE cod_equipo = :new.cod_equipo;
    -- Si el numero de jugadores es 6 o mas --> Error
    IF num_jugadores >= 6 THEN
        RAISE_APPLICATION_ERROR(-20001, 'El equipo ya esta completo');
    END IF;
END;


/*MINIMO 2 JUGADORES EN EL EQUIPO*/
CREATE OR REPLACE TRIGGER min_jugadores
BEFORE INSERT ON equipo_competicion
FOR EACH ROW
DECLARE
  jugadores INTEGER;
BEGIN
  -- Contar el numero de jugadores en el equipo que se intenta anadir
  SELECT COUNT(*) INTO jugadores
  FROM jugadores
  WHERE cod_equipo = :NEW.cod_equipo;
  -- Si el numero de jugadores es menor que dos --> Error
  IF jugadores < 2 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Equipo con menos de 2 jugadores');
  END IF;
END;



/*NUMERO DE EQUIPOS PAR*/
CREATE OR REPLACE TRIGGER equipos_pares
BEFORE UPDATE OF curso ON competiciones
FOR EACH ROW
DECLARE
  equipos INTEGER;
BEGIN
  -- Comprueba si el cambio es de 0 a 1
  IF :OLD.curso = 0 AND :NEW.curso = 1 THEN
    -- Cuenta el numero de equipos asociados a la competicion
    SELECT COUNT(*)
    INTO equipos
    FROM equipo_competicion
    WHERE cod_competicion = :NEW.cod_compe;
    -- Si el numero de equipos es impar --> Error
    IF MOD(equipos, 2) != 0 THEN
      RAISE_APPLICATION_ERROR(-20002, 
      'El numero de equipos debe ser par para iniciar la compticion');
    END IF;
  END IF;
END;    


/*SALARIO TOPE DE 200.000 euros*/
CREATE OR REPLACE TRIGGER salario_maximo_jugadores
BEFORE INSERT OR UPDATE ON jugadores
FOR EACH ROW
DECLARE
    sueldo_total NUMBER;
BEGIN
    -- Calcular el sueldo total del equipo antes de la insercion o actualizacion
    SELECT NVL(SUM(sueldo), 0) INTO sueldo_total
    FROM jugadores
    WHERE cod_equipo = :new.cod_equipo;
    -- Si estamos insertando, sumar el nuevo sueldo
    IF INSERTING THEN
        sueldo_total := sueldo_total + :new.sueldo;
    ELSIF UPDATING THEN
        -- Si estamos actualizando, ajustar con el sueldo anterior y el nuevo
        sueldo_total := sueldo_total - :old.sueldo + :new.sueldo;
    END IF;
    -- Verificar si el sueldo total supera el limite de 200,000 euros
    IF sueldo_total > 200000 THEN
        RAISE_APPLICATION_ERROR(-20004, 
        'Sobrepasa el limite salarial para jugadores');
    END IF;
END;

CREATE OR REPLACE TRIGGER salario_maximo_staff
BEFORE INSERT OR UPDATE ON staff
FOR EACH ROW
DECLARE
  sueldo_total NUMBER;
BEGIN
  -- Calcular el sueldo actual del equipo
  SELECT NVL(SUM(sueldo), 0) INTO sueldo_total 
  FROM jugadores 
  WHERE cod_equipo = :NEW.cod_equipo;
  SELECT NVL(SUM(sueldo), 0) + sueldo_total INTO sueldo_total 
  FROM staff 
  WHERE cod_equipo = :NEW.cod_equipo;
  -- Verificar el sueldo despues de la insert o update
  IF INSERTING THEN
    sueldo_total := sueldo_total + :new.sueldo;
  ELSIF UPDATING THEN
    sueldo_total := sueldo_total - :old.sueldo + :new.sueldo;
  END IF;
  -- Si la suma es mayor de 200.000 euros --> Error
  IF sueldo_total > 200000 THEN
    RAISE_APPLICATION_ERROR(-20005, 'Sobrepasa de limite salarial');
  END IF;
END;


/*MINIMO UN ENTRENTADOR*/
CREATE OR REPLACE TRIGGER MIN_ENTRENADOR
BEFORE INSERT OR UPDATE ON STAFF
FOR EACH ROW
DECLARE
  SUMA NUMBER;
BEGIN
    -- CALCULAR LA CANTIDAD DE ENTRENADORES EXISTENTES EN EL EQUIPO
    SELECT COUNT(*) INTO SUMA
    FROM STAFF
    WHERE COD_EQUIPO = :NEW.COD_EQUIPO
    AND UPPER(CARGO) = 'ENTRENADOR';
    -- AJUSTAR SEGÚN LA OPERACION
    IF INSERTING THEN
        -- SI ESTAMOS INSERTANDO Y EL CARGO ES 'ENTRENADOR', INCREMENTAR SUMA
        IF UPPER(:NEW.CARGO) = 'ENTRENADOR' THEN
            SUMA := SUMA + 1;
        END IF;
    ELSIF UPDATING THEN
        -- SI ESTAMOS ACTUALIZANDO, AJUSTAR SEGUN EL CARGO ANTERIOR Y NUEVO
        IF UPPER(:OLD.CARGO) = 'ENTRENADOR' THEN
            SUMA := SUMA - 1;
        END IF;
        IF UPPER(:NEW.CARGO) = 'ENTRENADOR' THEN
            SUMA := SUMA + 1;
        END IF;
    END IF;
    -- SI DESPUES DEL AJUSTE NO HAY NINGUN ENTRENADOR, LANZAR ERROR
    IF SUMA = 0 THEN
        RAISE_APPLICATION_ERROR(-20006, 'EQUIPO SIN ENTRENADOR');
    END IF;
END;



/*MAXIMO UN ASISTENTE*/
CREATE OR REPLACE TRIGGER MAX_ASISTENTE
BEFORE INSERT OR UPDATE ON STAFF
FOR EACH ROW
DECLARE
    SUMA NUMBER;
BEGIN
    -- CONTAR EL NUMERO DE ASISTENTES EN EL EQUIPO ANTES DE LA OPERACION
    SELECT COUNT(*) INTO SUMA
    FROM STAFF
    WHERE COD_EQUIPO = :NEW.COD_EQUIPO 
    AND UPPER(CARGO) = 'ASISTENTE';
    -- AJUSTAR EL CONTEO SEGUN LA OPERACION
    IF INSERTING THEN
        -- SI ESTAMOS INSERTANDO Y EL CARGO ES 'ASISTENTE', INCREMENTAR SUMA
        IF UPPER(:NEW.CARGO) = 'ASISTENTE' THEN
            SUMA := SUMA + 1;
        END IF;
    ELSIF UPDATING THEN
        -- AJUSTAR SEGUN EL CARGO ANTERIOR Y EL NUEVO
        IF UPPER(:OLD.CARGO) = 'ASISTENTE' THEN
            SUMA := SUMA - 1;
        END IF;
        IF UPPER(:NEW.CARGO) = 'ASISTENTE' THEN
            SUMA := SUMA + 1;
        END IF;
    END IF;
    -- LANZAR ERROR SI HAY MAS DE UN ASISTENTE
    IF SUMA > 1 THEN
        RAISE_APPLICATION_ERROR(-20007, 
        'SOLO SE PERMITE UN ASISTENTE POR EQUIPO');
    END IF;
END;


/*BLOQUEO DE LA TABLA EQUIPOS CON LA COMPETICION EN CURSO*/
CREATE OR REPLACE TRIGGER bloqueo_equipo_competicion
BEFORE INSERT OR UPDATE OR DELETE ON equipo_competicion
FOR EACH ROW
DECLARE
    en_curso NUMBER;
BEGIN
    -- Verificar si la competicion esta en curso
    SELECT curso INTO en_curso
    FROM competiciones
    WHERE cod_compe = :new.cod_equipo;
    -- Si esta en curso, impedir el insert
    IF en_curso = 1 THEN
        RAISE_APPLICATION_ERROR(-20008, 'Competicion en curso');
    END IF;
END;

CREATE OR REPLACE TRIGGER bloqueo_jugadores
BEFORE INSERT OR UPDATE OR DELETE ON jugadores
FOR EACH ROW
DECLARE
    en_curso NUMBER;  -- Para verificar si la competición esta en curso
BEGIN
    -- Verificar si el equipo esta en una competición en curso
    SELECT COUNT(*) INTO en_curso
    FROM competiciones c
    JOIN equipo_competicion ec ON ec.cod_competicion = c.cod_compe
    JOIN equipos e ON ec.cod_equipo = e.cod_equipo
    WHERE e.cod_equipo = :NEW.cod_equipo
    AND c.curso = 1;
    -- Si la competicion está en curso, bloquear la operacion
    IF en_curso > 0 THEN
        RAISE_APPLICATION_ERROR(-20009, 'Competicion en curso');
    END IF;
END;


CREATE OR REPLACE TRIGGER bloqueo_staff
BEFORE INSERT OR UPDATE OR DELETE ON staff
FOR EACH ROW
DECLARE
    en_curso NUMBER;  -- Para verificar si la competicion esta en curso
BEGIN
    -- Verificar si el equipo está en una competición en curso
    SELECT COUNT(*) INTO en_curso
    FROM competiciones c
    JOIN equipo_competicion ec ON ec.cod_competicion = c.cod_compe
    JOIN equipos e ON ec.cod_equipo = e.cod_equipo
    WHERE e.cod_equipo = :NEW.cod_equipo
    AND c.curso = 1;
    -- Si la competicion está en curso, bloquear la operacion
    IF en_curso > 0 THEN
        RAISE_APPLICATION_ERROR(-20010, 'Competicion en curso');
    END IF;
END;



/*ENFRENTAMIENTOS EN EL MISMO DIA*/
CREATE OR REPLACE TRIGGER dia_enfrentamientos
BEFORE INSERT OR UPDATE
ON enfrentamientos
FOR EACH ROW
DECLARE
  v_dia DATE;
BEGIN
  -- Saber el dia del enfrentamiento
  SELECT dia INTO v_dia
  FROM jornadas
  WHERE cod_jornadas = :new.cod_jornada;
  -- Verifica que todos los enfrentamientos sean el mismo dia
  IF :new.fecha != v_dia THEN
	RAISE_APPLICATION_ERROR(-20011, 'Fechas diferentes');
  END IF;
END;


/*EQUIPOS SIN REPETIR EN ENFRENTAMIENTOS*/
CREATE OR REPLACE TRIGGER enfrentamiento_unico
BEFORE INSERT OR UPDATE
ON enfrentamientos
FOR EACH ROW
DECLARE
  v_count_local NUMBER;
  v_count_visitante NUMBER;
BEGIN
  -- Verifica cuantos enfrentamientos tienen el mismo equipo local 
  SELECT COUNT(*)
  INTO v_count_local
  FROM enfrentamientos
  WHERE cod_jornada = :new.cod_jornada
	AND cod_equipo_local = :new.cod_equipo_local
	AND cod_enfrentamiento != :new.cod_enfrentamiento;
  -- Verifica cuantos enfrentamientos tienen el mismo equipo visitante 
  SELECT COUNT(*)
  INTO v_count_visitante
  FROM enfrentamientos
  WHERE cod_jornada = :new.cod_jornada
	AND cod_equipo_visitante = :new.cod_equipo_visitante
	AND cod_enfrentamiento != :new.cod_enfrentamiento;
  -- Si ya hay varios enfrentamiento con el mismo equipo local --> Error
  IF v_count_local > 0 THEN
	RAISE_APPLICATION_ERROR(-20012, 'Equipo 2 veces local');
  END IF;
  -- Si ya hay varios enfrentamiento con el mismo equipo visitante --> Error
  IF v_count_visitante > 0 THEN
	RAISE_APPLICATION_ERROR(-20013,'Equipo 2 veces visitante');
  END IF;
END;



