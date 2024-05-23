package controlador.jugadores;

import controlador.ControladorPrincipal;
import controlador.ControladorVista;
import org.junit.Before;
import org.junit.Test;
import view.VentanaJugadores;

import java.awt.event.ActionEvent;

import static org.junit.Assert.assertFalse;

public class ControladorJugadorTest {

    private ControladorJugador controlador;
    private ControladorPrincipal cp = new ControladorPrincipal();


    @Before
    public void setUp() {
        // Creamos un controlador de vista ficticio
        ControladorVista cv = new ControladorVista(cp);
        // Creamos una instancia de ControladorJugador
        controlador = new ControladorJugador(cv);
        // Simulamos la visibilidad de la ventana
        controlador.vj = new VentanaJugadores();
    }



    @Test
    public void testBAceptarAlta() {
        // Verificamos el comportamiento del botón "Aceptar" para la opción de Alta
        controlador.vj.getRbAlta().setSelected(true);
        controlador.vj.getTfNombreAlta().setText("Nombre");
        controlador.vj.getTfNacionalidadAlta().setText("Nacionalidad");
        controlador.vj.getTfFechaAlta().setText("2024-05-23");
        controlador.vj.getTfRolAlta().setText("Rol");
        controlador.vj.getTfSueldoAlta().setText("1000");
        controlador.vj.getTfNickAlta().setText("Nickname");
        controlador.vj.getTfEquipoAlta().setText("Equipo");

        // Creamos un evento de clic en el botón "Aceptar"
        ActionEvent event = new ActionEvent(controlador.vj.bAceptar, ActionEvent.ACTION_PERFORMED, "");

        // Simulamos el clic en el botón "Aceptar"
        controlador.new bAceptar().actionPerformed(event);

        // Verificamos si se muestra algún mensaje de error
        assertFalse(controlador.vj.getTaCons().getText().contains("Error"));
    }

    @Test
    public void testBAceptarBaja() {
        // Verificamos el comportamiento del botón "Aceptar" para la opción de Baja
        controlador.vj.getRbBaja().setSelected(true);
        controlador.vj.getTfNombreBaja().setText("Nombre");

        // Creamos un evento de clic en el botón "Aceptar"
        ActionEvent event = new ActionEvent(controlador.vj.bAceptar, ActionEvent.ACTION_PERFORMED, "");

        // Simulamos el clic en el botón "Aceptar"
        controlador.new bAceptar().actionPerformed(event);

        // Verificamos si se muestra algún mensaje de error
        assertFalse(controlador.vj.getTaCons().getText().contains("Error"));
    }

    @Test
    public void testBAceptarModificacion() {
        // Verificamos el comportamiento del botón "Aceptar" para la opción de Modificación
        controlador.vj.getRbModi().setSelected(true);
        controlador.vj.getTfNombreModi().setText("Nombre");
        controlador.vj.getTfNacionalidadModi().setText("Nacionalidad");
        controlador.vj.getTfFechaModi().setText("2024-05-23");
        controlador.vj.getTfRolModi().setText("Rol");
        controlador.vj.getTfSueldoModi().setText("1000");
        controlador.vj.getTfNickModi().setText("Nickname");
        controlador.vj.getTfEquipoModi().setText("Equipo");

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
        controlador.vj.getTfNombreCons().setText("Nombre");

        // Creamos un evento de clic en el botón "Aceptar"
        ActionEvent event = new ActionEvent(controlador.vj.bAceptar, ActionEvent.ACTION_PERFORMED, "");

        // Simulamos el clic en el botón "Aceptar"
        controlador.new bAceptar().actionPerformed(event);

        // Verificamos si se muestra algún mensaje de error
        assertFalse(controlador.vj.getTaCons().getText().contains("Error"));
    }

    // Puedes agregar más pruebas si lo deseas

}
