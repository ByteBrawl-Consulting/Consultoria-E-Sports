package controlador.introducir_resultados;

import controlador.ControladorPrincipal;
import controlador.ControladorVista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.VentanaIntroducirResultados;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControladorIntroducirResultadosTest {

    private ControladorVista cvMock;
    private VentanaIntroducirResultados virMock;
    private ControladorIntroducirResultados controlador;

    @BeforeEach
    void setUp() {
        cvMock = new ControladorVista(new ControladorPrincipal());
        virMock = new VentanaIntroducirResultados();

        controlador = new ControladorIntroducirResultados(cvMock);
        controlador.vir = virMock;
    }

    @Test
    void testInsertarResultado() {
        // Given
        virMock.getCbCompeticion().addItem("Competición Test");
        virMock.getTfCodEnfrentamiento().setText("E001");
        virMock.getTfEquipoGanador().setText("Equipo Ganador");

        // When
        controlador.new bAceptar().actionPerformed(null);

        // Then
        assertEquals("Competición Test", virMock.getCbCompeticion().getSelectedItem());
        assertEquals("E001", virMock.getTfCodEnfrentamiento().getText());
        assertEquals("Equipo Ganador", virMock.getTfEquipoGanador().getText());
    }
}
