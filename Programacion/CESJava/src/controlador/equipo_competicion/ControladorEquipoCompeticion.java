package controlador.equipo_competicion;

import controlador.ControladorVista;
import view.VentanaAsociacionEquipoCompe;

import javax.swing.*;
import java.awt.event.*;

public class ControladorEquipoCompeticion {
    private VentanaAsociacionEquipoCompe vaec;
    private ControladorVista cv;

    public ControladorEquipoCompeticion(ControladorVista cv) {
        this.cv = cv;
        vaec = new VentanaAsociacionEquipoCompe();

        vaec.getTfCompeAlta().addFocusListener(new PlaceholderListener("Competición"));
        vaec.getTfEquiAlta().addFocusListener(new PlaceholderListener("Equipo"));
        vaec.getTfCompeBaja().addFocusListener(new PlaceholderListener("Competición"));
        vaec.getTfEquiBaja().addFocusListener(new PlaceholderListener("Equipo"));

        vaec.bAceptarAL(new bAceptar());
        vaec.bSalirAL(new bSalir());

        vaec.bRbAltaAL(new bAlta());
        vaec.bRbBajaAL(new bBaja());

        vaec.setVisible(true);
        vaec.getpAlta().setVisible(false);
        vaec.getpBaja().setVisible(false);
    }

    public class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (vaec.getAltaRadioButton().isSelected()) {
                String nombreEquipo = vaec.getTfEquiAlta().getText();
                String nombreCompeticion = vaec.getTfCompeAlta().getText();

                if (nombreEquipo.isEmpty() || nombreCompeticion.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar nombre de equipo y competición");
                    return;
                }

                try {
                    cv.asociarEquipoCompeticion(nombreEquipo, nombreCompeticion);
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(null, "Error al asociar equipo y competición: " + ex.getMessage());
                }
            } else if (vaec.getBajaRadioButton().isSelected()) {
                String nombreEquipo = vaec.getTfEquiBaja().getText();
                String nombreCompeticion = vaec.getTfCompeBaja().getText();

                if (nombreEquipo.isEmpty() || nombreCompeticion.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar nombre de equipo y competición");
                    return;
                }

                try {
                    cv.desasociarEquipoCompeticion(nombreEquipo, nombreCompeticion);
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(null, "Error al desasociar equipo y competición: " + ex.getMessage());
                }
            }
        }
    }


    public class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vaec.dispose();
        }
    }

    private class bAlta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vaec.eleccionAlta();
        }
    }

    private class bBaja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vaec.eleccionBaja();
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