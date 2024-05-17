package controlador.baseDeDatos;

import modelo.Juego;

import javax.swing.*;
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
            String plantilla = "INSERT INTO juegos (nombre,desarrolladora,fecha_lanzamiento) VALUES (?,?,?)";
            PreparedStatement sentencia = con.prepareStatement(plantilla);
            sentencia.setString(1, juego.getNombre());
            sentencia.setString(2, juego.getDesarrolladora());
            String fechaVentana = String.valueOf(juego.getFechaLanzamiento());
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fechaJava = formato.parse(fechaVentana);
            java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
            sentencia.setDate(3, fechaSql);
            int n = sentencia.executeUpdate();
            if (n != 1){
                mostrar("No se ha insertado ningún juego");
            }else{
                mostrar("Juego insertado");
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
                mostrar("Juego borrado");
            }else{
                mostrar("Juego no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void modiJuego(Juego juego){
        try {
            String plantilla = "UPDATE juegos SET desarrolladora = ?, fecha_lanzamiento = ? WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(3, juego.getNombre());
            String fechaVentana = String.valueOf(juego.getFechaLanzamiento());
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fechaJava = formato.parse(fechaVentana);
            java.sql.Timestamp fechaSql = new java.sql.Timestamp(fechaJava.getTime());
            sentenciaPre.setTimestamp(2, fechaSql);
            sentenciaPre.setString(1, juego.getDesarrolladora());
            int n = sentenciaPre.executeUpdate();
            sentenciaPre.close();
            if (n == 1){
                mostrar("Juego actualizado");
            }else{
                mostrar("Juego no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public StringBuilder consultaJuego(String nombreJu){
        Juego juego = null;
        try {
            String plantilla = "SELECT desarrolladora,fecha_lanzamiento FROM juegos WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nombreJu);
            ResultSet respuesta = sentenciaPre.executeQuery();
            StringBuilder pantalla = new StringBuilder();
            if (respuesta.next()){
                String desarrolladora = respuesta.getString("desarrolladora");
                java.sql.Timestamp fecha = respuesta.getTimestamp("fecha_lanzamiento");
                pantalla.append("DESARROLLADORA: ").append(desarrolladora).append("\n").append("FECHA LANZAMIENTO: ").append(fecha);
            }
            return pantalla;
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
    public Juego getNombreJuegoPorCodigo(int cod){
        Juego juego = null;
        try {
            String plantilla = "SELECT nombre FROM juegos WHERE cod_juego = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setInt(1, cod);
            ResultSet respuesta = sentenciaPre.executeQuery();
            if (respuesta.next()){
            String nombreJuego = respuesta.getString("nombre");
                juego = new Juego();
                juego.setNombre(nombreJuego);
                juego.setCodJuego(cod);
            }
            return juego;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void mostrar(String m) {
        JOptionPane.showMessageDialog(null, m);
    }
}
