package controlador.baseDeDatos;

import modelo.Juego;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class TablaJuegos {
    Connection con;
    public TablaJuegos(Connection con) {
        this.con = con;
    }
    public void altaJuego (Juego juego){
        try{
            String plantilla = "INSERT INTO juegos (nombre,desarrolladore,fecha_lanzamiento) VALUES (?,?,?)";
            PreparedStatement sentencia = con.prepareStatement(plantilla);
            sentencia.setString(1, juego.getNombre());
            sentencia.setString(2, juego.getDesarrolladora());
            String fechaVentana = String.valueOf(juego.getFechaLanzamiento());
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fechaJava = formato.parse(fechaVentana);
            java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
            sentencia.setDate(3, fechaSql);
            int n = sentencia.executeUpdate();
            if (n != 1){
                throw new Exception("No se ha insertado ningún juego");
            }else{
                throw new Exception("Juego insertado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void bajaJuego(Juego juego){
        try{
            String plantilla = "DELETE FROM juegos WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, juego.getNombre());
            int n = sentenciaPre.executeUpdate();
            sentenciaPre.close();
            if (n == 1){
                throw new Exception("Juego borrado");
            }else{
                throw new Exception("Juego no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void modiJuego(Juego juego){
        try {
            String plantilla = "UPDATE juegos SET desarrolladora = ? AND fecha_lanzamiento = ? WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, juego.getNombre());
            String fechaVentana = String.valueOf(juego.getFechaLanzamiento());
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fechaJava = formato.parse(fechaVentana);
            java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
            sentenciaPre.setDate(2, fechaSql);
            int n = sentenciaPre.executeUpdate();
            sentenciaPre.close();
            if (n == 1){
                throw new Exception("Juego actualizado");
            }else{
                throw new Exception("Juego no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Juego consultaJuego(String nombreJu){
        Juego juego = null;
        try {
            String plantilla = "SELECT desarrolladora,fecha_lanzamiento FROM juegos WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nombreJu);
            ResultSet respuesta = sentenciaPre.executeQuery();
            if (respuesta.next()){
                String desarrolladora = respuesta.getString("desarrolladora");
                java.sql.Date fecha = respuesta.getDate("fecha_lanzamiento");
                juego = new Juego();
                juego.setNombre(nombreJu);
                juego.setFechaLanzamiento(fecha.toLocalDate());
                juego.setDesarrolladora(desarrolladora);
            }
            return juego;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Juego buscarJuego(String nombreJu){
        Juego juego = null;
        try {
            String plantilla = "SELECT cod_juego FROM juegos WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nombreJu);
            ResultSet respuesta = sentenciaPre.executeQuery();
            if (respuesta.next()){
                int codJuego = respuesta.getInt("cod_juego");
                juego = new Juego();
                juego.setNombre(nombreJu);
                juego.setCodJuego(codJuego);
            }
            return juego;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}