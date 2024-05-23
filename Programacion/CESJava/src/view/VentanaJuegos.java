package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaJuegos extends JFrame {
    private JPanel pPrincipal;
    private JRadioButton rbAlta;
    private JRadioButton rbBaja;
    private JRadioButton rbModi;
    private JRadioButton rbCons;
    private JPanel pAlta;
    private JPanel pBaja;
    private JPanel pModi;
    private JPanel pCons;
    private JTextField tfNombreAlta;
    private JTextField tfDesaAlta;
    private JTextField tfFechaAlta;
    private JTextField tfNombreBaja;
    private JTextField tfNombreModi;
    private JTextField tfDesaModi;
    private JTextField tfFechaModi;
    private JTextField tfNombreCons;
    public JButton bAceptar;
    private JButton bSalir;
    private JTextArea taCons;

    public VentanaJuegos() {
        super("Ventana Juegos");
        setContentPane(pPrincipal);
        setSize(500, 600);
        setLocationRelativeTo(null);
    }

    public void eleccionAlta() {
        pAlta.setVisible(true);
        pBaja.setVisible(false);
        pModi.setVisible(false);
        pCons.setVisible(false);
    }

    public void eleccionBaja() {
        pAlta.setVisible(false);
        pBaja.setVisible(true);
        pModi.setVisible(false);
        pCons.setVisible(false);
    }

    public void eleccionModi() {
        pAlta.setVisible(false);
        pBaja.setVisible(false);
        pModi.setVisible(true);
        pCons.setVisible(false);
    }

    public void eleccionConsulta() {
        pAlta.setVisible(false);
        pBaja.setVisible(false);
        pModi.setVisible(false);
        pCons.setVisible(true);
    }

    public void bAceptarAl(ActionListener listener) {
        bAceptar.addActionListener(listener);
    }

    public void bSalirAL(ActionListener listener) {
        bSalir.addActionListener(listener);
    }

    public void bRbAltaAL(ActionListener listener) {
        rbAlta.addActionListener(listener);
    }

    public void bRbBajaAL(ActionListener listener) {
        rbBaja.addActionListener(listener);
    }

    public void bRbModiAl(ActionListener listener) {
        rbModi.addActionListener(listener);
    }

    public void bRbConsultaAL(ActionListener listener) {
        rbCons.addActionListener(listener);
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public void setpPrincipal(JPanel pPrincipal) {
        this.pPrincipal = pPrincipal;
    }

    public JPanel getpAlta() {
        return pAlta;
    }

    public void setpAlta(JPanel pAlta) {
        this.pAlta = pAlta;
    }

    public JPanel getpBaja() {
        return pBaja;
    }

    public void setpBaja(JPanel pBaja) {
        this.pBaja = pBaja;
    }

    public JPanel getpModi() {
        return pModi;
    }

    public void setpModi(JPanel pModi) {
        this.pModi = pModi;
    }

    public JPanel getpCons() {
        return pCons;
    }

    public void setpCons(JPanel pCons) {
        this.pCons = pCons;
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

    public JTextField getTfDesaAlta() {
        return tfDesaAlta;
    }

    public void setTfDesaAlta(JTextField tfDesaAlta) {
        this.tfDesaAlta = tfDesaAlta;
    }

    public JTextField getTfFechaAlta() {
        return tfFechaAlta;
    }

    public void setTfFechaAlta(JTextField tfFechaAlta) {
        this.tfFechaAlta = tfFechaAlta;
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

    public JTextField getTfDesaModi() {
        return tfDesaModi;
    }

    public void setTfDesaModi(JTextField tfDesaModi) {
        this.tfDesaModi = tfDesaModi;
    }

    public JTextField getTfFechaModi() {
        return tfFechaModi;
    }

    public void setTfFechaModi(JTextField tfFechaModi) {
        this.tfFechaModi = tfFechaModi;
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
