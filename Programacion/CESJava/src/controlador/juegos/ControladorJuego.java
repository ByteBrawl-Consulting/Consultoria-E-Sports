package controlador.juegos;

import controlador.ControladorVista;
import controlador.equipos.ControladorEquipo;
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

public class ControladorJuego {
    private VentanaJuegos vj;
    private ControladorVista cv;

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

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.dispose();
        }
    }

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Juego juego = new Juego();
            if (vj.getRbAlta().isSelected()) {
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
            } else if (vj.getRbBaja().isSelected()) {
                try {
                    String nombre = vj.getTfNombreBaja().getText();
                    juego.setNombre(nombre);
                    cv.bajaJuego(juego);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            } else if (vj.getRbModi().isSelected()) {
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
            } else if (vj.getRbCons().isSelected()) {
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

    private void mostar() {
        vj.setVisible(true);
        vj.getpAlta().setVisible(false);
        vj.getpBaja().setVisible(false);
        vj.getpCons().setVisible(false);
        vj.getpModi().setVisible(false);
    }

    private class bAlta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.eleccionAlta();
        }
    }

    private class bBaja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.eleccionBaja();
        }
    }

    private class bModi implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.eleccionModi();
        }
    }

    private class bConsulta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.eleccionConsulta();
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
