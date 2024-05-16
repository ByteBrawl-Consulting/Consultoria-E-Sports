package view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class VentanaAsociacionEquipoCompe extends JFrame {
    private JPanel pTitulo;
    private JButton aceptarButton;
    private JButton salirButton;
    private JPanel pCompe;
    private JPanel pEquipo;
    private JPanel pBotones;
    private JTextField tfCompeticion;
    private JTextField tfEquipo;
    private JPanel pPrincipal;

    public VentanaAsociacionEquipoCompe(){
        super("Ventana Asociacion Equipo-Competicion");
        setContentPane(pPrincipal);
        setSize(500,600);
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

    public JTextField getTfCompeticion() {
        return tfCompeticion;
    }

    public void setTfCompeticion(JTextField tfCompeticion) {
        this.tfCompeticion = tfCompeticion;
    }

    public JTextField getTfEquipo() {
        return tfEquipo;
    }

    public void setTfEquipo(JTextField tfEquipo) {
        this.tfEquipo = tfEquipo;
    }

    public void clickRatonCompeAL (MouseListener al){
        tfCompeticion.addMouseListener(al);
    }
    public void clickRatonEquiAL (MouseListener al){
        tfEquipo.addMouseListener(al);
    }
    public void bAceptarAL (ActionListener al){
        aceptarButton.addActionListener(al);
    }
    public void bSalirAL (ActionListener al){
        salirButton.addActionListener(al);
    }
}
