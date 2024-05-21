package controlador.baseDeDatos;

import modelo.Equipo;
import modelo.Staff;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * La clase TablaStaff gestiona las operaciones relacionadas con el personal del equipo en la base de datos.
 */

public class TablaStaff {
    Connection con;
    ControladorBaseDeDatos cbd;

    /**
     * Constructor de la clase TablaStaff.
     *
     * @param con  La conexión a la base de datos.
     * @param cbd  El controlador de la base de datos.
     */

    public TablaStaff(Connection con, ControladorBaseDeDatos cbd) {
        this.con = con;
        this.cbd = cbd;
    }

    /**
     * Agrega un nuevo miembro del personal al equipo en la base de datos.
     *
     * @param staff  El objeto Staff que representa al nuevo miembro del personal.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

    public void altaStaff(Staff staff) {
        try {
            String plantilla = "INSERT INTO staff (nombre,cargo,sueldo,cod_equipo) VALUES (?,?,?,?)";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, staff.getNombre());
            sentenciaPre.setString(2, staff.getCargo());
            sentenciaPre.setInt(3, staff.getSueldo());
            sentenciaPre.setObject(4, staff.getCodEquipo().getCodEquipo());
            int n = sentenciaPre.executeUpdate();
            if (n != 1) {
                mostrar("No se ha insertado ningún Staff");
            } else {
                mostrar("Staff insertado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Elimina un miembro del personal del equipo en la base de datos.
     *
     * @param staff  El objeto Staff que representa al miembro del personal a eliminar.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

    public void bajaStaff(Staff staff) {
        try {
            String plantilla = "DELETE FROM staff WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, staff.getNombre());
            int n = sentenciaPre.executeUpdate();
            sentenciaPre.close();
            if (n == 1) {
                mostrar("Staff borrado");
            } else {
                mostrar("Staff no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Actualiza la información de un miembro del personal del equipo en la base de datos.
     *
     * @param staff       El objeto Staff que representa al miembro del personal cuya información se actualizará.
     * @param cargo       El nuevo cargo del miembro del personal.
     * @param sueldo      El nuevo sueldo del miembro del personal.
     * @param cod_equipo  El nuevo código de equipo al que pertenece el miembro del personal.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

    public void modiStaff(Staff staff, String cargo, Integer sueldo, Equipo cod_equipo) {
        try {
            String plantilla = "UPDATE staff SET cargo = ?, sueldo = ?, cod_equipo = ? WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, cargo);
            sentenciaPre.setInt(2, sueldo);
            sentenciaPre.setObject(3, staff.getCodEquipo().getCodEquipo());
            sentenciaPre.setString(4, staff.getNombre());
            int n = sentenciaPre.executeUpdate();
            sentenciaPre.close();
            if (n == 1) {
                mostrar("Staff actualizado");
            } else {
                mostrar("Staff no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Realiza una consulta sobre la información de un miembro del personal del equipo en la base de datos.
     *
     * @param nombreStaff  El nombre del miembro del personal a consultar.
     * @return             Un StringBuilder que contiene la información del miembro del personal consultado.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

    public StringBuilder consultaStaff(String nombreStaff) {
        Staff staff = null;
        try {
            String plantilla = "SELECT cargo,sueldo,cod_equipo FROM staff WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nombreStaff);
            ResultSet respuesta = sentenciaPre.executeQuery();
            StringBuilder pantalla = new StringBuilder();
            if (respuesta.next()) {
                Integer sueldo = respuesta.getInt("sueldo");
                String cargo = respuesta.getString("cargo");
                int codEquipo = respuesta.getInt("cod_equipo");
                Equipo eq = cbd.getNombreEquipoPorCodigo(codEquipo);
                pantalla.append("CARGO: ").append(cargo).append("\n").append("SUELDO: ").append(sueldo).append("\n").append("EQUIPO: ").append(eq.getNombre().toUpperCase());
            }
            return pantalla;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Muestra un mensaje en una ventana emergente.
     *
     * @param m  El mensaje a mostrar.
     */

    public void mostrar(String m) {
        JOptionPane.showMessageDialog(null, m);
    }
}
