package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class VentanaLogin extends JFrame {
    private JPanel pPrincipal;
    private JTextField tfUsu;
    private JTextField tfPassword;
    private JButton bSalir;
    private JButton bEntrar;
    private JButton bAyuda;
    private JLabel titulo;

    public VentanaLogin() throws HeadlessException {
        super("Login");
        setContentPane(pPrincipal);
        setSize(500, 300);
        setLocationRelativeTo(null);

    }
    // Funciones de los TF y de los botones
    public void clickRatonUsuAL (MouseListener al){
        tfUsu.addMouseListener(al);
    }
    public void clickRatonPassAL (MouseListener al){
        tfPassword.addMouseListener(al);
    }
    public void bSalirAL (ActionListener al){
        bSalir.addActionListener(al);
    }
    public void bEntrarAL (ActionListener al){
        bEntrar.addActionListener(al);
    }
    public void bAyudaAL (ActionListener al){
        bAyuda.addActionListener(al);
    }


    // Getter and Setter
    public JButton getbSalir() {
        return bSalir;
    }

    public void setbSalir(JButton bSalir) {
        this.bSalir = bSalir;
    }

    public JButton getbEntrar() {
        return bEntrar;
    }

    public void setbEntrar(JButton bEntrar) {
        this.bEntrar = bEntrar;
    }

    public JButton getbAyuda() {
        return bAyuda;
    }

    public void setbAyuda(JButton bAyuda) {
        this.bAyuda = bAyuda;
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
}



