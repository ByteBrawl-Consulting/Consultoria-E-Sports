/*MAXIMO 6 JUGADORES EN EL EQUIPO*/
CREATE OR REPLACE TRIGGER max_jugadores
BEFORE INSERT ON jugadores
FOR EACH ROW
DECLARE
    num_jugadores NUMBER;
BEGIN
    -- Contar el número de jugadores en el equipo actual
    SELECT COUNT(*) INTO num_jugadores 
    FROM jugadores WHERE id_equipo = :new.id_equipo;
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


/*SALARIO TOPE DE 200.00€*/
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
    --Si la suma es mayor de 200.00€ --> Error
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

  -- Si la suma es mayor de 200.00€ --> Error
  IF sueldo_total > 200000 THEN
    RAISE_APPLICATION_ERROR(-20005, 'Sobrepasa de limite salarial');
  END IF;
END;
