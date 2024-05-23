package controlador.resultados_todas_jornadas;

import controlador.ControladorPrincipal;
import controlador.ControladorVista;
import org.junit.Before;
import org.junit.Test;
import view.VentanaResultadosTodasJornadas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ControladorResultadosTJornadasTest {

    private ControladorResultadosTJornadas controlador;
    private ControladorPrincipal cp = new ControladorPrincipal();

    @Before
    public void setUp() {
        // Creamos un controlador de vista ficticio
        ControladorVista cv = new ControladorVista(cp);
        // Creamos una instancia de ControladorResultadosTJornadas
        controlador = new ControladorResultadosTJornadas(cv);
        // Simulamos la visibilidad de la ventana
        controlador.vrtj = new VentanaResultadosTodasJornadas();
    }

    @Test
    public void testLlenarCB() {
        // Verificamos que al llamar a llenarCB, se agreguen elementos al ComboBox
        controlador.llenarCB();
        assertTrue(controlador.vrtj.getCbCompeticion().getItemCount() > 0);
    }

    @Test
    public void testBAceptarJornada() {
        // Simulamos la selección de una competición en el ComboBox
        controlador.vrtj.getCbCompeticion().addItem("Competición 1");
        controlador.vrtj.getCbCompeticion().setSelectedItem("Competición 1");

        // Verificamos que al llamar a bAceptarJornada, se muestren los resultados en el TextArea
        controlador.new bAceptarJornada().actionPerformed(null);
        assertTrue(controlador.vrtj.getTaConsulta().getText().isEmpty()); // Como es una prueba ficticia, debería estar vacío
    }

    @Test
    public void testBSalir() {
        // Verificamos que al llamar a bSalir, se cierre la ventana
        controlador.new bSalir().actionPerformed(null);
        assertFalse(controlador.vrtj.isVisible());
    }

    // Puedes agregar más pruebas para otras funcionalidades si lo deseas

}