package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaGenerarCalendario extends JFrame{
    private JPanel pPrincipal;
    private JComboBox cbCalendario;
    private JButton bSalir;
    private JButton bAceptar;
    private JLabel espaciador1;
    private JLabel espaciador2;

    public VentanaGenerarCalendario() throws HeadlessException {
        super("Clasificacion");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setContentPane(pPrincipal);
    }
    public void cbCalendarioAL(ActionListener listener){
        cbCalendario.addActionListener(listener);
    }
    public void bSalirAL(ActionListener listener){
        bSalir.addActionListener(listener);
    }
    public void bAceptarAL(ActionListener listener){
        bAceptar.addActionListener(listener);
    }

    public JButton getbSalir() {
        return bSalir;
    }

    public void setbSalir(JButton bSalir) {
        this.bSalir = bSalir;
    }

    public JButton getbAceptar() {
        return bAceptar;
    }

    public void setbAceptar(JButton bAceptar) {
        this.bAceptar = bAceptar;
    }

    public JComboBox getCbCalendario() {
        return cbCalendario;
    }

    public void setCbCalendario(JComboBox cbCalendario) {
        this.cbCalendario = cbCalendario;
    }
}
