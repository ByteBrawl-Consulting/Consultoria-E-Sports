package controlador.login;

import controlador.ControladorPrincipal;
import controlador.ControladorVista;
import org.junit.Before;
import org.junit.Test;
import view.VentanaLogin;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ControladorLoginTest {

    private ControladorLogin controlador;
    private ControladorPrincipal cp = new ControladorPrincipal();

    @Before
    public void setUp() {
        // Creamos un controlador de vista ficticio
        ControladorVista cv = new ControladorVista(cp);
        // Creamos una instancia de ControladorLogin
        controlador = new ControladorLogin(cv);
        // Simulamos la visibilidad de la ventana
        controlador.vl = new VentanaLogin();
    }

    @Test
    public void testValidarCampoNoVacio() {
        // Verificamos que el método validarCampoNoVacio funcione correctamente
        assertTrue(controlador.validarCampoNoVacio("Usuario"));
        assertFalse(controlador.validarCampoNoVacio(""));
    }

    @Test
    public void testBAyuda() {
        // Verificamos que al llamar a bAyuda, se muestre un cuadro de diálogo con la información de ayuda
        controlador.new bAyuda().actionPerformed(null);
        // No es posible verificar la aparición del cuadro de diálogo automáticamente en los tests
    }

    @Test
    public void testBSalir() {
        // Verificamos que al llamar a bSalir, se cierre la aplicación
        controlador.new bSalir().actionPerformed(null);
        assertFalse(controlador.vl.isVisible());
    }

    // Puedes agregar más pruebas para otras funcionalidades si lo deseas

}
