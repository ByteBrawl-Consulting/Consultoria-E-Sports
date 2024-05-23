package controlador.equipos;

import controlador.ControladorPrincipal;
import controlador.ControladorVista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;

class ControladorEquipoTest {

    private ControladorEquipo controladorEquipo;

    @BeforeEach
    void setUp() {
        // Se inicializa el controlador
        controladorEquipo = new ControladorEquipo(new ControladorVista(new ControladorPrincipal()));
    }

    @Test
    void testMostrar() {
        controladorEquipo.mostrar();
        assertFalse(controladorEquipo.ve.getpAlta().isVisible());
        assertFalse(controladorEquipo.ve.getpBaja().isVisible());
        assertFalse(controladorEquipo.ve.getpConsulta().isVisible());
        assertFalse(controladorEquipo.ve.getpModificacion().isVisible());
    }

    @Test
    void testBAceptarAltaSinNombre() {
        controladorEquipo.ve.getTfNombreAlta().setText("Nombre");
        controladorEquipo.ve.getTfFechaAlta().setText("2024-05-23");
        controladorEquipo.ve.getRbAlta().setSelected(true);
        controladorEquipo.new bAceptar().actionPerformed(new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, ""));
        assertTrue(controladorEquipo.ve.getpAlta().isVisible());
    }

    @Test
    void testBAceptarAltaSinFecha() {
        controladorEquipo.ve.getTfNombreAlta().setText("Equipo Test");
        controladorEquipo.ve.getTfFechaAlta().setText("Fecha Fundación");
        controladorEquipo.ve.getRbAlta().setSelected(true);
        controladorEquipo.new bAceptar().actionPerformed(new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, ""));
        assertTrue(controladorEquipo.ve.getpAlta().isVisible());
    }
}
