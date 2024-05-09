package controlador.baseDeDatos;

import controlador.ControladorPrincipal;

import java.sql.*;

public class ControladorBaseDeDatos {

    public ControladorBaseDeDatos(ControladorPrincipal cp) {
        conexionBD();
    }

    public void conexionBD(){
        //Cargar el controlador de la BD
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //Conexion con la BD

        try {
            String url = "jdbc:oracle:thin:@SrvOracle:1521:orcl";
            String user = "eqdaw04";
            String passwd = "eqdaw04";
            Connection con = DriverManager.getConnection (url,user,passwd);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
