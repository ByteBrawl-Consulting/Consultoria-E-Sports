package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaPrincipalAdmin  extends JFrame {
    private JPanel pPrincipal;
    private JMenuBar menuBar;
    private JMenu menuEquipos;
    private JMenu menuJugadores;
    private JMenu staffMenu;
    private JMenu patrocinadoresMenu;
    private JMenu Juegos;
    private JMenu Competiciones;
    private JPanel pSecundario;
    private JLabel tituloLabel;
    private JMenuItem cerrarEtapaInscripcionMenuItem;
    private JMenu procesosMenu;
    private JMenuItem generarCalendarioMenuIItem;
    private JMenuItem introducirResultadosMenuItem;
    private JMenu consultasMenu;
    private JMenuItem resultadosJornadasMenuItem;
    private JMenuItem clasificacionMenuItem;
    private JMenuBar menuDosBar;
    private JButton cerrarSesionButton;
    private JButton salirButton;

    public VentanaPrincipalAdmin() throws HeadlessException {
        super("Login");
        setContentPane(pPrincipal);
        setSize(500, 300);
        setLocationRelativeTo(null);
    }
    public void addMEquipos(ActionListener listener){
        menuEquipos.addActionListener(listener);
    }
}
