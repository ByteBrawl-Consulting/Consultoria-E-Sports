package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaAsociacionPatroEqui extends JFrame{
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
    private JPanel pModif;
    private JTextField tfPatroModi;
    private JTextField tfEquiModi;
    private JRadioButton modificaciónRadioButton;
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
        setSize(750,500);
        setLocationRelativeTo(null);
    }
    public void eleccionAlta(){
        pAlta.setVisible(true);
        pBotones.setVisible(true);
        pBaja.setVisible(false);
        pModif.setVisible(false);
        pConsulEqui.setVisible(false);
        pConsultPatro.setVisible(false);
        pTA.setVisible(false);
        pTitulo.setVisible(true);
    }
    public void eleccionBaja(){
        pAlta.setVisible(false);
        pBotones.setVisible(true);
        pBaja.setVisible(true);
        pModif.setVisible(false);
        pConsulEqui.setVisible(false);
        pConsultPatro.setVisible(false);
        pTA.setVisible(false);
        pTitulo.setVisible(true);
    }
    public void eleccionModi(){
        pAlta.setVisible(false);
        pBotones.setVisible(true);
        pBaja.setVisible(false);
        pModif.setVisible(true);
        pConsulEqui.setVisible(false);
        pConsultPatro.setVisible(false);
        pTA.setVisible(false);
        pTitulo.setVisible(true);
    }
    public void eleccionConsPatr(){
        pAlta.setVisible(false);
        pBotones.setVisible(true);
        pBaja.setVisible(false);
        pModif.setVisible(false);
        pConsulEqui.setVisible(false);
        pConsultPatro.setVisible(true);
        pTA.setVisible(true);
        pTitulo.setVisible(true);
    }
    public void eleccionConsEqui(){
        pAlta.setVisible(false);
        pBotones.setVisible(true);
        pBaja.setVisible(false);
        pModif.setVisible(false);
        pConsulEqui.setVisible(true);
        pConsultPatro.setVisible(false);
        pTA.setVisible(true);
        pTitulo.setVisible(true);
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

    public JTextField getTfPatroModi() {
        return tfPatroModi;
    }

    public void setTfPatroModi(JTextField tfPatroModi) {
        this.tfPatroModi = tfPatroModi;
    }

    public JTextField getTfEquiModi() {
        return tfEquiModi;
    }

    public void setTfEquiModi(JTextField tfEquiModi) {
        this.tfEquiModi = tfEquiModi;
    }

    public JRadioButton getModificaciónRadioButton() {
        return modificaciónRadioButton;
    }

    public void setModificaciónRadioButton(JRadioButton modificaciónRadioButton) {
        this.modificaciónRadioButton = modificaciónRadioButton;
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
    public void bAceptarAL (ActionListener al){
        aceptarButton.addActionListener(al);
    }

    public void bSalirAL (ActionListener al){
        salirButton.addActionListener(al);
    }

    public void bRbAltaAL (ActionListener al){
        altaRadioButton.addActionListener(al);
    }

    public void bRbBajaAL (ActionListener al){
        bajaRadioButton.addActionListener(al);
    }
    public void bRbModiAL(ActionListener listener){
        modificaciónRadioButton.addActionListener(listener);
    }
    public void bRbConsPatrAL(ActionListener listener){
        consultaPorPatrocinadorRadioButton.addActionListener(listener);
    }
    public void bRbConsEquiAL(ActionListener listener){
        consultaPorEquipoRadioButton.addActionListener(listener);
    }
}
