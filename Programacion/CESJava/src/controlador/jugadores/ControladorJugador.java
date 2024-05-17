package controlador.jugadores;

import controlador.ControladorVista;
import modelo.Equipo;
import modelo.Jugador;
import view.VentanaJugadores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ControladorJugador {
    private VentanaJugadores vj;
    private ControladorVista cv;

    public ControladorJugador(ControladorVista cv) {
        this.cv = cv;

        vj = new VentanaJugadores();

        mostrar();

        vj.bAceptarAL(new bAceptar());
        vj.bSalirAL(new bSalir());
        vj.bRbAltaAL(new bAlta());
        vj.bRbBajaAL(new bBaja());
        vj.bRbModiAl(new bModi());
        vj.bRbConsultaAL(new bCons());

        vj.getTfNombreAlta().addFocusListener(new PlaceholderListener("Nombre"));
        vj.getTfFechaAlta().addFocusListener(new PlaceholderListener("Fecha Nacimiento"));
        vj.getTfNacionalidadAlta().addFocusListener(new PlaceholderListener("Nacionalidad"));
        vj.getTfNickAlta().addFocusListener(new PlaceholderListener("Nickname"));
        vj.getTfRolAlta().addFocusListener(new PlaceholderListener("Rol"));
        vj.getTfSueldoAlta().addFocusListener(new PlaceholderListener("Sueldo"));
        vj.getTfEquipoAlta().addFocusListener(new PlaceholderListener("Equipo"));

        vj.getTfNombreBaja().addFocusListener(new PlaceholderListener("Nombre"));

        vj.getTfNombreModi().addFocusListener(new PlaceholderListener("Nombre"));
        vj.getTfNacionalidadModi().addFocusListener(new PlaceholderListener("Nacionalidad"));
        vj.getTfFechaModi().addFocusListener(new PlaceholderListener("Fecha Nacimiento"));
        vj.getTfNickModi().addFocusListener(new PlaceholderListener("Nickname"));
        vj.getTfRolModi().addFocusListener(new PlaceholderListener("Rol"));
        vj.getTfSueldoModi().addFocusListener(new PlaceholderListener("Sueldo"));
        vj.getTfEquipoModi().addFocusListener(new PlaceholderListener("Equipo"));

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
            Jugador ju = new Jugador();
            if (vj.getRbAlta().isSelected()) {
                try {
                    String nombre = vj.getTfNombreAlta().getText();
                    String nacionalidad = vj.getTfNacionalidadAlta().getText();
                    String fecha = vj.getTfFechaAlta().getText();
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date fechaJava = formato.parse(fecha);
                    java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
                    String nick = vj.getTfNickAlta().getText();
                    String rol = vj.getTfRolAlta().getText();
                    Integer sueldo = Integer.parseInt(vj.getTfSueldoAlta().getText());
                    String equipo = vj.getTfEquipoAlta().getText();

                    ju.setNombreJugador(nombre);
                    ju.setNacionalidad(nacionalidad);
                    ju.setFechaNacimiento(fechaSql.toLocalDate());
                    ju.setNickname(nick);
                    ju.setRol(rol);
                    ju.setSueldo(sueldo);

                    Equipo equipoObj = cv.buscarEquipo(equipo);
                    if (equipoObj != null) {
                        ju.setCodEquipo(equipoObj); // Pass the entire Equipo object
                        cv.altaJugador(ju);
                    } else {
                        JOptionPane.showMessageDialog(vj, "Equipo no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            } else if (vj.getRbBaja().isSelected()) {
                try {
                    String nombre = vj.getTfNombreBaja().getText();
                    ju.setNombreJugador(nombre);
                    cv.bajaJugador(ju);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            } else if (vj.getRbModi().isSelected()) {
                try {
                    String nombre = vj.getTfNombreModi().getText();
                    String nacionalidad = vj.getTfNacionalidadModi().getText();
                    String fecha = vj.getTfFechaModi().getText();
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date fechaJava = formato.parse(fecha);
                    java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
                    String nick = vj.getTfNickModi().getText();
                    String rol = vj.getTfRolModi().getText();
                    Integer sueldo = Integer.parseInt(vj.getTfSueldoModi().getText());
                    String equipo = vj.getTfEquipoModi().getText();

                    ju.setNombreJugador(nombre);
                    ju.setNacionalidad(nacionalidad);
                    ju.setFechaNacimiento(fechaSql.toLocalDate());
                    ju.setNickname(nick);
                    ju.setRol(rol);
                    ju.setSueldo(sueldo);

                    Equipo equipoObj = cv.buscarEquipo(equipo);
                    if (equipoObj != null) {
                        ju.setCodEquipo(equipoObj); // Pass the entire Equipo object
                        cv.modiJugador(ju, fecha);
                    } else {
                        JOptionPane.showMessageDialog(vj, "Equipo no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            } else if (vj.getRbCons().isSelected()) {
                try {
                    String nombre = vj.getTfNombreCons().getText();
                    ju.setNombreJugador(nombre);
                    vj.getTaCons().setText(cv.consultaJugador(nombre));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
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

    private class bCons implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.eleccionConsulta();
        }
    }

    public void mostrar() {
        vj.setVisible(true);
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
