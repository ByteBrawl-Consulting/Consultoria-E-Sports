package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaPrincipalUsuario extends JFrame {
    private JPanel panel1;
    private JLabel tituloLabel;
    private JButton clasificacionButton;
    private JButton ultimaJornadaButton;
    private JTextField tfJornada;
    private JTextArea taJornada;
    private JPanel pJornada;
    private JPanel pClasificacion;
    private JTextField tfClasi;
    private JTextArea taClasi;

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
        return clasificacionButton;
    }

    public void setClasificacionButton(JButton clasificacionButton) {
        this.clasificacionButton = clasificacionButton;
    }

    public JButton getUltimaJornadaButton() {
        return ultimaJornadaButton;
    }

    public void setUltimaJornadaButton(JButton ultimaJornadaButton) {
        this.ultimaJornadaButton = ultimaJornadaButton;
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
