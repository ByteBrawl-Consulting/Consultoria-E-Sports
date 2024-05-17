package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaClasificacionAdmin extends JFrame {


    private JPanel pPirncipal;
    private JComboBox cbClasi;
    private JTextArea taClasi;

    public VentanaClasificacionAdmin() throws HeadlessException {
        super("Clasificacion");
        setSize(500,300);
        setLocationRelativeTo(null);
        setContentPane(pPirncipal);
    }

    public void cbClasiAL (ActionListener al){cbClasi.addActionListener(al);}
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
}
