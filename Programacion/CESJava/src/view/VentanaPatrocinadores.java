package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaPatrocinadores extends JFrame{
    private JPanel pPrincipal;
    private JRadioButton rbAlta;
    private JRadioButton rbBaja;
    private JPanel pAlta;
    private JPanel pBaja;
    private JButton bAceptar;
    private JButton bSalir;
    private JTextField tfNombreAlta;
    private JTextField tfNombreBaja;

    public VentanaPatrocinadores(){
        super("Ventana Patrocinadores");
        setContentPane(pPrincipal);
        setSize(500,600);
        setLocationRelativeTo(null);
    }
    public void eleccionAlta(){
        pAlta.setVisible(true);
        pBaja.setVisible(false);
    }
    public void eleccionBaja(){
        pAlta.setVisible(false);
        pBaja.setVisible(true);
    }
    public void eleccionModi(){
        pAlta.setVisible(false);
        pBaja.setVisible(false);
    }
    public void eleccionConsulta(){
        pAlta.setVisible(false);
        pBaja.setVisible(false);
    }
    public void bAceptarAl(ActionListener listener){
        bAceptar.addActionListener(listener);
    }
    public void bSalirAL(ActionListener listener){
        bSalir.addActionListener(listener);
    }
    public void bRbAltaAL(ActionListener listener){
        rbAlta.addActionListener(listener);
    }
    public void bRbBajaAL(ActionListener listener){
        rbBaja.addActionListener(listener);
    }

    public JRadioButton getRbAlta() {
        return rbAlta;
    }

    public void setRbAlta(JRadioButton rbAlta) {
        this.rbAlta = rbAlta;
    }

    public JRadioButton getRbBaja() {
        return rbBaja;
    }

    public void setRbBaja(JRadioButton rbBaja) {
        this.rbBaja = rbBaja;
    }

    public JTextField getTfNombreAlta() {
        return tfNombreAlta;
    }

    public void setTfNombreAlta(JTextField tfNombreAlta) {
        this.tfNombreAlta = tfNombreAlta;
    }

    public JTextField getTfNombreBaja() {
        return tfNombreBaja;
    }

    public void setTfNombreBaja(JTextField tfNombreBaja) {
        this.tfNombreBaja = tfNombreBaja;
    }
}
