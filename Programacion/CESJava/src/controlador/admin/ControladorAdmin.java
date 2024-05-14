package controlador.admin;

import controlador.ControladorVista;
import controlador.equipos.ControladorEquipo;
import controlador.juegos.ControladorJuego;
import controlador.jugadores.ControladorJugador;
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
}
