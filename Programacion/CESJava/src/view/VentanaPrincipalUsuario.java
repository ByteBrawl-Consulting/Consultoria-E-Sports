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
    private JPanel pJornada;
    private JPanel pClasificacion;
    private JTextField tfClasi;
    private JTextArea taConsulta;
    private JLabel claselb;
    private JRadioButton rbJornada;
    private JRadioButton rbClasi;
    private JButton bAceptarJornada;
    private JButton bAceptarClasi;
    private JButton bSalir;
    private JButton bSesion;

    public VentanaPrincipalUsuario() throws HeadlessException {
        super("Pagina Principal");
        setContentPane(panel1);
        setSize(750, 500);
        setLocationRelativeTo(null);

    }

    public void rbJornadaAL(ActionListener al) {
        rbJornada.addActionListener(al);
    }

    public void rbClasiAL(ActionListener al) {
        rbClasi.addActionListener(al);
    }

    public void botonAceprtarJornadaAL(ActionListener al) {
        bAceptarJornada.addActionListener(al);
    }

    public void botonAceptarClasiAL(ActionListener al) {
        bAceptarClasi.addActionListener(al);
    }

    public void bSalirAL(ActionListener al) {
        bSalir.addActionListener(al);
    }

    public void bSesion(ActionListener al) {
        bSesion.addActionListener(al);
    }


    public JButton getbSesion() {
        return bSesion;
    }

    public void setbSesion(JButton bSesion) {
        this.bSesion = bSesion;
    }

    public JButton getbAceptarJornada() {
        return bAceptarJornada;
    }

    public void setbAceptarJornada(JButton bAceptarJornada) {
        this.bAceptarJornada = bAceptarJornada;
    }

    public JButton getbAceptarClasi() {
        return bAceptarClasi;
    }

    public void setbAceptarClasi(JButton bAceptarClasi) {
        this.bAceptarClasi = bAceptarClasi;
    }

    public JButton getbSalir() {
        return bSalir;
    }

    public void setbSalir(JButton bSalir) {
        this.bSalir = bSalir;
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

    public JTextArea getTaConsulta() {
        return taConsulta;
    }

    public void setTaClasi(JTextArea taClasi) {
        this.taConsulta = taClasi;
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
