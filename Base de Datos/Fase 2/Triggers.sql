alter session set ddl_lock_timeout = 1000;

/*MAXIMO 6 JUGADORES EN EL EQUIPO*/
CREATE OR REPLACE TRIGGER max_jugadores
BEFORE INSERT ON jugadores
FOR EACH ROW
DECLARE
    num_jugadores NUMBER;
BEGIN
    -- Contar el número de jugadores en el equipo actual
    SELECT COUNT(*) INTO num_jugadores 
    FROM jugadores WHERE cod_equipo = :new.cod_equipo;
    -- Si el número de jugadores es 6 o más --> Error
    IF num_jugadores >= 6 THEN
        RAISE_APPLICATION_ERROR(-20001, 'El equipo ya está completo');
    END IF;
END;


/*MINIMO 2 JUGADORES EN EL EQUIPO*/
CREATE OR REPLACE TRIGGER min_jugadores
BEFORE DELETE ON jugadores
FOR EACH ROW
DECLARE
    num_jugadores NUMBER;
BEGIN
    -- Contar el numero de jugadores del equipo
    SELECT COUNT (*) INTO num_jugadores
    FROM jugadores WHERE cod_equipo = :new.cod_equipo;
    -- Si el numero de jugadores es 2 o menos --> Error
    IF num_jugadores <= 2 THEN
        RAISE_APPLICATION_ERROR (-20002, 'Equipo con los minimos jugadores');
    END IF;
END;


/*NUMERO DE EQUIPOS PAR*/
CREATE OR REPLACE TRIGGER equipos_par
BEFORE INSERT OR UPDATE ON competiciones
FOR EACH ROW
DECLARE
    num_equipos NUMBER;
BEGIN
    --Comprobar que la competicion este en curso
    IF INSERTING OR (UPDATING AND :new.curso = 1) THEN
        --Contar equipos
        SELECT COUNT (*) INTO num_equipos
        FROM equipos;
        --Comprobar que lso equipos sean pares
        IF MOD (num_equipos,2) != 0 THEN
            --Numero impar --> Error
            RAISE_APPLICATION_ERROR (-20003, 'Equipos impares');
        END IF;
    END IF;
END;    


/*SALARIO TOPE DE 200.00€*/
CREATE OR REPLACE TRIGGER salario_maximo_jugadores
BEFORE INSERT OR UPDATE ON jugadores
FOR EACH ROW
DECLARE
    sueldo_total NUMBER;
BEGIN
    -- Calcular el sueldo total del equipo antes de la inserción o actualización
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

    -- Verificar si el sueldo total supera el límite de 200,000 euros
    IF sueldo_total > 200000 THEN
        RAISE_APPLICATION_ERROR(-20004, 'Sobrepasa el límite salarial para jugadores');
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
  -- Si la suma es mayor de 200.000€ --> Error
  IF sueldo_total > 200000 THEN
    RAISE_APPLICATION_ERROR(-20005, 'Sobrepasa de limite salarial');
  END IF;
END;


/*MINIMO UN ENTRENTADOR*/
CREATE OR REPLACE TRIGGER min_entrenador
AFTER INSERT OR UPDATE ON staff
FOR EACH ROW
DECLARE
  suma NUMBER;
BEGIN
    -- Comprueba si el equipo del staff tiene al menos un entrenador
    SELECT COUNT(*) INTO suma
    FROM staff
    WHERE cod_equipo = :new.cod_equipo
    AND UPPER(cargo) = 'ENTRENADOR';
    -- Si no hay ningún entrenador --> Error
    IF suma = 0 THEN
        RAISE_APPLICATION_ERROR(-20006, 'Equipo sin entrenador');
    END IF;
END;


/*MAXIMO UN ASISTENTE*/
CREATE OR REPLACE TRIGGER max_asistente
AFTER INSERT OR UPDATE ON staff
FOR EACH ROW
DECLARE
    suma NUMBER;
BEGIN
    -- Contar el número de asistentes en el equipo
    SELECT COUNT(*) INTO suma
    FROM staff
    WHERE cod_equipo = :new.cod_equipo 
    AND UPPER(cargo) = 'ASISTENTE';
    -- Si hay más de un asistente --> Error
    IF suma > 1 THEN
        RAISE_APPLICATION_ERROR(-20007, 'Equipo con asistente');
    END IF;
END;


/*BLOQUEO DE LA TABLA EQUIPOS CON LA COMPETICION EN CURSO*/
CREATE OR REPLACE TRIGGER insert_competicion
BEFORE INSERT ON equipos
FOR EACH ROW
DECLARE
    en_curso NUMBER;
BEGIN
    -- Verificar si la competición está en curso
    SELECT curso INTO en_curso
    FROM competiciones
    WHERE cod_compe = :new.cod_equipo;
    -- Si está en curso, impedir el insert
    IF en_curso = 1 THEN
        RAISE_APPLICATION_ERROR(-20008, 'Competicion en curso');
    END IF;
END;

CREATE OR REPLACE TRIGGER update_competicion
BEFORE UPDATE ON equipos
FOR EACH ROW
DECLARE
    en_curso NUMBER;
BEGIN
    -- Verificar si la competición está en curso
    SELECT curso INTO en_curso
    FROM competiciones
    WHERE cod_compe = :old.cod_equipo;
    -- Si está en curso, impedir el update
    IF en_curso = 1 THEN
        RAISE_APPLICATION_ERROR(-20009, 'Competicion en curso');
    END IF;
END;

CREATE OR REPLACE TRIGGER delete_competicion
BEFORE DELETE ON equipos
FOR EACH ROW
DECLARE
    en_curso NUMBER;
BEGIN
    -- Verificar si la competición está en curso
    SELECT curso INTO en_curso
    FROM competiciones
    WHERE cod_compe = :old.cod_equipo;
    -- Si está en curso, impedir el delete
    IF en_curso = 1 THEN
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
  -- Verifica que la fecha del enfrentamiento sea la misma que el día de la jornada
  IF :new.fecha != v_dia THEN
	RAISE_APPLICATION_ERROR(-20011, 'Fechas diferentes.');
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
  -- Verifica cuántos enfrentamientos tienen el mismo equipo local en la misma jornada
  SELECT COUNT(*)
  INTO v_count_local
  FROM enfrentamientos
  WHERE cod_jornada = :new.cod_jornada
	AND cod_equipo_local = :new.cod_equipo_local
	AND cod_enfrentamiento != :new.cod_enfrentamiento;
  -- Verifica cuántos enfrentamientos tienen el mismo equipo visitante en la misma jornada
  SELECT COUNT(*)
  INTO v_count_visitante
  FROM enfrentamientos
  WHERE cod_jornada = :new.cod_jornada
	AND cod_equipo_visitante = :new.cod_equipo_visitante
	AND cod_enfrentamiento != :new.cod_enfrentamiento;
  -- Si ya hay un enfrentamiento con el mismo equipo local en la misma jornada, lanzar error
  IF v_count_local > 0 THEN
	RAISE_APPLICATION_ERROR(-20012, 'Equipo 2 veces local');
  END IF;
  -- Si ya hay un enfrentamiento con el mismo equipo visitante en la misma jornada, lanzar error
  IF v_count_visitante > 0 THEN
	RAISE_APPLICATION_ERROR(-20013,'Equipo 2 veces visitante');
  END IF;
END;



