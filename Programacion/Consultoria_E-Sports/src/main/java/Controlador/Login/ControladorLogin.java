package Controlador.Login;

import View.VentanaLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorLogin {
    private VentanaLogin vl;

    public ControladorLogin() {
        mostrar();
        vl.clickRatonUsuAL(new clickRatonUsu());
        vl.clickRatonPassAL(new clickRatonPass());
        vl.bAyudaAL(new bAyuda());
        vl.bEntrarAL(new bEntrar());
        vl.bSalirAL(new bSalir());
    }
    public void mostrar(){
        vl=new VentanaLogin();
        vl.setVisible(true);
    }

    //Clases creadas para los tf y los botones
    public class bAyuda implements ActionListener {
        public void actionPerformed (ActionEvent e){
            JOptionPane.showMessageDialog(null,"Si necesitas ayuda contacte con nuestros administradores \n " +
                    " Jordi.fernandez@ikasle.egibide.org \n Adrian.lopez@ikasle.egibide.org \n Jon.garay@ikasle.egibide.org");
        }
    }
    public class bSalir implements ActionListener {
        public void actionPerformed (ActionEvent e){
            System.exit(0);
        }
    }
    public class bEntrar implements ActionListener {
        public void actionPerformed (ActionEvent e){

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
