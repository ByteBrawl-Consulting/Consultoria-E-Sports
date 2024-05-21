package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaPrincipalAdmin extends JFrame {
    private JPanel pPrincipal;
    private JMenu menuEquipos;
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
    private JButton equiposButton;
    private JButton jugadoresButton;
    private JButton staffButton;
    private JButton patrocinadoresButton;
    private JButton juegosButton;
    private JButton competicionesButton;
    private JButton añadirEquipoACompeticiónButton;
    private JButton añadirPatrocinadorEquipoButton;
    private JButton altaNuevoUsuarioButton;
    private JButton generarXMLButton;

    public VentanaPrincipalAdmin() throws HeadlessException {
        super("Panel de Administrador");
        setContentPane(pPrincipal);
        setSize(750, 450);
        setLocationRelativeTo(null);
    }

    public void cerrarSesion(ActionListener al) {
        cerrarSesionButton.addActionListener(al);
    }

    public void bAltaUSu(ActionListener al) {
        altaNuevoUsuarioButton.addActionListener(al);
    }

    public JButton getAltaNuevoUsuarioButton() {
        return altaNuevoUsuarioButton;
    }

    public void setAltaNuevoUsuarioButton(JButton altaNuevoUsuarioButton) {
        this.altaNuevoUsuarioButton = altaNuevoUsuarioButton;
    }

    public void addBSalir(ActionListener listener) {
        salirButton.addActionListener(listener);
    }

    public void addBEquipos(ActionListener listener) {
        equiposButton.addActionListener(listener);
    }

    public void addBJugadores(ActionListener listener) {
        jugadoresButton.addActionListener(listener);
    }

    public void addBStaff(ActionListener listener) {
        staffButton.addActionListener(listener);
    }

    public void addBJuegos(ActionListener listener) {
        juegosButton.addActionListener(listener);
    }

    public void addBPatrocinadores(ActionListener listener) {
        patrocinadoresButton.addActionListener(listener);
    }

    public void addBCompeticiones(ActionListener listener) {
        competicionesButton.addActionListener(listener);
    }

    public void addBAsociarEquiCompe(ActionListener listener) {
        añadirEquipoACompeticiónButton.addActionListener(listener);
    }

    public void addBAsociarPatrocinadorEquipo(ActionListener listener) {
        añadirPatrocinadorEquipoButton.addActionListener(listener);
    }

    public void addClasi(ActionListener al) {
        clasificacionMenuItem.addActionListener(al);
    }

    public void addBCerrarEtapaInscripcion(ActionListener al) {
        cerrarEtapaInscripcionMenuItem.addActionListener(al);
    }

    public void addBResultadosJornadas(ActionListener al) {
        resultadosJornadasMenuItem.addActionListener(al);
    }

    public void addBGenerarCalendario(ActionListener al) {
        generarCalendarioMenuIItem.addActionListener(al);
    }

    public void addBIntroducirResultados(ActionListener al) {
        introducirResultadosMenuItem.addActionListener(al);
    }

    public void addBGenerarXML(ActionListener al) {
        generarXMLButton.addActionListener(al);
    }
}
