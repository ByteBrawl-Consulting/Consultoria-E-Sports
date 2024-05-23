package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaCompeticiones extends JFrame {
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
    private JTextField tfFechaIniAlta;
    private JTextField tfFechaFinAlta;
    private JTextField tfJuegoAlta;
    private JTextField tfNombreBaja;
    private JTextField tfNombreModi;
    private JTextField tfFechaIniModi;
    private JTextField tfFechaFinModi;
    private JTextField tfJuegoModi;
    private JTextField tfNombreCons;
    private JTextArea taCons;
    private JButton bAceptar;
    private JButton bSalir;

    public VentanaCompeticiones() {
        super("Ventana Competiciones");
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

    public JTextField getTfFechaIniAlta() {
        return tfFechaIniAlta;
    }

    public void setTfFechaIniAlta(JTextField tfFechaIniAlta) {
        this.tfFechaIniAlta = tfFechaIniAlta;
    }

    public JTextField getTfFechaFinAlta() {
        return tfFechaFinAlta;
    }

    public void setTfFechaFinAlta(JTextField tfFechaFinAlta) {
        this.tfFechaFinAlta = tfFechaFinAlta;
    }

    public JTextField getTfJuegoAlta() {
        return tfJuegoAlta;
    }

    public void setTfJuegoAlta(JTextField tfJuegoAlta) {
        this.tfJuegoAlta = tfJuegoAlta;
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

    public JTextField getTfFechaIniModi() {
        return tfFechaIniModi;
    }

    public void setTfFechaIniModi(JTextField tfFechaIniModi) {
        this.tfFechaIniModi = tfFechaIniModi;
    }

    public JTextField getTfFechaFinModi() {
        return tfFechaFinModi;
    }

    public void setTfFechaFinModi(JTextField tfFechaFinModi) {
        this.tfFechaFinModi = tfFechaFinModi;
    }

    public JTextField getTfJuegoModi() {
        return tfJuegoModi;
    }

    public void setTfJuegoModi(JTextField tfJuegoModi) {
        this.tfJuegoModi = tfJuegoModi;
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
