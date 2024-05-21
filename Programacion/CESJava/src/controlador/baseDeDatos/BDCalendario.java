package controlador.baseDeDatos;

import javax.swing.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * La clase BDCalendario proporciona métodos para generar un calendario
 * de competición utilizando procedimientos almacenados en una base de datos.
 */
public class BDCalendario {
    Connection con;
    ControladorBaseDeDatos cbd;

    /**
     * Crea una nueva instancia de BDCalendario.
     *
     * @param con la conexión a la base de datos
     * @param cbd el controlador de base de datos
     */
    public BDCalendario(Connection con, ControladorBaseDeDatos cbd) {
        this.con = con;
        this.cbd = cbd;
    }

    /**
     * Genera el calendario para una competición específica.
     *
     * @param codCompeticion el código de la competición
     * @throws RuntimeException si ocurre un error de SQL
     */
    public void generarCalendario(int codCompeticion) {
        try {
            String procedimiento = "GENERAR_CALENDARIO";
            String plantilla = "{call " + procedimiento + "(?)}";
            CallableStatement sentencia = con.prepareCall(plantilla);
            sentencia.setInt(1, codCompeticion);
            int n = sentencia.executeUpdate();
            if (n != 1) {
                mostrar("Calendario no generado");
            } else {
                mostrar("Calendario generado");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Muestra un mensaje en un cuadro de diálogo.
     *
     * @param m el mensaje a mostrar
     */
    private void mostrar(String m) {
        JOptionPane.showMessageDialog(null, m);
    }
}
