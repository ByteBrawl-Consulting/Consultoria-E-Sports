package controlador.competiciones;

import controlador.ControladorPrincipal;
import controlador.ControladorVista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class ControladorCompeticionTest {

    private ControladorCompeticion controladorCompeticion;

    @BeforeEach
    void setUp() {
        controladorCompeticion = new ControladorCompeticion(new ControladorVista(new ControladorPrincipal()));

        controladorCompeticion.vc.getRbAlta().setSelected(true);
    }

    @Test
    void testMostrar() {
        controladorCompeticion.mostrar();
        assertFalse(controladorCompeticion.vc.getpAlta().isVisible());
        assertFalse(controladorCompeticion.vc.getpBaja().isVisible());
        assertFalse(controladorCompeticion.vc.getpModi().isVisible());
        assertFalse(controladorCompeticion.vc.getpCons().isVisible());
    }

    @Test
    void testBAceptarAltaSinNombre() {
        controladorCompeticion.vc.getTfNombreAlta().setText("Nombre");
        controladorCompeticion.vc.getTfFechaIniAlta().setText("2024-05-23");
        controladorCompeticion.vc.getTfFechaFinAlta().setText("2024-05-30");
        controladorCompeticion.vc.getTfJuegoAlta().setText("Juego");
        JOptionPane.getRootFrame().dispose();
        controladorCompeticion.new bAceptar().actionPerformed(new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, ""));
        assertTrue(controladorCompeticion.vc.getpAlta().isVisible());
    }

    @Test
    void testBAceptarBajaSinNombre() {
        controladorCompeticion.vc.getTfNombreBaja().setText("Nombre");
        controladorCompeticion.vc.getRbBaja().setSelected(true);
        JOptionPane.getRootFrame().dispose();
        controladorCompeticion.new bAceptar().actionPerformed(new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, ""));
        assertTrue(controladorCompeticion.vc.getpBaja().isVisible());
    }
}
