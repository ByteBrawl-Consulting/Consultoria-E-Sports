package controlador.equipos;

import controlador.ControladorVista;
import org.junit.Before;
import org.junit.Test;
import view.VentanaEquipos;

import javax.swing.*;
import java.awt.event.FocusEvent;

public class ControladorEquipoTest {

    private ControladorEquipo controlador;
    private ControladorVista cv;

    @Before
    public void setUp() {
        cv = new ControladorVista(null); // No es necesario un ControladorPrincipal para las pruebas
        controlador = new ControladorEquipo(cv);
        controlador.ve = new VentanaEquipos(); // Asignamos una instancia de VentanaEquipos para evitar NullPointerException
    }

    @Test
    public void testBAceptar_Alta() {
        controlador.ve.getRbAlta().setSelected(true);
        controlador.ve.getTfNombreAlta().setText("hola");
        controlador.ve.getTfFechaAlta().setText("2023-05-05");
        controlador.ve.bAceptar.doClick();
    }

    @Test
    public void testBAceptar_BajaConCamposCompletos() {
        controlador.ve.getRbBaja().setSelected(true);
        controlador.ve.getTfNombreBaja().setText("hola");
        controlador.ve.bAceptar.doClick();
    }

    @Test
    public void testBAceptar_Modificacion() {
        controlador.ve.getRbModificacion().setSelected(true);
        controlador.ve.getTfNombreModi().setText("hola");
        controlador.ve.getTfFechaModi().setText("2023-06-06");
        controlador.ve.bAceptar.doClick();
    }

    @Test
    public void testBAceptar_ConsultaConCamposCompletos() {
        controlador.ve.getRbConsulta().setSelected(true);
        controlador.ve.getTfNombreCons().setText("hola");
        controlador.ve.bAceptar.doClick();
    }

    @Test
    public void testPlaceholderListenerFocusGained() {
        JTextField textField = new JTextField();
        ControladorEquipo.PlaceholderListener listener = controlador.new PlaceholderListener("Placeholder");
        textField.setText("Placeholder");
        listener.focusGained(new FocusEvent(textField, FocusEvent.FOCUS_GAINED));
        // Verificar que el texto se borra al ganar el foco
        assert textField.getText().isEmpty();
    }

    @Test
    public void testPlaceholderListenerFocusLost() {
        JTextField textField = new JTextField();
        ControladorEquipo.PlaceholderListener listener = controlador.new PlaceholderListener("Placeholder");
        textField.setText("");
        listener.focusLost(new FocusEvent(textField, FocusEvent.FOCUS_LOST));
        // Verificar que el texto placeholder se restaura al perder el foco
        assert textField.getText().equals("Placeholder");
    }
}

