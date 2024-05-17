package controlador;

import controlador.admin.ControladorAdmin;
import controlador.clasificacion.ControladorClasificacion;
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
    private ControladorAdmin cvpa;
    private ControladorEquipo ce;
    private ControladorCompeticion cc;
    private ControladorJuego cjueg;
    private ControladorJugador cjuga;
    private ControladorPatrocinador cpat;
    private ControladorClasificacion ccl;



    public ControladorVista(ControladorPrincipal cp) {
        cl = new ControladorLogin(this);
        this.cp=cp;
    }

    public String login (Usuario usu) throws SQLException {
        return cp.login(usu);
    }

    public void modiStaff(Staff staff, String cargo, Integer sueldo, Equipo cod_equipo) {
        cp.modiStaff(staff, cargo, sueldo, cod_equipo);
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

    public void modiJugador(Jugador ju, String fecha) {
        cp.modiJugador(ju, fecha);
    }

    public String consultaJugador(String nombre) {
        return cp.consultaJugador(nombre).toString();
    }

    public void altaJuego(Juego juego) {
        cp.altaJuego(juego);
    }

    public void bajaJuego(Juego juego) {
        cp.bajaJuego(juego);
    }

    public void modiJuego(Juego juego) {
        cp.modiJuego(juego);
    }

    public String consultaJuego(String nombreJu) {
        return cp.consultaJuego(nombreJu).toString();
    }

    public void altaPatrocinador(Patrocinador patr) {
        cp.altaPatrocinador(patr);
    }

    public void bajaPatrocinador(Patrocinador patr) {
        cp.bajaPatrocinador(patr);
    }

    public void altaUsu(Usuario usu) throws Exception{
        cp.altaUsu(usu);
    }

    public Usuario comprobarUsu(Usuario usu) throws Exception{
       return cp.comprobarUsu(usu);
    }

    public ArrayList clasiEquipos() throws Exception{
        return cp.clasiEquipos();
    }

    public ArrayList clasificacionAdmin(Competicion com) {
        return cp.clasificacionAdmin(com);
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

    public void modiEquipo(Equipo eq, String fecha) {
        cp.modiEquipo(eq, fecha);
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
    public Juego buscarJuego(String nombreJu){
        return cp.buscarJuego(nombreJu);
    }
    public Equipo buscarEquipo(String nombreEq) {
        return cp.buscarEquipo(nombreEq);
    }

    public ArrayList ultimaJornada(Competicion com) {
        return cp.ultimaJornada(com);
    }
    public void altaCompeticion(Competicion compe) {
        cp.altaCompeticion(compe);
    }

    public void bajaCompeticion(Competicion compe) {
        cp.bajaCompeticion(compe);
    }

    public void modiCompeticion(Competicion compe) {
        cp.modiCompeticion(compe);
    }

    public String consultaCompeticion(String nombreCo) {
        return cp.consultaCompeticion(nombreCo).toString();
    }

    public ArrayList clasificacion(Competicion com) {
        return cp.clasificacion(com);
    }

    public void asociarEquipoCompeticion(String nombreEquipo, String nombreCompeticion) {
        cp.asociarEquipoCompeticion(nombreEquipo, nombreCompeticion);
    }
}