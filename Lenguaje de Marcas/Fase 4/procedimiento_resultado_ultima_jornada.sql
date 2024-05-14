SET SERVEROUTPUT ON;

DROP TABLE temp_ultima_jornada_tab;

CREATE TABLE temp_ultima_jornada_tab (
  xml_data CLOB
);

DECLARE
    v_xml_data CLOB;
    v_ultima_jornada NUMBER;
    resultado CLOB; -- Declare resultado variable
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
END;
/
