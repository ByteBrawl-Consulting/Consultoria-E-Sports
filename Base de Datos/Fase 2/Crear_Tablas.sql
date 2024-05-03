/*Esto son los drops de las tablas*/
drop table equipos cascade constraints;
drop table jugadores cascade constraints;
drop table staff cascade constraints;
drop table juegos cascade constraints;
drop table competiciones cascade constraints;
drop table jornadas cascade constraints;
drop table enfrentamientos cascade constraints;
drop table usuarios cascade constraints;
drop table patrocinadores cascade constraints;
drop table patrocinadores_equipos cascade constraints;
drop table equipo_competicion cascade constraints;
/*Fin de los drop de las tablas*/

/*Creacion de las tablas*/
create table equipos (
    cod_equipo number(5) generated always as identity (start with 1) primary key,
    nombre varchar2 (50) not null,
    fecha_fundacion date not null
);
create table jugadores(
    cod_jugador number(5)generated always as identity(start with 1)primary key,
    nombre_jugador varchar2 (50) not null,
    nacionalidad varchar2(50) not null,
    fecha_nac date not null,
    nickname varchar2(20) not null,
    rol varchar2(10) not null,
    sueldo number(7) not null,
    cod_equipo number(5)
);
create table staff(
    cod_staff number(5) generated always as identity(start with 1)primary key,
    nombre varchar2 (50) not null,
    cargo varchar2(50) not null,
    sueldo float(7)not null,
    cod_equipo number(5)

);
create table competiciones (
    cod_compe number(5) generated always as identity (start with 1) primary key,
    nombre varchar2 (50) not null,
    fecha_inicio date not null,
    fecha_fin date not null,
    curso number(1) not null,
    equipo_ganador number(5),
    cod_juego number(5) not null
);
create table juegos(
    cod_juego number(5) generated always as identity (start with 1) primary key,
    nombre varchar2 (50) not null,
    desarrolladora varchar2 (50) not null,
    fecha_lanzamiento date not null
);
create table jornadas (
    cod_jornadas number(5)generated always as identity (start with 1) primary key,
    num_jornada number(3) not null,
    dia date not null,
    cod_compe number(5) not null
);
create table enfrentamientos(
    cod_enfrentamiento number(5) generated always as identity (start with 1) primary key,
    fecha date not null,
    cod_jornada number(5) not null,
    hora varchar2(5) not null,
    resultado varchar2(4),
    cod_equipo_local number(5) not null,
    cod_equipo_visitante number(5) not null
);
create table usuarios (
    cod_usuario number(3)generated always as identity (start with 1) primary key,
    tipo varchar2(20) not null,
    contraseña varchar2(50) not null
);
create table patrocinadores(
    cod_patrocinadores number(5)generated always as identity (start with 1)
                                                              primary key,
    nombre varchar2(100) not null
);
create table patrocinadores_equipos(
    cod_patr_equi number(5)generated always as identity(start with 1)
                                                        primary key,
    cod_patrocinadores number(5) not null,
    cod_equipo number(5) not null
);
create table equipo_competicion(
    cod_equipo_compe number(5) generated always as identity (start with 1) 
                                                            primary key,
    cod_equipo number(5) not null,
    cod_competicion number(5) not null
);
 /*Fin de creacion de tablas*/


/*Comenzamos con las claves foraneas*/
alter table jugadores 
add constraint fk_equipo_en_jugador 
foreign key (cod_equipo) 
references equipos (cod_equipo);

alter table enfrentamientos
add constraint fk_jornada
foreign key (cod_jornada)
references jornadas(cod_jornadas);

alter table staff 
add constraint fk_equipo_en_staff
foreign key (cod_equipo)
references equipos (cod_equipo);

alter table competiciones 
add constraint fk_juego_en_compe
foreign key (cod_juego)
references juegos(cod_juego); 

alter table jornadas
add constraint fk_competicion_en_jornada
foreign key (cod_compe)
references competiciones(cod_compe);  

alter table enfrentamientos
add constraint fk_equipo_local
foreign key (cod_equipo_local)
references equipos(cod_equipo); 

alter table enfrentamientos
add constraint fk_equipo_visitante
foreign key (cod_equipo_visitante)
references equipos(cod_equipo); 

alter table patrocinadores_equipos
add constraint fk_patro_en_patro_equipos
foreign key (cod_patrocinadores) 
references patrocinadores(cod_patrocinadores);

alter table patrocinadores_equipos
add constraint fk_equipos_en_patro_equipos
foreign key (cod_equipo) 
references equipos(cod_equipo);

alter table equipo_competicion
add constraint fk_equipo_equipo_compe
foreign key (cod_equipo)
references equipos(cod_equipo);

alter table equipo_competicion
add constraint fk_compe_equipo_compe
foreign key (cod_competicion)
references competiciones(cod_compe);
/*Fin de las claves foraneas*/

/*Comenzamos con los check*/
alter table jugadores
add constraint chck_sueldo_jugadores
check (sueldo>1323)
;

alter table staff
add constraint chck_cargo_staff
check (cargo in('Asistente','Entrenador'))
;

alter table staff
add constraint chck_sueldo_staff
check (sueldo>1323)
;

alter table competiciones
add constraint chck_curso_compe
check (curso in(0,1))
;

alter table usuarios
add constraint chck_tipo_usu
check (tipo in('Administrador','Usuario'))
;
/*Fin de los check*/


/*Creacion de las vistas*/
/*Para hacer la consulta de quienes son los juegadores de cada equipo equipo*/
create or replace view jugadores_equipo as
select j.nombre_jugador, j.nacionalidad, j.rol, j.sueldo, e.nombre "Equipo" 
from jugadores j
join equipos e
on e.cod_equipo=j.cod_equipo order by e.cod_equipo;
/*Consulta para saber que tipos de torneos pueden existir y sus fechas de 
inicio y fin*/
create or replace view juegos_compe as
select j.cod_juego, j.nombre"juego", c.nombre, c.fecha_inicio, c.fecha_fin 
from juegos j 
join competiciones c 
on j.cod_juego = c.cod_juego;
/*Los equipos y que competiciones juegan*/
create or replace view equipos_compe as
SELECT e.cod_equipo, e.nombre AS nombre_equipo, c.cod_compe, 
c.nombre AS nombre_competicion, c.cod_juego, j.nombre AS nombre_juego
FROM equipos e
JOIN equipo_competicion ec ON e.cod_equipo = ec.cod_equipo
JOIN competiciones c ON c.cod_compe = ec.cod_competicion
JOIN juegos j ON j.cod_juego = c.cod_juego
order by e.nombre;