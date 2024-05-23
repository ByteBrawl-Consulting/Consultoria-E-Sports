package controlador.staff;

import controlador.ControladorPrincipal;
import controlador.ControladorVista;
import org.junit.Before;
import org.junit.Test;
import view.VentanaStaff;

import javax.swing.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ControladorStaffTest {

    private ControladorStaff controladorStaff;
    private ControladorPrincipal cp = new ControladorPrincipal();

    @Before
    public void setUp() {
        // Creamos un controlador de vista ficticio
        ControladorVista cv = new ControladorVista(cp);
        // Creamos una instancia de ControladorStaff
        controladorStaff = new ControladorStaff(cv);
        // Simulamos la visibilidad de la ventana
        controladorStaff.vs = new VentanaStaff();
    }

    @Test
    public void testMostrar() {
        // Verificamos que al llamar a mostrar, la ventana se muestre y los paneles se oculten
        controladorStaff.mostrar();
        assertTrue(controladorStaff.vs.isVisible());
        assertFalse(controladorStaff.vs.getpAlta().isVisible());
        assertFalse(controladorStaff.vs.getpBaja().isVisible());
        assertFalse(controladorStaff.vs.getpModi().isVisible());
        assertFalse(controladorStaff.vs.getpConsulta().isVisible());
    }

    @Test
    public void testValidarCamposVacios() {
        // Creamos campos de texto ficticios
        JTextField campo1 = new JTextField("Nombre");
        JTextField campo2 = new JTextField("Cargo");
        JTextField campo3 = new JTextField("1000");
        JTextField campo4 = new JTextField("Equipo");

        // Verificamos que la validación funcione correctamente
        assertTrue(controladorStaff.validarCamposVacios(campo1, campo2, campo3, campo4));

        // Cambiamos el texto de un campo para que esté vacío
        campo1.setText("");
        assertFalse(controladorStaff.validarCamposVacios(campo1, campo2, campo3, campo4));
    }

    // Puedes agregar más pruebas para otras funcionalidades si lo deseas

}