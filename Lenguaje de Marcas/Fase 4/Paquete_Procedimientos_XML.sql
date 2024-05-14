CREATE OR REPLACE PACKAGE gestion_xml IS
    PROCEDURE generar_todas_jornadas;
    PROCEDURE generar_clasificacion(resultado OUT CLOB);
    PROCEDURE generar_ultima_jornada;
    PROCEDURE preparar_entorno;
END gestion_xml;
/

CREATE OR REPLACE PACKAGE BODY gestion_xml IS

    PROCEDURE preparar_entorno IS
    BEGIN
        BEGIN
            EXECUTE IMMEDIATE 'DROP TABLE temp_jornadas_tab';
        EXCEPTION
            WHEN OTHERS THEN
                IF SQLCODE != -942 THEN
                    RAISE;
                END IF;
        END;
        EXECUTE IMMEDIATE 'CREATE TABLE temp_jornadas_tab (xml_data CLOB)';

        BEGIN
            EXECUTE IMMEDIATE 'DROP TABLE temp_clasificacion_tab';
        EXCEPTION
            WHEN OTHERS THEN
                IF SQLCODE != -942 THEN
                    RAISE;
                END IF;
        END;
        EXECUTE IMMEDIATE 'CREATE TABLE temp_clasificacion_tab (xml_data CLOB)';

        BEGIN
            EXECUTE IMMEDIATE 'DROP TABLE temp_ultima_jornada_tab';
        EXCEPTION
            WHEN OTHERS THEN
                IF SQLCODE != -942 THEN
                    RAISE;
                END IF;
        END;
        EXECUTE IMMEDIATE 'CREATE TABLE temp_ultima_jornada_tab (xml_data CLOB)';
    END preparar_entorno;

    PROCEDURE generar_todas_jornadas IS
        v_xml_data CLOB;
        resultado CLOB;
    BEGIN
        -- Generar XML con los datos de todas las jornadas
        SELECT XMLElement("Jornadas",
                   XMLAgg(
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
                       )
                   )
               ).getClobVal()
        INTO v_xml_data
        FROM jornadas j
        LEFT JOIN enfrentamientos e ON j.cod_jornadas = e.cod_jornada
        LEFT JOIN equipos el ON e.cod_equipo_local = el.cod_equipo
        LEFT JOIN equipos ev ON e.cod_equipo_visitante = ev.cod_equipo
        GROUP BY j.cod_jornadas, j.num_jornada, j.cod_compe;

        -- Concatenar el encabezado XML y el DTD al resultado
        resultado := '<?xml version=''1.0'' encoding=''UTF-8'' ?>' || '<!DOCTYPE Jornadas SYSTEM "resultados_todas_jornadas.dtd">' || v_xml_data;
        DBMS_OUTPUT.PUT_LINE(resultado);
        
        -- Insertar el resultado en la tabla
        INSERT INTO temp_jornadas_tab (xml_data) VALUES (resultado);
        
        COMMIT; -- Realiza la inserción de manera permanente
    END generar_todas_jornadas;

    PROCEDURE generar_clasificacion(
        resultado OUT CLOB
    ) IS
        v_xml CLOB;
    BEGIN
        -- Generar el XML utilizando la consulta, sin agregar manualmente la versión y codificación
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

        -- Concatenar el encabezado XML y el DTD al resultado
        resultado := '<?xml version=''1.0'' encoding=''UTF-8'' ?>' || '<!DOCTYPE Clasificaciones SYSTEM "clasificacion.dtd">' || v_xml;
        DBMS_OUTPUT.PUT_LINE(resultado);
    END generar_clasificacion;

    PROCEDURE generar_ultima_jornada IS
        v_xml_data CLOB;
        v_ultima_jornada NUMBER;
        resultado CLOB;
    BEGIN
        -- Obtener el número de la última jornada
        SELECT MAX(num_jornada) INTO v_ultima_jornada FROM jornadas;

        -- Generar XML con los datos de la última jornada
        SELECT XMLElement("Jornadas",
                   XMLAgg(
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
                       )
                   )
               ).getClobVal()
        INTO v_xml_data
        FROM jornadas j
        LEFT JOIN enfrentamientos e ON j.cod_jornadas = e.cod_jornada
        LEFT JOIN equipos el ON e.cod_equipo_local = el.cod_equipo
        LEFT JOIN equipos ev ON e.cod_equipo_visitante = ev.cod_equipo
        WHERE j.num_jornada = v_ultima_jornada -- Aquí se filtra por el número de jornada
        GROUP BY j.cod_jornadas, j.num_jornada, j.cod_compe;

        -- Concatenar el encabezado XML y el DTD al resultado
        resultado := '<?xml version=''1.0'' encoding=''UTF-8'' ?>' || '<!DOCTYPE Jornadas SYSTEM "resultados_ultima_jornada.dtd">' || v_xml_data;
        DBMS_OUTPUT.PUT_LINE(resultado);
        
        -- Insertar el resultado en la tabla
        INSERT INTO temp_ultima_jornada_tab (xml_data) VALUES (resultado);
        
        COMMIT; -- Realiza la inserción de manera permanente
    END generar_ultima_jornada;

END gestion_xml;
/


BEGIN
    -- Preparar el entorno (crear tablas temporales)
    gestion_xml.preparar_entorno;
    
    -- Generar todas las jornadas
    gestion_xml.generar_todas_jornadas;

    DECLARE
        xml_data CLOB;
    BEGIN
        -- Generar clasificación y almacenar el resultado
        gestion_xml.generar_clasificacion(xml_data);
        INSERT INTO temp_clasificacion_tab (XML_DATA) VALUES (xml_data);
        COMMIT;
    END;

    -- Generar la última jornada
    gestion_xml.generar_ultima_jornada;
END;
/
