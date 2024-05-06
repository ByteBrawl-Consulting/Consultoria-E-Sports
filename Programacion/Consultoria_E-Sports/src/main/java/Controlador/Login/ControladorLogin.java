package Controlador.Login;

import View.VentanaLogin;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorLogin {
    private VentanaLogin vl;

    public ControladorLogin() {
        mostrar();
        vl.clickRatonUsuAL(new clickRatonUsu());
        vl.clickRatonPassAL(new clickRatonPass());
    }
    public void mostrar(){
        vl=new VentanaLogin();
        vl.setVisible(true);
    }
    public class clickRatonUsu implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            vl.getTfUsu().setText("");
            if (vl.getTfPassword().getText().length()==0){
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
            if (vl.getTfUsu().getText().length()==0){
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
