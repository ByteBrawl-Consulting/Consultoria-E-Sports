package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaPrincipalUsuario extends JFrame {
    private JPanel panel1;
    private JLabel tituloLabel;
    private JButton bClasi;
    private JButton bJornada;
    private JTextField tfJornada;
    private JTextArea taJornada;
    private JPanel pJornada;
    private JPanel pClasificacion;
    private JTextField tfClasi;
    private JTextArea taClasi;
    private JLabel jornadalb;
    private JLabel claselb;
    private JRadioButton rbJornada;
    private JRadioButton rbClasi;

    public VentanaPrincipalUsuario() throws HeadlessException {
        super("Pagina Principal");
        setContentPane(panel1);
        setSize(500,300);
        setLocationRelativeTo(null);

    }
    public void jornadaAL (ActionListener al){
        tfJornada.addActionListener(al);
    }
    public void claseAL (ActionListener al){
        tfClasi.addActionListener(al);
    }
    public void rbJornadaAL (ActionListener al){
        rbJornada.addActionListener(al);
    }
    public void rbClasiAL (ActionListener al){
        rbClasi.addActionListener(al);
    }



    public JButton getbClasi() {
        return bClasi;
    }

    public void setbClasi(JButton bClasi) {
        this.bClasi = bClasi;
    }

    public JButton getbJornada() {
        return bJornada;
    }

    public void setbJornada(JButton bJornada) {
        this.bJornada = bJornada;
    }

    public JRadioButton getUltimaJornadaRadioButton() {
        return rbJornada;
    }

    public void setUltimaJornadaRadioButton(JRadioButton ultimaJornadaRadioButton) {
        this.rbJornada = ultimaJornadaRadioButton;
    }

    public JRadioButton getClasificacionRadioButton() {
        return rbClasi;
    }

    public void setClasificacionRadioButton(JRadioButton clasificacionRadioButton) {
        this.rbClasi = clasificacionRadioButton;
    }

    public JTextField getTfClasi() {
        return tfClasi;
    }

    public void setTfClasi(JTextField tfClasi) {
        this.tfClasi = tfClasi;
    }

    public JTextArea getTaClasi() {
        return taClasi;
    }

    public void setTaClasi(JTextArea taClasi) {
        this.taClasi = taClasi;
    }

    public JLabel getTituloLabel() {
        return tituloLabel;
    }

    public void setTituloLabel(JLabel tituloLabel) {
        this.tituloLabel = tituloLabel;
    }

    public JButton getClasificacionButton() {
        return bClasi;
    }

    public void setClasificacionButton(JButton clasificacionButton) {
        this.bClasi = clasificacionButton;
    }

    public JButton getUltimaJornadaButton() {
        return bJornada;
    }

    public void setUltimaJornadaButton(JButton ultimaJornadaButton) {
        this.bJornada = ultimaJornadaButton;
    }

    public JTextField getTfJornada() {
        return tfJornada;
    }

    public void setTfJornada(JTextField tfJornada) {
        this.tfJornada = tfJornada;
    }

    public JTextArea getTaJornada() {
        return taJornada;
    }

    public void setTaJornada(JTextArea taJornada) {
        this.taJornada = taJornada;
    }

    public JPanel getpJornada() {
        return pJornada;
    }

    public void setpJornada(JPanel pJornada) {
        this.pJornada = pJornada;
    }

    public JPanel getpClasificacion() {
        return pClasificacion;
    }

    public void setpClasificacion(JPanel pClasificacion) {
        this.pClasificacion = pClasificacion;
    }
}
