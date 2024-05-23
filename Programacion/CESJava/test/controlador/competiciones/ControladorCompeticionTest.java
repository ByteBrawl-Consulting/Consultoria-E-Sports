package controlador.competiciones;

import controlador.ControladorVista;
import org.junit.Before;
import org.junit.Test;
import view.VentanaCompeticiones;

public class ControladorCompeticionTest {

    private ControladorCompeticion controlador;
    private ControladorVista cv;

    @Before
    public void setUp() {
        cv = new ControladorVista(null);
        controlador = new ControladorCompeticion(cv);
        controlador.vc = new VentanaCompeticiones();
    }

    @Test
    public void testBAceptar_Alta() {
        controlador.vc.getRbAlta().setSelected(true);
        controlador.vc.getTfNombreAlta().setText("Nombre");
        controlador.vc.getTfFechaIniAlta().setText("Fecha Inicio");
        controlador.vc.getTfFechaFinAlta().setText("Fecha Fin");
        controlador.vc.getTfJuegoAlta().setText("Juego");
        controlador.vc.getbAceptar().doClick();
    }

    @Test
    public void testBAceptar_Baja() {
        controlador.vc.getRbBaja().setSelected(true);
        controlador.vc.getTfNombreBaja().setText("Nombre");
        controlador.vc.getbAceptar().doClick();
    }

    @Test
    public void testBAceptar_Modificacion() {
        controlador.vc.getRbModi().setSelected(true);
        controlador.vc.getTfNombreModi().setText("Nombre");
        controlador.vc.getTfFechaIniModi().setText("Fecha Inicio");
        controlador.vc.getTfFechaFinModi().setText("Fecha Fin");
        controlador.vc.getTfJuegoModi().setText("Juego");
        controlador.vc.getbAceptar().doClick();
    }

    @Test
    public void testBAceptar_Consulta() {
        controlador.vc.getRbCons().setSelected(true);
        controlador.vc.getTfNombreCons().setText("Nombre");
        controlador.vc.getbAceptar().doClick();
    }

}
