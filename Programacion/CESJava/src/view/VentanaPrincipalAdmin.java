package view;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipalAdmin  extends JFrame {
    private JPanel pPrincipal;
    private JMenuBar menuBar;
    private JMenuItem altaEquiposMenuItem;
    private JMenu menuEquipos;
    private JMenuItem bajaEquiposMenuItem;
    private JMenuItem consultaEquiposMenuItem;
    private JMenuItem modificacionEquiposMenuItem;
    private JMenu menuJugadores;
    private JMenuItem altaJugadoresMenuItem;
    private JMenuItem bajaJugadoresMenuItem;
    private JMenuItem consultaJugadoresMenuItem;
    private JMenuItem modificacionJugadoresMenuItem;
    private JMenu staffMenu;
    private JMenuItem altaStaffMenuItem;
    private JMenuItem bajaStaffMenuItem;
    private JMenuItem consultaStaffMenuItem;
    private JMenuItem modificacionStaffMenuItem;
    private JMenu patrocinadoresMenu;
    private JMenuItem altaPatrocinadoresMenuItem;
    private JMenuItem bajaPatrocinadoresMenuItem;
    private JMenuItem consultaPatrocinadoresMenuItem;
    private JMenuItem modificacionPatrocinadoresMenuItem;
    private JMenu Juegos;
    private JMenuItem altaJuegosMenuItem;
    private JMenuItem bajaJuegosMenuItem;
    private JMenuItem consultaJuegosMenuItem;
    private JMenuItem modificacionJuegosMenuItem;
    private JMenu Competiciones;
    private JMenuItem altaCompeticionesMenuItem;
    private JMenuItem bajaCompeticionesMenuItem;
    private JMenuItem consultaCompeticionesMenuItem;
    private JMenuItem modificacionCompeticionesMenuItem;
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
}
