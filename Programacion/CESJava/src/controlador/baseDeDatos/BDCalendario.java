package controlador.baseDeDatos;

import javax.swing.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class BDCalendario {
    Connection con;
    ControladorBaseDeDatos cbd;

    public BDCalendario(Connection con, ControladorBaseDeDatos cbd) {
        this.con = con;
        this.cbd = cbd;
    }

    public void generarCalendario(int codCompeticion){
        try {
            String procedimiento = "GENERAR_CALENDARIO";
            String plantilla = "{call " + procedimiento + "(?)}";
            CallableStatement sentencia = con.prepareCall(plantilla);
            sentencia.setInt(1, codCompeticion);
            int n = sentencia.executeUpdate();
            if (n != 1){
                mostrar("Calendario no generado");
            }else{
                mostrar("Calendario generado");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void mostrar(String m) {
        JOptionPane.showMessageDialog(null, m);
    }
}
