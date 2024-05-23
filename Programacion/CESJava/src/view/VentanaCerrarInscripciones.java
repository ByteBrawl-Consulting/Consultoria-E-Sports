package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaCerrarInscripciones extends JFrame {
    private JPanel pPrincipal;
    private JTextArea taConsulta;
    private JButton aceptarButton;
    private JButton salirButton;
    private JComboBox cbCompeticion;
    private JLabel espaciador1;
    private JLabel espaciador2;
    private JLabel espaciador3;

    public VentanaCerrarInscripciones() {
        super("Ventana Cerrar Inscripciones");
        setContentPane(pPrincipal);
        setSize(850, 500);
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

    public JComboBox getCbCompeticion() {
        return cbCompeticion;
    }

    public void setCbCompeticion(JComboBox cbCompeticion) {
        this.cbCompeticion = cbCompeticion;
    }
}
