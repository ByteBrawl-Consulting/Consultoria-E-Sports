SET SERVEROUTPUT ON;
/*Procedimientos*/
/*Sacamos por pantalla el nombre del juego, cuando empieza y acaba, 
nombre de equipo, nombre del staff y cantidad de jugadores */
CREATE OR REPLACE PROCEDURE obtener_info_competicion(
    fecha_consulta IN DATE
)
AS
    cursor_info_competicion SYS_REFCURSOR;
    nombre_juego juegos.nombre%TYPE;
    fecha_inicio competiciones.fecha_inicio%TYPE;
    fecha_fin competiciones.fecha_fin%TYPE;
    nombre_equipo equipos.nombre%TYPE;
    nombre_staff staff.nombre%TYPE;
    cantidad_jugadores NUMBER;
BEGIN
    OPEN cursor_info_competicion FOR
    SELECT j.nombre AS nombre_juego,
           c.fecha_inicio,
           c.fecha_fin,
           e.nombre AS nombre_equipo,
           s.nombre AS nombre_staff,
           COUNT(DISTINCT jug.cod_jugador) AS cantidad_jugadores
    FROM competiciones c
    JOIN juegos j ON c.cod_juego = j.cod_juego
    JOIN equipo_competicion ec ON c.cod_compe = ec.cod_competicion
    JOIN equipos e ON ec.cod_equipo = e.cod_equipo
    LEFT JOIN jugadores jug ON e.cod_equipo = jug.cod_equipo
    LEFT JOIN staff s ON e.cod_equipo = s.cod_equipo
    WHERE fecha_consulta BETWEEN c.fecha_inicio AND c.fecha_fin
    GROUP BY j.nombre, c.fecha_inicio, c.fecha_fin, e.nombre, s.nombre;

    DBMS_OUTPUT.PUT_LINE('Información de la competición:');
    LOOP
        FETCH cursor_info_competicion INTO nombre_juego, fecha_inicio, fecha_fin, nombre_equipo, nombre_staff, cantidad_jugadores;
        EXIT WHEN cursor_info_competicion%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Juego: ' || nombre_juego);
        DBMS_OUTPUT.PUT_LINE('Fecha de inicio: ' || TO_CHAR(fecha_inicio, 'dd/MM/yyyy'));
        DBMS_OUTPUT.PUT_LINE('Fecha de fin: ' || TO_CHAR(fecha_fin, 'dd/MM/yyyy'));
        DBMS_OUTPUT.PUT_LINE('Equipo: ' || nombre_equipo);
        DBMS_OUTPUT.PUT_LINE('Miembro del staff: ' || nombre_staff);
        DBMS_OUTPUT.PUT_LINE('Cantidad de jugadores: ' || cantidad_jugadores);
        DBMS_OUTPUT.PUT_LINE('-----------------------');
    END LOOP;

    CLOSE cursor_info_competicion;
END;

BEGIN
    obtener_info_competicion (to_date('25/04/2020','dd/MM/yyyy'));
END;

