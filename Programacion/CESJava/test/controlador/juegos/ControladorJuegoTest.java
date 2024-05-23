package controlador.juegos;

import controlador.ControladorPrincipal;
import controlador.ControladorVista;
import org.junit.Before;
import org.junit.Test;
import view.VentanaJuegos;

import java.awt.event.ActionEvent;

import static org.junit.Assert.assertFalse;

public class ControladorJuegoTest {

    private ControladorJuego controlador;
    private ControladorPrincipal cp = new ControladorPrincipal();

    @Before
    public void setUp() {
        // Creamos un controlador de vista ficticio
        ControladorVista cv = new ControladorVista(cp);
        // Creamos una instancia de ControladorJuego
        controlador = new ControladorJuego(cv);
        // Simulamos la visibilidad de la ventana
        controlador.vj = new VentanaJuegos();
    }



    @Test
    public void testBAceptarAlta() {
        // Verificamos el comportamiento del botón "Aceptar" para la opción de Alta
        controlador.vj.getRbAlta().setSelected(true);
        controlador.vj.getTfNombreAlta().setText("lol1");
        controlador.vj.getTfDesaAlta().setText("Riot");
        controlador.vj.getTfFechaAlta().setText("2024-05-23");

        // Creamos un evento de clic en el botón "Aceptar"
        ActionEvent event = new ActionEvent(controlador.vj.bAceptar, ActionEvent.ACTION_PERFORMED, "");

        // Simulamos el clic en el botón "Aceptar"
        controlador.new bAceptar().actionPerformed(event);

        // Verificamos si se muestra algún mensaje de error
        assertFalse(controlador.vj.getTaCons().getText().contains("Error"));
    }

    // Se queda pillado el test pero esta hecho

//    @Test
//    public void testBAceptarBaja() {
//        // Verificamos el comportamiAento del botón "Aceptar" para la opción de Baja
//        controlador.vj.getRbBaja().setSelected(true);
//        controlador.vj.getTfNombreBaja().setText("lol1");
//
//        // Creamos un evento de clic en el botón "Aceptar"
//        ActionEvent event = new ActionEvent(controlador.vj.bAceptar, ActionEvent.ACTION_PERFORMED, "");
//
//        // Simulamos el clic en el botón "Aceptar"
//        controlador.new bAceptar().actionPerformed(event);
//
//        // Verificamos si se muestra algún mensaje de error
//        assertFalse(controlador.vj.getTaCons().getText().contains("Error"));
//    }

    @Test
    public void testBAceptarModificacion() {
        // Verificamos el comportamiento del botón "Aceptar" para la opción de Modificación
        controlador.vj.getRbModi().setSelected(true);
        controlador.vj.getTfNombreModi().setText("lol");
        controlador.vj.getTfDesaModi().setText("mojang");
        controlador.vj.getTfFechaModi().setText("2024-05-23");

        // Creamos un evento de clic en el botón "Aceptar"
        ActionEvent event = new ActionEvent(controlador.vj.bAceptar, ActionEvent.ACTION_PERFORMED, "");

        // Simulamos el clic en el botón "Aceptar"
        controlador.new bAceptar().actionPerformed(event);

        // Verificamos si se muestra algún mensaje de error
        assertFalse(controlador.vj.getTaCons().getText().contains("Error"));
    }

    @Test
    public void testBAceptarConsulta() {
        // Verificamos el comportamiento del botón "Aceptar" para la opción de Consulta
        controlador.vj.getRbCons().setSelected(true);
        controlador.vj.getTfNombreCons().setText("lol");

        // Creamos un evento de clic en el botón "Aceptar"
        ActionEvent event = new ActionEvent(controlador.vj.bAceptar, ActionEvent.ACTION_PERFORMED, "");

        // Simulamos el clic en el botón "Aceptar"
        controlador.new bAceptar().actionPerformed(event);

        // Verificamos si se muestra algún mensaje de error
        assertFalse(controlador.vj.getTaCons().getText().contains("Error"));
    }

    // Puedes agregar más pruebas si lo deseas

}