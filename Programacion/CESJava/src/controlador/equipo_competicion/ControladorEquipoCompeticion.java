package controlador.equipo_competicion;

import controlador.ControladorVista;
import view.VentanaAsociacionEquipoCompe;

import javax.swing.*;
import java.awt.event.*;

/**
 * El ControladorEquipoCompeticion gestiona la interacción entre la vista de asociación de equipos con competiciones y el modelo de datos.
 */

public class ControladorEquipoCompeticion {
    private VentanaAsociacionEquipoCompe vaec;
    private ControladorVista cv;

    /**
     * Constructor de la clase ControladorEquipoCompeticion.
     *
     * @param cv El ControladorVista asociado.
     */

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

    /**
     * Clase interna para manejar el evento de aceptar.
     */

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

    /**
     * Clase interna para manejar el evento de salir.
     */

    public class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vaec.dispose();
        }
    }

    /**
     * Clase interna para manejar el evento de alta de asociación de equipo a competición.
     */

    private class bAlta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vaec.eleccionAlta();
        }
    }

    /**
     * Clase interna para manejar el evento de baja de asociación de equipo a competición.
     */

    private class bBaja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vaec.eleccionBaja();
        }
    }

    /**
     * Clase interna para manejar los eventos de enfoque de los campos de texto,
     * mostrando y ocultando los placeholders.
     */

    public class PlaceholderListener implements FocusListener {
        private String placeholder;

        /**
         * Constructor de PlaceholderListener.
         *
         * @param placeholder El texto de marcador de posición.
         */

        public PlaceholderListener(String placeholder) {
            this.placeholder = placeholder;
        }

        /**
         * Maneja el evento de ganar foco, mostrando el marcador de posición si es necesario.
         *
         * @param e El evento de focus.
         */

        @Override
        public void focusGained(FocusEvent e) {
            JTextField textField = (JTextField) e.getSource();
            if (textField.getText().equals(placeholder)) {
                textField.setText("");
            }
        }

        /**
         * Maneja el evento de perder foco, mostrando el marcador de posición si el campo está vacío.
         *
         * @param e El evento de focus.
         */

        @Override
        public void focusLost(FocusEvent e) {
            JTextField textField = (JTextField) e.getSource();
            if (textField.getText().isEmpty()) {
                textField.setText(placeholder);
            }
        }
    }
}