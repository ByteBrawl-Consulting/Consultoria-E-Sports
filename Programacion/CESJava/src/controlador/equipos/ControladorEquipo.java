package controlador.equipos;

import controlador.ControladorVista;
import modelo.Equipo;
import view.VentanaEquipos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * El ControladorEquipo gestiona la interacción entre la vista de gestión de equipos y el modelo de datos.
 */

public class ControladorEquipo {
    private VentanaEquipos ve;
    private ControladorVista cv;

    /**
     * Constructor de la clase ControladorEquipo.
     *
     * @param cv El ControladorVista asociado.
     */

    public ControladorEquipo(ControladorVista cv) {
        this.cv = cv;

        ve = new VentanaEquipos();

        mostrar();

        ve.bAceptarAl(new bAceptar());
        ve.bSalirAL(new bSalir());
        ve.bRbAltaAL(new bAlta());
        ve.bRbBajaAL(new bBaja());
        ve.bRbModiAl(new bModi());
        ve.bRbConsultaAL(new bConsulta());

        ve.getTfNombreAlta().addFocusListener(new PlaceholderListener("Nombre"));
        ve.getTfFechaAlta().addFocusListener(new PlaceholderListener("Fecha Fundación"));

        ve.getTfNombreBaja().addFocusListener(new PlaceholderListener("Nombre"));

        ve.getTfNombreModi().addFocusListener(new PlaceholderListener("Nombre"));
        ve.getTfFechaModi().addFocusListener(new PlaceholderListener("Fecha Fundación"));

        ve.getTfNombreCons().addFocusListener(new PlaceholderListener("Nombre"));

        ve.getTaConsulta().setEditable(false);
        ve.getTaConsulta().setBackground(new Color(205, 205, 205));
    }

    /**
     * Muestra la ventana de gestión de equipos y oculta los paneles específicos.
     */

    public void mostrar() {
        ve.setVisible(true);
        ve.getpAlta().setVisible(false);
        ve.getpBaja().setVisible(false);
        ve.getpConsulta().setVisible(false);
        ve.getpModificacion().setVisible(false);
    }

    /**
     * Clase interna para manejar el evento de salir.
     */

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ve.dispose();
        }
    }

    /**
     * Clase interna para manejar el evento de aceptar, ejecutando la operación correspondiente según la selección del usuario.
     */

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Equipo eq = new Equipo();
            if (ve.getRbAlta().isSelected()) {
                try {
                    String nombre = ve.getTfNombreAlta().getText();
                    String fecha = ve.getTfFechaAlta().getText();
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date fechaJava = null;
                    fechaJava = formato.parse(fecha);
                    java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
                    eq.setNombre(nombre);
                    eq.setFechaFundacion(fechaSql.toLocalDate());
                    cv.altaEquipo(eq);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            } else if (ve.getRbBaja().isSelected()) {
                try {
                    String nombre = ve.getTfNombreBaja().getText();
                    eq.setNombre(nombre);
                    cv.bajaEquipo(eq);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            } else if (ve.getRbModificacion().isSelected()) {
                try {
                    String nombre = ve.getTfNombreModi().getText();
                    String fecha = ve.getTfFechaModi().getText();
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date fechaJava = formato.parse(fecha);
                    java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
                    eq.setNombre(nombre);
                    eq.setFechaFundacion(fechaSql.toLocalDate());
                    cv.modiEquipo(eq, fecha);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            } else if (ve.getRbConsulta().isSelected()) {
                try {
                    String nombre = ve.getTfNombreCons().getText();
                    eq.setNombre(nombre);
                    ve.getTaConsulta().setText(cv.consultaEquipo(nombre));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    /**
     * Clase interna para manejar el evento de alta de equipo.
     */

    private class bAlta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ve.eleccionAlta();
        }
    }

    /**
     * Clase interna para manejar el evento de baja de equipo.
     */

    private class bBaja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ve.eleccionBaja();
        }
    }

    /**
     * Clase interna para manejar el evento de modificación de equipo.
     */

    private class bModi implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ve.eleccionModi();
        }
    }

    /**
     * Clase interna para manejar el evento de consulta de equipo.
     */

    private class bConsulta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ve.eleccionConsulta();
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
