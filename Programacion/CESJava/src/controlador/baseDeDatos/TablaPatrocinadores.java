package controlador.baseDeDatos;

import modelo.Equipo;
import modelo.Patrocinador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class TablaPatrocinadores {
    private Connection con;

    public TablaPatrocinadores(Connection con) {
        this.con = con;
    }
    public void altaPatrocinador(Patrocinador patrocinador){
        try {
            String plantilla = "INSERT INTO patrocinadores (nombre) VALUES (?)";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, patrocinador.getNombre());
            int n =sentenciaPre.executeUpdate();
            if (n != 1){
                throw new Exception("No se ha insertado ningún patrocinador");
            }else{
                throw new Exception("Patrocinador insertado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void bajaPatrocinador(Patrocinador patrocinador){
        try {
            String plantilla = "DELETE FROM patrocinadores WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, patrocinador.getNombre());
            int n = sentenciaPre.executeUpdate();
            sentenciaPre.close();
            if (n == 1){
                throw new Exception("Patrocinador borrado");
            }else{
                throw new Exception("Patrocinador no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
