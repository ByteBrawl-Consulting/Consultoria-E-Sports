package view;

import javax.swing.*;

public class VentanaIntroducirResultados extends JFrame{
    private JPanel pPrincipal;
    private JPanel pTitulo;
    private JPanel pAlta;
    private JLabel labelTitulo;
    private JRadioButton altaRadioButton;
    private JRadioButton modificaciónRadioButton;
    private JComboBox cbCompetición;
    private JTextField tfJornada;
    private JTextArea taConsulta;
    private JTextField tfCodEnfrentamiento;
    private JTextField tfEquipoGanador;
    private JButton aceptarButton;
    private JButton salirButton;

    public VentanaIntroducirResultados() {
        super("Ventana Introducir Resultados");
        setContentPane(pPrincipal);
        setSize(500, 600);
        setLocationRelativeTo(null);
    }

    public JRadioButton getAltaRadioButton() {
        return altaRadioButton;
    }

    public void setAltaRadioButton(JRadioButton altaRadioButton) {
        this.altaRadioButton = altaRadioButton;
    }

    public JRadioButton getModificaciónRadioButton() {
        return modificaciónRadioButton;
    }

    public void setModificaciónRadioButton(JRadioButton modificaciónRadioButton) {
        this.modificaciónRadioButton = modificaciónRadioButton;
    }

    public JComboBox getCbCompetición() {
        return cbCompetición;
    }

    public void setCbCompetición(JComboBox cbCompetición) {
        this.cbCompetición = cbCompetición;
    }

    public JTextField getTfJornada() {
        return tfJornada;
    }

    public void setTfJornada(JTextField tfJornada) {
        this.tfJornada = tfJornada;
    }

    public JTextArea getTaConsulta() {
        return taConsulta;
    }

    public void setTaConsulta(JTextArea taConsulta) {
        this.taConsulta = taConsulta;
    }

    public JTextField getTfCodEnfrentamiento() {
        return tfCodEnfrentamiento;
    }

    public void setTfCodEnfrentamiento(JTextField tfCodEnfrentamiento) {
        this.tfCodEnfrentamiento = tfCodEnfrentamiento;
    }

    public JTextField getTfEquipoGanador() {
        return tfEquipoGanador;
    }

    public void setTfEquipoGanador(JTextField tfEquipoGanador) {
        this.tfEquipoGanador = tfEquipoGanador;
    }
}
