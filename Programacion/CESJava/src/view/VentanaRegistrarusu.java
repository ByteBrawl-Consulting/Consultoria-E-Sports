package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaRegistrarusu extends JFrame {
    private JTextField tfPass;
    private JTextField tfUsu;
    private JButton bAceptar;
    private JButton bSalir;
    private JPanel pPrincipal;

    public VentanaRegistrarusu() throws HeadlessException {
        super("Registrar usuario");
        setSize(500,350);
        setLocationRelativeTo(null);
        setContentPane(pPrincipal);
    }

    public void bAceptarAL (ActionListener al){
        bAceptar.addActionListener(al);
    }
    public void bSalirAL (ActionListener al){
        bSalir.addActionListener(al);
    }

    public JTextField getTfPass() {
        return tfPass;
    }

    public void setTfPass(JTextField tfPass) {
        this.tfPass = tfPass;
    }

    public JTextField getTfUsu() {
        return tfUsu;
    }

    public void setTfUsu(JTextField tfUsu) {
        this.tfUsu = tfUsu;
    }

    public JButton getbAceptar() {
        return bAceptar;
    }

    public void setbAceptar(JButton bAceptar) {
        this.bAceptar = bAceptar;
    }

    public JButton getbSalir() {
        return bSalir;
    }

    public void setbSalir(JButton bSalir) {
        this.bSalir = bSalir;
    }
}
