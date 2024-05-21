package controlador.baseDeDatos;

import modelo.Competicion;
import modelo.Equipo;

import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Clase que maneja las operaciones relacionadas con los equipos en la base de datos.
 */

public class TablaEquipos {
    private Connection con;

    /**
     * Constructor para inicializar la conexión a la base de datos.
     *
     * @param con La conexión a la base de datos.
     */

    public TablaEquipos(Connection con) {
        this.con = con;
    }

    /**
     * Inserta un nuevo equipo en la base de datos.
     *
     * @param eq El equipo a insertar.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

    public void altaEquipo(Equipo eq) {
        try {
            String plantilla = "INSERT INTO equipos (nombre,fecha_fundacion) VALUES (?,?)";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, eq.getNombre());
            String fechaVentana = String.valueOf(eq.getFechaFundacion());
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fechaJava = formato.parse(fechaVentana);
            java.sql.Timestamp fechaSql = new java.sql.Timestamp(fechaJava.getTime());
            sentenciaPre.setTimestamp(2, fechaSql);
            int n = sentenciaPre.executeUpdate();
            if (n != 1) {
                mostrar("No se ha insertado ningún equipo");
            } else {
                mostrar("Equipo insertado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Elimina un equipo de la base de datos.
     *
     * @param eq El equipo a eliminar.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

    public void bajaEquipo(Equipo eq) {
        try {
            String plantilla = "DELETE FROM equipos WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, eq.getNombre());
            int n = sentenciaPre.executeUpdate();
            sentenciaPre.close();
            if (n == 1) {
                mostrar("Equipo borrado");
            } else {
                mostrar("Equipo no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Actualiza la fecha de fundación de un equipo en la base de datos.
     *
     * @param eq    El equipo a actualizar.
     * @param fecha La nueva fecha de fundación.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

    public void modiEquipo(Equipo eq, String fecha) {
        try {
            String plantilla = "UPDATE equipos SET fecha_fundacion = ? WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            String fechaVentana = fecha;
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fechaJava = formato.parse(fechaVentana);
            java.sql.Timestamp fechaSql = new java.sql.Timestamp(fechaJava.getTime());
            sentenciaPre.setTimestamp(1, fechaSql);
            sentenciaPre.setString(2, eq.getNombre());
            int n = sentenciaPre.executeUpdate();
            sentenciaPre.close();
            if (n == 1) {
                mostrar("Equipo actualizado");
            } else {
                mostrar("Equipo no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Consulta y devuelve información sobre un equipo en la base de datos.
     *
     * @param nombreEq El nombre del equipo a consultar.
     * @return Un StringBuilder con la información del equipo.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

    public StringBuilder consultaEquipo(String nombreEq) {
        Equipo eq = null;
        try {
            String plantilla = "SELECT cod_equipo,fecha_fundacion FROM equipos WHERE (nombre) = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nombreEq);
            ResultSet respuesta = sentenciaPre.executeQuery();
            StringBuilder pantalla = new StringBuilder();
            if (respuesta.next()) {
                Timestamp fechaBD = respuesta.getTimestamp("fecha_fundacion");
                pantalla.append("CODIGO EQUIPO: ").append(respuesta.getString("cod_equipo")).append("\n").append("FECHA FUNDACION: ").append(fechaBD);
            }
            return pantalla;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Busca y devuelve un equipo por su nombre.
     *
     * @param nombreEq El nombre del equipo a buscar.
     * @return El equipo encontrado, o null si no se encuentra.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

    public Equipo buscarEquipo(String nombreEq) {
        Equipo eq = null;
        try {
            String plantilla = "SELECT cod_equipo FROM equipos WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nombreEq);
            ResultSet respuesta = sentenciaPre.executeQuery();
            if (respuesta.next()) {
                int codEquipo = respuesta.getInt("cod_equipo");
                eq = new Equipo();
                eq.setNombre(nombreEq);
                eq.setCodEquipo(codEquipo);
            }
            return eq;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Muestra un mensaje en un cuadro de diálogo.
     *
     * @param m El mensaje a mostrar.
     */

    public void mostrar(String m) {
        JOptionPane.showMessageDialog(null, m);
    }

    /**
     * Obtiene el código de un equipo por su nombre.
     *
     * @param nombreEquipo El nombre del equipo.
     * @return El código del equipo, o -1 si no se encuentra.
     */

    public int getCodigoEquipoPorNombre(String nombreEquipo) {
        try {
            String query = "SELECT cod_equipo FROM equipos WHERE nombre = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, nombreEquipo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("cod_equipo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Devuelve -1 si no se encuentra el equipo
    }

    /**
     * Obtiene un equipo por su código.
     *
     * @param codEquipo El código del equipo.
     * @return El equipo encontrado, o null si no se encuentra.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

    public Equipo getNombreEquipoPorCodigo(int codEquipo) {
        Equipo equipo = null;
        try {
            String plantilla = "SELECT nombre FROM equipos WHERE cod_equipo = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setInt(1, codEquipo);
            ResultSet respuesta = sentenciaPre.executeQuery();
            if (respuesta.next()) {
                String nombreJuego = respuesta.getString("nombre");
                equipo = new Equipo();
                equipo.setNombre(nombreJuego);
                equipo.setCodEquipo(codEquipo);
            }
            return equipo;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Obtiene una lista de equipos asociados a una competición.
     *
     * @param competicion La competición para la cual se desean obtener los equipos.
     * @return Una lista de equipos asociados a la competición.
     */

    public ArrayList<Equipo> obtenerEquiposPorCompeticion(Competicion competicion) {
        ArrayList<Equipo> equipos = new ArrayList<>();
        try {

            String query = "SELECT e.cod_equipo, e.nombre FROM equipos e " +
                    "INNER JOIN equipo_competicion ec ON e.cod_equipo = ec.cod_equipo " +
                    "INNER JOIN competiciones c ON ec.cod_competicion = c.cod_compe " +
                    "WHERE c.nombre = ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, competicion.getNombre());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Equipo equipo = new Equipo();
                equipo.setCodEquipo(rs.getInt("cod_equipo"));
                equipo.setNombre(rs.getString("nombre"));
                equipos.add(equipo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipos;
    }
}
