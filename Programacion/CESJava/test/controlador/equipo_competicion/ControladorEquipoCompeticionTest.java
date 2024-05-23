package controlador.equipo_competicion;

import controlador.ControladorVista;
import org.junit.Before;
import org.junit.Test;
import view.VentanaAsociacionEquipoCompe;

public class ControladorEquipoCompeticionTest {

    private ControladorEquipoCompeticion controlador;
    private ControladorVista cv;

    @Before
    public void setUp() {
        cv = new ControladorVista(null);
        controlador = new ControladorEquipoCompeticion(cv);
        controlador.vaec = new VentanaAsociacionEquipoCompe();
    }

    @Test
    public void testBAceptar_Alta() {
        controlador.vaec.getAltaRadioButton().setSelected(true);
        controlador.vaec.getTfEquiAlta().setText("Equipo");
        controlador.vaec.getTfCompeAlta().setText("Competición");
        controlador.vaec.getAceptarButton().doClick();
    }

    @Test
    public void testBAceptar_Baja() {
        controlador.vaec.getBajaRadioButton().setSelected(true);
        controlador.vaec.getTfEquiBaja().setText("Equipo");
        controlador.vaec.getTfCompeBaja().setText("Competición");
        controlador.vaec.getAceptarButton().doClick();
    }
    
}
