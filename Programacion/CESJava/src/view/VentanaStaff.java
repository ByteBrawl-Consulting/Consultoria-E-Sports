package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaStaff extends JFrame {
    private JRadioButton rbAlta;
    private JRadioButton rbBaja;
    private JRadioButton rbModi;
    private JRadioButton rbConsulta;
    private JPanel pAlta;
    private JPanel pBaja;
    private JPanel pModi;
    private JPanel pConsulta;
    private JButton bAceptar;
    private JButton bSalir;
    private JTextField tfNombreAlta;
    private JTextField tfCargoAlta;
    private JTextField tfSueldoAlta;
    private JTextField tfNombreBaja;
    private JTextField tfNombreModi;
    private JTextField tfCargoModi;
    private JTextField tfSueldoModi;
    private JTextField tfNombreCons;
    private JTextArea taConsulta;
    private JPanel pPrincipal;
    private JTextField tfEquipoAlta;
    private JTextField tfEquipoModi;

    public VentanaStaff() {
        super("Ventana Staff");
        setContentPane(pPrincipal);
        setSize(500, 600);
        setLocationRelativeTo(null);
    }

    public void eleccionAlta() {
        pAlta.setVisible(true);
        pBaja.setVisible(false);
        pModi.setVisible(false);
        pConsulta.setVisible(false);
    }

    public void eleccionBaja() {
        pAlta.setVisible(false);
        pBaja.setVisible(true);
        pModi.setVisible(false);
        pConsulta.setVisible(false);
    }

    public void eleccionModi() {
        pAlta.setVisible(false);
        pBaja.setVisible(false);
        pModi.setVisible(true);
        pConsulta.setVisible(false);
    }

    public void eleccionConsulta() {
        pAlta.setVisible(false);
        pBaja.setVisible(false);
        pModi.setVisible(false);
        pConsulta.setVisible(true);
    }

    public void bAceptarAL(ActionListener listener) {
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
        rbConsulta.addActionListener(listener);
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

    public JPanel getpConsulta() {
        return pConsulta;
    }

    public void setpConsulta(JPanel pConsulta) {
        this.pConsulta = pConsulta;
    }

    public JTextField getTfNombreAlta() {
        return tfNombreAlta;
    }

    public void setTfNombreAlta(JTextField tfNombreAlta) {
        this.tfNombreAlta = tfNombreAlta;
    }

    public JTextField getTfCargoAlta() {
        return tfCargoAlta;
    }

    public void setTfCargoAlta(JTextField tfCargoAlta) {
        this.tfCargoAlta = tfCargoAlta;
    }

    public JTextField getTfSueldoAlta() {
        return tfSueldoAlta;
    }

    public void setTfSueldoAlta(JTextField tfSueldoAlta) {
        this.tfSueldoAlta = tfSueldoAlta;
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

    public JTextField getTfCargoModi() {
        return tfCargoModi;
    }

    public void setTfCargoModi(JTextField tfCargoModi) {
        this.tfCargoModi = tfCargoModi;
    }

    public JTextField getTfSueldoModi() {
        return tfSueldoModi;
    }

    public void setTfSueldoModi(JTextField tfSueldoModi) {
        this.tfSueldoModi = tfSueldoModi;
    }

    public JTextField getTfNombreCons() {
        return tfNombreCons;
    }

    public void setTfNombreCons(JTextField tfNombreCons) {
        this.tfNombreCons = tfNombreCons;
    }

    public JTextArea getTaConsulta() {
        return taConsulta;
    }

    public void setTaConsulta(JTextArea taConsulta) {
        this.taConsulta = taConsulta;
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

    public JRadioButton getRbConsulta() {
        return rbConsulta;
    }

    public void setRbConsulta(JRadioButton rbConsulta) {
        this.rbConsulta = rbConsulta;
    }

    public JTextField getTfEquipoAlta() {
        return tfEquipoAlta;
    }

    public void setTfEquipoAlta(JTextField tfEquipoAlta) {
        this.tfEquipoAlta = tfEquipoAlta;
    }

    public JTextField getTfEquipoModi() {
        return tfEquipoModi;
    }

    public void setTfEquipoModi(JTextField tfEquipoModi) {
        this.tfEquipoModi = tfEquipoModi;
    }
}
