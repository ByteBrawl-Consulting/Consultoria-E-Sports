package controlador.baseDeDatos;

import modelo.Competicion;
import modelo.Juego;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class TablaCompeticiones {
    Connection con;

    public TablaCompeticiones(Connection con) {
        this.con = con;
    }
    public void altaCompeticion(Competicion compe){
        try{
            String plantilla = "INSERT INTO competiciones (nombre,fecha_inicio,fecha_fin,juego) VALUES (?,?,?,?)";
            PreparedStatement sentencia = con.prepareStatement(plantilla);
            sentencia.setString(1, compe.getNombre());
            String fechaVentana1 = String.valueOf(compe.getFechaInicio());
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fechaJava1 = formato.parse(fechaVentana1);
            java.sql.Date fechaSql1 = new java.sql.Date(fechaJava1.getTime());
            sentencia.setDate(2, fechaSql1);
            String fechaVentana2 = String.valueOf(compe.getFechaFin());
            java.util.Date fechaJava2 = formato.parse(fechaVentana2);
            java.sql.Date fechaSql2 = new java.sql.Date(fechaJava2.getTime());
            sentencia.setDate(3, fechaSql2);
            sentencia.setObject(4, compe.getCodJuego());
            int n = sentencia.executeUpdate();
            if (n != 1){
                throw new Exception("No se ha insertado ninguna competición");
            }else{
                throw new Exception("Competición insertada");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void bajaCompeticion(Competicion compe){
        try{
            String plantilla = "DELETE FROM competiciones WHERE nombre = ?";
            PreparedStatement sentencia = con.prepareStatement(plantilla);
            int n = sentencia.executeUpdate();
            sentencia.close();
            if (n == 1){
                throw new Exception("Competición borrada");
            }else{
                throw new Exception("Competición no encontrada");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void modiCompeticion(Competicion compe){
        try {
            String plantilla = "UPDATE competiciones SET fecha_inicio = ? AND fecha_fin = ? AND juego = ? WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, compe.getNombre());
            String fechaVentana1 = String.valueOf(compe.getFechaInicio());
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fechaJava1 = formato.parse(fechaVentana1);
            java.sql.Date fechaSql1 = new java.sql.Date(fechaJava1.getTime());
            sentenciaPre.setDate(2, fechaSql1);
            String fechaVentana2 = String.valueOf(compe.getFechaFin());
            java.util.Date fechaJava2 = formato.parse(fechaVentana1);
            java.sql.Date fechaSql2 = new java.sql.Date(fechaJava1.getTime());
            sentenciaPre.setDate(3, fechaSql2);
            sentenciaPre.setObject(4, compe.getCodJuego());
            int n = sentenciaPre.executeUpdate();
            sentenciaPre.close();
            if (n == 1){
                throw new Exception("Competición actualizada");
            }else{
                throw new Exception("Competición no encontrada");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Competicion consultaCompeticion(String nombreCompe){
        Competicion compe = null;
        try{
            String plantilla = "SELECT fecha_inicio,fecha_fin,juego FROM competiciones WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nombreCompe);
            ResultSet respuesta = sentenciaPre.executeQuery();
            if (respuesta.next()){
                java.sql.Date fechaInicio = respuesta.getDate("fecha_inicio");
                java.sql.Date fechaFin = respuesta.getDate("fecha_fin");
                Juego juego = (Juego) respuesta.getObject("juego");
                compe = new Competicion();
                compe.setNombre(nombreCompe);
                compe.setFechaInicio(fechaInicio.toLocalDate());
                compe.setFechaFin(fechaFin.toLocalDate());
                compe.setCodJuego(juego);
            }
            return compe;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
