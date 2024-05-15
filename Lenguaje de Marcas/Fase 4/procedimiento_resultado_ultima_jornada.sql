SET SERVEROUTPUT ON;

DROP TABLE temp_ultima_jornada_tab;

CREATE TABLE temp_ultima_jornada_tab (
  xml_data CLOB
);

DECLARE
    resultado CLOB;
BEGIN
    SELECT
        XMLELEMENT(
            "competiciones",
            XMLAGG(
                XMLELEMENT(
                    "competicion",
                    XMLATTRIBUTES(c.cod_compe AS "id_competicion"),
                    XMLELEMENT("nombre_competicion", c.nombre),
                    (SELECT
                    XMLAGG(
                        XMLELEMENT(
                            "jornada",
                            XMLATTRIBUTES(j.cod_jornadas AS "id_jornada", j.dia AS "Fecha"),
                            XMLELEMENT("numero_jornada", j.num_jornada),
                            (
                                SELECT
                                    XMLAGG(
                                        XMLELEMENT(
                                                    "enfrentamiento",
                                                    XMLATTRIBUTES(rj.cod_enfrentamiento AS "id"),
                                                    XMLFOREST(
                                                        (SELECT nombre FROM equipos WHERE cod_equipo = rj.cod_equipo_local) AS "equipo_local",
                                                        (SELECT nombre FROM equipos WHERE cod_equipo = rj.cod_equipo_visitante) AS "equipo_visitante",
                                                        rj.resultado AS "ganador"
                                                    )
                                                )
                                            )
                                FROM enfrentamientos rj
                                WHERE rj.cod_jornada = j.cod_jornadas
                            )
                        )
                    )
                    FROM (
                        SELECT * FROM jornadas j
                        WHERE j.cod_compe = c.cod_compe
                        ORDER BY j.num_jornada DESC
                    ) j
                    WHERE ROWNUM = 1
                    )
                )
            )
        ).getClobVal()
    INTO resultado
    FROM competiciones c;

    -- Concatenar el encabezado XML y el DTD al resultado
    resultado := '<?xml version=''1.0'' encoding=''UTF-8'' ?>' || 
    '<!DOCTYPE competiciones SYSTEM "resultados_todas_jornadas.dtd">' || resultado;
    DBMS_OUTPUT.PUT_LINE(resultado);
    
    -- Insertar el resultado en la tabla
    INSERT INTO temp_ultima_jornada_tab (xml_data) VALUES (resultado);
    
    COMMIT; -- Realiza la inserción de manera permanente
END;
/
