package view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class VentanaAsociacionEquipoCompe extends JFrame {
    private JPanel pTitulo;
    private JButton aceptarButton;
    private JButton salirButton;
    private JPanel pAlta;
    private JPanel pBaja;
    private JPanel pBotones;
    private JTextField tfCompeAlta;
    private JTextField tfEquiAlta;
    private JPanel pPrincipal;
    private JRadioButton altaRadioButton;
    private JRadioButton bajaRadioButton;
    private JTextField tfCompeBaja;
    private JTextField tfEquiBaja;

    public VentanaAsociacionEquipoCompe(){
        super("Ventana Asociacion Equipo-Competicion");
        setContentPane(pPrincipal);
        setSize(750,500);
        setLocationRelativeTo(null);
    }

    public JButton getAceptarButton() {
        return aceptarButton;
    }

    public void setAceptarButton(JButton aceptarButton) {
        this.aceptarButton = aceptarButton;
    }

    public JButton getSalirButton() {
        return salirButton;
    }

    public void setSalirButton(JButton salirButton) {
        this.salirButton = salirButton;
    }

    public JTextField getTfCompeAlta() {
        return tfCompeAlta;
    }

    public void setTfCompeAlta(JTextField tfCompeAlta) {
        this.tfCompeAlta = tfCompeAlta;
    }

    public JTextField getTfEquiAlta() {
        return tfEquiAlta;
    }

    public void setTfEquiAlta(JTextField tfEquiAlta) {
        this.tfEquiAlta = tfEquiAlta;
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

    public JTextField getTfEquiBaja() {
        return tfEquiBaja;
    }

    public void setTfEquiBaja(JTextField tfEquiBaja) {
        this.tfEquiBaja = tfEquiBaja;
    }

    public JTextField getTfCompeBaja() {
        return tfCompeBaja;
    }

    public void setTfCompeBaja(JTextField tfCompeBaja) {
        this.tfCompeBaja = tfCompeBaja;
    }

    public void clickRatonCompeAltaAL(MouseListener al){
        tfCompeAlta.addMouseListener(al);
    }

    public void clickRatonEquiAltaAL(MouseListener al){
        tfEquiAlta.addMouseListener(al);
    }

    public void clickRatonCompeBajaAL (MouseListener al){
        tfCompeBaja.addMouseListener(al);
    }

    public void clickRatonEquiBajaAL (MouseListener al){
        tfEquiBaja.addMouseListener(al);
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

    public void eleccionAlta(){
        pAlta.setVisible(true);
        pBaja.setVisible(false);
    }
    public void eleccionBaja(){
        pAlta.setVisible(false);
        pBaja.setVisible(true);
    }
}