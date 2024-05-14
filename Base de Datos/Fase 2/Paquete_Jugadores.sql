SET SERVEROUTPUT ON;
/*PAQUETE CRUD JUGADORES*/
/*SE USARA EN JAVA EN LAS VENTANAS DEDICADAS AL CRUD DE JUGADORES*/
CREATE OR REPLACE PACKAGE GESTION_JUGADORES AS
-- AGREGAR JUGADOR
    PROCEDURE AGREGAR_JUGADOR (
        V_NOMBRE VARCHAR2,
        V_NACIONALIDAD VARCHAR2,
        V_FECHA DATE,
        V_NICKNAME VARCHAR2,
        V_ROL VARCHAR2,
        V_SUELDO NUMBER,
        V_COD_EQUIPO NUMBER );
    
-- ELIMINAR JUGADOR
    PROCEDURE ELIMINAR_JUGADOR (V_NOM_JUGADOR VARCHAR2);
    
-- ACTUALIZAR JUGADOR
    PROCEDURE ACTUALIZAR_JUGADOR (
        V_NOMBRE VARCHAR2,
        V_NACIONALIDAD VARCHAR2,
        V_FECHA DATE,
        V_NICKNAME VARCHAR2,
        V_ROL VARCHAR2,
        V_SUELDO NUMBER );
        
END GESTION_JUGADORES;
/


CREATE OR REPLACE PACKAGE BODY GESTION_JUGADORES AS
-- AGREGAR JUGADOR 
    PROCEDURE AGREGAR_JUGADOR (
        V_NOMBRE VARCHAR2,
        V_NACIONALIDAD VARCHAR2,
        V_FECHA DATE,
        V_NICKNAME VARCHAR2,
        V_ROL VARCHAR2,
        V_SUELDO NUMBER,
        V_COD_EQUIPO NUMBER) IS
    BEGIN
        INSERT INTO JUGADORES (NOMBRE_JUGADOR,NACIONALIDAD,FECHA_NAC,NICKNAME,
        ROL,SUELDO,COD_EQUIPO)
        VALUES (V_NOMBRE,V_NACIONALIDAD,V_FECHA,V_NICKNAME,V_ROL,
        V_SUELDO,V_COD_EQUIPO);
        DBMS_OUTPUT.PUT_LINE ('JUGADOR INSERTADO CON EXITO');
    END AGREGAR_JUGADOR;

-- ELIMINAR JUGADOR
    PROCEDURE ELIMINAR_JUGADOR (
    V_NOM_JUGADOR VARCHAR2) IS
    BEGIN
        DELETE FROM JUGADORES WHERE UPPER(NOMBRE_JUGADOR) = V_NOM_JUGADOR;
        DBMS_OUTPUT.PUT_LINE ('JUGADOR ELIMINADO CON EXITO');
    END ELIMINAR_JUGADOR;

-- ACTUALIZAR JUGADOR
    PROCEDURE ACTUALIZAR_JUGADOR (
        V_NOMBRE VARCHAR2,
        V_NACIONALIDAD VARCHAR2,
        V_FECHA DATE,
        V_NICKNAME VARCHAR2,
        V_ROL VARCHAR2,
        V_SUELDO NUMBER ) IS
    BEGIN
        UPDATE JUGADORES SET
        NOMBRE_JUGADOR = V_NOMBRE,
        NACIONALIDAD = V_NACIONALIDAD,
        FECHA_NAC = V_FECHA,
        NICKNAME = V_NICKNAME,
        ROL = V_ROL,
        SUELDO = V_SUELDO
        WHERE UPPER(NOMBRE_JUGADOR) = V_NOMBRE;
        DBMS_OUTPUT.PUT_LINE ('JUGADOR ACTUALIZADO CON EXITO');
    END ACTUALIZAR_JUGADOR;    
END GESTION_JUGADORES;
