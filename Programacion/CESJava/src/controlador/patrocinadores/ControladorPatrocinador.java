package controlador.patrocinadores;

import controlador.ControladorVista;
import modelo.Patrocinador;
import view.VentanaPatrocinadores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ControladorPatrocinador {
    VentanaPatrocinadores vp;
    ControladorVista cv;

    public ControladorPatrocinador(ControladorVista cv) {
        vp = new VentanaPatrocinadores();

        vp.bSalirAL(new bSalir());
        vp.bAceptarAl(new bAceptar());
        vp.bRbAltaAL(new bAlta());
        vp.bRbBajaAL(new bBaja());

        mostrar();

        vp.getTfNombreAlta().addFocusListener(new PlaceholderListener("Nombre"));
        vp.getTfNombreBaja().addFocusListener(new PlaceholderListener("Nombre"));

        this.cv = cv;
    }

    private void mostrar() {
        vp.setVisible(true);
    }

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vp.dispose();
        }
    }

    private class bAlta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vp.eleccionAlta();
        }
    }

    private class bBaja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vp.eleccionBaja();
        }
    }

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Patrocinador patr = new Patrocinador();
            if (vp.getRbAlta().isSelected()) {
                try {
                    String nombre = vp.getTfNombreAlta().getText();
                    patr.setNombre(nombre);
                    cv.altaPatrocinador(patr);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            } else if (vp.getRbBaja().isSelected()) {
                String nombre = vp.getTfNombreBaja().getText();
                patr.setNombre(nombre);
                cv.bajaPatrocinador(patr);
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
