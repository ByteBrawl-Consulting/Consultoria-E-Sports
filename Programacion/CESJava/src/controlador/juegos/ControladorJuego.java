package controlador.juegos;

import controlador.ControladorVista;
import controlador.equipos.ControladorEquipo;
import modelo.Jornada;
import modelo.Juego;
import view.VentanaJuegos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * La clase ControladorJuego es responsable de gestionar las interacciones entre la interfaz de usuario para manejar juegos (VentanaJuegos) y el modelo de datos (Juego).
 * Maneja acciones como agregar, eliminar, modificar y consultar juegos.
 */

public class ControladorJuego {
    private VentanaJuegos vj;
    private ControladorVista cv;

    /**
     * Construye un ControladorJuego con el controlador de vista especificado.
     *
     * @param cv El controlador de vista que se utilizará para interactuar con el modelo de datos.
     */

    public ControladorJuego(ControladorVista cv) {
        this.cv = cv;

        vj = new VentanaJuegos();

        mostar();

        vj.bAceptarAl(new bAceptar());
        vj.bSalirAL(new bSalir());
        vj.bRbAltaAL(new bAlta());
        vj.bRbBajaAL(new bBaja());
        vj.bRbModiAl(new bModi());
        vj.bRbConsultaAL(new bConsulta());

        vj.getTfNombreAlta().addFocusListener(new PlaceholderListener("Nombre"));
        vj.getTfDesaAlta().addFocusListener(new PlaceholderListener("Desarrolladora"));
        vj.getTfFechaAlta().addFocusListener(new PlaceholderListener("Fecha Lanzamiento"));

        vj.getTfNombreBaja().addFocusListener(new PlaceholderListener("Nombre"));

        vj.getTfNombreModi().addFocusListener(new PlaceholderListener("Nombre"));
        vj.getTfDesaModi().addFocusListener(new PlaceholderListener("Desarrolladora"));
        vj.getTfFechaModi().addFocusListener(new PlaceholderListener("Fecha Lanzamiento"));

        vj.getTfNombreCons().addFocusListener(new PlaceholderListener("Nombre"));

        vj.getTaCons().setEditable(false);
        vj.getTaCons().setBackground(new Color(205, 205, 205));
    }

    /**
     * Listener para el botón "Salir".
     */

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.dispose();
        }
    }

    /**
     * Listener para el botón "Aceptar".
     */

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Juego juego = new Juego();
            if (vj.getRbAlta().isSelected()) {
                if (vj.getTfNombreAlta().getText().equals("Nombre")){
                    JOptionPane.showMessageDialog(null, "El nombre es obligatiorio");
                } else if (vj.getTfDesaAlta().getText().equals("Desarrolladora")) {
                    JOptionPane.showMessageDialog(null, "La desarrolladora es obligatoria");
                } else if (vj.getTfFechaAlta().getText().equals("Fecha Lanzamiento")) {
                    JOptionPane.showMessageDialog(null, "La fecha de lanzamiento es obligatoria");
                }else{
                    try {
                        String nombre = vj.getTfNombreAlta().getText();
                        String desarrolladora = vj.getTfDesaAlta().getText();
                        String fecha = vj.getTfFechaAlta().getText();
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date fechaJava = null;
                        fechaJava = formato.parse(fecha);
                        java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
                        juego.setNombre(nombre);
                        juego.setDesarrolladora(desarrolladora);
                        juego.setFechaLanzamiento(fechaSql.toLocalDate());
                        cv.altaJuego(juego);
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            } else if (vj.getRbBaja().isSelected()) {
                if (vj.getTfNombreBaja().getText().equals("Nombre")){
                    JOptionPane.showMessageDialog(null, "El nombre es obligatorio");
                }else{
                    try {
                        String nombre = vj.getTfNombreBaja().getText();
                        juego.setNombre(nombre);
                        cv.bajaJuego(juego);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            } else if (vj.getRbModi().isSelected()) {
                if (vj.getTfNombreModi().getText().equals("Nombre")){
                    JOptionPane.showMessageDialog(null, "El nombre es obligatiorio");
                } else if (vj.getTfDesaModi().getText().equals("Desarrolladora")) {
                    JOptionPane.showMessageDialog(null, "La desarrolladora es obligatoria");
                } else if (vj.getTfFechaModi().getText().equals("Fecha Lanzamiento")) {
                    JOptionPane.showMessageDialog(null, "La fecha de lanzamiento es obligatoria");
                }else{
                    try {
                        String nombre = vj.getTfNombreModi().getText();
                        String desarrolladora = vj.getTfDesaModi().getText();
                        String fecha = vj.getTfFechaModi().getText();
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date fechaJava = null;
                        fechaJava = formato.parse(fecha);
                        java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
                        juego.setNombre(nombre);
                        juego.setDesarrolladora(desarrolladora);
                        juego.setFechaLanzamiento(fechaSql.toLocalDate());
                        cv.modiJuego(juego);
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            } else if (vj.getRbCons().isSelected()) {
                if (vj.getTfNombreCons().getText().equals("Nombre")){
                    JOptionPane.showMessageDialog(null, "El nombre es obligatorio");
                }else{
                    try {
                        String nombre = vj.getTfNombreCons().getText();
                        juego.setNombre(nombre);
                        vj.getTaCons().setText(cv.consultaJuego(nombre));
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        }
    }

    /**
     * Muestra la ventana principal de juegos y oculta los paneles de operaciones específicas.
     */

    private void mostar() {
        vj.setVisible(true);
        vj.getpAlta().setVisible(false);
        vj.getpBaja().setVisible(false);
        vj.getpCons().setVisible(false);
        vj.getpModi().setVisible(false);
    }

    /**
     * Listener para el botón "Alta".
     */

    private class bAlta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.eleccionAlta();
        }
    }

    /**
     * Listener para el botón "Baja".
     */

    private class bBaja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.eleccionBaja();
        }
    }

    /**
     * Listener para el botón "Modificación".
     */

    private class bModi implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.eleccionModi();
        }
    }

    /**
     * Listener para el botón "Consulta".
     */

    private class bConsulta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.eleccionConsulta();
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
