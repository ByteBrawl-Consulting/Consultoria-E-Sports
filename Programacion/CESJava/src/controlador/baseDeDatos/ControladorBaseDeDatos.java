package controlador.baseDeDatos;

import controlador.ControladorPrincipal;
import modelo.*;

import java.sql.*;
import java.util.ArrayList;

public class ControladorBaseDeDatos {
    private TablaJornadas tj;
    private TablaUsuarios tu;
    private TablaEquipos te;
    private TablaStaff ts;
    private TablaJugadores tju;
    private TablaJuegos tjue;
    private TablaPatrocinadores tp;
    private TablaCompeticiones tc;
    private TablaClasi tb;
    private Connection con;
    private TablaEquipoCompeticion tce;

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
        /*
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
        */
        /* ----------------- Conexion con la BD Local Casa (Test)  ----------------- */

            String url = "jdbc:oracle:thin:@localhost:1521:XE";
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
            }
    }

    /* ----------------- Metodo Inicializacion Tablas  ----------------- */

    public void inicializarTablas(ControladorPrincipal cp) {
        tu = new TablaUsuarios(con);
        ts = new TablaStaff(con);
        te = new TablaEquipos(con);
        tj = new TablaJornadas(con);
        tju = new TablaJugadores(con,this);
        tjue = new TablaJuegos(con);
        tp = new TablaPatrocinadores(con);
        tc = new TablaCompeticiones(con,this);
        tb = new TablaClasi(con);
        tce = new TablaEquipoCompeticion(con, te, tc);
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

    public void modiEquipo(Equipo eq, String fecha) {
        te.modiEquipo(eq, fecha);
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

    public void modiStaff(Staff staff, String cargo, Integer sueldo, Equipo cod_equipo) {
        ts.modiStaff(staff, cargo, sueldo, cod_equipo);
    }

    public String consultaStaff(String nombreSt) {
        return ts.consultaStaff(nombreSt).toString();
    }

    public Equipo buscarEquipo(String nombreEq) {
        return te.buscarEquipo(nombreEq);
    }
    public ArrayList ultimaJornada(Competicion com) {
        return tj.ultimaJornada(com);
    }

    public void altaJugador(Jugador ju) {
        tju.altaJugador(ju);
    }

    public void bajaJugador(Jugador ju) {
        tju.bajaJugador(ju);
    }

    public void modiJugador(Jugador ju,String fecha) {
        tju.modiJugador(ju, fecha);
    }

    public String consultaJugador(String nombre) {
        return tju.consultaJugador(nombre).toString();
    }

    public void altaJuego(Juego juego) {
        tjue.altaJuego(juego);
    }

    public void bajaJuego(Juego juego) {
        tjue.bajaJuego(juego);
    }

    public void modiJuego(Juego juego) {
        tjue.modiJuego(juego);
    }

    public Object consultaJuego(String nombreJu) {
        return tjue.consultaJuego(nombreJu).toString();
    }
    public Juego buscarJuego(String nombreJu){
        return tjue.buscarJuego(nombreJu);
    }
    public void altaPatrocinador(Patrocinador patr) {
        tp.altaPatrocinador(patr);
    }

    public void bajaPatrocinador(Patrocinador patr) {
        tp.bajaPatrocinador(patr);
    }

    public ArrayList calsificacion(Competicion com) {
        return tb.clasificacion(com);
    }
    public void altaCompeticion(Competicion compe) {
        tc.altaCompeticion(compe);
    }

    public void bajaCompeticion(Competicion compe) {
        tc.bajaCompeticion(compe);
    }

    public void modiCompeticion(Competicion compe) {
        tc.modiCompeticion(compe);
    }

    public String consultaCompeticion(String nombreCo) {
        return tc.consultaCompeticion(nombreCo).toString();
    }

    public void asociarEquipoCompeticion(String nombreEquipo, String nombreCompeticion) {
        tce.altaEquipoCompeticion(nombreEquipo, nombreCompeticion);
    }

    public void altaUsu(Usuario usu) throws Exception{
        tu.altaUsu(usu);
    }

    public Usuario comprobarUsu(Usuario usu) throws Exception{
        return tu.comprobarUsu(usu);
    }

    public Juego getNombreJuegoPorCodigo(int cod) {
        return tjue.getNombreJuegoPorCodigo(cod);
    }

    public Equipo getNombreEquipoPorCodigo(int codEquipo) {
        return te.getNombreEquipoPorCodigo(codEquipo);
    }
}