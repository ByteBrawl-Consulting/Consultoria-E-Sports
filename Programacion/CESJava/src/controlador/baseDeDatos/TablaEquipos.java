package controlador.baseDeDatos;

import modelo.Equipos;
import oracle.jdbc.proxy.annotation.Pre;
import oracle.jdbc.replay.internal.ReplayableConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TablaEquipos {
    Connection con;
    public void altaEquipo (Equipos eq){
        try {
            String plantilla = "INSERT INTO equipos (nombre,fecha_fundacion) VALUES (?,?)";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, eq.getNombre());
            String fechaVentana = String.valueOf(eq.getFechaFundacion());
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fechaJava = formato.parse(fechaVentana);
            java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
            sentenciaPre.setDate(2, fechaSql);
            int n =sentenciaPre.executeUpdate();
            if (n != 1){
                throw new Exception("No se ha insertado ningún equipo");
            }else{
                throw new Exception("Equipo insertado");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void bajaEquipo(Equipos eq){
        try {
            String plantilla = "DELETE FROM equipos WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, eq.getNombre());
            int n = sentenciaPre.executeUpdate();
            sentenciaPre.close();
            if (n == 1){
                throw new Exception("Equipo borrado");
            }else{
                throw new Exception("Equipo no encontrado");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void modiEquipo(Equipos eq){
        try {
            String plantilla = "UPDATE equipos SET fecha_fundacion = ? WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            String fechaVentana = String.valueOf(eq.getFechaFundacion());
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fechaJava = formato.parse(fechaVentana);
            java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
            sentenciaPre.setDate(1, fechaSql);
            sentenciaPre.setString(2, eq.getNombre());
            int n = sentenciaPre.executeUpdate();
            sentenciaPre.close();
            if (n == 1){
                throw new Exception("Equipo actualizado");
            }else{
                throw new Exception("Equipo no encontrado");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Equipos consultaEquipo(String nombreEq){
        Equipos eq = null;
        try {
            String plantilla = "SELECT cod_equipo,fecha_fundacion FROM equipos WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nombreEq);
            ResultSet respuesta = sentenciaPre.executeQuery();
            if (respuesta.next()){
                Integer codEquipo = respuesta.getInt("cod_equipo");
                java.sql.Date fecha = respuesta.getDate("fecha_fundacion");
                eq = new Equipos();
                eq.setNombre(nombreEq);
                eq.setFechaFundacion(fecha);
                eq.setCodEquipo(codEquipo);
            }
            return eq;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
