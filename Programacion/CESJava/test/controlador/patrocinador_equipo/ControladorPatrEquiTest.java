package controlador.patrocinador_equipo;

import controlador.ControladorPrincipal;
import controlador.ControladorVista;
import org.junit.Before;
import org.junit.Test;
import view.VentanaAsociacionPatroEqui;

import static org.junit.Assert.assertFalse;

public class ControladorPatrEquiTest {

    private ControladorPatrEqui controlador;
    private ControladorPrincipal cp = new ControladorPrincipal();

    @Before
    public void setUp() {
        // Creamos un controlador de vista ficticio
        ControladorVista cv = new ControladorVista(cp);
        // Creamos una instancia de ControladorPatrEqui
        controlador = new ControladorPatrEqui(cv);
        // Simulamos la visibilidad de la ventana
        controlador.vape = new VentanaAsociacionPatroEqui();
    }



    @Test
    public void testBAceptarAlta() {
        // Simulamos la selección del radio button de Alta y el texto en los campos de nombre de patrocinador y equipo
        controlador.vape.getAltaRadioButton().setSelected(true);
        controlador.vape.getTfPatroAlta().setText("Patrocinador 1");
        controlador.vape.getTfEquiAlta().setText("Equipo 1");

        // Verificamos que al llamar a bAceptar, se invoque correctamente el método de asociación en el controlador de vista
        controlador.new bAceptar().actionPerformed(null);
        // Aquí puedes agregar más verificaciones según el comportamiento esperado
    }

    @Test
    public void testBAceptarBaja() {
        // Simulamos la selección del radio button de Baja y el texto en los campos de nombre de patrocinador y equipo
        controlador.vape.getBajaRadioButton().setSelected(true);
        controlador.vape.getTfPatroBaja().setText("Patrocinador 2");
        controlador.vape.getTfEquiBaja().setText("Equipo 2");

        // Verificamos que al llamar a bAceptar, se invoque correctamente el método de desasociación en el controlador de vista
        controlador.new bAceptar().actionPerformed(null);
        // Aquí puedes agregar más verificaciones según el comportamiento esperado
    }

    @Test
    public void testBConsPatr() {
        // Simulamos la selección del radio button de Consulta por Patrocinador y el texto en el campo de nombre de patrocinador
        controlador.vape.getConsultaPorPatrocinadorRadioButton().setSelected(true);
        controlador.vape.getTfPatroConsul().setText("Patrocinador 3");

        // Verificamos que al llamar a bAceptar, se invoque correctamente el método de consulta por patrocinador en el controlador de vista
        controlador.new bAceptar().actionPerformed(null);
        // Aquí puedes agregar más verificaciones según el comportamiento esperado
    }

    @Test
    public void testBConsEqui() {
        // Simulamos la selección del radio button de Consulta por Equipo y el texto en el campo de nombre de equipo
        controlador.vape.getConsultaPorEquipoRadioButton().setSelected(true);
        controlador.vape.getTfEquiConsul().setText("Equipo 3");

        // Verificamos que al llamar a bAceptar, se invoque correctamente el método de consulta por equipo en el controlador de vista
        controlador.new bAceptar().actionPerformed(null);
        // Aquí puedes agregar más verificaciones según el comportamiento esperado
    }

    @Test
    public void testBSalir() {
        // Verificamos que al llamar a bSalir, se cierre la ventana
        controlador.new bSalir().actionPerformed(null);
        assertFalse(controlador.vape.isVisible());
    }
}
