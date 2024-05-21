/* ORA-00054: resource busy and acquire with NOWAIT specified or timeout expired
alter session set ddl_lock_timeout = 500; */
/*alter session set plscope_settings = 'IDENTIFIERS:NONE';*/
/*MAXIMO 6 JUGADORES EN EL EQUIPO*/
create or replace NONEDITIONABLE TRIGGER MAX_JUGADORES
FOR INSERT OR UPDATE ON JUGADORES
COMPOUND TRIGGER
    NUM_JUGADORES NUMBER;
    V_COD_EQUIPO NUMBER;
BEFORE EACH ROW IS
    BEGIN
    V_COD_EQUIPO := :NEW.COD_EQUIPO;  
    END BEFORE EACH ROW;
AFTER STATEMENT IS
    BEGIN
    -- Contar el numero de jugadores en el equipo actual
    SELECT COUNT(*) INTO NUM_JUGADORES 
        FROM JUGADORES WHERE COD_EQUIPO = V_COD_EQUIPO;
        -- Si el numero de jugadores es 6 o mas --> Error
        IF NUM_JUGADORES >= 6 THEN
            RAISE_APPLICATION_ERROR(-20001, 'El equipo ya esta completo');
        END IF;
    END AFTER STATEMENT;
END;
/

/*MINIMO 2 JUGADORES EN EL EQUIPO*/
CREATE OR REPLACE TRIGGER MIN_JUGADORES
BEFORE INSERT OR UPDATE ON EQUIPO_COMPETICION
FOR EACH ROW
DECLARE
  JUGADORES INTEGER;
BEGIN
  -- Contar el numero de jugadores en el equipo que se intenta anadir
  SELECT COUNT(*) INTO JUGADORES
  FROM JUGADORES
  WHERE COD_EQUIPO = :NEW.COD_EQUIPO;
  -- Si el numero de jugadores es menor que dos --> Error
  IF JUGADORES < 2 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Equipo con menos de 2 jugadores');
  END IF;
END;
/


/*NUMERO DE EQUIPOS PAR*/
CREATE OR REPLACE TRIGGER EQUIPOS_PARES
BEFORE UPDATE OF CURSO ON COMPETICIONES
FOR EACH ROW
DECLARE
  EQUIPOS INTEGER;
BEGIN
  -- Comprueba si el cambio es de 0 a 1
  IF :OLD.CURSO = 0 AND :NEW.CURSO = 1 THEN
    -- Cuenta el numero de equipos asociados a la competicion
    SELECT COUNT(*)
    INTO EQUIPOS
    FROM EQUIPO_COMPETICION
    WHERE COD_COMPETICION = :NEW.COD_COMPE;
    -- Si el numero de equipos es impar --> Error
    IF MOD(EQUIPOS, 2) != 0 THEN
      RAISE_APPLICATION_ERROR(-20002, 
      'El numero de equipos debe ser par para iniciar la compticion');
    END IF;
  END IF;
END;    
/

/*SALARIO TOPE DE 200.000 euros*/
CREATE OR REPLACE TRIGGER SALARIO_MAXIMO_JUGADORES
FOR INSERT OR UPDATE ON JUGADORES
COMPOUND TRIGGER
    SUELDO_TOTAL NUMBER := 0; -- Suma del sueldo
    V_COD_EQUIPO_NEW NUMBER; -- Código de equipo para nueva inserción o actualización
BEFORE EACH ROW IS
    BEGIN
        V_COD_EQUIPO_NEW := :NEW.COD_EQUIPO;
    END BEFORE EACH ROW;
AFTER STATEMENT IS
    BEGIN
        -- Calcular el sueldo total del equipo después de insert o update
        SELECT NVL(SUM(SUELDO), 0) INTO SUELDO_TOTAL
        FROM JUGADORES
        WHERE COD_EQUIPO = V_COD_EQUIPO_NEW;
        -- Verificar si el sueldo total supera el límite de 200,000 euros
        IF SUELDO_TOTAL > 200000 THEN
            RAISE_APPLICATION_ERROR(-20004, 
                'Sobrepasa el límite salarial para jugadores');
        END IF;
    END AFTER STATEMENT;
END;
/



CREATE OR REPLACE NONEDITIONABLE TRIGGER SALARIO_MAXIMO_STAFF
FOR INSERT OR UPDATE ON STAFF
COMPOUND TRIGGER
    SUELDO_TOTAL NUMBER := 0;
    V_COD_EQUIPO NUMBER;
    INCREMENTO_SALARIO NUMBER := 0;
    DECREMENTO_SALARIO NUMBER := 0;
BEFORE EACH ROW IS
    BEGIN
        V_COD_EQUIPO := :NEW.COD_EQUIPO;
        IF INSERTING THEN
            INCREMENTO_SALARIO := INCREMENTO_SALARIO + :NEW.SUELDO;
        ELSIF UPDATING THEN
            DECREMENTO_SALARIO := DECREMENTO_SALARIO + :OLD.SUELDO;
            INCREMENTO_SALARIO := INCREMENTO_SALARIO + :NEW.SUELDO;
        END IF;
    END BEFORE EACH ROW;

AFTER STATEMENT IS
    BEGIN
        -- Calcular el sueldo total actual del equipo
        SELECT NVL(SUM(SUELDO), 0) INTO SUELDO_TOTAL 
        FROM JUGADORES 
        WHERE COD_EQUIPO = V_COD_EQUIPO;
        SELECT NVL(SUM(SUELDO), 0) + SUELDO_TOTAL INTO SUELDO_TOTAL 
        FROM STAFF 
        WHERE COD_EQUIPO = V_COD_EQUIPO;
        -- Ajustar el sueldo total
        SUELDO_TOTAL := SUELDO_TOTAL - DECREMENTO_SALARIO + INCREMENTO_SALARIO;
        -- Verificar si el sueldo total supera los 200.000
        IF SUELDO_TOTAL > 200000 THEN
            RAISE_APPLICATION_ERROR(-20005, 'Sobrepasa de limite salarial');
        END IF;
    END AFTER STATEMENT;
END;
/


/*MINIMO UN ENTRENTADOR*/
CREATE OR REPLACE NONEDITIONABLE TRIGGER MIN_ENTRENADOR
FOR INSERT OR UPDATE ON STAFF
COMPOUND TRIGGER
    NUM_ENTRENADORES NUMBER := 0;
    V_COD_EQUIPO NUMBER;
    V_CARGO_ANTERIOR VARCHAR2(50);
    V_CARGO_NUEVO VARCHAR2(50);
BEFORE EACH ROW IS
    BEGIN
        V_CARGO_NUEVO := :NEW.CARGO;
        V_COD_EQUIPO := :NEW.COD_EQUIPO;
        IF UPDATING THEN
            V_CARGO_ANTERIOR := :OLD.CARGO;
        ELSE
            V_CARGO_ANTERIOR := NULL;
        END IF;
END BEFORE EACH ROW;
AFTER STATEMENT IS
    BEGIN
        -- Contar el número de entrenadores 
        SELECT COUNT(*) INTO NUM_ENTRENADORES 
        FROM STAFF 
        WHERE COD_EQUIPO = V_COD_EQUIPO 
        AND UPPER(CARGO) = 'ENTRENADOR';
        -- Reajuste si ha habido update
        IF UPDATING THEN
            IF V_CARGO_ANTERIOR IS NOT NULL AND UPPER(V_CARGO_ANTERIOR) = 'ENTRENADOR' THEN
                NUM_ENTRENADORES := NUM_ENTRENADORES + 1;
            END IF;
        END IF;
        -- Reajuste tras insert
        IF INSERTING THEN
            IF UPPER(V_CARGO_NUEVO) = 'ENTRENADOR' THEN
                NUM_ENTRENADORES := NUM_ENTRENADORES + 1;
            END IF;
        END IF;
        -- Verificar si después del ajuste no hay ningún entrenador
        IF NUM_ENTRENADORES = 0 THEN
            RAISE_APPLICATION_ERROR(-20006, 'EQUIPO SIN ENTRENADOR');
        END IF;
    END AFTER STATEMENT;
END;
/



/*MAXIMO UN ASISTENTE*/
CREATE OR REPLACE NONEDITIONABLE TRIGGER MAX_ASISTENTE
FOR INSERT OR UPDATE ON STAFF
COMPOUND TRIGGER
    -- Declaración de variables a nivel del trigger
    NUM_ASISTENTES NUMBER := 0;
    V_COD_EQUIPO NUMBER;
    V_CARGO_ANTERIOR VARCHAR2(50);
BEFORE EACH ROW IS
    BEGIN
        -- Capturar el equipo y el cargo del nuevo registro
        V_COD_EQUIPO := :NEW.COD_EQUIPO;
        -- Capturar el cargo anterior si es una actualización
        IF UPDATING THEN
            V_CARGO_ANTERIOR := :OLD.CARGO;
        ELSE
            V_CARGO_ANTERIOR := NULL;
        END IF;
    END BEFORE EACH ROW;
AFTER STATEMENT IS
    BEGIN
        -- Contar el número de asistentes
        SELECT COUNT(*) INTO NUM_ASISTENTES 
        FROM STAFF 
        WHERE COD_EQUIPO = V_COD_EQUIPO 
        AND UPPER(CARGO) = 'ASISTENTE';
        IF UPDATING THEN
            -- Reajustar por el cambio de cargo
            IF V_CARGO_ANTERIOR IS NOT NULL AND 
                UPPER(V_CARGO_ANTERIOR) = 'ASISTENTE' THEN
                NUM_ASISTENTES := NUM_ASISTENTES - 1;
            END IF;
        END IF;
        -- Verificar si hay más de un asistente
        IF NUM_ASISTENTES > 1 THEN
            RAISE_APPLICATION_ERROR(-20007, 
                'SOLO SE PERMITE UN ASISTENTE POR EQUIPO');
        END IF;
    END AFTER STATEMENT;
END;
/


/*BLOQUEO DE LA TABLA EQUIPOS CON LA COMPETICION EN CURSO*/
create or replace NONEDITIONABLE TRIGGER BLOQUEO_EQUIPO_COMPETICION
BEFORE INSERT OR DELETE ON EQUIPO_COMPETICION
FOR EACH ROW
DECLARE
    EN_CURSO NUMBER := 0;
BEGIN
    -- Verificar si la competicion esta en curso
    BEGIN
        SELECT CURSO INTO EN_CURSO
        FROM COMPETICIONES
        WHERE COD_COMPE = :NEW.COD_COMPETICION;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            EN_CURSO := 0;
        WHEN OTHERS THEN
            RAISE_APPLICATION_ERROR(-20009, 'Error desconocido al verificar la competición');
    END;

    IF EN_CURSO = 1 THEN
        RAISE_APPLICATION_ERROR(-20008, 'Competicion en curso');
    END IF;
END;
/

CREATE OR REPLACE TRIGGER BLOQUEO_JUGADORES_1
BEFORE INSERT OR UPDATE OR DELETE ON JUGADORES
FOR EACH ROW
DECLARE
    EN_CURSO NUMBER;  -- Para verificar si la competición esta en curso
BEGIN
    -- Verificar si el equipo esta en una competición en curso
    SELECT COUNT(*) INTO EN_CURSO
    FROM COMPETICIONES C
    JOIN EQUIPO_COMPETICION EC ON EC.COD_COMPETICION = C.COD_COMPE
    JOIN EQUIPOS E ON EC.COD_EQUIPO = E.COD_EQUIPO
    WHERE E.COD_EQUIPO = :NEW.COD_EQUIPO
    AND C.CURSO = 1;
    -- Si la competicion está en curso, bloquear la operacion
    IF EN_CURSO > 0 THEN
        RAISE_APPLICATION_ERROR(-20009, 'Competicion en curso');
    END IF;
END;
/

CREATE OR REPLACE TRIGGER BLOQUEO_STAFF
BEFORE INSERT OR UPDATE OR DELETE ON STAFF
FOR EACH ROW
DECLARE
    EN_CURSO NUMBER;  -- Para verificar si la competicion esta en curso
BEGIN
    -- Verificar si el equipo está en una competición en curso
    SELECT COUNT(*) INTO EN_CURSO
    FROM COMPETICIONES C
    JOIN EQUIPO_COMPETICION EC ON EC.COD_COMPETICION = C.COD_COMPE
    JOIN EQUIPOS E ON EC.COD_EQUIPO = E.COD_EQUIPO
    WHERE E.COD_EQUIPO = :NEW.COD_EQUIPO
    AND C.CURSO = 1;
    -- Si la competicion está en curso, bloquear la operacion
    IF EN_CURSO > 0 THEN
        RAISE_APPLICATION_ERROR(-20010, 'Competicion en curso');
    END IF;
END;
/


/*ENFRENTAMIENTOS EN EL MISMO DIA*/
CREATE OR REPLACE TRIGGER DIA_ENFRENTAMIENTOS
BEFORE INSERT OR UPDATE
ON ENFRENTAMIENTOS
FOR EACH ROW
DECLARE
  V_DIA DATE;
BEGIN
  -- Saber el dia del enfrentamiento
  SELECT DIA INTO V_DIA
  FROM JORNADAS
  WHERE COD_JORNADAS = :NEW.COD_JORNADA;
  -- Verifica que todos los enfrentamientos sean el mismo dia
  IF :NEW.FECHA != V_DIA THEN
	RAISE_APPLICATION_ERROR(-20011, 'Fechas diferentes');
  END IF;
END;
/

/*EQUIPOS SIN REPETIR EN ENFRENTAMIENTOS*/
CREATE OR REPLACE NONEDITIONABLE TRIGGER ENFRENTAMIENTO_UNICO
FOR INSERT OR UPDATE ON ENFRENTAMIENTOS
COMPOUND TRIGGER
  TYPE jornada_team IS RECORD (
    cod_jornada        enfrentamientos.cod_jornada%TYPE,
    cod_equipo_local   enfrentamientos.cod_equipo_local%TYPE,
    cod_equipo_visitante enfrentamientos.cod_equipo_visitante%TYPE,
    cod_enfrentamiento enfrentamientos.cod_enfrentamiento%TYPE
  );
  TYPE jornada_team_list IS TABLE OF jornada_team;
  jornada_team_tab jornada_team_list := jornada_team_list();
  BEFORE EACH ROW IS
  BEGIN
    jornada_team_tab.EXTEND;
    jornada_team_tab(jornada_team_tab.LAST).cod_jornada := :NEW.cod_jornada;
    jornada_team_tab(jornada_team_tab.LAST).cod_equipo_local := :NEW.cod_equipo_local;
    jornada_team_tab(jornada_team_tab.LAST).cod_equipo_visitante := :NEW.cod_equipo_visitante;
    jornada_team_tab(jornada_team_tab.LAST).cod_enfrentamiento := :NEW.cod_enfrentamiento;
  END BEFORE EACH ROW;
  AFTER STATEMENT IS
    v_count_local NUMBER;
    v_count_visitante NUMBER;
  BEGIN
    FOR i IN 1..jornada_team_tab.COUNT LOOP
      -- Verifica cuantos enfrentamientos tienen el mismo equipo local
      SELECT COUNT(*)
      INTO v_count_local
      FROM ENFRENTAMIENTOS
      WHERE COD_JORNADA = jornada_team_tab(i).cod_jornada
        AND COD_EQUIPO_LOCAL = jornada_team_tab(i).cod_equipo_local
        AND COD_ENFRENTAMIENTO != jornada_team_tab(i).cod_enfrentamiento;
      -- Verifica cuantos enfrentamientos tienen el mismo equipo visitante
      SELECT COUNT(*)
      INTO v_count_visitante
      FROM ENFRENTAMIENTOS
      WHERE COD_JORNADA = jornada_team_tab(i).cod_jornada
        AND COD_EQUIPO_VISITANTE = jornada_team_tab(i).cod_equipo_visitante
        AND COD_ENFRENTAMIENTO != jornada_team_tab(i).cod_enfrentamiento;
      -- Si ya hay varios enfrentamientos con el mismo equipo local --> Error
      IF v_count_local > 0 THEN
        RAISE_APPLICATION_ERROR(-20012, 'Equipo 2 veces local');
      END IF;
      -- Si ya hay varios enfrentamientos con el mismo equipo visitante --> Error
      IF v_count_visitante > 0 THEN
        RAISE_APPLICATION_ERROR(-20013, 'Equipo 2 veces visitante');
      END IF;
    END LOOP;
  END AFTER STATEMENT;
END;
/




/* CAMBIAR ESTADO (CERRAR PLAZO INSCRIPCION SI COMPETICION ESTA YA EN CURSO) */
CREATE OR REPLACE TRIGGER CERRAR_INSCRIPCION
BEFORE INSERT ON COMPETICIONES
FOR EACH ROW
BEGIN
    IF :NEW.FECHA_INICIO <= SYSDATE THEN
        :NEW.CURSO := 1;
    END IF;
END;
/

