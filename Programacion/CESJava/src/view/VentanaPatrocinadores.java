package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaPatrocinadores extends JFrame{
    private JPanel pPrincipal;
    private JRadioButton rbAlta;
    private JRadioButton rbBaja;
    private JRadioButton rbModi;
    private JRadioButton rbCons;
    private JPanel pAlta;
    private JPanel pBaja;
    private JPanel pModi;
    private JPanel pCons;
    private JButton bAceptar;
    private JButton bSalir;
    private JTextField tfNombreAlta;
    private JTextField tfNombreBaja;
    private JTextField tfNombreModi;
    private JTextField tfNombreCons;
    private JTextArea taCons;
    public VentanaPatrocinadores(){
        super("Ventana Patrocinadores");
        setContentPane(pPrincipal);
        setSize(500,600);
        setLocationRelativeTo(null);
    }
    public void eleccionAlta(){
        pAlta.setVisible(true);
        pBaja.setVisible(false);
        pModi.setVisible(false);
        pCons.setVisible(false);
    }
    public void eleccionBaja(){
        pAlta.setVisible(false);
        pBaja.setVisible(true);
        pModi.setVisible(false);
        pCons.setVisible(false);
    }
    public void eleccionModi(){
        pAlta.setVisible(false);
        pBaja.setVisible(false);
        pModi.setVisible(true);
        pCons.setVisible(false);
    }
    public void eleccionConsulta(){
        pAlta.setVisible(false);
        pBaja.setVisible(false);
        pModi.setVisible(false);
        pCons.setVisible(true);
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
    public void bRbModiAl(ActionListener listener){
        rbModi.addActionListener(listener);
    }
    public void bRbConsultaAL(ActionListener listener){
        rbCons.addActionListener(listener);
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

    public JRadioButton getRbModi() {
        return rbModi;
    }

    public void setRbModi(JRadioButton rbModi) {
        this.rbModi = rbModi;
    }

    public JRadioButton getRbCons() {
        return rbCons;
    }

    public void setRbCons(JRadioButton rbCons) {
        this.rbCons = rbCons;
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

    public JTextField getTfNombreModi() {
        return tfNombreModi;
    }

    public void setTfNombreModi(JTextField tfNombreModi) {
        this.tfNombreModi = tfNombreModi;
    }

    public JTextField getTfNombreCons() {
        return tfNombreCons;
    }

    public void setTfNombreCons(JTextField tfNombreCons) {
        this.tfNombreCons = tfNombreCons;
    }

    public JTextArea getTaCons() {
        return taCons;
    }

    public void setTaCons(JTextArea taCons) {
        this.taCons = taCons;
    }
}
