SET SERVEROUTPUT ON;

DROP TABLE temp_jornadas_tab;

CREATE TABLE temp_jornadas_tab (
  xml_data CLOB
);

DECLARE
    TYPE jornadas_tab IS TABLE OF CLOB;
    v_jornadas jornadas_tab;
    resultado CLOB; -- Declare resultado variable
BEGIN
    -- Generar XML con los datos de todas las jornadas
    SELECT 
        XMLElement("Jornada",
            XMLAttributes(j.num_jornada AS "Numero_Jornada", j.cod_compe AS "Codigo_Competencion", j.cod_jornadas AS "Codigo_Jornada"),
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
           ).getClobVal()
    BULK COLLECT INTO v_jornadas
    FROM jornadas j
    LEFT JOIN enfrentamientos e ON j.cod_jornadas = e.cod_jornada
    LEFT JOIN equipos el ON e.cod_equipo_local = el.cod_equipo
    LEFT JOIN equipos ev ON e.cod_equipo_visitante = ev.cod_equipo
    GROUP BY j.cod_jornadas, j.num_jornada, j.cod_compe;

    -- Concatenar el encabezado XML y el DTD al resultado
    resultado := '<?xml version=''1.0'' encoding=''UTF-8'' ?>' || '<Jornadas 
    xmlns:xs="http://www.w3.org/2001/XMLSchema-instance" 
    xs:noNamespaceSchemaLocation="resultados_todas_jornadas.xsd">' || 
    v_jornadas(1);
    FOR i IN 2..v_jornadas.COUNT LOOP
        resultado := resultado || v_jornadas(i);
    END LOOP;
    resultado := resultado || '</Jornadas>';
    DBMS_OUTPUT.PUT_LINE(resultado);
    
    -- Insertar el resultado en la tabla
    INSERT INTO temp_jornadas_tab (xml_data) VALUES (resultado);
    
    COMMIT; -- Realiza la inserción de manera permanente
END;
/