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
    private JTextField tfCompeticion;
    private JTextField tfEquipo;
    private JPanel pPrincipal;
    private JRadioButton altaRadioButton;
    private JRadioButton bajaRadioButton;

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

    public JTextField getTfCompeticion() {
        return tfCompeticion;
    }

    public void setTfCompeticion(JTextField tfCompeticion) {
        this.tfCompeticion = tfCompeticion;
    }

    public JTextField getTfEquipo() {
        return tfEquipo;
    }

    public void setTfEquipo(JTextField tfEquipo) {
        this.tfEquipo = tfEquipo;
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

    public void clickRatonCompeAL (MouseListener al){
        tfCompeticion.addMouseListener(al);
    }
    public void clickRatonEquiAL (MouseListener al){
        tfEquipo.addMouseListener(al);
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