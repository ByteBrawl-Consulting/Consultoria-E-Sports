/* Procedimientos Anonimos */

SET SERVEROUTPUT ON;

/* Procedimiento destinado a probar el procedimiento almacenado */
DECLARE
    FECHA_CONSULTA DATE := TO_DATE('25/04/2020', 'DD/MM/YYYY'); 
BEGIN
    DBMS_OUTPUT.PUT_LINE('EJECUTANDO PROCEDIMIENTO OBTENER_INFO_COMPETICION');
    OBTENER_INFO_COMPETICION(FECHA_CONSULTA);
    DBMS_OUTPUT.PUT_LINE('PROCEDIMIENTO EJECUTADO CON EXITO.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR AL EJECUTAR EL PROCEDIMIENTO: ' || SQLERRM);
END;
/


/* Procedimientos añadidos */

/* Funcion: Verificar si la etapa de inscripcion de una competicion se encuentra
            abierta o cerrada 
            
            Se usara en Java en la consulta de etapa de inscripcion.
            */

DECLARE
    V_COD_COMPE INT;       -- COD COMPETICION
    V_FECHA_FIN DATE;      -- FECHA FIN INSCRIPCION

BEGIN
    V_COD_COMPE := 1; -- COD COMPE QUE QUEEREMOS CERRAR ETAPA INSCRIPCION

    -- OBTENER LA FECHA DE FIN DE INSCRIPCION PARA LA COMPETICION
    SELECT FECHA_INICIO INTO V_FECHA_FIN
    FROM COMPETICIONES
    WHERE COD_COMPE = V_COD_COMPE;

    -- VERIFICAR SI LA FECHA DE FIN DE INSCRIPCIÃ“N HA PASADO
    IF V_FECHA_FIN < SYSDATE THEN
        DBMS_OUTPUT.PUT_LINE('LA ETAPA DE INSCRIPCION 
            PARA LA COMPETICION ESTA CERRADA.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('LA ETAPA DE INSCRIPCION 
            PARA LA COMPETICION ESTA ABIERTA.');
    END IF;
END;
/

/* Resultados Obtenidos Ejemplo
LA ETAPA DE INSCRIPCION PARA LA COMPETICION ESTA CERRADA.

Procedimiento PL/SQL terminado correctamente.
*/



/* Funcion: Este procedimiento cierra la etapa de inscripcion de la competicion
        que elijas (mediante codigo competicion [cod_compe]), si esta abierta y 
        se cierra mediante este procedimiento habra una salida que indique que
        se ha cerrado la competicion correctamente, si ya estaba cerrada 
        anteriormente la salida dira que ya estaba cerrada. 
        
         Se usara en Java en la modificacion de etapa de inscripcion
        */

DECLARE
    V_COD_COMPE INT;       -- COD COMPETICION
    V_CURRENT_DATE DATE;        -- FECHA ACTUAL

BEGIN
    V_COD_COMPE := 1; -- COD COMPE QUE QUEEREMOS CERRAR ETAPA INSCRIPCION

    -- VERIFICAR SI ESTA ABIERTA O CERRADA ESA COMPETICION
    SELECT FECHA_INICIO INTO V_CURRENT_DATE
    FROM COMPETICIONES
    WHERE COD_COMPE = V_COD_COMPE;

    -- SI LA FECHA ACTUAL YA SOBREPASA LA DE CIERRE DE INSCRIPCION SACAMOS ESTO
    IF V_CURRENT_DATE < SYSDATE THEN
        DBMS_OUTPUT.PUT_LINE('LA ETAPA DE INSCRIPCION 
            PARA LA COMPETICION YA ESTA CERRADA.');
    ELSE
        -- SE CAMBIA LA FECHA DE FIN DE INSCRIPCION A LA ACTUAL
        UPDATE COMPETICIONES
        SET FECHA_FIN = SYSDATE
        WHERE COD_COMPE = V_COD_COMPE;

        DBMS_OUTPUT.PUT_LINE('SE HA CERRADO LA ETAPA DE INSCRIPCION 
            PARA LA COMPETICION CORRECTAMENTE.');
    END IF;
END;
/
/* Resultados Obtenidos Ejmplo
LA ETAPA DE INSCRIPCION PARA LA COMPETICION YA ESTA CERRADA.

Procedimiento PL/SQL terminado correctamente.
*/


    
/* Funcion: Este procedimiento calcula la duracion de una competicion
            
            Se usara en Java en la consulta de competicion.
*/

DECLARE
    V_COD_COMPE INT;       -- COD COMPE
    V_FECHA_INICIO DATE;   -- FECHA INICIO COMPE
    V_FECHA_FIN DATE;      -- FECHA FIN COMPE
    V_DURACION NUMBER;     -- DURACION COMPE

BEGIN
    V_COD_COMPE := 1; -- COD COMPE A CALCULAR

    -- OBTENER FECHA INICIO Y FIN COMPE A VERIFICAR
    SELECT FECHA_INICIO, FECHA_FIN
    INTO V_FECHA_INICIO, V_FECHA_FIN
    FROM COMPETICIONES
    WHERE COD_COMPE = V_COD_COMPE;

    -- CALCULAR EN DIAS
    V_DURACION := V_FECHA_FIN - V_FECHA_INICIO;

    -- MOSTRAR DURACION
    DBMS_OUTPUT.PUT_LINE('LA DURACION DE LA 
        COMPETICION ES DE ' || V_DURACION || ' DIAS.');
END;
/
/* Resultados Obtenidos Ejemplo
LA DURACION DE LA COMPETICION ES DE 1 DIAS.

Procedimiento PL/SQL terminado correctamente.
*/
