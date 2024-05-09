package controlador.baseDeDatos;

import modelo.Equipos;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
                throw new Exception("No se ha insertado ningún vuelo");
            }else{
                throw new Exception("Vuelo insertado");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
