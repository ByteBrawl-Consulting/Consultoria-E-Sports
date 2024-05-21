package controlador.login;

import controlador.ControladorVista;
import controlador.admin.ControladorAdmin;
import controlador.usuario.ControladorUsuario;
import modelo.Competicion;
import modelo.Enfrentamiento;
import modelo.Jornada;
import modelo.Usuario;
import view.VentanaEquipos;
import view.VentanaLogin;
import view.VentanaPrincipalAdmin;
import view.VentanaPrincipalUsuario;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * ControladorLogin es el controlador que gestiona la interacción entre la vista de login (VentanaLogin)
 * y el modelo de usuario (Usuario). También dirige al usuario a la vista correspondiente
 * dependiendo de su tipo (administrador o usuario estándar).
 */

public class ControladorLogin {
    private VentanaLogin vl;
    private ControladorVista cv;
    private ControladorUsuario cu;
    private ControladorAdmin ca;

    /**
     * Constructor de ControladorLogin.
     *
     * @param cv El controlador principal de la vista.
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
     * Muestra un mensaje con información de contacto para ayuda.
     */

    public class bAyuda implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Si necesitas ayuda contacte con nuestros administradores. \n " +
                    "Jordi.fernandez@ikasle.egibide.org \n Adrian.lopez@ikasle.egibide.org \n Jon.garay@ikasle.egibide.org", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Clase interna que maneja el evento de clic en el botón "Salir".
     * Finaliza la aplicación.
     */

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
            try {
                Usuario usu = new Usuario();

                usu.setTipo(vl.getTfUsu().getText());
                usu.setContrasena(vl.getTfPassword().getText());
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

