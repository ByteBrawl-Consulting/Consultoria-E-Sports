package controlador.staff;

import controlador.ControladorVista;
import modelo.Equipo;
import modelo.Staff;
import view.VentanaStaff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ControladorStaff {
    VentanaStaff vs;
    ControladorVista cv;

    public ControladorStaff(ControladorVista cv) {
        this.cv = cv;

        vs = new VentanaStaff();

        mostrar();

        vs.bAceptarAL(new bAceptar());
        vs.bSalirAL(new bSalir());
        vs.bRbAltaAL(new bAlta());
        vs.bRbBajaAL(new bBaja());
        vs.bRbModiAl(new bModi());
        vs.bRbConsultaAL(new bConsulta());

        vs.getTfNombreAlta().addFocusListener(new PlaceholderListener("Nombre"));
        vs.getTfCargoAlta().addFocusListener(new PlaceholderListener("Cargo"));
        vs.getTfSueldoAlta().addFocusListener(new PlaceholderListener("Sueldo"));
        vs.getTfEquipoAlta().addFocusListener(new PlaceholderListener("Equipo"));

        vs.getTfNombreBaja().addFocusListener(new PlaceholderListener("Nombre"));

        vs.getTfNombreModi().addFocusListener(new PlaceholderListener("Nombre"));
        vs.getTfCargoModi().addFocusListener(new PlaceholderListener("Cargo"));
        vs.getTfSueldoModi().addFocusListener(new PlaceholderListener("Sueldo"));
        vs.getTfEquipoModi().addFocusListener(new PlaceholderListener("Equipo"));

        vs.getTfNombreCons().addFocusListener(new PlaceholderListener("Nombre"));

        vs.getTaConsulta().setEditable(false);
        vs.getTaConsulta().setBackground(new Color(205, 205, 205));
    }

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.dispose();
        }
    }

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Staff staff = new Staff();
            if (vs.getRbAlta().isSelected()) {
                String nombre = vs.getTfNombreAlta().getText();
                String cargo = vs.getTfCargoAlta().getText();
                Integer sueldo = Integer.valueOf(vs.getTfSueldoAlta().getText());
                //Buscar equipo
                Equipo eq = cv.buscarEquipo(nombre);
                staff.setNombre(nombre);
                staff.setCargo(cargo);
                staff.setSueldo(sueldo);
                staff.setCodEquipo(eq);
                cv.altaStaff(staff);
            } else if (vs.getRbBaja().isSelected()) {
                String nombre = vs.getTfNombreBaja().getText();
                staff.setNombre(nombre);
                cv.bajaStaff(staff);
            } else if (vs.getRbModi().isSelected()) {
                String nombre = vs.getTfNombreModi().getText();
                String cargo = vs.getTfCargoModi().getText();
                Integer sueldo = Integer.valueOf(vs.getTfSueldoModi().getText());
                Equipo eq = cv.buscarEquipo(nombre);
                staff.setNombre(nombre);
                staff.setCargo(cargo);
                staff.setSueldo(sueldo);
                staff.setCodEquipo(eq);
                cv.modiStaff(staff,cargo,sueldo,eq);
            } else if (vs.getRbConsulta().isSelected()) {
                String nombre = vs.getTfNombreCons().getText();
                staff.setNombre(nombre);
                vs.getTaConsulta().setText(cv.cosultaStaff(nombre));
            }
        }
    }

    private class bAlta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.eleccionAlta();
        }
    }

    private class bBaja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.eleccionBaja();
        }
    }

    private class bModi implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.eleccionModi();
        }
    }

    private class bConsulta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.eleccionConsulta();
        }
    }
    public void mostrar(){
        vs.setVisible(true);
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
