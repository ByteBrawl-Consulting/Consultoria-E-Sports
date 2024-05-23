package controlador.calendario;

import controlador.ControladorVista;
import org.junit.Before;
import org.junit.Test;
import view.VentanaGenerarCalendario;

import javax.swing.*;

public class ControladorCalendarioTest {

    private ControladorCalendario controlador;
    private ControladorVista cv;

    @Before
    public void setUp() {
        cv = new ControladorVista(null);
        controlador = new ControladorCalendario(cv);
        controlador.vc = new VentanaGenerarCalendario();
    }

    @Test
    public void testLlenarCB() {
        controlador.llenarCB();
    }
}
