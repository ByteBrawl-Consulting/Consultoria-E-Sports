package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaResultadosTodasJornadas extends JFrame {
    private JPanel pPrincipal;
    private JPanel pTitulo;
    private JComboBox<String> cbCompeticion; // Agrega el tipo String
    private JTextArea taConsulta;
    private JButton bSalir;
    private JScrollPane pScroll;

    public VentanaResultadosTodasJornadas() throws HeadlessException {
        super("Resultados de Todas las Jornadas");
        setContentPane(pPrincipal);
        setSize(500, 300);
        setLocationRelativeTo(null);
    }

    public JComboBox<String> getCbCompeticion() {
        return cbCompeticion;
    }

    public void setCbCompeticion(JComboBox<String> cbCompeticion) {
        this.cbCompeticion = cbCompeticion;
    }

    public JTextArea getTaConsulta() {
        return taConsulta;
    }

    public void setTaConsulta(JTextArea taConsulta) {
        this.taConsulta = taConsulta;
    }

    public void addBSalir(ActionListener actionListener) {
        bSalir.addActionListener(actionListener);
    }

    public void addCompeticion(String competicion) {
        cbCompeticion.addItem(competicion);
    }

    public void addCBCompeticionAL(ActionListener actionListener) {
        cbCompeticion.addActionListener(actionListener);
    }

    public void addBSalirAL(ActionListener actionListener) {
        bSalir.addActionListener(actionListener);
    }
}
