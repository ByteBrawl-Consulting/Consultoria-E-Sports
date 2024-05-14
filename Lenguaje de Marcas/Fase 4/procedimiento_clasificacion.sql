drop table temp_clasificacion_tab;

CREATE TABLE temp_clasificacion_tab (
  xml_data CLOB
);

CREATE OR REPLACE PROCEDURE generar_clasificacion(
    codigo_competicion VARCHAR2,
    resultado OUT CLOB
)
IS
BEGIN
    SELECT XMLElement("Clasificacion",
               XMLAgg(
                   XMLElement("Equipo",
                       XMLForest(
                           e.nombre AS "Nombre",
                           ec.puntos AS "Puntos"
                       )
                   )
               )
           ).getClobVal()
    INTO resultado
    FROM equipos e
    JOIN equipo_competicion ec ON e.cod_equipo = ec.cod_equipo
    WHERE ec.cod_competicion = codigo_competicion
    ORDER BY ec.puntos DESC; -- ORDENAR POR PUNTOS
END generar_clasificacion;
/


DECLARE
    xml_data CLOB;
BEGIN
    -- Llamar al procedimiento para generar la clasificación
    generar_clasificacion('1', xml_data); -- HAY QUE ELEGIR EL NUMERO DE LA 
                                          --  COMPETICION QUE QUIERES VISUALIZAR
                                          -- LA CLASIFICACION

    INSERT INTO temp_clasificacion_tab (xml_data) VALUES (xml_data);

    COMMIT;
END;
