/*MAXIMO 6 JUGADORES EN EL EQUIPO*/
CREATE OR REPLACE TRIGGER max_jugadores
BEFORE INSERT ON jugadores
FOR EACH ROW
DECLARE
    num_jugadores NUMBER;
BEGIN
    -- Contar el n�mero de jugadores en el equipo actual
    SELECT COUNT(*) INTO num_jugadores 
    FROM jugadores WHERE id_equipo = :new.id_equipo;
    -- Si el n�mero de jugadores es 6 o m�s --> Error
    IF num_jugadores >= 6 THEN
        RAISE_APPLICATION_ERROR(-20001, 'El equipo ya est� completo');
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
    SELECT COUNT (*) INTO num_jugaores
    FROM jugadores WHERE id_equipo = :new.id_equipo;
    -- Si el numero de jugadores es 2 o menos --> Error
    IF num_jugadores <= 2 THEN
        RAISE_APPLICATION_ERROR (-20002, 'Equipo con los minimos jugadores');
    END IF;
END;


/*NUMERO DE EQUIPOS PAR*/
CREATE OR REPLACE TRIGGER equipos_par
BEFORE INSERT OR UPDATE ON competicion
FOR EACH ROW
DECLARE
    num_equipos NUMBER;
BEGIN
    --Comprobar que la competicion este en curso
    IF INSERTING OR (UPDATING AND :new.en_curso = 1) THEN
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


/*SALARIO TOPE DE 200.00�*/
CREATE OR REPLACE TRIGGER salario_maximo_jugadores
BEFORE INSERT OR UPDATE ON jugadores
FOR EACH ROW
DECLARE
    sueldo_total NUMBER;
BEGIN
    --Calcular el sueldo actual del equipo
    SELECT NVL(SUM(sueldo),0) INTO sueldo_total
    FROM jugadores
    WHERE cod_equipo = :new.cod_equipo;
    SELECT NVL(SUM(sueldo),0) + sueldo_total INTO sueldo_total
    FROM staff
    WHERE cod_staff = :new.cod_staff;
    --Verificar el sueldo despues de la insert o update
    IF INSERTING THEN
        sueldo_total := sueldo_total + :new.sueldo;
    ELSIF UPDATING THEN
        sueldo_total := sueldo_total - :old.sueldo + :new.sueldo;
    END IF;
    --Si la suma es mayor de 200.00� --> Error
    IF sueldo_total > 200000 THEN
        RAISE_APPLICATION_ERROR (-20004, 'Sobrepasa de limite salarial');
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
  WHERE id_equipo = :NEW.id_equipo;
  SELECT NVL(SUM(sueldo), 0) + sueldo_total INTO sueldo_total 
  FROM staff 
  WHERE id_equipo = :NEW.id_equipo;
  -- Verificar el sueldo despues de la insert o update
  IF INSERTING THEN
    sueldo_total := sueldo_total + :new.sueldo;
  ELSIF UPDATING THEN
    sueldo_total := sueldo_total - :old.sueldo + :new.sueldo;
  END IF;
  -- Si la suma es mayor de 200.000� --> Error
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
    WHERE equipo_id = :new.equipo_id
    AND UPPER(puesto) = 'ENTRENADOR';
    -- Si no hay ning�n entrenador --> Error
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
    -- Contar el n�mero de asistentes en el equipo
    SELECT COUNT(*) INTO suma
    FROM staff
    WHERE cod_equipo = :new.cod_equipo 
    AND UPPER(puesto) = 'ASISTENTE';
    -- Si hay m�s de un asistente --> Error
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
    -- Verificar si la competici�n est� en curso
    SELECT curso INTO en_curso
    FROM competiciones
    WHERE cod_competicion = :new.cod_equipo;
    -- Si est� en curso, impedir el insert
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
    -- Verificar si la competici�n est� en curso
    SELECT curso INTO en_curso
    FROM competiciones
    WHERE cod_competicion = :old.cod_equipo;
    -- Si est� en curso, impedir el update
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
    -- Verificar si la competici�n est� en curso
    SELECT curso INTO en_curso
    FROM competiciones
    WHERE cod_competicion = :old.cod_equipo;
    -- Si est� en curso, impedir el delete
    IF en_curso = 1 THEN
        RAISE_APPLICATION_ERROR(-20010, 'Competicion en curso');
    END IF;
END;


