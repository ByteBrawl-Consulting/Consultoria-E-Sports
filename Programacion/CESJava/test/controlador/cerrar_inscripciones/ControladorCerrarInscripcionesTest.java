package controlador.cerrar_inscripciones;

import controlador.ControladorVista;
import org.junit.Before;
import org.junit.Test;
import view.VentanaCerrarInscripciones;

import javax.swing.*;

public class ControladorCerrarInscripcionesTest {

    private ControladorCerrarInscripciones controlador;
    private ControladorVista cv;

    @Before
    public void setUp() {
        cv = new ControladorVista(null);
        controlador = new ControladorCerrarInscripciones(cv);
        controlador.vci = new VentanaCerrarInscripciones();
    }

    @Test
    public void testLlenarCB() {
        controlador.llenarCB();
    }

    @Test
    public void testItemListenerCompeticionItemStateChanged() {
        controlador.llenarCB();
        JComboBox<String> comboBox = controlador.vci.getCbCompeticion();
        comboBox.setSelectedItem("Competición");
    }

    @Test
    public void testBAceptarActionPerformed() {
        controlador.llenarCB();
        JComboBox<String> comboBox = controlador.vci.getCbCompeticion();
        comboBox.setSelectedIndex(1);
        controlador.vci.getAceptarButton().doClick();
    }

}