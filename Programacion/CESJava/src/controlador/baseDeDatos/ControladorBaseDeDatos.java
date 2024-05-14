package controlador.baseDeDatos;

import controlador.ControladorPrincipal;
import modelo.Competicion;
import modelo.Equipo;
import modelo.Staff;
import modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class ControladorBaseDeDatos {
    private TablaJornadas tj;
    private TablaUsuarios tu;
    private TablaEquipos te;
    private TablaStaff ts;
    private Connection con;

    public ControladorBaseDeDatos(ControladorPrincipal cp) {
        conexionBD(cp);
        inicializarTablas(cp);
    }

    public void conexionBD(ControladorPrincipal cp) {

        /* ----------------- Conexion con la BD Clase PC ----------------- */

//        String url = "jdbc:oracle:thin:@SrvOracle:1521:orcl";
//        String user = "eqdaw04";
//        String passwd = "eqdaw04";
//
//        try {
//            Class.forName("oracle.jdbc.OracleDriver");
//            con = DriverManager.getConnection(url, user, passwd);
//            System.out.println("Conexión exitosa a la base de datos");
//
//        } catch (SQLException e) {
//            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
      
        /* ----------------- Conexion con la BD Clase Portatil ----------------- */

        String url = "jdbc:oracle:thin:@172.20.225.114:1521:orcl";
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

//            String url = "jdbc:oracle:thin:@localhost:1521:XE";
//            String user = "userproyecto";
//            String passwd = "userproyecto";
//
//            try {
//                Class.forName("oracle.jdbc.OracleDriver");
//                con = DriverManager.getConnection(url, user, passwd);
//                System.out.println("Conexión exitosa a la base de datos");
//
//            } catch (SQLException e) {
//                System.out.println("Error al conectar a la base de datos: " + e.getMessage());
//            } catch (ClassNotFoundException e) {
//                throw new RuntimeException(e);
//            }
    }

    /* ----------------- Metodo Inicializacion Tablas  ----------------- */

    public void inicializarTablas(ControladorPrincipal cp) {
        tu = new TablaUsuarios(con);
        te = new TablaEquipos(con);
        tj = new TablaJornadas(con);
    }

    public String login (Usuario usu) throws SQLException {
        return tu.login(usu);
    }

    public void altaEquipo(Equipo eq) {
        te.altaEquipo(eq);
    }

    public void bajaEquipo(Equipo eq) {
        te.bajaEquipo(eq);
    }

    public void modiEquipo(Equipo eq) {
        te.modiEquipo(eq);
    }

    public String consultaEquipo(String nombreEq) {
        return te.consultaEquipo(nombreEq).toString();
    }

    public void altaStaff(Staff staff) {
        ts.altaStaff(staff);
    }

    public void bajaStaff(Staff staff) {
        ts.bajaStaff(staff);
    }

    public void modiStaff(Staff staff) {
        ts.modiStaff(staff);
    }

    public String consultaStaff(String nombreSt) {
        return ts.consultaStaff(nombreSt).toString();
    }

    public Equipo buscarEquipo(String nombreEq) {
        return te.buscarEquipo(nombreEq);
    }
}
