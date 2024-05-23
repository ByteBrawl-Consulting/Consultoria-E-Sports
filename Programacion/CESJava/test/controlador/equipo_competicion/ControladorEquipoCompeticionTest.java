package controlador.equipo_competicion;

import controlador.ControladorPrincipal;
import controlador.ControladorVista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class ControladorEquipoCompeticionTest {

    private ControladorEquipoCompeticion controladorEquipoCompeticion;

    @BeforeEach
    void setUp() {
        controladorEquipoCompeticion = new ControladorEquipoCompeticion(new ControladorVista(new ControladorPrincipal()));
    }

    @Test
    void testMostrar() {
        controladorEquipoCompeticion.toString();
        assertFalse(controladorEquipoCompeticion.vaec.getpAlta().isVisible());
        assertFalse(controladorEquipoCompeticion.vaec.getpBaja().isVisible());
    }

    @Test
    void testBAceptarAltaSinNombre() {
        controladorEquipoCompeticion.vaec.getTfEquiAlta().setText("Equipo");
        controladorEquipoCompeticion.vaec.getTfCompeAlta().setText("Competicion");
        controladorEquipoCompeticion.vaec.getAltaRadioButton().setSelected(true);
        JOptionPane.getRootFrame().dispose();
        controladorEquipoCompeticion.new bAceptar().actionPerformed(new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, ""));
        assertTrue(controladorEquipoCompeticion.vaec.getpAlta().isVisible());
    }

    @Test
    void testBAceptarBajaSinNombre() {
        controladorEquipoCompeticion.vaec.getTfEquiBaja().setText("Equipo");
        controladorEquipoCompeticion.vaec.getTfCompeBaja().setText("Competicion");
        controladorEquipoCompeticion.vaec.getBajaRadioButton().setSelected(true);
        JOptionPane.getRootFrame().dispose();
        controladorEquipoCompeticion.new bAceptar().actionPerformed(new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, ""));
        assertTrue(controladorEquipoCompeticion.vaec.getpBaja().isVisible());
    }
}
