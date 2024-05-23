package controlador.usuario;

import controlador.ControladorPrincipal;
import controlador.ControladorVista;
import modelo.Competicion;
import modelo.Enfrentamiento;
import modelo.Equipo;
import modelo.Jornada;
import org.junit.Before;
import org.junit.Test;
import view.VentanaPrincipalUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ControladorUsuarioTest {
    private ControladorVista cv;
    private VentanaPrincipalUsuario vpu;
    private ControladorUsuario controladorUsuario;
    private ControladorPrincipal cp = new ControladorPrincipal();

    @Before
    public void setUp() {
        cv = new ControladorVistaStub(cp);
        vpu = new VentanaPrincipalUsuarioStub();
        controladorUsuario = new ControladorUsuario(cv);
        controladorUsuario.vpu = vpu;
    }

    @Test
    public void testMostrar() {
        controladorUsuario.mostrar();
        assertTrue(vpu.isVisible());
        assertFalse(vpu.getTaConsulta().isVisible());
        assertFalse(vpu.getjScroll().isVisible());
    }

    @Test
    public void testRbUsuJornadaActionPerformed() {
        ControladorUsuario.rbUsuJornada rbUsuJornada = controladorUsuario.new rbUsuJornada();
        vpu.getpJornada().setEnabled(true);

        rbUsuJornada.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        assertTrue(vpu.getTaConsulta().isVisible());
        assertTrue(vpu.getjScroll().isVisible());
        assertTrue(vpu.getpJornada().isVisible());
        assertFalse(vpu.getpClasificacion().isVisible());
        assertThat(vpu.getTaConsulta().getText(), is(""));
    }

    @Test
    public void testRbUsuClasiActionPerformed() {
        ControladorUsuario.rbUsuClasi rbUsuClasi = controladorUsuario.new rbUsuClasi();
        vpu.getpClasificacion().setEnabled(true);

        rbUsuClasi.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        assertTrue(vpu.getTaConsulta().isVisible());
        assertTrue(vpu.getjScroll().isVisible());
        assertFalse(vpu.getpJornada().isVisible());
        assertTrue(vpu.getpClasificacion().isVisible());
        assertThat(vpu.getTaConsulta().getText(), is(""));
    }

    @Test
    public void testBAceptarJornadaActionPerformed() {
        ControladorUsuario.bAceptarJornada bAceptarJornada = controladorUsuario.new bAceptarJornada();
        vpu.getTfJornada().setText("Test Competicion");

        bAceptarJornada.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        assertThat(vpu.getTaConsulta().getText(), containsString("Numero de jornada: 1"));
    }

    @Test
    public void testBSalirUsuActionPerformed() {
        ControladorUsuario.bSalirUsu bSalirUsu = controladorUsuario.new bSalirUsu();
        ActionEvent eventMock = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null);


    }

    @Test
    public void testBSesionUsuActionPerformed() {
        ControladorUsuario.bSesionUsu bSesionUsu = controladorUsuario.new bSesionUsu();
        vpu.getTfJornada().setText("Test Jornada");
        vpu.getTfClasi().setText("Test Clasi");

        bSesionUsu.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        assertFalse(vpu.isVisible());
        assertThat(vpu.getTfJornada().getText(), is(""));
        assertThat(vpu.getTfClasi().getText(), is(""));
    }

    private class ControladorVistaStub extends ControladorVista {
        public ControladorVistaStub(ControladorPrincipal cp) {
            super(cp);
        }

        @Override
        public ArrayList<Enfrentamiento> obtenerUltimaJornada(Competicion competicion) {
            ArrayList<Enfrentamiento> enfrentamientos = new ArrayList<>();
            Jornada jornada = new Jornada();
            jornada.setNumJornada(1);
            jornada.setCodCompe(competicion);

            Equipo equipoLocal = new Equipo();
            equipoLocal.setCodEquipo(Integer.parseInt("1"));

            Equipo equipoVisitante = new Equipo();
            equipoVisitante.setCodEquipo(Integer.parseInt("2"));

            Enfrentamiento enfrentamiento = new Enfrentamiento();
            enfrentamiento.setCodJornada(jornada);
            enfrentamiento.setCodEquipoLocal(equipoLocal);
            enfrentamiento.setCodEquipoVisitante(equipoVisitante);
            enfrentamiento.setHora("18:00");
            enfrentamiento.setFecha(LocalDate.parse("2023-05-23"));
            enfrentamiento.setResultado("Local1");

            enfrentamientos.add(enfrentamiento);
            return enfrentamientos;
        }

    }

    private class VentanaPrincipalUsuarioStub extends VentanaPrincipalUsuario {
        private JTextField tfJornada = new JTextField();
        private JTextField tfClasi = new JTextField();
        private JTextArea taConsulta = new JTextArea();
        private JScrollPane jScroll = new JScrollPane();
        private JPanel pJornada = new JPanel();
        private JPanel pClasificacion = new JPanel();

        @Override
        public JTextField getTfJornada() {
            return tfJornada;
        }

        @Override
        public JTextField getTfClasi() {
            return tfClasi;
        }

        @Override
        public JTextArea getTaConsulta() {
            return taConsulta;
        }

        @Override
        public JScrollPane getjScroll() {
            return jScroll;
        }

        @Override
        public JPanel getpJornada() {
            return pJornada;
        }

        @Override
        public JPanel getpClasificacion() {
            return pClasificacion;
        }
    }
}
