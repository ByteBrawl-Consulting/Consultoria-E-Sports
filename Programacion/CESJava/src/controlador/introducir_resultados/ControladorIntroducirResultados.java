package controlador.introducir_resultados;

import controlador.ControladorVista;
import controlador.equipo_competicion.ControladorEquipoCompeticion;
import view.VentanaIntroducirResultados;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ControladorIntroducirResultados {

    private VentanaIntroducirResultados vir;
    private ControladorVista cv;

    public ControladorIntroducirResultados() {
        this.cv = cv;

        vir = new VentanaIntroducirResultados();

        vir.getTfJornada().addFocusListener(new PlaceholderListener("Numero Jornada"));
        vir.getTfCodEnfrentamiento().addFocusListener(new PlaceholderListener("Codigo Enfrentamiento"));
        vir.getTfEquipoGanador().addFocusListener(new PlaceholderListener("Equipo Ganador"));

        vir.setVisible(true);
    }

    public class PlaceholderListener implements FocusListener {
        private String placeholder;

        public PlaceholderListener(String placeholder) {
            this.placeholder = placeholder;
        }

        @Override
        public void focusGained(FocusEvent e) {
            JTextField textField = (JTextField) e.getSource();
            if (textField.getText().equals(placeholder)) {
                textField.setText("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            JTextField textField = (JTextField) e.getSource();
            if (textField.getText().isEmpty()) {
                textField.setText(placeholder);
            }
        }
    }
}
