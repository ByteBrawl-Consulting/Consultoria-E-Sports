package controlador.baseDeDatos;

import modelo.Equipo;
import modelo.Patrocinador;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * La clase TablaPatrocinadores gestiona las operaciones relacionadas con la tabla de patrocinadores en la base de datos.
 */

public class TablaPatrocinadores {
    private Connection con;

    /**
     * Constructor de la clase TablaPatrocinadores.
     *
     * @param con La conexión a la base de datos.
     */

    public TablaPatrocinadores(Connection con) {
        this.con = con;
    }

    /**
     * Agrega un nuevo patrocinador a la base de datos.
     *
     * @param patrocinador El patrocinador a ser agregado.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

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

    /**
     * Elimina un patrocinador de la base de datos.
     *
     * @param patrocinador El patrocinador a ser eliminado.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

    public void bajaPatrocinador(Patrocinador patrocinador){
        try {
            String plantilla = "DELETE FROM patrocinadores WHERE nombre = ?";
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

    /**
     * Obtiene el código de un patrocinador dado su nombre.
     *
     * @param nombrePatrocinador El nombre del patrocinador.
     * @return El código del patrocinador, o -1 si no se encuentra.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

    public int getCodigoPatrocinadorPorNombre(String nombrePatrocinador) {
        try {
            String query = "SELECT cod_patrocinadores FROM patrocinadores WHERE nombre = ?";
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

    /**
     * Muestra un mensaje en una ventana emergente.
     *
     * @param m El mensaje a ser mostrado.
     */

    public void mostrar(String m) {
        JOptionPane.showMessageDialog(null, m);
    }
}
