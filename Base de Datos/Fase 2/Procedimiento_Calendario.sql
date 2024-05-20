/*GEENRAR CALENDARIO*/
CREATE OR REPLACE PROCEDURE GENERAR_CALENDARIO(
    p_cod_compe IN NUMBER
)
AS
    CURSOR equipos_cur IS
        SELECT COD_EQUIPO
        FROM EQUIPO_COMPETICION
        WHERE COD_COMPETICION = p_cod_compe;

    v_num_equipos NUMBER;
    v_num_jornadas NUMBER;
    v_jornada_date DATE := SYSDATE;
    v_cod_jornada NUMBER;
    TYPE equipo_tab IS TABLE OF NUMBER;
    equipos equipo_tab;
    v_temp_equipo NUMBER;

BEGIN
    -- Obtener el número de equipos en la competición
    OPEN equipos_cur;
    FETCH equipos_cur BULK COLLECT INTO equipos;
    CLOSE equipos_cur;

    v_num_equipos := equipos.COUNT;
    v_num_jornadas := v_num_equipos - 1;

    -- Crear jornadas y enfrentamientos
    FOR i IN 1..v_num_jornadas LOOP
        -- Insertar nueva jornada
        INSERT INTO JORNADAS (NUM_JORNADA, DIA, COD_COMPE)
        VALUES (i, v_jornada_date, p_cod_compe)
        RETURNING COD_JORNADAS INTO v_cod_jornada;

        -- Generar enfrentamientos para la jornada
        FOR j IN 1..FLOOR(v_num_equipos / 2) LOOP
            -- Enfrentamientos (circular)
            DECLARE
                v_local NUMBER := equipos(j);
                v_visitante NUMBER := equipos(v_num_equipos - j + 1);
            BEGIN
                INSERT INTO ENFRENTAMIENTOS (FECHA, COD_JORNADA, HORA, COD_EQUIPO_LOCAL, COD_EQUIPO_VISITANTE)
                VALUES (v_jornada_date, v_cod_jornada, '20:00', v_local, v_visitante);
            END;
        END LOOP;

        -- Rotar los equipos para la siguiente jornada (excepto el primer equipo)
        v_temp_equipo := equipos(2);
        FOR k IN 2..(v_num_equipos - 1) LOOP
            equipos(k) := equipos(k + 1);
        END LOOP;
        equipos(v_num_equipos) := v_temp_equipo;

        -- Incrementar la fecha de la jornada
        v_jornada_date := v_jornada_date + 7;
    END LOOP;
END;
/







