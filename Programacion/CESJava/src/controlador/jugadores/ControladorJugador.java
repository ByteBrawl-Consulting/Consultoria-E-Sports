package controlador.jugadores;

import controlador.ControladorVista;
import modelo.Equipo;
import modelo.Jornada;
import modelo.Jugador;
import view.VentanaJugadores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * La clase ControladorJugador gestiona las interacciones entre la interfaz de usuario para manejar jugadores (VentanaJugadores) y el modelo de datos (Jugador).
 * Se encarga de acciones como agregar, eliminar, modificar y consultar jugadores.
 */

public class ControladorJugador {
    private VentanaJugadores vj;
    private ControladorVista cv;

    /**
     * Construye un ControladorJugador con el controlador de vista especificado.
     *
     * @param cv El controlador de vista que se utilizará para interactuar con el modelo de datos.
     */

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
     * Clase interna que maneja la acción del botón "Aceptar". Dependiendo de la opción seleccionada (Alta, Baja, Modificación, Consulta),
     * realiza la acción correspondiente sobre el objeto Jugador.
     */

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Jugador ju = new Jugador();
            if (vj.getRbAlta().isSelected()) {
                if (vj.getTfNombreAlta().getText().equals("Nombre")){
                    JOptionPane.showMessageDialog(null, "El nombre es obligatorio");
                } else if (vj.getTfNacionalidadAlta().getText().equals("Nacionalidad")) {
                    JOptionPane.showMessageDialog(null, "La nacionalidad es obligatoria");
                } else if (vj.getTfFechaAlta().getText().equals("Fecha Nacimineto")) {
                    JOptionPane.showMessageDialog(null, "La fecha de nacimiento es obligatoria");
                } else if (vj.getTfRolAlta().getText().equals("Rol")) {
                    JOptionPane.showMessageDialog(null, "El rol es obligatorio");
                } else if (vj.getTfSueldoAlta().getText().equals("Sueldo")) {
                    JOptionPane.showMessageDialog(null, "El sueldo es obligatorio");
                }else if (vj.getTfNickAlta().getText().equals("nickname")){
                    JOptionPane.showMessageDialog(null, "El nickname es obligatorio");
                }else {
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
                }
            } else if (vj.getRbBaja().isSelected()) {
                if (vj.getTfNombreBaja().getText().equals("nombre")) {
                    JOptionPane.showMessageDialog(null, "El nombre es obligatiorio");
                }else{
                    try {
                        String nombre = vj.getTfNombreBaja().getText();
                        ju.setNombreJugador(nombre);
                        cv.bajaJugador(ju);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            } else if (vj.getRbModi().isSelected()) {
                if (vj.getTfNombreModi().getText().equals("Nombre")){
                    JOptionPane.showMessageDialog(null, "El nombre es obligatorio");
                } else if (vj.getTfNacionalidadModi().getText().equals("Nacionalidad")) {
                    JOptionPane.showMessageDialog(null, "La nacionalidad es obligatoria");
                } else if (vj.getTfFechaModi().getText().equals("Fecha Nacimineto")) {
                    JOptionPane.showMessageDialog(null, "La fecha de nacimiento es obligatoria");
                } else if (vj.getTfRolModi().getText().equals("Rol")) {
                    JOptionPane.showMessageDialog(null, "El rol es obligatorio");
                } else if (vj.getTfSueldoModi().getText().equals("Sueldo")) {
                    JOptionPane.showMessageDialog(null, "El sueldo es obligatorio");
                }else if (vj.getTfNickModi().getText().equals("nickname")){
                    JOptionPane.showMessageDialog(null, "El nickname es obligatorio");
                }else{
                    try {
                        String nombre = vj.getTfNombreModi().getText();
                        String nacionalidad = vj.getTfNacionalidadModi().getText();
                        String fecha = vj.getTfFechaModi().getText();
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date fechaJava = null;
                        fechaJava = formato.parse(fecha);
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
                            ju.setCodEquipo(equipoObj);
                            cv.modiJugador(ju);
                        } else {
                            JOptionPane.showMessageDialog(vj, "Equipo no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            } else if (vj.getRbCons().isSelected()) {
                if (vj.getTfNombreCons().getText().equals("Nombre")){
                    JOptionPane.showMessageDialog(null, "El nombre es obligatiorio");
                }else{
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
     * Listener para el botón "Modi".
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

    private class bCons implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.eleccionConsulta();
        }
    }

    public void mostrar() {
        vj.setVisible(true);
        vj.getpAlta().setVisible(false);
        vj.getpBaja().setVisible(false);
        vj.getpCons().setVisible(false);
        vj.getpModi().setVisible(false);
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
