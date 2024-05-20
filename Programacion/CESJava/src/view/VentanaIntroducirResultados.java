package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaIntroducirResultados extends JFrame{
    private JPanel pPrincipal;
    private JPanel pTitulo;
    private JPanel pAlta;
    private JLabel labelTitulo;
    private JRadioButton altaRadioButton;
    private JRadioButton modificaciónRadioButton;
    private JComboBox cbCompetición;
    private JTextField tfJornada;
    private JTextArea taConsultaAlta;
    private JTextField tfCodEnfrentamiento;
    private JTextField tfEquipoGanador;
    private JButton aceptarButton;
    private JButton salirButton;
    private JTextArea taConsultaModi;
    private JPanel pModi;
    private JTextField tfJornadaModi;
    private JTextField tfCodEnfreModi;
    private JTextField tfEquiGanadorModi;
    private JComboBox cbCompeticionModi;

    public VentanaIntroducirResultados() {
        super("Ventana Introducir Resultados");
        setContentPane(pPrincipal);
        setSize(500, 600);
        setLocationRelativeTo(null);
    }

    public void eleccionAlta() {
        pAlta.setVisible(true);
        pModi.setVisible(false);
    }

    public void eleccionModi() {
        pAlta.setVisible(false);
        pModi.setVisible(true);
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

    public JComboBox getCbCompeticion() {
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

    public JTextArea getTaConsultaAlta() {
        return taConsultaAlta;
    }

    public void setTaConsultaAlta(JTextArea taConsultaAlta) {
        this.taConsultaAlta = taConsultaAlta;
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

    public JTextArea getTaConsultaModi() {
        return taConsultaModi;
    }

    public void setTaConsultaModi(JTextArea taConsultaModi) {
        this.taConsultaModi = taConsultaModi;
    }

    public JTextField getTfJornadaModi() {
        return tfJornadaModi;
    }

    public void setTfJornadaModi(JTextField tfJornadaModi) {
        this.tfJornadaModi = tfJornadaModi;
    }

    public JTextField getTfCodEnfreModi() {
        return tfCodEnfreModi;
    }

    public void setTfCodEnfreModi(JTextField tfCodEnfreModi) {
        this.tfCodEnfreModi = tfCodEnfreModi;
    }

    public JTextField getTfEquiGanadorModi() {
        return tfEquiGanadorModi;
    }

    public void setTfEquiGanadorModi(JTextField tfEquiGanadorModi) {
        this.tfEquiGanadorModi = tfEquiGanadorModi;
    }

    public JComboBox getCbCompeticionModi() {
        return cbCompeticionModi;
    }

    public void setCbCompeticionModi(JComboBox cbCompeticionModi) {
        this.cbCompeticionModi = cbCompeticionModi;
    }

    public void bRbAltaAL(ActionListener listener) {
        altaRadioButton.addActionListener(listener);
    }

    public void bRbModiAl(ActionListener listener) {
        modificaciónRadioButton.addActionListener(listener);
    }

    public void bAceptarAL(ActionListener listener) {
        aceptarButton.addActionListener(listener);
    }

    public void bSalirAL(ActionListener listener) {
        salirButton.addActionListener(listener);
    }

    public JPanel getpAlta() {
        return pAlta;
    }

    public void setpAlta(JPanel pAlta) {
        this.pAlta = pAlta;
    }

    public JPanel getpModi() {
        return pModi;
    }

    public void setpModi(JPanel pModi) {
        this.pModi = pModi;
    }
}
