package controlador;

import controlador.competiciones.ControladorCompeticion;
import controlador.equipos.ControladorEquipo;
import controlador.juegos.ControladorJuego;
import controlador.jugadores.ControladorJugador;
import controlador.login.ControladorLogin;
import controlador.patrocinadores.ControladorPatrocinador;
import modelo.*;
import view.VentanaPrincipalAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorVista {
    private ControladorPrincipal cp;
    private ControladorLogin cl;
    private VentanaPrincipalAdmin vpa;

    /* ----------- Controladores ----------- */
    private ControladorVentanaPrincipalAdmin cvpa;
    private ControladorEquipo ce;
    private ControladorCompeticion cc;
    private ControladorJuego cjueg;
    private ControladorJugador cjuga;
    private ControladorPatrocinador cpat;

//    private VentanaEquipos ve;



    public ControladorVista(ControladorPrincipal cp) {
        cl = new ControladorLogin(this);
        cvpa = new ControladorVentanaPrincipalAdmin();
        this.cp=cp;
    }

    public String login (Usuario usu) throws SQLException {
        return cp.login(usu);
    }

    public void modiStaff(Staff staff) {
        cp.modiStaff(staff);
    }

    public String cosultaStaff(String nombreSt) {
        return cp.consultaStaff(nombreSt).toString();
    }

    public void altaJugador(Jugador ju) {
        cp.altaJugador(ju);
    }

    public void bajaJugador(Jugador ju) {
        cp.bajaJugador(ju);
    }

    public void modiJugador(Jugador ju) {
        cp.modiJugador(ju);
    }

    public String consultaJugador(String nombre) {
        return cp.consultaJugador(nombre).toString();
    }

    /* ----------- Botones Ventana Administrador ------------- */
    public class controlEquipos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ce = new ControladorEquipo(ControladorVista.this);
        }
    }

    /* ----------- Metodos  ----------- */

    public void altaEquipo(Equipo eq) {
        cp.altaEquipo(eq);
    }

    public void bajaEquipo(Equipo eq) {
        cp.bajaEquipo(eq);
    }

    public void modiEquipo(Equipo eq) {
        cp.modiEquipo(eq);
    }
    public void altaStaff(Staff staff) {
        cp.altaStaff(staff);
    }
    public void bajaStaff(Staff staff) {
        cp.bajaStaff(staff);
    }

    public String consultaEquipo(String nombreEq) {
        return cp.consultaEquipo(nombreEq).toString();
    }
    public Equipo buscarEquipo(String nombreEq) {
        return cp.buscarEquipo(nombreEq);
    }

    public ArrayList ultimaJornada(Competicion com) {
        return cp.ultimaJornada(com);
    }
}