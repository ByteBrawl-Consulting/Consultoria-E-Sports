package controlador.baseDeDatos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            int codEquipo = tablaEquipos.getCodigoEquipoPorNombre(nombreEquipo);
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

    public void bajaEquipoCompeticion(String nombreEquipo, String nombreCompeticion) {
        try {
            int codEquipo = tablaEquipos.getCodigoEquipoPorNombre(nombreEquipo);
            int codCompeticion = tablaCompeticiones.getCodigoCompeticionPorNombre(nombreCompeticion);

            if (codEquipo == -1 || codCompeticion == -1) {
                System.out.println("Equipo o Competición no encontrados");
                throw new Exception("Equipo o Competición no encontrados");
            }

            System.out.println("CodEquipo: " + codEquipo + ", CodCompeticion: " + codCompeticion);

            String plantilla = "DELETE FROM equipo_competicion WHERE cod_equipo = ? AND cod_competicion = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setInt(1, codEquipo);
            sentenciaPre.setInt(2, codCompeticion);

            int n = sentenciaPre.executeUpdate();
            if (n != 1) {
                throw new Exception("No se ha podido eliminar la asociación");
            } else {
                System.out.println("Asociación eliminada");
                mostrar("Asociación eliminada");
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

    public void aumentarPuntos(String equipoGanadorActual, String codEnfrentamiento)throws Exception{
        String equipo = equipoGanadorActual;
        String enfre = codEnfrentamiento;
        String codEquipo = sacarCodigoEquipo(equipo);
        int puntosActuales = obtenerPuntosActuales(equipo,enfre);
        puntosActuales = puntosActuales + 3;
        String plantilla ="UPDATE equipo_competicion " +
                "SET puntos = ?" +
                "WHERE cod_equipo = ?";
        PreparedStatement pre = con.prepareStatement(plantilla);
        pre.setString(1, String.valueOf(puntosActuales));
        pre.setString(2,codEquipo);
        pre.execute();
        pre.close();
    }

    private int obtenerPuntosActuales(String codEquipo, String codEnfrentamiento) throws Exception{

        String plantilla ="select puntos from enfrentamientos where cod_equipo=? and cod_enfrentamiento=?";
        PreparedStatement pre = con.prepareStatement(plantilla);
        pre.setString(1,codEquipo);
        pre.setString(2,codEnfrentamiento);
        ResultSet res = pre.executeQuery();
        return res.getInt(1);
    }

    private String sacarCodigoEquipo(String equipoGanadorActual) throws Exception{
        String plantilla ="select cod_equipo from equipos where nombre=?";
        PreparedStatement pre = con.prepareStatement(plantilla);
        pre.setString(1,equipoGanadorActual);
        ResultSet res = pre.executeQuery();
        return res.getString(1);
    }
}
