/*Equipos*/
insert into equipos (nombre, fecha_fundacion) values
('Team Alpha', TO_DATE('01/01/2015', 'DD/MM/YYYY'));
insert into equipos (nombre, fecha_fundacion) values
('Team Bravo', TO_DATE('15/07/2016', 'DD/MM/YYYY'));
insert into equipos (nombre, fecha_fundacion) values
('Team Charlie', TO_DATE('10/03/2017', 'DD/MM/YYYY'));
insert into equipos (nombre, fecha_fundacion) values
('Team Delta', TO_DATE('20/11/2018', 'DD/MM/YYYY'));


/*Jugadores*/
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values
('John Smith', 'Estados Unidos', '10/06/1995', 'xXxGamerxXx', 'ADC', 1500,2);
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values
('Maria Garcia', 'España', '10/03/1999', 'KillerQueen', 'Support', 1400,2); 
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values
('Jung Min-woo', 'Corea del Sur', '19/02/1985','SniperKing', 'Jungler', 1600,2); 
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values
('Luis Hernandez', 'México', '20/09/2000', 'AztecWarrior', 'Top', 1350,3); 
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values
('Anna Schmidt', 'Alemania', '10/08/1955', 'Blitzkrieg', 'Mid', 1450,1); 
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values
('Chen Wei', 'China', '10/11/1989', 'DragonMaster', 'ADC', 1550,2); 
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values
('Ryuji Tanaka', 'Japón', '10/01/1975', 'SamuraiSlicer', 'Top', 1400,4); 
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values
('Sofia Petrova', 'Rusia', '10/06/1995', 'IceQueen', 'Support', 1380,4); 
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values
('Ricardo Silva', 'Brasil', '10/06/1995', 'SambaGod', 'Mid', 1420,1); 
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Elias Nielsen', 'Dinamarca', '10/06/1995', 'VikingWarrior','Jungler', 1450,4); 
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values
('Ahmed Hassan', 'Egipto', '10/06/1995', 'Pharaoh', 'ADC', 1600,1); 
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values
('Lee Sung-hoon', 'Corea del Sur', '10/06/1995', 'NinjaAssassin','Mid', 1480,1);
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values
('Mateo Fernandez', 'Argentina', '10/06/1995', 'TangoMaster','Support', 1375,4);
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values
('Katarina Ivanova', 'Bulgaria', '10/06/1995', 'DarkKnightess', 'Mid', 1360,3);
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values
('Luca Rossi', 'Italia', '10/06/1995', 'Gladiator', 'Top', 1500,3); 
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values
('Haruto Yamamoto', 'Japón', '10/06/1995', 'Ronin', 'Jungler', 1450,3);
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values
('Miguel Rodriguez', 'España', '10/06/1995', 'Matador', 'ADC', 1550,1);
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
VALUES
('Nadia Kovalenko', 'Ucrania', '10/06/1995', 'Blizzard', 'Support', 1400,2);
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values
('Andrei Popescu', 'Rumania', '10/06/1995', 'CountDracula', 'Mid', 1450,4);
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values
('Tobias Jensen', 'Dinamarca', '10/06/1995', 'Thundergod', 'Top', 1400,3);
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values 
('Maria Lujan', 'España', '25/05/2000', 'YHLQMDLG', 'Jungler', 1500, 1);
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values 
('Jorge McPen', 'Rusia', '15/07/1995', 'Pepelu', 'ADC', 1500, 2);
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values 
('Ghuan Yu Zou', 'Japón', '10/12/1998', 'TKLI', 'Support', 1500, 3);
insert into jugadores (nombre_jugador,nacionalidad,
fecha_nac,nickname,rol,sueldo,cod_equipo)
values 
('Jose Luis', 'España', '30/01/2001', 'JL', 'Mid', 1500, 4);


/*Staff*/
insert into staff (nombre,cargo,sueldo,cod_equipo) 
values ('Alvaro','Entrenador',1400,1);
insert into staff (nombre,cargo,sueldo,cod_equipo) 
values ('Adrian','Entrenador',1325,2);
insert into staff (nombre,cargo,sueldo,cod_equipo) 
values ('Alberto','Entrenador',1600,3);
insert into staff (nombre,cargo,sueldo,cod_equipo) 
values ('Lucia','Entrenador',1500,4);


/*Patrocinadores*/
insert into patrocinadores (nombre) values
('CyberTech Solutions');
insert into patrocinadores (nombre) values 
('EliteGaming Gear');
insert into patrocinadores (nombre) values 
('HyperXperience');
insert into patrocinadores (nombre) values 
('NovaForce Gaming');
insert into patrocinadores (nombre) values 
('Quantum eSports');
insert into patrocinadores (nombre) values 
('Vortex Ventures');
insert into patrocinadores (nombre) values 
('ThunderByte Technologies');
insert into patrocinadores (nombre) values 
('PhoenixRise Corporation');
insert into patrocinadores (nombre) values 
('TitanTech Innovations');
insert into patrocinadores (nombre) values 
('Apex Alliance');
insert into patrocinadores (nombre) values 
('SpectraSphere Gaming');
insert into patrocinadores (nombre) values 
('Ignite Impact');
insert into patrocinadores (nombre) values 
('VelocityVision');
insert into patrocinadores (nombre) values 
('Zenith eSports');
insert into patrocinadores (nombre) values 
('FusionForce Enterprises');
insert into patrocinadores (nombre) values 
('AlphaStrike Solutions');
insert into patrocinadores (nombre) values 
('Nexus Nexus Corporation');
insert into patrocinadores (nombre) values 
('OmegaGaming Group');
insert into patrocinadores (nombre) values 
('BlazeByte Brands');
insert into patrocinadores (nombre) values 
('CrystalClear Sponsorship');


/*Patrocinadores_equipo*/
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(1,2);
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(1,15);
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(1,5);
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(2,1);
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(2,11);
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(2,4);
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(3,12);
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(3,10);
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(4,20);
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(4,12);
insert into patrocinadores_equipos (cod_equipo, cod_patrocinadores)values(4,14);

/*Juegos*/
insert into juegos (nombre,desarrolladora,fecha_lanzamiento) 
values ('lol','Riot','10/10/2010');
insert into juegos (nombre,desarrolladora,fecha_lanzamiento) 
values ('Minecraft','Mojang','18/07/2012');
insert into juegos (nombre,desarrolladora,fecha_lanzamiento) 
values ('CSGO','Valve','11/12/2005');
insert into juegos (nombre,desarrolladora,fecha_lanzamiento) 
values ('Valorant','Riot','14/04/2020');


/*Competicion*/
insert into competiciones 
(nombre,fecha_inicio,fecha_fin,curso,equipo_ganador,cod_juego)
values('torneo 1','25/04/2020','25/05/2020',0,null,1);
insert into competiciones 
(nombre,fecha_inicio,fecha_fin,curso,equipo_ganador,cod_juego)
values('torneo 2','20/10/2017','20/11/2017',0,null,2);
insert into competiciones 
(nombre,fecha_inicio,fecha_fin,curso,equipo_ganador,cod_juego)
values('torneo 3','20/10/2019','20/10/2019',0,null,3);
insert into competiciones 
(nombre,fecha_inicio,fecha_fin,curso,equipo_ganador,cod_juego)
values('torneo 4','15/08/2015','10/09/2015',0,null,4);


/*Equipo_competicion*/
insert into equipo_competicion (cod_equipo,cod_competicion,puntos)values(1,1,0);
insert into equipo_competicion (cod_equipo,cod_competicion,puntos)values(2,1,0);
insert into equipo_competicion (cod_equipo,cod_competicion,puntos)values(3,1,0);
insert into equipo_competicion (cod_equipo,cod_competicion,puntos)values(4,1,0);
insert into equipo_competicion (cod_equipo,cod_competicion,puntos)values(2,2,0);
insert into equipo_competicion (cod_equipo,cod_competicion,puntos)values(3,2,0);


/*Usuarios*/
insert into usuarios (tipo,contraseña)values('Usuario','12345');
insert into usuarios (tipo,contraseña)values('Administrador','54321');

/*Jornadas*/
insert into jornadas (num_jornada, dia, cod_compe)
values (1, TO_DATE('01/03/2024', 'dd/MM/yyyy'), 1);
insert into jornadas (num_jornada, dia, cod_compe)
values (2, TO_DATE('08/03/2024', 'dd/MM/yyyy'), 1);

/*Enfrentamientos*/
insert into enfrentamientos (fecha, cod_jornada, hora, resultado, 
                            cod_equipo_local, cod_equipo_visitante)
values (TO_DATE('01/03/2024', 'dd/MM/yyyy'), 1, '16:00', (
    SELECT nombre FROM equipos WHERE cod_equipo = 1), 1, 2);
insert into enfrentamientos (fecha, cod_jornada, hora, resultado, 
                            cod_equipo_local, cod_equipo_visitante)
values (TO_DATE('01/03/2024', 'dd/MM/yyyy'), 1, '18:00', (
    SELECT nombre FROM equipos WHERE cod_equipo = 4), 3, 4);
insert into enfrentamientos (fecha, cod_jornada, hora, resultado, 
                            cod_equipo_local, cod_equipo_visitante)
values (TO_DATE('01/03/2024', 'dd/MM/yyyy'), 2, '10:00', (
SELECT nombre FROM equipos WHERE cod_equipo = 2), 1, 2);
insert into enfrentamientos (fecha, cod_jornada, hora, resultado, 
                            cod_equipo_local, cod_equipo_visitante)
values (TO_DATE('01/03/2024', 'dd/MM/yyyy'), 2, '12:00', (
SELECT nombre FROM equipos WHERE cod_equipo = 3), 3, 4);