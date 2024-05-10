package controlador.baseDeDatos;

import controlador.ControladorPrincipal;
import modelo.Equipos;
import modelo.Usuarios;

import java.sql.*;

public class ControladorBaseDeDatos {

    private TablaUsuarios tu;
    private TablaEquipos te;
    private Connection con;

    public ControladorBaseDeDatos(ControladorPrincipal cp) {
        conexionBD(cp);
       inicializarTablas(cp);
    }

    public void conexionBD(ControladorPrincipal cp) {

        /* ----------------- Conexion con la BD Clase ----------------- */

        String url = "jdbc:oracle:thin:@SrvOracle:1521:orcl";
        String user = "eqdaw04";
        String passwd = "eqdaw04";

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection(url, user, passwd);
            System.out.println("Conexión exitosa a la base de datos");

        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        /* ----------------- Conexion con la BD Local Casa (Test)  ----------------- */

            /*String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String user = "userproyecto";
            String passwd = "userproyecto";

            try {
                Class.forName("oracle.jdbc.OracleDriver");
                con = DriverManager.getConnection(url, user, passwd);
                System.out.println("Conexión exitosa a la base de datos");
                
            } catch (SQLException e) {
                System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }*/
    }

    /* ----------------- Metodo Inicializacion Tablas  ----------------- */

    public void inicializarTablas(ControladorPrincipal cp) {
        tu = new TablaUsuarios(con);
    }

    public String login (Usuarios usu) throws SQLException {
        System.out.println("cbd");
        return tu.login(usu);
    }

    public void altaEquipo(Equipos eq) {
        te.altaEquipo(eq);
    }

    public void bajaEquipo(Equipos eq) {
        te.bajaEquipo(eq);
    }

    public void modiEquipo(Equipos eq) {
        te.modiEquipo(eq);
    }

    public void consultaEquipo(Equipos eq) {
        te.consultaEquipo(eq);
    }
}
