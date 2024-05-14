DROP TABLE temp_jornadas_tab;

CREATE TABLE temp_jornadas_tab (
  xml_data CLOB
);

DECLARE
    v_xml_data CLOB;
BEGIN
    -- Generar XML con los datos de todas las jornadas
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
                       ) AS "Enfrentamientos"
                   )
               )
           ).getClobVal()
    INTO v_xml_data
    FROM jornadas j
    LEFT JOIN enfrentamientos e ON j.cod_jornadas = e.cod_jornada
    LEFT JOIN equipos el ON e.cod_equipo_local = el.cod_equipo
    LEFT JOIN equipos ev ON e.cod_equipo_visitante = ev.cod_equipo
    GROUP BY j.cod_jornadas, j.num_jornada
    ORDER BY j.cod_jornadas;

    -- Insertar el resultado en la tabla temporal
    INSERT INTO temp_jornadas_tab (xml_data) VALUES (v_xml_data);

    -- Confirmar la transacción
    COMMIT;
END;
