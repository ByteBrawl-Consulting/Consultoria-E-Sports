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
import org.junit.Before;
import org.junit.Test;
import view.VentanaPrincipalAdmin;

import java.awt.*;
import java.awt.event.ActionEvent;

public class ControladorAdminTest {

    private ControladorAdmin controlador;

    @Before
    public void setUp() {
        ControladorVista cv = new ControladorVista(null);
        controlador = new ControladorAdmin(cv);
    }

    @Test
    public void testBotones() {
        controlador.botones();
    }

    @Test
    public void testBSalirActionPerformed() {
        controlador.new bSalir().actionPerformed(new ActionEvent(new Button(), 0, ""));
    }

    @Test
    public void testBEquipoActionPerformed() {
        controlador.new bEquipo().actionPerformed(new ActionEvent(new Button(), 0, ""));
    }

    @Test
    public void testBJugadorActionPerformed() {
        controlador.new bJugador().actionPerformed(new ActionEvent(new Button(), 0, ""));
    }

    @Test
    public void testBStaffActionPerformed() {
        controlador.new bStaff().actionPerformed(new ActionEvent(new Button(), 0, ""));
    }

    @Test
    public void testBJuegosActionPerformed() {
        controlador.new bJuegos().actionPerformed(new ActionEvent(new Button(), 0, ""));
    }

    @Test
    public void testBCompeticionesActionPerformed() {
        controlador.new bCompeticiones().actionPerformed(new ActionEvent(new Button(), 0, ""));
    }

    @Test
    public void testBPatrocinadoresActionPerformed() {
        controlador.new bPatrocinadores().actionPerformed(new ActionEvent(new Button(), 0, ""));
    }

    @Test
    public void testBAsociarEquiCompeActionPerformed() {
        controlador.new bAsociarEquiCompe().actionPerformed(new ActionEvent(new Button(), 0, ""));
    }

    @Test
    public void testBAltaUsuActionPerformed() {
        controlador.new bAltaUsu().actionPerformed(new ActionEvent(new Button(), 0, ""));
    }

    @Test
    public void testClasiActionPerformed() {
        controlador.new clasi().actionPerformed(new ActionEvent(new Button(), 0, ""));
    }

    @Test
    public void testBAsociarPatroEquiActionPerformed() {
        controlador.new bAsociarPatroEqui().actionPerformed(new ActionEvent(new Button(), 0, ""));
    }

    @Test
    public void testBCierreInscripcionesActionPerformed() {
        controlador.new bCierreInscripciones().actionPerformed(new ActionEvent(new Button(), 0, ""));
    }

    @Test
    public void testBResultadosJornadasActionPerformed() {
        controlador.new bResultadosJornadas().actionPerformed(new ActionEvent(new Button(), 0, ""));
    }

    @Test
    public void testBGenerarCalendarioActionPerformed() {
        controlador.new bGenerarCalendario().actionPerformed(new ActionEvent(new Button(), 0, ""));
    }

    @Test
    public void testBIntroducirResultadosActionPerformed() {
        controlador.new bIntroducirResultados().actionPerformed(new ActionEvent(new Button(), 0, ""));
    }

    @Test
    public void testBGenerarXMLActionPerformed() {
        controlador.new bGenerarXML().actionPerformed(new ActionEvent(new Button(), 0, ""));
    }
}
