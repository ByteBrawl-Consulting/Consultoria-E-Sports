package controlador.cerrar_inscripciones;

import controlador.ControladorVista;
import controlador.equipo_competicion.ControladorEquipoCompeticion;
import modelo.Equipo;
import view.VentanaCerrarInscripciones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ControladorCerrarInscripciones {

    private VentanaCerrarInscripciones vci;
    private ControladorVista cv;

    public ControladorCerrarInscripciones(ControladorVista cv) {
        this.cv = cv;

        vci = new VentanaCerrarInscripciones();

        vci.getTfCompeticion().addFocusListener(new PlaceholderListener("Competición"));

        vci.bAceptarAL(new bAceptar());
        vci.bSalirAL(new bSalir());

        vci.setVisible(true);
    }

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vci.dispose();
        }
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
