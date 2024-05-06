package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VentanaLogin extends JFrame {
    private JPanel pPrincipal;
    private JTextField tfUsu;
    private JTextField tfPassword;

    public VentanaLogin() throws HeadlessException {
        setContentPane(pPrincipal);
        setSize(700, 500);
        setLocationRelativeTo(null);
        }

    public JTextField getTfUsu() {
        return tfUsu;
    }

    public void setTfUsu(JTextField tfUsu) {
        this.tfUsu = tfUsu;
    }

    public JTextField getTfPassword() {
        return tfPassword;
    }

    public void setTfPassword(JTextField tfPassword) {
        this.tfPassword = tfPassword;
    }

    public void clickRatonUsuAL (MouseListener e){
        tfUsu.addMouseListener(e);
    }
    public void clickRatonPassAL (MouseListener e){
        tfPassword.addMouseListener(e);
    }

}



