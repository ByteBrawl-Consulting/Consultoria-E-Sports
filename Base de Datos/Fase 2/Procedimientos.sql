SET SERVEROUTPUT ON;
/*Procedimientos*/

/*Sacamos por pantalla el nombre del juego, cuando empieza y acaba, 
nombre de equipo, nombre del staff y cantidad de jugadores, con la fecha que 
recibe de entrada sacamos esos datos*/
create or replace procedure obtener_info_competicion(
    fecha_consulta IN DATE
)
as
    cursor_info_competicion SYS_REFCURSOR;
    nombre_juego juegos.nombre%type;
    fecha_inicio competiciones.fecha_inicio%type;
    fecha_fin competiciones.fecha_fin%type;
    nombre_equipo equipos.nombre%type;
    nombre_staff staff.nombre%type;
    cantidad_jugadores number;
begin
    open cursor_info_competicion for
    select j.nombre AS nombre_juego,
           c.fecha_inicio,
           c.fecha_fin,
           e.nombre AS nombre_equipo,
           s.nombre AS nombre_staff,
           COUNT(DISTINCT jug.cod_jugador) AS cantidad_jugadores
    from competiciones c
    join juegos j on c.cod_juego = j.cod_juego
    join equipo_competicion ec on c.cod_compe = ec.cod_competicion
    join equipos e on ec.cod_equipo = e.cod_equipo
    LEFT join jugadores jug on e.cod_equipo = jug.cod_equipo
    LEFT join staff s on e.cod_equipo = s.cod_equipo
    where fecha_consulta between c.fecha_inicio AND c.fecha_fin
    group by j.nombre, c.fecha_inicio, c.fecha_fin, e.nombre, s.nombre;

    DBMS_OUTPUT.PUT_LINE('Información de la competición:');
    DBMS_OUTPUT.PUT_LINE('-----------------------');

    loop
        fetch cursor_info_competicion into nombre_juego, fecha_inicio, fecha_fin, nombre_equipo, nombre_staff, cantidad_jugadores;
        exit when cursor_info_competicion%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Juego: ' || nombre_juego);
        DBMS_OUTPUT.PUT_LINE('Fecha de inicio: ' || TO_CHAR(fecha_inicio, 'dd/MM/yyyy'));
        DBMS_OUTPUT.PUT_LINE('Fecha de fin: ' || TO_CHAR(fecha_fin, 'dd/MM/yyyy'));
        DBMS_OUTPUT.PUT_LINE('Equipo: ' || nombre_equipo);
        DBMS_OUTPUT.PUT_LINE('Miembro del staff: ' || nombre_staff);
        DBMS_OUTPUT.PUT_LINE('Cantidad de jugadores: ' || cantidad_jugadores);
        DBMS_OUTPUT.PUT_LINE('-----------------------');
    end loop;

    close cursor_info_competicion;
end;
/*Esto lo usaremos cuando queramos saber informacion de que equipos participan
en torneos de fechas en concreto, lo usaremos en el crud de equipos*/
/*Probamos el procedimiento "obtener_info_competicion"*/
begin
    obtener_info_competicion (to_date('25/04/2020','dd/MM/yyyy'));
end;
/*
Información de la competición:
-----------------------
Juego: Maneater
Fecha de inicio: 25/04/2020
Fecha de fin: 25/05/2020
Equipo: E11
Miembro del staff: 
Cantidad de jugadores: 0
-----------------------
Juego: Maneater
Fecha de inicio: 25/04/2020
Fecha de fin: 25/05/2020
Equipo: E12
Miembro del staff: 
Cantidad de jugadores: 0
-----------------------
Juego: Maneater
Fecha de inicio: 25/04/2020
Fecha de fin: 25/05/2020
Equipo: E13
Miembro del staff: 
Cantidad de jugadores: 0
-----------------------
Juego: Maneater
Fecha de inicio: 25/04/2020
Fecha de fin: 25/05/2020
Equipo: E10
Miembro del staff: 
Cantidad de jugadores: 0
-----------------------
*/

/*Aqui vamos a sacar por pantalla toda la informacion de los jugadores, equipos
staff, competiciones y patrocinadores de un equipo en concreto*/
create or replace procedure info_general (
    equipo equipos.nombre%type
)
as
    cursor_equipo SYS_REFCURSOR;
    enombre equipos.nombre%type;
    jnombre jugadores.nombre_jugador%type;
    jnacionalidad jugadores.nacionalidad%type;
    jnickname jugadores.nickname%type;
    jrol jugadores.rol%type;
    cnombre competiciones.nombre%type;
begin
    open cursor_equipo for
select e.nombre, j.nombre_jugador, j.nacionalidad, j.nickname, j.rol, 
       c.nombre
from jugadores j
join equipos e ON j.cod_equipo = e.cod_equipo
join staff s ON j.cod_equipo = s.cod_equipo
join equipo_competicion ec ON e.cod_equipo = ec.cod_equipo
join competiciones c ON ec.cod_competicion = c.cod_compe
where e.nombre = equipo
order by e.nombre;

dbms_output.put_line('Esta es la informacion');
dbms_output.put_line('-----------------------');


loop 
fetch cursor_equipo into enombre,jnombre,jnacionalidad,jnickname,jrol,cnombre;
        EXIT WHEN cursor_equipo%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Nombre del equipo: ' || enombre);
        DBMS_OUTPUT.PUT_LINE('Nombre del jugador: ' || jnombre);
        DBMS_OUTPUT.PUT_LINE('Nacionalidad: ' || jnacionalidad);
        DBMS_OUTPUT.PUT_LINE('Nickname: ' || jnickname);
        DBMS_OUTPUT.PUT_LINE('Rol: ' || jrol);
        DBMS_OUTPUT.PUT_LINE('Nombre de la competicion: ' || cnombre);
        DBMS_OUTPUT.PUT_LINE('-----------------------');
end loop;
end;
/*Este procedimiento lo usaremos para saber toda la informacion sobre un 
jugador, lo usaremos en el crud de jugadores*/
/*Comprobacion del procedimiento*/
begin
    info_general('Team Delta');
end;
/*
Esta es la informacion
-----------------------
Nombre del equipo: Team Delta
Nombre del jugador: Jose Luis
Nacionalidad: España
Nickname: JL
Rol: Mid
Nombre de la competicion: torneo 1
-----------------------
Nombre del equipo: Team Delta
Nombre del jugador: Andrei Popescu
Nacionalidad: Rumania
Nickname: CountDracula
Rol: Mid
Nombre de la competicion: torneo 1
-----------------------
Nombre del equipo: Team Delta
Nombre del jugador: Mateo Fernandez
Nacionalidad: Argentina
Nickname: TangoMaster
Rol: Support
Nombre de la competicion: torneo 1
-----------------------
Nombre del equipo: Team Delta
Nombre del jugador: Elias Nielsen
Nacionalidad: Dinamarca
Nickname: VikingWarrior
Rol: Jungler
Nombre de la competicion: torneo 1
-----------------------
Nombre del equipo: Team Delta
Nombre del jugador: Sofia Petrova
Nacionalidad: Rusia
Nickname: IceQueen
Rol: Support
Nombre de la competicion: torneo 1
-----------------------
Nombre del equipo: Team Delta
Nombre del jugador: Ryuji Tanaka
Nacionalidad: Japón
Nickname: SamuraiSlicer
Rol: Top
Nombre de la competicion: torneo 1
-----------------------
*/

