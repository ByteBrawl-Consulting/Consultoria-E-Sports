package controlador.cerrar_inscripciones;

import controlador.ControladorPrincipal;
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
        cv = new ControladorVista(new ControladorPrincipal());
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
}