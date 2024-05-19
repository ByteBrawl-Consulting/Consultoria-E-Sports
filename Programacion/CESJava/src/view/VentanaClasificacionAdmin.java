package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaClasificacionAdmin extends JFrame {


    private JPanel pPirncipal;
    private JComboBox cbClasi;
    private JTextArea taClasi;
    private JButton salirButton;

    public VentanaClasificacionAdmin() throws HeadlessException {
        super("Clasificacion");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setContentPane(pPirncipal);
    }

    public void cbClasiAL(ActionListener al) {
        cbClasi.addActionListener(al);
    }

    public JComboBox getCbClasi() {
        return cbClasi;
    }

    public void setCbClasi(JComboBox cbClasi) {
        this.cbClasi = cbClasi;
    }

    public JTextArea getTaClasi() {
        return taClasi;
    }

    public void setTaClasi(JTextArea taClasi) {
        this.taClasi = taClasi;
    }

    public void addBSalirAL(ActionListener al) {
        salirButton.addActionListener(al);
    }
}
