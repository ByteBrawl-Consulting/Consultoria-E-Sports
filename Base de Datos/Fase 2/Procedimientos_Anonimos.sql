/* Procedimientos Anonimos */

SET SERVEROUTPUT ON;

/* Funcion: Verificar si la etapa de inscripcion de una competicion se encuentra
            abierta o cerrada 
            
            Se usara en Java en la consulta de etapa de inscripcion.
            */

DECLARE
    V_COD_COMPE INT;       -- COD COMPETICION
    V_FECHA_FIN DATE;      -- FECHA FIN INSCRIPCION

BEGIN
    V_COD_COMPE := 1; -- COD COMPE QUE QUEEREMOS CERRAR ETAPA INSCRIPCION

    -- OBTENER LA FECHA DE FIN DE INSCRIPCI�N PARA LA COMPETICI�N
    SELECT FECHA_INICIO INTO V_FECHA_FIN
    FROM COMPETICIONES
    WHERE COD_COMPE = V_COD_COMPE;

    -- VERIFICAR SI LA FECHA DE FIN DE INSCRIPCI�N HA PASADO
    IF V_FECHA_FIN < SYSDATE THEN
        DBMS_OUTPUT.PUT_LINE('LA ETAPA DE INSCRIPCI�N PARA LA COMPETICI�N EST� CERRADA.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('LA ETAPA DE INSCRIPCI�N PARA LA COMPETICI�N EST� ABIERTA.');
    END IF;
END;

/* Resultados Obtenidos Ejemplo
LA ETAPA DE INSCRIPCI�N PARA LA COMPETICI�N EST� CERRADA.

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
        DBMS_OUTPUT.PUT_LINE('LA ETAPA DE INSCRIPCI�N PARA LA COMPETICI�N YA EST� CERRADA.');
    ELSE
        -- SE CAMBIA LA FECHA DE FIN DE INSCRIPCION A LA ACTUAL
        UPDATE COMPETICIONES
        SET FECHA_FIN = SYSDATE
        WHERE COD_COMPE = V_COD_COMPE;

        DBMS_OUTPUT.PUT_LINE('SE HA CERRADO LA ETAPA DE INSCRIPCI�N PARA LA COMPETICI�N CORRECTAMENTE.');
    END IF;
END;

/* Resultados Obtenidos Ejmplo
LA ETAPA DE INSCRIPCI�N PARA LA COMPETICI�N YA EST� CERRADA.

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
    DBMS_OUTPUT.PUT_LINE('LA DURACI�N DE LA COMPETICI�N ES DE ' || V_DURACION || ' D�AS.');
END;

/* Resultados Obtenidos Ejemplo
LA DURACI�N DE LA COMPETICI�N ES DE 1 D�AS.

Procedimiento PL/SQL terminado correctamente.
*/