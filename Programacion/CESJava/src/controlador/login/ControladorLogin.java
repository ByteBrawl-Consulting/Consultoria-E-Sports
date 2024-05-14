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

public class ControladorLogin {
    private VentanaLogin vl;
    private ControladorVista cv;
    private ControladorUsuario cu;
    private ControladorAdmin ca;
    public ControladorLogin(ControladorVista cv) {
        this.cv = cv;
        vl = new VentanaLogin();

        vl.clickRatonUsuAL(new clickRatonUsu());
        vl.clickRatonPassAL(new clickRatonPass());
        vl.bAyudaAL(new bAyuda());
        vl.bEntrarAL(new bEntrar());
        vl.bSalirAL(new bSalir());

        vl.setVisible(true);
    }



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

    public class bEntrar implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Usuario usu = new Usuario();

                usu.setTipo(vl.getTfUsu().getText());
                usu.setContrasena(vl.getTfPassword().getText());
                String nombreAU = cv.login(usu);

                if (nombreAU.equals("Administrador")) {
                    ca = new ControladorAdmin(cv);
                } else if (nombreAU.equals("Usuario")) {
                    cu = new ControladorUsuario(cv);

                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public class clickRatonUsu implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            vl.getTfUsu().setText("");
            if (vl.getTfPassword().getText().isEmpty()) {
                vl.getTfPassword().setText("Contraseña");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    public class clickRatonPass implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            vl.getTfPassword().setText("");
            if (vl.getTfUsu().getText().isEmpty()) {
                vl.getTfUsu().setText("Usuario");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}

