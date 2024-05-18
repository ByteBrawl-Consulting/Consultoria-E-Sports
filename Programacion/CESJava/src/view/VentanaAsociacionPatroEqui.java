package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaAsociacionPatroEqui extends JFrame {
    private JPanel pPrincipal;
    private JPanel pTitulo;
    private JRadioButton altaRadioButton;
    private JRadioButton bajaRadioButton;
    private JPanel pAlta;
    private JTextField tfPatroAlta;
    private JTextField tfEquiAlta;
    private JPanel pBotones;
    private JButton aceptarButton;
    private JButton salirButton;
    private JRadioButton consultaPorPatrocinadorRadioButton;
    private JRadioButton consultaPorEquipoRadioButton;
    private JPanel pBaja;
    private JPanel pConsultPatro;
    private JPanel pConsulEqui;
    private JTextField tfPatroBaja;
    private JTextField tfEquiBaja;
    private JTextField tfPatroConsul;
    private JTextField tfEquiConsul;
    private JTextArea taConsulta;
    private JPanel pTA;

    public VentanaAsociacionPatroEqui() throws HeadlessException {
        super("Ventana Asociacion Patrocinador-Equipo");
        setContentPane(pPrincipal);
        setSize(750, 500);
        setLocationRelativeTo(null);
    }

    public void eleccionAlta() {
        pAlta.setVisible(true);
        pBotones.setVisible(true);
        pBaja.setVisible(false);
        pConsulEqui.setVisible(false);
        pConsultPatro.setVisible(false);
        pTA.setVisible(false);
        pTitulo.setVisible(true);
    }

    public void eleccionBaja() {
        pAlta.setVisible(false);
        pBotones.setVisible(true);
        pBaja.setVisible(true);
        pConsulEqui.setVisible(false);
        pConsultPatro.setVisible(false);
        pTA.setVisible(false);
        pTitulo.setVisible(true);
    }

    public void eleccionModi() {
        pAlta.setVisible(false);
        pBotones.setVisible(true);
        pBaja.setVisible(false);
        pConsulEqui.setVisible(false);
        pConsultPatro.setVisible(false);
        pTA.setVisible(false);
        pTitulo.setVisible(true);
    }

    public void eleccionConsPatr() {
        pAlta.setVisible(false);
        pBotones.setVisible(true);
        pBaja.setVisible(false);
        pConsulEqui.setVisible(false);
        pConsultPatro.setVisible(true);
        pTA.setVisible(true);
        pTitulo.setVisible(true);
    }

    public void eleccionConsEqui() {
        pAlta.setVisible(false);
        pBotones.setVisible(true);
        pBaja.setVisible(false);
        pConsulEqui.setVisible(true);
        pConsultPatro.setVisible(false);
        pTA.setVisible(true);
        pTitulo.setVisible(true);
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

    public JPanel getpConsultPatro() {
        return pConsultPatro;
    }

    public void setpConsultPatro(JPanel pConsultPatro) {
        this.pConsultPatro = pConsultPatro;
    }

    public JPanel getpConsulEqui() {
        return pConsulEqui;
    }

    public void setpConsulEqui(JPanel pConsulEqui) {
        this.pConsulEqui = pConsulEqui;
    }

    public JPanel getpTA() {
        return pTA;
    }

    public void setpTA(JPanel pTA) {
        this.pTA = pTA;
    }

    public JRadioButton getAltaRadioButton() {
        return altaRadioButton;
    }

    public void setAltaRadioButton(JRadioButton altaRadioButton) {
        this.altaRadioButton = altaRadioButton;
    }

    public JRadioButton getBajaRadioButton() {
        return bajaRadioButton;
    }

    public void setBajaRadioButton(JRadioButton bajaRadioButton) {
        this.bajaRadioButton = bajaRadioButton;
    }

    public JTextField getTfPatroAlta() {
        return tfPatroAlta;
    }

    public void setTfPatroAlta(JTextField tfPatroAlta) {
        this.tfPatroAlta = tfPatroAlta;
    }

    public JTextField getTfEquiAlta() {
        return tfEquiAlta;
    }

    public void setTfEquiAlta(JTextField tfEquiAlta) {
        this.tfEquiAlta = tfEquiAlta;
    }

    public JRadioButton getConsultaPorPatrocinadorRadioButton() {
        return consultaPorPatrocinadorRadioButton;
    }

    public void setConsultaPorPatrocinadorRadioButton(JRadioButton consultaPorPatrocinadorRadioButton) {
        this.consultaPorPatrocinadorRadioButton = consultaPorPatrocinadorRadioButton;
    }

    public JRadioButton getConsultaPorEquipoRadioButton() {
        return consultaPorEquipoRadioButton;
    }

    public void setConsultaPorEquipoRadioButton(JRadioButton consultaPorEquipoRadioButton) {
        this.consultaPorEquipoRadioButton = consultaPorEquipoRadioButton;
    }

    public JTextField getTfPatroBaja() {
        return tfPatroBaja;
    }

    public void setTfPatroBaja(JTextField tfPatroBaja) {
        this.tfPatroBaja = tfPatroBaja;
    }

    public JTextField getTfEquiBaja() {
        return tfEquiBaja;
    }

    public void setTfEquiBaja(JTextField tfEquiBaja) {
        this.tfEquiBaja = tfEquiBaja;
    }

    public JTextField getTfPatroConsul() {
        return tfPatroConsul;
    }

    public void setTfPatroConsul(JTextField tfPatroConsul) {
        this.tfPatroConsul = tfPatroConsul;
    }

    public JTextField getTfEquiConsul() {
        return tfEquiConsul;
    }

    public void setTfEquiConsul(JTextField tfEquiConsul) {
        this.tfEquiConsul = tfEquiConsul;
    }

    public JTextArea getTaConsulta() {
        return taConsulta;
    }

    public void setTaConsulta(JTextArea taConsulta) {
        this.taConsulta = taConsulta;
    }

    public void bAceptarAL(ActionListener al) {
        aceptarButton.addActionListener(al);
    }

    public void bSalirAL(ActionListener al) {
        salirButton.addActionListener(al);
    }

    public void bRbAltaAL(ActionListener al) {
        altaRadioButton.addActionListener(al);
    }

    public void bRbBajaAL(ActionListener al) {
        bajaRadioButton.addActionListener(al);
    }

    public void bRbConsPatrAL(ActionListener listener) {
        consultaPorPatrocinadorRadioButton.addActionListener(listener);
    }

    public void bRbConsEquiAL(ActionListener listener) {
        consultaPorEquipoRadioButton.addActionListener(listener);
    }
}
