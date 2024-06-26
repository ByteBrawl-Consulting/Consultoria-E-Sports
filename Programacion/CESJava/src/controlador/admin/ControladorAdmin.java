package controlador.admin;

import controlador.ControladorVista;
import controlador.cerrar_inscripciones.ControladorCerrarInscripciones;
import controlador.clasificacion.ControladorClasificacion;
import controlador.competiciones.ControladorCompeticion;
import controlador.equipo_competicion.ControladorEquipoCompeticion;
import controlador.equipos.ControladorEquipo;
import controlador.generar_xml.ControladorXML;
import controlador.introducir_resultados.ControladorIntroducirResultados;
import controlador.calendario.ControladorCalendario;
import controlador.juegos.ControladorJuego;
import controlador.jugadores.ControladorJugador;
import controlador.patrocinador_equipo.ControladorPatrEqui;
import controlador.patrocinadores.ControladorPatrocinador;
import controlador.registrar.ControladorRegistrar;
import controlador.resultados_todas_jornadas.ControladorResultadosTJornadas;
import controlador.staff.ControladorStaff;
import view.VentanaEquipos;
import view.VentanaPrincipalAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador para la interfaz de administrador.
 */

public class ControladorAdmin {
    private ControladorVista cv;
    private VentanaPrincipalAdmin vpa;
    private ControladorEquipo ce;
    private ControladorJugador cj;
    private ControladorStaff cs;
    private ControladorJuego cje;
    private ControladorPatrocinador cp;
    private ControladorCompeticion cc;
    private ControladorEquipoCompeticion cec;
    private ControladorRegistrar cr;
    private ControladorClasificacion ccl;
    private ControladorPatrEqui cpe;
    private ControladorCerrarInscripciones cci;
    private ControladorResultadosTJornadas crtj;
    private ControladorCalendario cgc;
    private ControladorIntroducirResultados cir;
    private ControladorXML cxml;

    /**
     * Constructor para crear una instancia de ControladorAdmin.
     * @param cv el controlador de la vista principal
     */

    public ControladorAdmin(ControladorVista cv) {
        mostrar();
        botones();
        this.cv=cv;
    }

    /**
     * Muestra la ventana principal de administrador.
     */

    public void mostrar() {
        vpa = new VentanaPrincipalAdmin();
        vpa.setVisible(true);
    }

    /**
     * Asigna acciones a los botones de la interfaz de administrador.
     */

    public void botones() {
        vpa.addBSalir(new bSalir());
        vpa.addBEquipos(new bEquipo());
        vpa.addBJugadores(new bJugador());
        vpa.addBStaff(new bStaff());
        vpa.addBJuegos(new bJuegos());
        vpa.addBCompeticiones(new bCompeticiones());
        vpa.addBPatrocinadores(new bPatrocinadores());
        vpa.addBAsociarEquiCompe(new bAsociarEquiCompe());
        vpa.bAltaUSu(new bAltaUsu());
        vpa.cerrarSesion(new cerrarSesion());
        vpa.addClasi(new clasi());
        vpa.addBAsociarPatrocinadorEquipo(new bAsociarPatroEqui());
        vpa.addBCerrarEtapaInscripcion(new bCierreInscripciones());
        vpa.addBResultadosJornadas(new bResultadosJornadas());
        vpa.addBGenerarCalendario(new bGenerarCalendario());
        vpa.addBIntroducirResultados(new bIntroducirResultados());
        vpa.addBGenerarXML(new bGenerarXML());
    }

    private class cerrarSesion implements ActionListener{
        public void actionPerformed (ActionEvent e){
            vpa.dispose();
        }
    }

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public class bEquipo implements ActionListener{
        public void actionPerformed(ActionEvent e){
            ce = new ControladorEquipo(cv);
        }
    }

    private class bJugador implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cj = new ControladorJugador(cv);
        }
    }

    private class bStaff implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cs = new ControladorStaff(cv);
        }
    }

    private class bJuegos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cje = new ControladorJuego(cv);
        }
    }

    private class bCompeticiones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cc = new ControladorCompeticion(cv);
        }
    }

    private class bPatrocinadores implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cp = new ControladorPatrocinador(cv);
        }
    }

    private class bAsociarEquiCompe implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cec = new ControladorEquipoCompeticion(cv);
        }
    }

    private class bAltaUsu implements ActionListener{
        public void actionPerformed (ActionEvent e){
            cr = new ControladorRegistrar(cv);
        }
    }

    private class clasi implements ActionListener{
        public void actionPerformed (ActionEvent e){
            ccl = new ControladorClasificacion(cv);
        }
    }

    public class bAsociarPatroEqui implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cpe = new ControladorPatrEqui(cv);
        }
    }

    public class bCierreInscripciones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cci = new ControladorCerrarInscripciones(cv);
        }
    }

    public class bResultadosJornadas implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            crtj = new ControladorResultadosTJornadas(cv);
        }
    }

    public class bGenerarCalendario implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cgc = new ControladorCalendario(cv);
        }
    }

    public class bIntroducirResultados implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cir = new ControladorIntroducirResultados(cv);
        }
    }

    public class bGenerarXML implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cxml = new ControladorXML(cv);
        }
    }
}
