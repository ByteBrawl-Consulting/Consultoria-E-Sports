package controlador.competiciones;

import controlador.ControladorVista;
import modelo.Competicion;
import modelo.Juego;
import view.VentanaCompeticiones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ControladorCompeticion {
    private VentanaCompeticiones vc;
    private ControladorVista cv;

    public ControladorCompeticion(ControladorVista cv) {
        this.cv = cv;

        vc = new VentanaCompeticiones();

        mostrar();

        vc.bAceptarAl(new bAceptar());
        vc.bSalirAL(new bSalir());
        vc.bRbAltaAL(new bAlta());
        vc.bRbBajaAL(new bBaja());
        vc.bRbModiAl(new bModi());
        vc.bRbConsultaAL(new bConsulta());

        vc.getTfNombreAlta().addFocusListener(new PlaceholderListener("Nombre"));
        vc.getTfFechaIniAlta().addFocusListener(new PlaceholderListener("Fecha Inicio"));
        vc.getTfFechaFinAlta().addFocusListener(new PlaceholderListener("Fecha Fin"));
        vc.getTfJuegoAlta().addFocusListener(new PlaceholderListener("Juego"));
        vc.getTfNombreBaja().addFocusListener(new PlaceholderListener("Nombre"));
        vc.getTfNombreModi().addFocusListener(new PlaceholderListener("Nombre"));
        vc.getTfFechaIniModi().addFocusListener(new PlaceholderListener("Fecha Inicio"));
        vc.getTfFechaFinModi().addFocusListener(new PlaceholderListener("Fecha Fin"));
        vc.getTfJuegoModi().addFocusListener(new PlaceholderListener("Juego"));
        vc.getTfNombreCons().addFocusListener(new PlaceholderListener("Nombre"));

        vc.getTaCons().setEditable(false);
        vc.getTaCons().setBackground(new Color(205, 205, 205));
    }

    private void mostrar() {
        vc.setVisible(true);
    }

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vc.dispose();
        }
    }

    private class bAlta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vc.eleccionAlta();
        }
    }

    private class bBaja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vc.eleccionBaja();
        }
    }

    private class bModi implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vc.eleccionModi();
        }
    }

    private class bConsulta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vc.eleccionConsulta();
        }
    }

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Competicion compe = new Competicion();
            if (vc.getRbAlta().isSelected()) {
                try {
                    String nombre = vc.getTfNombreAlta().getText();
                    String fecha1 = vc.getTfFechaIniAlta().getText();
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date fechaJava1 = formato.parse(fecha1);
                    java.sql.Date fechaSql1 = new java.sql.Date(fechaJava1.getTime());
                    String fecha2 = vc.getTfFechaFinAlta().getText();
                    java.util.Date fechaJava2 = formato.parse(fecha2);
                    java.sql.Date fechaSql2 = new java.sql.Date(fechaJava2.getTime());
                    String juego = vc.getTfJuegoAlta().getText();
                    compe.setNombre(nombre);
                    compe.setFechaInicio(fechaSql1.toLocalDate());
                    compe.setFechaFin(fechaSql2.toLocalDate());
                    Juego ju = cv.buscarJuego(juego);
                    if (ju != null){
                        compe.setCodJuego(ju);
                        cv.altaCompeticion(compe);
                    }else{
                        JOptionPane.showMessageDialog(vc, "Juego no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            } else if (vc.getRbBaja().isSelected()) {
                try {
                    String nombre = vc.getTfNombreBaja().getText();
                    compe.setNombre(nombre);
                    cv.bajaCompeticion(compe);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            } else if (vc.getRbModi().isSelected()) {
                try {
                    String nombre = vc.getTfNombreModi().getText();
                    String fecha1 = vc.getTfFechaIniModi().getText();
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date fechaJava1 = null;
                    fechaJava1 = formato.parse(fecha1);
                    java.sql.Date fechaSql1 = new java.sql.Date(fechaJava1.getTime());
                    String fecha2 = vc.getTfFechaFinModi().getText();
                    java.util.Date fechaJava2 = null;
                    fechaJava2 = formato.parse(fecha2);
                    java.sql.Date fechaSql2 = new java.sql.Date(fechaJava2.getTime());
                    String juego = vc.getTfJuegoModi().getText();
                    compe.setNombre(nombre);
                    compe.setFechaInicio(fechaSql1.toLocalDate());
                    compe.setFechaFin(fechaSql2.toLocalDate());
                    compe.setCodJuego(cv.getNombreJuegoPorCodigo(cv.buscarJuego(juego).getCodJuego()));
                    cv.modiCompeticion(compe);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            } else if (vc.getRbCons().isSelected()) {
                try {
                    String nombre = vc.getTfNombreCons().getText();
                    compe.setNombre(nombre);
                    vc.getTaCons().setText(cv.consultaCompeticion(nombre));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
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