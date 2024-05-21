package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaMostrarXML extends JFrame{
    private JPanel pPrincipal;
    private JPanel pTitulo;
    private JTextArea taConsultaClasi;
    private JButton salirButton;
    private JLabel labelClasificacion;
    private JTextArea taConsultaJornada;
    private JTextArea taConsultaTodasJornadas;

    public VentanaMostrarXML() {
        super("Generar XML");
        setContentPane(pPrincipal);
        setSize(500, 500);
        setLocationRelativeTo(null);
    }

    public JTextArea getTaConsultaClasi() {
        return taConsultaClasi;
    }

    public void setTaConsultaClasi(JTextArea taConsultaClasi) {
        this.taConsultaClasi = taConsultaClasi;
    }

    public JTextArea getTaConsultaJornada() {
        return taConsultaJornada;
    }

    public void setTaConsultaJornada(JTextArea taConsultaJornada) {
        this.taConsultaJornada = taConsultaJornada;
    }

    public JTextArea getTaConsultaTodasJornadas() {
        return taConsultaTodasJornadas;
    }

    public void setTaConsultaTodasJornadas(JTextArea taConsultaTodasJornadas) {
        this.taConsultaTodasJornadas = taConsultaTodasJornadas;
    }

    public void addBSalir(ActionListener listener) {
        salirButton.addActionListener(listener);
    }
}
