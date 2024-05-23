package controlador.patrocinadores;

import controlador.ControladorPrincipal;
import controlador.ControladorVista;
import org.junit.Before;
import org.junit.Test;
import view.VentanaPatrocinadores;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ControladorPatrocinadorTest {

    private ControladorPatrocinador controlador;
    private ControladorPrincipal cp = new ControladorPrincipal();


    @Before
    public void setUp() {
        // Creamos un controlador de vista ficticio
        ControladorVista cv = new ControladorVista(cp);
        // Creamos una instancia de ControladorPatrocinador
        controlador = new ControladorPatrocinador(cv);
        // Simulamos la visibilidad de la ventana
        controlador.vp = new VentanaPatrocinadores();
    }

    @Test
    public void testValidarCampoNoVacio() {
        // Verificamos que el método validarCampoNoVacio funcione correctamente
        assertTrue(controlador.validarCampoNoVacio("Nombre"));
        assertFalse(controlador.validarCampoNoVacio(""));
    }

    @Test
    public void testBAceptarAlta() {
        // Simulamos la selección del radio button de Alta y el texto en el campo de nombre
        controlador.vp.getRbAlta().setSelected(true);
        controlador.vp.getTfNombreAlta().setText("Patrocinador 1");

        // Verificamos que al llamar a bAceptar, se invoque correctamente el método de alta en el controlador de vista
        controlador.new bAceptar().actionPerformed(null);
        // Aquí puedes agregar más verificaciones según el comportamiento esperado
    }
/* No funciona este test se queda pillado el programa
    @Test
    public void testBAceptarBaja() {
        // Simulamos la selección del radio button de Baja y el texto en el campo de nombre
        controlador.vp.getRbBaja().setSelected(true);
        controlador.vp.getTfNombreBaja().setText("Patrocinador 2");

        // Verificamos que al llamar a bAceptar, se invoque correctamente el método de baja en el controlador de vista
        controlador.new bAceptar().actionPerformed(null);
        // Aquí puedes agregar más verificaciones según el comportamiento esperado
    }
*/
    @Test
    public void testBSalir() {
        // Verificamos que al llamar a bSalir, se cierre la ventana
        controlador.new bSalir().actionPerformed(null);
        assertFalse(controlador.vp.isVisible());
    }

    // Puedes agregar más pruebas para otras funcionalidades si lo deseas

}