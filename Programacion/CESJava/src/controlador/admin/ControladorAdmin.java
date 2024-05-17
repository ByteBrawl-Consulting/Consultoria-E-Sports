package controlador.admin;

import controlador.ControladorVista;
import controlador.competiciones.ControladorCompeticion;
import controlador.equipo_competicion.ControladorEquipoCompeticion;
import controlador.equipos.ControladorEquipo;
import controlador.juegos.ControladorJuego;
import controlador.jugadores.ControladorJugador;
import controlador.patrocinadores.ControladorPatrocinador;
import controlador.registrar.ControladorRegistrar;
import controlador.staff.ControladorStaff;
import view.VentanaEquipos;
import view.VentanaPrincipalAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAdmin {
    private ControladorVista cv;
    private VentanaPrincipalAdmin vpa;
    private ControladorEquipo ce;
    private ControladorJugador cj;
    private ControladorStaff cs;
    private ControladorJuego cje;
    private ControladorPatrocinador cp;
    private ControladorCompeticion cc;
    private ControladorEquipoCompeticion cec;
    private ControladorRegistrar cr;

    public ControladorAdmin(ControladorVista cv) {
        mostrar();
        botones();
        this.cv=cv;
    }
    public void mostrar(){
        vpa = new VentanaPrincipalAdmin();
        vpa.setVisible(true);
    }
    public void botones(){
        vpa.addBSalir(new bSalir());
        vpa.addBEquipos(new bEquipo());
        vpa.addBJugadores(new bJugador());
        vpa.addBStaff(new bStaff());
        vpa.addBJuegos(new bJuegos());
        vpa.addBCompeticiones(new bCompeticiones());
        vpa.addBPatrocinadores(new bPatrocinadores());
        vpa.addBAsociarEquiCompe(new bAsociarEquiCompe());
        vpa.bAltaUSu(new bAltaUsu());
        vpa.cerrarSesion(new cerrarSesion());
    }
    private class cerrarSesion implements ActionListener{
        public void actionPerformed (ActionEvent e){
            vpa.dispose();
        }
    }
    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    public class bEquipo implements ActionListener{
        public void actionPerformed(ActionEvent e){
            ce = new ControladorEquipo(cv);
        }
    }

    private class bJugador implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cj = new ControladorJugador(cv);
        }
    }

    private class bStaff implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cs = new ControladorStaff(cv);
        }
    }

    private class bJuegos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cje = new ControladorJuego(cv);
        }
    }

    private class bCompeticiones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cc = new ControladorCompeticion(cv);
        }
    }

    private class bPatrocinadores implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cp = new ControladorPatrocinador(cv);
        }
    }

    private class bAsociarEquiCompe implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cec = new ControladorEquipoCompeticion(cv);
        }
    }
    private class bAltaUsu implements ActionListener{
        public void actionPerformed (ActionEvent e){
            cr = new ControladorRegistrar(cv);
        }
    }
}
