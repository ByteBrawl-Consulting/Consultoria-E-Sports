set serveroutput on;

DROP TABLE temp_clasificacion_tab;

CREATE TABLE temp_clasificacion_tab (
  xml_data CLOB
);

CREATE OR REPLACE PROCEDURE generar_clasificacion(
    resultado OUT CLOB
)
IS
    v_xml CLOB;
BEGIN
    SELECT 
       XMLElement("Clasificaciones",
           XMLAgg(
               XMLElement("Clasificacion",
                   XMLForest(
                       EC.COD_COMPETICION AS "compId",
                       XMLAgg(
                           XMLElement("Equipo",
                               XMLForest(
                                   E.NOMBRE AS "Nombre",
                                   EC.PUNTOS AS "Puntos"
                               )
                           )
                           ORDER BY EC.PUNTOS DESC
                       ) AS "Equipos"
                   )
               )
           )
       ).getClobVal() 
    INTO v_xml
    FROM EQUIPO_COMPETICION EC
    JOIN EQUIPOS E ON EC.COD_EQUIPO = E.COD_EQUIPO
    GROUP BY EC.COD_COMPETICION;

    resultado := '<?xml version=''1.0'' encoding=''UTF-8'' ?>' || '<!DOCTYPE Clasificaciones SYSTEM "clasificacion.dtd">' || v_xml;
    DBMS_OUTPUT.PUT_LINE(resultado);
END generar_clasificacion;
/

DECLARE
    xml_data CLOB;
BEGIN
    generar_clasificacion(xml_data);

    INSERT INTO temp_clasificacion_tab (XML_DATA) VALUES (xml_data);

    COMMIT;
END;
/
