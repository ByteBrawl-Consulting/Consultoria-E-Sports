package controlador.login;

import controlador.ControladorVista;
import controlador.admin.ControladorAdmin;
import controlador.usuario.ControladorUsuario;
import modelo.Usuario;
import view.VentanaLogin;

import javax.swing.*;
import java.awt.event.*;

/**
 * El ControladorLogin gestiona la lógica de la interfaz de inicio de sesión,
 * validando las credenciales de los usuarios y redirigiéndolos a sus respectivas vistas.
 */

public class ControladorLogin {
    private VentanaLogin vl;
    private ControladorVista cv;
    private ControladorUsuario cu;
    private ControladorAdmin ca;

    /**
     * Constructor de la clase ControladorLogin.
     *
     * Inicializa la ventana de inicio de sesión, configura los eventos de los botones
     * y establece los placeholders en los campos de texto.
     *
     * @param cv El ControladorVista asociado.
     */

    public ControladorLogin(ControladorVista cv) {
        this.cv = cv;
        vl = new VentanaLogin();

        vl.bAyudaAL(new bAyuda());
        vl.bEntrarAL(new bEntrar());
        vl.bSalirAL(new bSalir());

        vl.getTfUsu().addFocusListener(new PlaceholderListener("Usuario"));
        vl.getTfPassword().addFocusListener(new PlaceholderListener("Contraseña"));

        vl.setVisible(true);
    }

    /**
     * Clase interna que maneja el evento de clic en el botón "Ayuda".
     * Muestra un cuadro de diálogo con información de contacto para ayuda.
     */


    public class bAyuda implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Si necesitas ayuda contacte con nuestros administradores. \n " +
                    "Jordi.fernandez@ikasle.egibide.org \n Adrian.lopez@ikasle.egibide.org \n Jon.garay@ikasle.egibide.org", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public class bSalir implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    /**
     * Clase interna que maneja el evento de clic en el botón "Entrar".
     * Valida las credenciales del usuario e inicia la vista correspondiente según el tipo de usuario.
     */

    public class bEntrar implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String usuario = vl.getTfUsu().getText();
            String contrasena = vl.getTfPassword().getText();

            if (!validarCampoNoVacio(usuario) || !validarCampoNoVacio(contrasena)) {
                JOptionPane.showMessageDialog(null, "Debe ingresar usuario y contraseña", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Usuario usu = new Usuario();
                usu.setTipo(usuario);
                usu.setContrasena(contrasena);

                String nombreAU = cv.login(usu);
                Usuario usu2 = cv.comprobarUsu(usu);

                if (nombreAU.equals("Administrador") || nombreAU.equals("1")) {
                    vl.getTfUsu().setText("Usuario");
                    vl.getTfPassword().setText("Contraseña");
                    ca = new ControladorAdmin(cv);
                } else if (usu.getTipo().equals(usu2.getTipo()) && usu.getContrasena().equals(usu2.getContrasena()) || nombreAU.equals("2")) {
                    vl.getTfUsu().setText("Usuario");
                    vl.getTfPassword().setText("Contraseña");
                    cu = new ControladorUsuario(cv);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Valida que el campo de texto no esté vacío.
     *
     * @param texto El texto a validar.
     * @return true si el campo no está vacío, false en caso contrario.
     */

    private boolean validarCampoNoVacio(String texto) {
        return !texto.trim().isEmpty();
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