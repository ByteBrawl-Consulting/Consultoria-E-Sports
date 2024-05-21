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

    public void aumentarPuntos(String equipoGanadorActual, String codEnfrentamiento, String nombreCompe)throws Exception{
        String equipo = equipoGanadorActual;
        String codCompe = tablaCompeticiones.sacarNumCompe(nombreCompe);
        String codEquipo = sacarCodigoEquipo(equipo);
        int puntosActuales = Integer.parseInt(obtenerPuntosActuales(codEquipo,codCompe));
        puntosActuales = puntosActuales + 3;
        String plantilla ="UPDATE equipo_competicion " +
                "SET puntos = ?" +
                "WHERE cod_equipo = ?";
        PreparedStatement pre = con.prepareStatement(plantilla);
        pre.setString(1, String.valueOf(puntosActuales));
        pre.setString(2, String.valueOf(codEquipo));
        pre.execute();
        pre.close();
    }

    private String obtenerPuntosActuales(String codEquipo, String codEnfrentamiento) throws Exception{

        String plantilla ="select puntos from equipo_competicion where cod_equipo=? and cod_competicion=?";
        PreparedStatement pre = con.prepareStatement(plantilla);
        pre.setString(1, String.valueOf(codEquipo));
        pre.setString(2,codEnfrentamiento);
        ResultSet res = pre.executeQuery();
        res.next();
        String puntos = String.valueOf(res.getInt(1));
        return puntos;
    }

    private String sacarCodigoEquipo(String equipoGanadorActual) throws Exception{
        String plantilla ="select cod_equipo from equipos where nombre=?";
        PreparedStatement pre = con.prepareStatement(plantilla);
        pre.setString(1,equipoGanadorActual);
        ResultSet res = pre.executeQuery();
        res.next();
        String codEquipo = res.getString(1);
        return codEquipo;
    }

   /* public void restarPuntosEquipo(String codEnfrentamiento, String equipoGanador) throws Exception {
        int codEquipo = Integer.parseInt(sacarCodigoEquipo());
        int puntos = Integer.parseInt(obtenerPuntosActuales(codEnfrentamiento, String.valueOf(codEquipo)));
        puntos = puntos - 3;
        String query = "UPDATE enfrentamientos " +
                "SET puntos = ? " +
                "WHERE cod_equipo = ?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(puntos));
        preparedStatement.setString(2, String.valueOf(codEquipo));
        preparedStatement.executeUpdate();
    }*/
}
