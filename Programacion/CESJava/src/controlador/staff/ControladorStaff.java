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

/**
 * ControladorStaff gestiona la interacción entre la vista de staff (VentanaStaff) y el modelo de negocio
 * relacionado con el personal del equipo (Staff) a través del ControladorVista.
 */

public class ControladorStaff {
   private VentanaStaff vs;
   private ControladorVista cv;

    /**
     * Constructor de ControladorStaff.
     *
     * @param cv El controlador principal de la vista.
     */

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
        validarCamposVacios();
    }

    /**
     * Clase interna que maneja el evento de clic en el botón "Salir".
     */
    private boolean validarCamposVacios(JTextField... fields) {
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty() || field.getText().equals("Nombre") || field.getText().equals("Cargo") || field.getText().equals("Sueldo") || field.getText().equals("Equipo")) {
                return false;
            }
        }
        return true;
    }
    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.dispose();
        }
    }

    /**
     * Clase interna que maneja el evento de clic en el botón "Aceptar".
     *
     * Dependiendo de la opción seleccionada (alta, baja, modificación, consulta),
     * realiza la acción correspondiente sobre el objeto Staff.
     *
     * - En caso de "alta", crea un nuevo objeto Staff con los datos ingresados,
     *   verifica la existencia del equipo y lo da de alta en el sistema.
     * - En caso de "baja", elimina el Staff del sistema basado en el nombre proporcionado.
     * - En caso de "modificación", actualiza los datos del Staff existente
     *   con los nuevos valores proporcionados.
     * - En caso de "consulta", busca y muestra la información del Staff basado en el nombre ingresado.
     */

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Staff staff = new Staff();

            if (vs.getRbAlta().isSelected()) {
                if (!validarCamposVacios(vs.getTfNombreAlta(), vs.getTfCargoAlta(), vs.getTfSueldoAlta(), vs.getTfEquipoAlta())) {
                    JOptionPane.showMessageDialog(vs, "Todos los campos deben estar llenos y no deben contener el texto del marcador de posición.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String nombre = vs.getTfNombreAlta().getText();
                String cargo = vs.getTfCargoAlta().getText();
                Integer sueldo = Integer.valueOf(vs.getTfSueldoAlta().getText());
                String equipo = vs.getTfEquipoAlta().getText();
                staff.setNombre(nombre);
                staff.setCargo(cargo);
                staff.setSueldo(sueldo);
                Equipo eq = cv.buscarEquipo(equipo);
                if (eq != null) {
                    staff.setCodEquipo(eq);
                    cv.altaStaff(staff);
                } else {
                    JOptionPane.showMessageDialog(vs, "Equipo no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (vs.getRbBaja().isSelected()) {
                if (!validarCamposVacios(vs.getTfNombreBaja())) {
                    JOptionPane.showMessageDialog(vs, "El campo 'Nombre' debe estar lleno y no debe contener el texto del marcador de posición.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String nombre = vs.getTfNombreBaja().getText();
                staff.setNombre(nombre);
                cv.bajaStaff(staff);
            } else if (vs.getRbModi().isSelected()) {
                if (!validarCamposVacios(vs.getTfNombreModi(), vs.getTfCargoModi(), vs.getTfSueldoModi(), vs.getTfEquipoModi())) {
                    JOptionPane.showMessageDialog(vs, "Todos los campos deben estar llenos y no deben contener el texto del marcador de posición.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String nombre = vs.getTfNombreModi().getText();
                String cargo = vs.getTfCargoModi().getText();
                Integer sueldo = Integer.valueOf(vs.getTfSueldoModi().getText());
                String equipo = vs.getTfEquipoModi().getText();
                staff.setNombre(nombre);
                staff.setCargo(cargo);
                staff.setSueldo(sueldo);
                Equipo eq = cv.buscarEquipo(equipo);
                if (eq != null) {
                    staff.setCodEquipo(eq);
                    cv.modiStaff(staff, cargo, sueldo, eq);
                } else {
                    JOptionPane.showMessageDialog(vs, "Equipo no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (vs.getRbConsulta().isSelected()) {
                if (!validarCamposVacios(vs.getTfNombreCons())) {
                    JOptionPane.showMessageDialog(vs, "El campo 'Nombre' debe estar lleno y no debe contener el texto del marcador de posición.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String nombre = vs.getTfNombreCons().getText();
                staff.setNombre(nombre);
                vs.getTaConsulta().setText(cv.cosultaStaff(nombre));
            }
        }
    }

    /**
     * Clase interna que maneja el evento de clic en el botón "Alta".
     */

    private class bAlta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.eleccionAlta();
        }
    }

    /**
     * Clase interna que maneja el evento de clic en el botón "Baja".
     */

    private class bBaja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.eleccionBaja();
        }
    }

    /**
     * Clase interna que maneja el evento de clic en el botón "Modificación".
     */

    private class bModi implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.eleccionModi();
        }
    }

    /**
     * Clase interna que maneja el evento de clic en el botón "Consulta".
     */

    private class bConsulta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.eleccionConsulta();
        }
    }

    /**
     * Muestra la ventana de staff y oculta los paneles de alta, baja, modificación y consulta.
     */

    public void mostrar() {
        vs.setVisible(true);
        vs.getpAlta().setVisible(false);
        vs.getpBaja().setVisible(false);
        vs.getpModi().setVisible(false);
        vs.getpConsulta().setVisible(false);
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
