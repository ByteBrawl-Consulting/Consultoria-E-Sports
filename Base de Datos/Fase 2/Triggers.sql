/* ORA-00054: resource busy and acquire with NOWAIT specified or timeout expired.
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
    -- Si el nï¿½mero de jugadores es 6 o mas --> Error
    IF num_jugadores >= 6 THEN
        RAISE_APPLICATION_ERROR(-20001, 'El equipo ya estï¿½ completo');
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
    -- Cuenta el número de equipos asociados a la competición
    SELECT COUNT(*)
    INTO equipos
    FROM equipo_competicion
    WHERE cod_competicion = :NEW.cod_compe;
    -- Si el número de equipos es impar, lanza un error
    IF MOD(equipos, 2) != 0 THEN
      RAISE_APPLICATION_ERROR(-20002, 'El número de equipos debe ser par');
    END IF;
  END IF;
END;    


/*SALARIO TOPE DE 200.000*/
CREATE OR REPLACE TRIGGER salario_maximo_jugadores
BEFORE INSERT OR UPDATE ON jugadores
FOR EACH ROW
DECLARE
    sueldo_total NUMBER;
BEGIN
    -- Calcular el sueldo total anual
    SELECT NVL(SUM(sueldo * 12), 0) INTO sueldo_total 
    FROM jugadores 
    WHERE cod_equipo = :NEW.cod_equipo;
    -- Agregar el sueldo del staff al cálculo del sueldo total anual
    SELECT NVL(SUM(sueldo * 12), 0) + sueldo_total INTO sueldo_total 
    FROM staff 
    WHERE cod_equipo = :NEW.cod_equipo;
    -- Ajustar el sueldo total anual según la operación
    IF INSERTING THEN
        sueldo_total := sueldo_total + (:NEW.sueldo * 12);
    ELSIF UPDATING THEN
        sueldo_total := sueldo_total - (:OLD.sueldo * 12) + (:NEW.sueldo * 12);
    END IF;
    -- Verificar si el sueldo total anual supera el límite de 200,000 euros
    IF sueldo_total > 200000 THEN
        RAISE_APPLICATION_ERROR(-20004, 'El sueldo supera 200,000 euros');
    END IF;
END;


CREATE OR REPLACE TRIGGER salario_maximo_staff
BEFORE INSERT OR UPDATE ON staff
FOR EACH ROW
DECLARE
    sueldo_total NUMBER;
BEGIN
    -- Calcular el sueldo total anual
    SELECT NVL(SUM(sueldo * 12), 0) INTO sueldo_total 
    FROM jugadores 
    WHERE cod_equipo = :NEW.cod_equipo;
    -- Agregar el sueldo del staff al cálculo del sueldo total anual
    SELECT NVL(SUM(sueldo * 12), 0) + sueldo_total INTO sueldo_total 
    FROM staff 
    WHERE cod_equipo = :NEW.cod_equipo;
    -- Ajustar el sueldo total anual según la operación
    IF INSERTING THEN
        sueldo_total := sueldo_total + (:NEW.sueldo * 12);
    ELSIF UPDATING THEN
        sueldo_total := sueldo_total - (:OLD.sueldo * 12) + (:NEW.sueldo * 12);
    END IF;
    -- Verificar si el sueldo total anual supera el límite de 200,000 euros
    IF sueldo_total > 200000 THEN
        RAISE_APPLICATION_ERROR(-20005, 'El sueldo supera 200,000 euros');
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
    -- Si no hay ningï¿½n entrenador --> Error
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
    -- Contar el nï¿½mero de asistentes en el equipo
    SELECT COUNT(*) INTO suma
    FROM staff
    WHERE cod_equipo = :new.cod_equipo 
    AND UPPER(cargo) = 'ASISTENTE';
    -- Si hay mï¿½s de un asistente --> Error
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
    -- Verificar si la competicion esta en curso
    SELECT curso INTO en_curso
    FROM competiciones
    WHERE cod_compe = :new.cod_equipo;
    -- Si esta en curso, impedir el insert
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
    -- Verificar si la competicion esta en curso
    SELECT curso INTO en_curso
    FROM competiciones
    WHERE cod_compe = :old.cod_equipo;
    -- Si esta en curso, impedir el update
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
    -- Verificar si la competicion esta en curso
    SELECT curso INTO en_curso
    FROM competiciones
    WHERE cod_compe = :old.cod_equipo;
    -- Si esta en curso, impedir el delete
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
  -- Verifica que la fecha del enfrentamiento = el dia de la jornada
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
  -- Verifica cuantos enfrentamientos tienen un equipo local en la misma jornada
  SELECT COUNT(*)
  INTO v_count_local
  FROM enfrentamientos
  WHERE cod_jornada = :new.cod_jornada
	AND cod_equipo_local = :new.cod_equipo_local
	AND cod_enfrentamiento != :new.cod_enfrentamiento;
  -- Verifica cuantos enfrentamientos tienen un equipo visitante en la misma jornada
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



