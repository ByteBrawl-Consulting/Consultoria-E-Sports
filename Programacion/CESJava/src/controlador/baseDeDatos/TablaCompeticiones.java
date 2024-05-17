package controlador.baseDeDatos;

import modelo.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TablaCompeticiones {
    Connection con;
    ControladorBaseDeDatos cbd;

    public TablaCompeticiones(Connection con, ControladorBaseDeDatos cbd) {
        this.con = con;
        this.cbd = cbd;
    }
    public void altaCompeticion(Competicion compe){
        try{
            String plantilla = "INSERT INTO competiciones (nombre,fecha_inicio,fecha_fin,curso,cod_juego) VALUES (?,?,?,?,?)";
            PreparedStatement sentencia = con.prepareStatement(plantilla);
            sentencia.setString(1, compe.getNombre());
            String fechaVentana1 = String.valueOf(compe.getFechaInicio());
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fechaJava1 = formato.parse(fechaVentana1);
            java.sql.Timestamp fechaSql1 = new java.sql.Timestamp(fechaJava1.getTime());
            sentencia.setTimestamp(2, fechaSql1);
            String fechaVentana2 = String.valueOf(compe.getFechaFin());
            java.util.Date fechaJava2 = formato.parse(fechaVentana2);
            java.sql.Timestamp fechaSql2 = new java.sql.Timestamp(fechaJava2.getTime());
            sentencia.setTimestamp(3, fechaSql2);
            sentencia.setInt(4, 0);
            sentencia.setObject(5, compe.getCodJuego().getCodJuego());
            int n = sentencia.executeUpdate();
            if (n != 1){
                mostrar("No se ha insertado ninguna competición");
            }else{
                mostrar("Competición insertada");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void bajaCompeticion(Competicion compe){
        try{
            String plantilla = "DELETE FROM competiciones WHERE nombre = ?";
            PreparedStatement sentencia = con.prepareStatement(plantilla);
            sentencia.setString(1, compe.getNombre());
            int n = sentencia.executeUpdate();
            sentencia.close();
            if (n == 1){
                mostrar("Competición borrada");
            }else{
                mostrar("Competición no encontrada");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void modiCompeticion(Competicion compe){
        try {
            String plantilla = "UPDATE competiciones SET fecha_inicio = ?, fecha_fin = ?, cod_juego = ? WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            String fechaVentana1 = String.valueOf(compe.getFechaInicio());
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fechaJava1 = formato.parse(fechaVentana1);
            java.sql.Timestamp fechaSql1 = new java.sql.Timestamp(fechaJava1.getTime());
            sentenciaPre.setTimestamp(1, fechaSql1);
            String fechaVentana2 = String.valueOf(compe.getFechaFin());
            java.util.Date fechaJava2 = formato.parse(fechaVentana2);
            java.sql.Timestamp fechaSql2 = new java.sql.Timestamp(fechaJava2.getTime());
            sentenciaPre.setTimestamp(2, fechaSql2);
            sentenciaPre.setObject(3, compe.getCodJuego().getCodJuego());
            sentenciaPre.setString(4, compe.getNombre());
            int n = sentenciaPre.executeUpdate();
            sentenciaPre.close();
            if (n == 1){
                mostrar("Competición actualizada");
            }else{
                mostrar("Competición no encontrada");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public StringBuilder consultaCompeticion(String nombreCompe){
        try{
            String plantilla = "SELECT fecha_inicio,fecha_fin,cod_juego FROM competiciones WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nombreCompe);
            ResultSet respuesta = sentenciaPre.executeQuery();
            StringBuilder pantalla = new StringBuilder();
            if (respuesta.next()){
                java.sql.Timestamp fechaInicio = respuesta.getTimestamp("fecha_inicio");
                java.sql.Timestamp fechaFin = respuesta.getTimestamp("fecha_fin");
                int codJuego = respuesta.getInt("cod_juego");
                Juego ju = cbd.getNombreJuegoPorCodigo(codJuego);
                pantalla.append("FECHA INICIO: ").append(fechaInicio).append("\n").append("FECHA FIN: ").append(fechaFin).append("\n").append("JUEGO: ").append(ju.getNombre());
            }
            return pantalla;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void mostrar(String m) {
        JOptionPane.showMessageDialog(null, m);
    }

    public int getCodigoCompeticionPorNombre(String nombreCompeticion) {
        try {
            String query = "SELECT cod_compe FROM competiciones WHERE nombre = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, nombreCompeticion);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("cod_compe");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
