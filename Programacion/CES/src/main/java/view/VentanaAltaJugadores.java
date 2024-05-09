package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaAltaJugadores extends JFrame{
    private JTextField tfSueldo;
    private JTextField tfNombre;
    private JLabel titulo;
    private JButton bSalir;
    private JButton bAceptar;
    private JPanel pPrincipal;
    private JTextField tfNacionalidad;
    private JTextField tfFecha;
    private JTextField tfNick;
    private JTextField tfRol;
    private JTextField tfEquipo;

    public VentanaAltaJugadores() throws HeadlessException {
        super("Ventana Alta Jugadores");
        setContentPane(pPrincipal);
        setSize(500,300);
        setLocationRelativeTo(null);
    }
    // Funciones de los TF y de los botones
    public void bAceptarAL (ActionListener listener){
        bAceptar.addActionListener(listener);
    }
    public void bSalirAL (ActionListener listener){
        bSalir.addActionListener(listener);
    }

    public JTextField getTfSueldo() {
        return tfSueldo;
    }

    public void setTfSueldo(JTextField tfSueldo) {
        this.tfSueldo = tfSueldo;
    }

    public JTextField getTfNombre() {
        return tfNombre;
    }

    public void setTfNombre(JTextField tfNombre) {
        this.tfNombre = tfNombre;
    }

    public JTextField getTfNacionalidad() {
        return tfNacionalidad;
    }

    public void setTfNacionalidad(JTextField tfNacionalidad) {
        this.tfNacionalidad = tfNacionalidad;
    }

    public JTextField getTfFecha() {
        return tfFecha;
    }

    public void setTfFecha(JTextField tfFecha) {
        this.tfFecha = tfFecha;
    }

    public JTextField getTfNick() {
        return tfNick;
    }

    public void setTfNick(JTextField tfNick) {
        this.tfNick = tfNick;
    }

    public JTextField getTfRol() {
        return tfRol;
    }

    public void setTfRol(JTextField tfRol) {
        this.tfRol = tfRol;
    }

    public JTextField getTfEquipo() {
        return tfEquipo;
    }

    public void setTfEquipo(JTextField tfEquipo) {
        this.tfEquipo = tfEquipo;
    }
}
