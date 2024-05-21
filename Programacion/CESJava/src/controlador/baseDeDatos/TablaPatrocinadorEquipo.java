package controlador.baseDeDatos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaPatrocinadorEquipo {

    private Connection con;
    private TablaEquipos tablaEquipos;
    private TablaPatrocinadores tablaPatrocinadores;

    public TablaPatrocinadorEquipo(Connection con, TablaEquipos tablaEquipos, TablaPatrocinadores tablaPatrocinadores) {
        this.con = con;
        this.tablaEquipos = tablaEquipos;
        this.tablaPatrocinadores = tablaPatrocinadores;
    }

    public void altaPatrocinadorEquipo(String nombrePatrocinador, String nombreEquipo) {
        try {
            int codPatrocinador = tablaPatrocinadores.getCodigoPatrocinadorPorNombre(nombrePatrocinador);
            int codEquipo = tablaEquipos.getCodigoEquipoPorNombre(nombreEquipo);

            if (codPatrocinador == -1 || codEquipo == -1) {
                System.out.println("Patrocinador o Equipo no encontrados");
                throw new Exception("Patrocinador o Equipo no encontrados");
            }

            System.out.println("CodPatrocinador: " + codPatrocinador + ", CodEquipo: " + codEquipo);

            String plantilla = "INSERT INTO patrocinadores_equipos (cod_patrocinadores, cod_equipo) VALUES (?, ?)";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setInt(1, codPatrocinador);
            sentenciaPre.setInt(2, codEquipo);

            int n = sentenciaPre.executeUpdate();
            if (n != 1) {
                throw new Exception("No se ha podido asociar");
            } else {
                System.out.println("Asociación insertada");
                mostrar("Asociación insertada");
            }
        } catch (SQLException e) {
            System.out.println("SQL Error Code: " + e.getErrorCode());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Error Message: " + e.getMessage());
            e.printStackTrace(); // Logs Depuración
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace(); // Logs Depuración
            throw new RuntimeException(e);
        }
    }

    public void bajaPatrocinadorEquipo(String nombrePatrocinador, String nombreEquipo) {
        try {
            int codPatrocinador = tablaPatrocinadores.getCodigoPatrocinadorPorNombre(nombrePatrocinador);
            int codEquipo = tablaEquipos.getCodigoEquipoPorNombre(nombreEquipo);

            if (codPatrocinador == -1 || codEquipo == -1) {
                System.out.println("Patrocinador o Equipo no encontrados");
                throw new Exception("Patrocinador o Equipo no encontrados");
            }

            System.out.println("CodPatrocinador: " + codPatrocinador + ", CodEquipo: " + codEquipo);

            String plantilla = "DELETE FROM patrocinadores_equipos WHERE cod_patrocinadores = ? AND cod_equipo = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setInt(1, codPatrocinador);
            sentenciaPre.setInt(2, codEquipo);

            int n = sentenciaPre.executeUpdate();
            if (n != 1) {
                throw new Exception("No se ha podido desasociar");
            } else {
                System.out.println("Asociación eliminada");
                mostrar("Asociación eliminada");
            }
        } catch (SQLException e) {
            System.out.println("SQL Error Code: " + e.getErrorCode());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Error Message: " + e.getMessage());
            e.printStackTrace(); // Logs Depuración
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace(); // Logs Depuración
            throw new RuntimeException(e);
        }
    }

    public List<String> getEquiposPorPatrocinador(String nombrePatrocinador) {
        List<String> equipos = new ArrayList<>();
        try {
            String query = "SELECT e.nombre " +
                    "FROM equipos e " +
                    "JOIN patrocinadores_equipos pe ON e.cod_equipo = pe.cod_equipo " +
                    "JOIN patrocinadores p ON pe.cod_patrocinadores = p.cod_patrocinadores " +
                    "WHERE upper(p.nombre) = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, nombrePatrocinador);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                equipos.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipos;
    }

    public List<String> getPatrocinadoresPorEquipo(String nombreEquipo) {
        List<String> patrocinadores = new ArrayList<>();
        try {
            String query = "SELECT p.nombre " +
                    "FROM patrocinadores p " +
                    "JOIN patrocinadores_equipos pe ON p.cod_patrocinadores = pe.cod_patrocinadores " +
                    "JOIN equipos e ON pe.cod_equipo = e.cod_equipo " +
                    "WHERE upper(e.nombre) = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, nombreEquipo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                patrocinadores.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patrocinadores;
    }

    public void mostrar(String m) {
        JOptionPane.showMessageDialog(null, m);
    }
}
