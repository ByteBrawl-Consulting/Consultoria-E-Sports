package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaEquipos extends JFrame{
    private JRadioButton rbAlta;
    private JRadioButton rbBaja;
    private JRadioButton rbModificacion;
    private JPanel pAlta;
    private JPanel pPrincipal;
    private JPanel pBaja;
    private JPanel pModificacion;
    private JRadioButton rbConsulta;
    private JTextField tfNombreAlta;
    private JTextField tfFechaAlta;
    private JTextField tfNombreBaja;
    private JTextField tfNombreModi;
    private JTextField tfFechaModi;
    private JTextField tfNombreCons;
    private JTextArea taConsulta;
    private JButton bAceptar;
    private JButton bSalir;
    private JPanel pConsulta;

    public VentanaEquipos(){
        super("Ventana Equipos");
        setContentPane(pPrincipal);
        setLocationRelativeTo(null);
        setSize(500,300);
    }
    public void eleccionAlta(){
        pAlta.setVisible(true);
        pBaja.setVisible(false);
        pModificacion.setVisible(false);
        pConsulta.setVisible(false);
    }
    public void eleccionBaja(){
        pAlta.setVisible(false);
        pBaja.setVisible(true);
        pModificacion.setVisible(false);
        pConsulta.setVisible(false);
    }
    public void eleccionModi(){
        pAlta.setVisible(false);
        pBaja.setVisible(false);
        pModificacion.setVisible(true);
        pConsulta.setVisible(false);
    }
    public void eleccionConsulta(){
        pAlta.setVisible(false);
        pBaja.setVisible(false);
        pModificacion.setVisible(false);
        pConsulta.setVisible(true);
    }
    public void bAceptarAl(ActionListener listener){
        bAceptar.addActionListener(listener);
    }
    public void bSalirAL(ActionListener listener){
        bSalir.addActionListener(listener);
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

    public JRadioButton getRbModificacion() {
        return rbModificacion;
    }

    public void setRbModificacion(JRadioButton rbModificacion) {
        this.rbModificacion = rbModificacion;
    }

    public JRadioButton getRbConsulta() {
        return rbConsulta;
    }

    public void setRbConsulta(JRadioButton rbConsulta) {
        this.rbConsulta = rbConsulta;
    }

    public JTextField getTfNombreAlta() {
        return tfNombreAlta;
    }

    public void setTfNombreAlta(JTextField tfNombreAlta) {
        this.tfNombreAlta = tfNombreAlta;
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

    public JTextArea getTaConsulta() {
        return taConsulta;
    }

    public void setTaConsulta(JTextArea taConsulta) {
        this.taConsulta = taConsulta;
    }
}
