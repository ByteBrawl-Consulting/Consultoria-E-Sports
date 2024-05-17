package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaCerrarInscripciones extends JFrame{
    private JPanel pPrincipal;
    private JTextField tfCompeticion;
    private JTextArea taConsulta;
    private JButton aceptarButton;
    private JButton salirButton;

    public VentanaCerrarInscripciones() {
        super("Ventana Cerrar Inscripciones");
        setContentPane(pPrincipal);
        setSize(750,500);
        setLocationRelativeTo(null);
    }

    public JTextField getTfCompeticion() {
        return tfCompeticion;
    }

    public void setTfCompeticion(JTextField tfCompeticion) {
        this.tfCompeticion = tfCompeticion;
    }

    public JTextArea getTaConsulta() {
        return taConsulta;
    }

    public void setTaConsulta(JTextArea taConsulta) {
        this.taConsulta = taConsulta;
    }

    public void bAceptarAL(ActionListener listener) {
        aceptarButton.addActionListener(listener);
    }

    public void bSalirAL(ActionListener listener) {
        salirButton.addActionListener(listener);
    }
}
