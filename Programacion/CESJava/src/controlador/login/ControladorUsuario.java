package controlador.login;

import controlador.ControladorVista;
import modelo.Usuarios;
import view.VentanaLogin;
import view.VentanaPrincipalAdmin;
import view.VentanaPrincipalUsuario;

import javax.swing.*;
import java.awt.event.*;

public class ControladorUsuario {
    private VentanaPrincipalUsuario vpu;
    private VentanaPrincipalAdmin vpa;
    private VentanaLogin vl;
    private ControladorVista cv;

    public ControladorUsuario(ControladorVista cv) {
        this.cv=cv;
    }
    public void mostrar(){
        vl=new VentanaLogin();
        vl.clickRatonUsuAL(new clickRatonUsu());
        vl.clickRatonPassAL(new clickRatonPass());
        vl.bAyudaAL(new bAyuda());
        vl.bEntrarAL(new bEntrar());
        vl.bSalirAL(new bSalir());
        vl.setVisible(true);
    }

    //Clases creadas para los tf y los botones
    public class bAyuda implements ActionListener {
        public void actionPerformed (ActionEvent e){
            JOptionPane.showMessageDialog(null,"Si necesitas ayuda contacte con nuestros administradores. \n " +
                    "Jordi.fernandez@ikasle.egibide.org \n Adrian.lopez@ikasle.egibide.org \n Jon.garay@ikasle.egibide.org","Ayuda",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public class bSalir implements ActionListener {
        public void actionPerformed (ActionEvent e){
            System.exit(0);
        }
    }
    public class bEntrar implements ActionListener {
        public void actionPerformed (ActionEvent e){
            try {
            Usuarios usu = new Usuarios();
            usu.setTipo(vl.getTfUsu().getText());
            usu.setContrasena(vl.getTfPassword().getText());
            String nombreAU= cv.login(usu);
            if (nombreAU.equals("Administrador"))
            {
                vpa = new VentanaPrincipalAdmin();
            } else if (nombreAU.equals("Usuario")) {
                vpu = new VentanaPrincipalUsuario();
            } else{
                throw new Exception("Usuario o contraseña incorrecto");
            }
            }
            catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public class clickRatonUsu implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            vl.getTfUsu().setText("");
            if (vl.getTfPassword().getText().isEmpty()){
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
            if (vl.getTfUsu().getText().isEmpty()){
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




