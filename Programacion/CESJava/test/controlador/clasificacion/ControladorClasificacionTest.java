package controlador.clasificacion;

import controlador.ControladorVista;
import org.junit.Before;
import org.junit.Test;
import view.VentanaClasificacionAdmin;

public class ControladorClasificacionTest {

    private ControladorClasificacion controlador;
    private ControladorVista cv;

    @Before
    public void setUp() {
        cv = new ControladorVista(null);
        controlador = new ControladorClasificacion(cv);
        controlador.vca = new VentanaClasificacionAdmin();
    }

    @Test
    public void testLlenarCB() {
        controlador.llenarCB();
    }

    @Test
    public void testBSalirActionPerformed() {
        controlador.vca.getSalirButton().doClick();
    }
}