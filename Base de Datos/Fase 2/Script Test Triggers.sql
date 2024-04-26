/* Script para probar Funcionalidada de los Triggers */

/* Prueba Trigger 6 Jugadores Max por Equipo */
SELECT * FROM JUGADORES WHERE COD_EQUIPO = 1;

INSERT INTO JUGADORES (NOMBRE_JUGADOR, NACIONALIDAD, FECHA_NAC, NICKNAME, ROL,
SUELDO, COD_EQUIPO) VALUES ('Oscar Cañellas', 'España', 
                            TO_DATE('10/10/1995', 'DD/MM/YYYY'), 'Mixwell', 
                            'MID', 2000, 1);
                            
INSERT INTO JUGADORES (NOMBRE_JUGADOR, NACIONALIDAD, FECHA_NAC, NICKNAME, ROL,
SUELDO, COD_EQUIPO) VALUES ('Zahir Rivera', 'Peru', 
                            TO_DATE('28/07/2005', 'DD/MM/YYYY'), 'Za', 
                            'SUPPORT', 1000, 1);

SELECT * FROM JUGADORES WHERE COD_EQUIPO = 1;

ROLLBACK;

/* Prueba Trigger 2 Jugadores Minimo por Equipo */
INSERT INTO EQUIPOS (NOMBRE, FECHA_FUNDACION) VALUES ('Team Test 21 Trig',
                                        TO_DATE('12/06/2011', 'DD/MM/YYYY'));
                                        
SELECT COD_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE) = 'TEAM TEST 21 TRIG';
                                        
INSERT INTO JUGADORES (NOMBRE_JUGADOR, NACIONALIDAD, FECHA_NAC, NICKNAME, ROL,
SUELDO, COD_EQUIPO) VALUES ('Juan Marquina', 'España', 
                            TO_DATE('10/10/1995', 'DD/MM/YYYY'), 'Juanmi', 
                            'MID', 2000, 21);
                                        
INSERT INTO EQUIPOS (NOMBRE, FECHA_FUNDACION) VALUES ('Team Test 22 Trig',
                                        TO_DATE('12/06/2011', 'DD/MM/YYYY'));
                                        
SELECT COD_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE) = 'TEAM TEST 22 TRIG';

INSERT INTO JUGADORES (NOMBRE_JUGADOR, NACIONALIDAD, FECHA_NAC, NICKNAME, ROL,
SUELDO, COD_EQUIPO) VALUES ('Alonso Codere', 'España', 
                            TO_DATE('10/10/1995', 'DD/MM/YYYY'), 'Alocod', 
                            'MID', 2000, 22);

INSERT INTO JUEGOS (NOMBRE, DESARROLLADORA, FECHA_LANZAMIENTO)
VALUES ('TEST TRIG 1', 'ADRIAN', '21/11/2023');

SELECT COD_JUEGO FROM JUEGOS WHERE UPPER(NOMBRE) = 'TEST TRIG 1';

INSERT INTO COMPETICIONES 
(NOMBRE, FECHA_INICIO, FECHA_FIN, CURSO, EQUIPO_GANADOR, COD_JUEGO)
VALUES ('TEST TRIG', '26/04/2024', '27/04/2024', 0, NULL, 7);

INSERT INTO EQUIPO_COMPETICION (COD_EQUIPO, COD_COMPETICION) VALUES (21,22);
                                        
ROLLBACK;

/* Prueba Trigger Numero de Equipos Par */
INSERT INTO EQUIPOS (NOMBRE, FECHA_FUNDACION) VALUES ('Team Test 31 Trig',
                                        TO_DATE('12/06/2011', 'DD/MM/YYYY'));
                                        
SELECT COD_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE) = 'TEAM TEST 31 TRIG';
                                        
INSERT INTO JUGADORES (NOMBRE_JUGADOR, NACIONALIDAD, FECHA_NAC, NICKNAME, ROL,
SUELDO, COD_EQUIPO) VALUES ('Charles Lukia', 'España', 
                            TO_DATE('10/10/1995', 'DD/MM/YYYY'), 'Charli', 
                            'MID', 2000, 1);
                                        
INSERT INTO EQUIPOS (NOMBRE, FECHA_FUNDACION) VALUES ('Team Test 32 Trig',
                                        TO_DATE('12/06/2011', 'DD/MM/YYYY'));
                                        
SELECT COD_EQUIPO FROM EQUIPOS WHERE UPPER(NOMBRE) = 'TEAM TEST 32 TRIG';

INSERT INTO JUGADORES (NOMBRE_JUGADOR, NACIONALIDAD, FECHA_NAC, NICKNAME, ROL,
SUELDO, COD_EQUIPO) VALUES ('Za RetaBet', 'España', 
                            TO_DATE('10/10/1995', 'DD/MM/YYYY'), 'ZaBet', 
                            'MID', 2000, 1);

INSERT INTO JUEGOS (NOMBRE, DESARROLLADORA, FECHA_LANZAMIENTO)
VALUES ('TEST TRIG 1', 'ADRIAN', '21/11/2023');

SELECT COD_JUEGO FROM JUEGOS WHERE UPPER(NOMBRE) = 'TEST TRIG 1';