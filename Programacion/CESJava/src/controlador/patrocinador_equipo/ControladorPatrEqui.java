package controlador.patrocinador_equipo;

import controlador.ControladorVista;
import view.VentanaAsociacionPatroEqui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

public class ControladorPatrEqui {
    private VentanaAsociacionPatroEqui vape;
    private ControladorVista cv;

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
    }

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vape.dispose();
        }
    }

    private class bAlta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vape.eleccionAlta();
        }
    }

    private class bBaja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vape.eleccionBaja();
        }
    }

    private class bConsPatr implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vape.eleccionConsPatr();
        }
    }

    private class bConsEqui implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vape.eleccionConsEqui();
        }
    }

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (vape.getAltaRadioButton().isSelected()){
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
