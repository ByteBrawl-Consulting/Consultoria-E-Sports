package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaJugadores extends JFrame{
    private JRadioButton rbAlta;
    private JRadioButton rbBaja;
    private JRadioButton rbModi;
    private JRadioButton rbCons;
    private JPanel pPrincipal;
    private JPanel pAlta;
    private JPanel pBaja;
    private JPanel pModi;
    private JPanel pCons;
    private JTextField tfNombreAlta;
    private JTextField tfNacionalidadAlta;
    private JTextField tfFechaAlta;
    private JTextField tfNickAlta;
    private JTextField tfRolAlta;
    private JTextField tfSueldoAlta;
    private JTextField tfEquipoAlta;
    private JButton bAceptar;
    private JButton bSalir;
    private JTextField tfNombreBaja;
    private JTextField tfNombreModi;
    private JTextField tfNacionalidadModi;
    private JTextField tfFechaModi;
    private JTextField tfNickModi;
    private JTextField tfRolModi;
    private JTextField tfSueldoModi;
    private JTextField tfEquipoModi;
    private JTextField tfNombreCons;
    private JTextArea taCons;
    public VentanaJugadores(){
        super("Ventana Jugadores");
        setContentPane(pPrincipal);
        setLocationRelativeTo(null);
        setSize(500,300);
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
    public void bAceptarAL(ActionListener listener){
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

    public JTextField getTfNacionalidadAlta() {
        return tfNacionalidadAlta;
    }

    public void setTfNacionalidadAlta(JTextField tfNacionalidadAlta) {
        this.tfNacionalidadAlta = tfNacionalidadAlta;
    }

    public JTextField getTfFechaAlta() {
        return tfFechaAlta;
    }

    public void setTfFechaAlta(JTextField tfFechaAlta) {
        this.tfFechaAlta = tfFechaAlta;
    }

    public JTextField getTfNickAlta() {
        return tfNickAlta;
    }

    public void setTfNickAlta(JTextField tfNickAlta) {
        this.tfNickAlta = tfNickAlta;
    }

    public JTextField getTfRolAlta() {
        return tfRolAlta;
    }

    public void setTfRolAlta(JTextField tfRolAlta) {
        this.tfRolAlta = tfRolAlta;
    }

    public JTextField getTfSueldoAlta() {
        return tfSueldoAlta;
    }

    public void setTfSueldoAlta(JTextField tfSueldoAlta) {
        this.tfSueldoAlta = tfSueldoAlta;
    }

    public JTextField getTfEquipoAlta() {
        return tfEquipoAlta;
    }

    public void setTfEquipoAlta(JTextField tfEquipoAlta) {
        this.tfEquipoAlta = tfEquipoAlta;
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

    public JTextField getTfNacionalidadModi() {
        return tfNacionalidadModi;
    }

    public void setTfNacionalidadModi(JTextField tfNacionalidadModi) {
        this.tfNacionalidadModi = tfNacionalidadModi;
    }

    public JTextField getTfFechaModi() {
        return tfFechaModi;
    }

    public void setTfFechaModi(JTextField tfFechaModi) {
        this.tfFechaModi = tfFechaModi;
    }

    public JTextField getTfNickModi() {
        return tfNickModi;
    }

    public void setTfNickModi(JTextField tfNickModi) {
        this.tfNickModi = tfNickModi;
    }

    public JTextField getTfRolModi() {
        return tfRolModi;
    }

    public void setTfRolModi(JTextField tfRolModi) {
        this.tfRolModi = tfRolModi;
    }

    public JTextField getTfSueldoModi() {
        return tfSueldoModi;
    }

    public void setTfSueldoModi(JTextField tfSueldoModi) {
        this.tfSueldoModi = tfSueldoModi;
    }

    public JTextField getTfEquipoModi() {
        return tfEquipoModi;
    }

    public void setTfEquipoModi(JTextField tfEquipoModi) {
        this.tfEquipoModi = tfEquipoModi;
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
