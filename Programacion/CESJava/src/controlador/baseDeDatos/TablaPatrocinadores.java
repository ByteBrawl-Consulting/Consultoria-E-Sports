package controlador.baseDeDatos;

import modelo.Equipo;
import modelo.Patrocinador;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                mostrar("No se ha insertado ningún patrocinador");
            }else{
                mostrar("Patrocinador insertado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void bajaPatrocinador(Patrocinador patrocinador){
        try {
            String plantilla = "DELETE FROM patrocinadores WHERE upper(nombre) = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, patrocinador.getNombre());
            int n = sentenciaPre.executeUpdate();
            sentenciaPre.close();
            if (n == 1){
                mostrar("Patrocinador borrado");
            }else{
                mostrar("Patrocinador no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int getCodigoPatrocinadorPorNombre(String nombrePatrocinador) {
        try {
            String query = "SELECT cod_patrocinadores FROM patrocinadores WHERE upper(nombre) = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, nombrePatrocinador);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("cod_patrocinadores");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void mostrar(String m) {
        JOptionPane.showMessageDialog(null, m);
    }
}
