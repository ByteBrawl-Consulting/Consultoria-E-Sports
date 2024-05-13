package controlador;

import controlador.competiciones.ControladorCompeticion;
import controlador.equipos.ControladorEquipo;
import controlador.juegos.ControladorJuego;
import controlador.jugadores.ControladorJugador;
import controlador.login.ControladorLogin;
import controlador.patrocinadores.ControladorPatrocinador;
import modelo.Competicion;
import modelo.Equipo;
import modelo.Staff;
import modelo.Usuario;
import view.VentanaPrincipalAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ControladorVista {
    private ControladorPrincipal cp;
    private ControladorLogin cl;
    private VentanaPrincipalAdmin vpa;

    /* ----------- Controladores ----------- */
    private ControladorEquipo ce;
    private ControladorCompeticion cc;
    private ControladorJuego cjueg;
    private ControladorJugador cjuga;
    private ControladorPatrocinador cpat;

//    private VentanaEquipos ve;



    public ControladorVista(ControladorPrincipal cp) {
        cl = new ControladorLogin(this);
        this.cp=cp;
        iniciarBotones();
    }

    public String login (Usuario usu) throws SQLException {
        return cp.login(usu);
    }
    public void iniciarBotones(){
        vpa = new VentanaPrincipalAdmin();
        vpa.addMEquipos(new controlEquipos());
    }

    /* ----------- Botones Menus ------------- */
    public class controlEquipos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            ve = new VentanaEquipos();
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
    public void ultimaJornada(Competicion com) {
        cp.ultimaJornada(com);
    }

}