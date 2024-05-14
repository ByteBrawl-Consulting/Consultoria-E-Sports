DROP TABLE temp_ultima_jornada_tab;

CREATE TABLE temp_ultima_jornada_tab (
  xml_data CLOB
);

DECLARE
    v_xml_data CLOB;
    v_ultima_jornada NUMBER;
BEGIN
    -- Obtener el número de la última jornada
    SELECT MAX(cod_jornadas) INTO v_ultima_jornada FROM jornadas;

    -- Generar XML con los datos de la última jornada
    SELECT XMLElement("Jornadas",
               XMLAgg(
                   XMLElement("Jornada",
                       XMLAttributes(j.cod_jornadas AS "Codigo_Jornada", j.num_jornada AS "Numero_Jornada"),
                       XMLAgg(
                           XMLElement("Enfrentamiento",
                               XMLForest(
                                   e.cod_enfrentamiento AS "Codigo_Enfrentamiento",
                                   el.nombre AS "Equipo_Local",
                                   ev.nombre AS "Equipo_Visitante",
                                   e.resultado AS "Ganador"
                               )
                           )
                       )
                   )
               )
           ).getClobVal()
    INTO v_xml_data
    FROM jornadas j
    LEFT JOIN enfrentamientos e ON j.cod_jornadas = e.cod_jornada
    LEFT JOIN equipos el ON e.cod_equipo_local = el.cod_equipo
    LEFT JOIN equipos ev ON e.cod_equipo_visitante = ev.cod_equipo
    WHERE j.cod_jornadas = v_ultima_jornada
    GROUP BY j.cod_jornadas, j.num_jornada;

    -- Insertar el resultado en la tabla temporal
    INSERT INTO temp_ultima_jornada_tab (xml_data) VALUES (v_xml_data);

    -- Confirmar la transacción
    COMMIT;
END;
