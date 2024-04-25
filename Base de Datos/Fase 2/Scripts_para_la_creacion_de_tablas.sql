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
/*Fin de los drop de las tablas*/

/*Esto son los drops de las secuencias*/
drop sequence cod_equipo;
drop sequence cod_jugadores;
drop sequence cod_staff;
drop sequence cod_juegos;
drop sequence cod_competiciones;
drop sequence cod_jornadas;
drop sequence cod_enfrentamientos;
drop sequence cod_usuarios;
/*Fin de los drop de las secuencias*/

/*Secuencias para los codigos de las tablas*/
create sequence cod_equipo
    start with 1
    increment by 1
    maxvalue 9999
    nocycle
    noorder;
create sequence cod_jugadores
    start with 1
    increment by 1
    maxvalue 9999
    nocycle
    noorder;
create sequence cod_staff
    start with 1
    increment by 1
    maxvalue 9999
    nocycle
    noorder;
create sequence cod_juegos
    start with 1
    increment by 1
    maxvalue 9999
    nocycle
    noorder;
create sequence cod_competiciones
    start with 1
    increment by 1
    maxvalue 9999
    nocycle
    noorder;
create sequence cod_jornadas
    start with 1
    increment by 1
    maxvalue 9999
    nocycle
    noorder;
create sequence cod_enfrentamientos
    start with 1
    increment by 1
    maxvalue 9999
    nocycle
    noorder;
create sequence cod_usuarios
    start with 1
    increment by 1
    maxvalue 9999
    nocycle
    noorder;
/*Fin de las secuencias*/


/*Creacion de las tablas*/
create table equipos (
    cod_equipo number(5) default cod_equipo.nextval primary key,
    nombre varchar2 (50) not null,
    fecha_fundacion date not null,
    patrocinador varchar2(50) not null,
    cod_jugador number(5) not null,
    cod_staff number(5) not null
);
create table jugadores(
    cod_jugador number(5) default cod_jugadores.nextval primary key,
    nombre_jugador varchar2 (50) not null,
    nacionalidad varchar2(50) not null,
    fecha_nac date not null,
    nickname varchar2(20) not null,
    rol varchar2(10) not null,
    sueldo number(7) not null
);
create table staff(
    cod_staff number(5) default cod_staff.nextval primary key,
    nombre varchar2 (50) not null,
    cargo varchar2(50) not null,
    sueldo float(7)not null
);
create table competiciones (
    cod_compe number(5) default cod_competiciones.nextval primary key,
    nombre varchar2 (50) not null,
    fecha_inicio date not null,
    fecha_fin date not null,
    curso number(1) not null,
    equipo_ganador number(5),
    cod_equipo number(5) not null,
    cod_juego number(5) not null
);
create table juegos(
    cod_juego number(5) default cod_juegos.nextval primary key,
    nombre varchar2 (50) not null,
    desarrolladora varchar2 (50) not null,
    fecha_lanzamiento date not null
);
create table jornadas (
    cod_jornadas number(5)default cod_jornadas.nextval primary key,
    num_jornada number(3) not null,
    dia date not null,
    cod_compe number(5) not null,
    cod_enfrentamiento number(5) not null
);
create table enfrentamientos(
    cod_enfrentamiento number(5) default cod_enfrentamientos.nextval primary key,
    fecha date not null,
    con_jornada number(5) not null,
    hora varchar2(5) not null,
    resultado varchar2(4),
    cod_equipo_local number(5) not null,
    cod_equipo_visitante number(5) not null
);
create table usuarios (
    cod_usuario number(3)default cod_usuarios.nextval primary key,
    tipo varchar2(20),
    contraseña varchar2(50)
);
create table patrocinadores(
    nombre varchar2(20) primary key
    
);
/*Fin de creacion de tablas*/


/*Comenzamos con las claves foraneas*/
alter table equipos 
add constraint fk_jugadores 
foreign key (cod_jugador) 
references jugadores (cod_jugador);
alter table equipos 
add constraint fk_staff
foreign key (cod_staff)
references staff (cod_staff);
alter table equipos
add constraint fk_patrocinadores
foreign key (patrocinador)
references patrocinadores(nombre);
alter table competiciones 
add constraint fk_juego
foreign key (cod_juego)
references juegos(cod_juego);
alter table competiciones
add constraint fk_equipo
foreign key (cod_equipo)
references equipos(cod_equipo);
alter table jornadas
add constraint fk_competicion
foreign key (cod_compe)
references competiciones(cod_compe);
alter table jornadas
add constraint fk_enfrentamiento
foreign key (cod_enfrentamiento)
references enfrentamientos(cod_enfrentamiento);
alter table enfrentamientos
add constraint fk_equipo_local
foreign key (cod_equipo_local)
references equipos(cod_equipo);
alter table enfrentamientos
add constraint fk_equipo_visitante
foreign key (cod_equipo_visitante)
references equipos(cod_equipo);
/*Fin de las claves foraneas*/

/*Comenzamos con los check*/
alter table jugadores
add constraint chck_sueldo
check (sueldo<1323);

alter table staff
add constraint chck_cargo
check (cargo in('Asistente','Entrenador'));

alter table staff
add constraint chck_sueldo_staff
check (sueldo<1323);

alter table competiciones
add constraint chck_curso
check (curso in(0,1));

alter table usuarios
add constraint chck_tipo
check (tipo in('Administrador','Usuario'));
/*Fin de los check*/


