package controlador.patrocinadores;

import controlador.ControladorVista;
import modelo.Patrocinador;
import view.VentanaPatrocinadores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * ControladorPatrocinador es el controlador que gestiona la interacción entre la vista de patrocinadores
 * (VentanaPatrocinadores) y el modelo de negocio a través del ControladorVista.
 */

public class ControladorPatrocinador {
    VentanaPatrocinadores vp;
    ControladorVista cv;

    /**
     * Constructor de ControladorPatrocinador.
     *
     * @param cv El controlador principal de la vista.
     */

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

    /**
     * Muestra la ventana de patrocinadores y oculta los paneles de alta y baja inicialmente.
     */

    private void mostrar() {
        vp.setVisible(true);
        vp.getpAlta().setVisible(false);
        vp.getpBaja().setVisible(false);
    }

    /**
     * Clase interna que maneja el evento de clic en el botón "Salir".
     * Cierra la ventana de patrocinadores.
     */

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vp.dispose();
        }
    }

    /**
     * Clase interna que maneja el evento de selección del radio button "Alta".
     * Muestra el panel de alta de patrocinadores.
     */

    private class bAlta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vp.eleccionAlta();
        }
    }

    /**
     * Clase interna que maneja el evento de selección del radio button "Baja".
     * Muestra el panel de baja de patrocinadores.
     */

    private class bBaja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vp.eleccionBaja();
        }
    }

    /**
     * Clase interna que maneja el evento de clic en el botón "Aceptar".
     * Realiza la operación correspondiente (alta o baja) según la selección del usuario.
     */

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
