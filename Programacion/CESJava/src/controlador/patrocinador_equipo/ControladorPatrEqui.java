package controlador.patrocinador_equipo;

import controlador.ControladorVista;
import view.VentanaAsociacionPatroEqui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;


/**
 * ControladorPatrEqui es el controlador que gestiona la interacción entre la vista de asociación
 * de patrocinadores y equipos (VentanaAsociacionPatroEqui) y el modelo de negocio a través del
 * ControladorVista.
 */

public class ControladorPatrEqui {
    private VentanaAsociacionPatroEqui vape;
    private ControladorVista cv;

    /**
     * Constructor de ControladorPatrEqui.
     *
     * @param cv El controlador principal de la vista.
     */

    public ControladorPatrEqui(ControladorVista cv) {
        this.cv = cv;

        vape = new VentanaAsociacionPatroEqui();

        vape.getTfPatroAlta().addFocusListener(new PlaceholderListener("Patrocinador"));
        vape.getTfEquiAlta().addFocusListener(new PlaceholderListener("Equipo"));

        vape.getTfPatroBaja().addFocusListener(new PlaceholderListener("Patrocinador"));
        vape.getTfEquiBaja().addFocusListener(new PlaceholderListener("Equipo"));

        vape.getTfPatroConsul().addFocusListener(new PlaceholderListener("Patrocinador"));

        vape.getTfEquiConsul().addFocusListener(new PlaceholderListener("Equipo"));


        vape.bAceptarAL(new bAceptar());
        vape.bSalirAL(new bSalir());
        vape.bRbAltaAL(new bAlta());
        vape.bRbBajaAL(new bBaja());
        vape.bRbConsPatrAL(new bConsPatr());
        vape.bRbConsEquiAL(new bConsEqui());

        vape.setVisible(true);
        vape.getpAlta().setVisible(false);
        vape.getpBaja().setVisible(false);
        vape.getpConsulEqui().setVisible(false);
        vape.getpConsultPatro().setVisible(false);
        vape.getpTA().setVisible(false);
        vape.getTaConsulta().setEditable(false);
    }

    /**
     * Clase interna que maneja el evento de clic en el botón "Salir".
     * Cierra la ventana de asociación de patrocinadores y equipos.
     */

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vape.dispose();
        }
    }

    /**
     * Clase interna que maneja el evento de selección del radio button "Alta".
     * Muestra el panel de alta de patrocinadores y equipos.
     */

    private class bAlta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vape.eleccionAlta();
        }
    }

    /**
     * Clase interna que maneja el evento de selección del radio button "Baja".
     * Muestra el panel de baja de patrocinadores y equipos.
     */

    private class bBaja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vape.eleccionBaja();
        }
    }

    /**
     * Clase interna que maneja el evento de selección del radio button "Consulta por Patrocinador".
     * Muestra el panel de consulta por patrocinador.
     */

    private class bConsPatr implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vape.eleccionConsPatr();
        }
    }

    /**
     * Clase interna que maneja el evento de selección del radio button "Consulta por Equipo".
     * Muestra el panel de consulta por equipo.
     */

    private class bConsEqui implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vape.eleccionConsEqui();
        }
    }

    /**
     * Clase interna que maneja el evento de clic en el botón "Aceptar".
     * Realiza la operación correspondiente (alta, baja, consulta) según la selección del usuario.
     */

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (vape.getAltaRadioButton().isSelected()) {
                String nombrePatrocinador = vape.getTfPatroAlta().getText();
                String nombreEquipo = vape.getTfEquiAlta().getText();

                if (nombrePatrocinador.isEmpty() || nombreEquipo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar nombre de patrocinador y equipo");
                    return;
                }

                try {
                    cv.asociarPatrocinadorEquipo(nombrePatrocinador, nombreEquipo);
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(null, "Error al asociar patrocinador y equipo: " + ex.getMessage());
                }
            } else if (vape.getBajaRadioButton().isSelected()) {
                String nombrePatrocinador = vape.getTfPatroBaja().getText();
                String nombreEquipo = vape.getTfEquiBaja().getText();

                if (nombrePatrocinador.isEmpty() || nombreEquipo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar nombre de patrocinador y equipo");
                    return;
                }

                try {
                    cv.desasociarPatrocinadorEquipo(nombrePatrocinador, nombreEquipo);
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(null, "Error al desasociar patrocinador y equipo: " + ex.getMessage());
                }
            } else if (vape.getConsultaPorPatrocinadorRadioButton().isSelected()) {
                String nombrePatrocinador = vape.getTfPatroConsul().getText();
                List<String> equipos = cv.getEquiposPorPatrocinador(nombrePatrocinador);
                StringBuilder mensaje = new StringBuilder("Equipos asociados al patrocinador ");
                mensaje.append(nombrePatrocinador).append(":\n");
                for (String equipo : equipos) {
                    mensaje.append(equipo).append("\n");
                }
                vape.getTaConsulta().setText(mensaje.toString());
            } else if (vape.getConsultaPorEquipoRadioButton().isSelected()) {
                String nombreEquipo = vape.getTfEquiConsul().getText();
                List<String> patrocinadores = cv.getPatrocinadoresPorEquipo(nombreEquipo);
                StringBuilder mensaje = new StringBuilder("Patrocinadores asociados al equipo ");
                mensaje.append(nombreEquipo).append(":\n");
                for (String patrocinador : patrocinadores) {
                    mensaje.append(patrocinador).append("\n");
                }
                vape.getTaConsulta().setText(mensaje.toString());
            }
        }
    }

    /**
     * Clase interna para manejar el evento de focus en los campos de texto, mostrando y ocultando placeholders.
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