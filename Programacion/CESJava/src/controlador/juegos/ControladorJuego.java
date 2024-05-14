package controlador.juegos;

import controlador.ControladorVista;
import controlador.equipos.ControladorEquipo;
import view.VentanaJuegos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorJuego {
    private VentanaJuegos vj;
    private ControladorVista cv;

    public ControladorJuego(ControladorVista cv) {
        vj = new VentanaJuegos();
        mostar();
        vj.bAceptarAl(new bAceptar());
        vj.bSalirAL(new bSalir());
        vj.bRbAltaAL(new bAlta());
        vj.bRbBajaAL(new bBaja());
        vj.bRbModiAl(new bModi());
        vj.bRbConsultaAL(new bConsulta());
        this.cv = cv;
    }
    private void mostar() {
        vj.setVisible(true);
    }
    private class bAlta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.eleccionAlta();
        }
    }

    private class bBaja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.eleccionBaja();
        }
    }

    private class bModi implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.eleccionModi();
        }
    }

    private class bConsulta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.eleccionConsulta();
        }
    }
}
