package controlador.baseDeDatos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TablaEquipoCompeticion {
    private Connection con;
    private TablaEquipos tablaEquipos;
    private TablaCompeticiones tablaCompeticiones;

    public TablaEquipoCompeticion(Connection con, TablaEquipos tablaEquipos, TablaCompeticiones tablaCompeticiones) {
        this.con = con;
        this.tablaEquipos = tablaEquipos;
        this.tablaCompeticiones = tablaCompeticiones;
    }

    public void altaEquipoCompeticion(String nombreEquipo, String nombreCompeticion) {
        try {
            int codEquipo = tablaEquipos.getCodigoEquipo(nombreEquipo);
            int codCompeticion = tablaCompeticiones.getCodigoCompeticionPorNombre(nombreCompeticion);

            if (codEquipo == -1 || codCompeticion == -1) {
                System.out.println("Equipo o Competición no encontrados");
                throw new Exception("Equipo o Competición no encontrados");
            }

            System.out.println("CodEquipo: " + codEquipo + ", CodCompeticion: " + codCompeticion);

            String plantilla = "INSERT INTO equipo_competicion (cod_equipo, cod_competicion, puntos) VALUES (?, ?, ?)";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setInt(1, codEquipo);
            sentenciaPre.setInt(2, codCompeticion);
            sentenciaPre.setInt(3, 0);

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
            e.printStackTrace(); // Logs Depuracion
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace(); // Logs Depuracion
            throw new RuntimeException(e);
        }
    }

    public void mostrar(String m) {
        JOptionPane.showMessageDialog(null, m);
    }
}
