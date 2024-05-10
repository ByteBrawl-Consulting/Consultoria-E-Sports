package controlador.staff;

import controlador.ControladorVista;
import view.VentanaStaff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorStaff {
    VentanaStaff vs;
    ControladorVista cv;

    public ControladorStaff(ControladorVista cv) {
        vs = new VentanaStaff();
        vs.bAceptarAL(new bAceptar());
        vs.bSalirAL(new bSalir());
        vs.bRbAltaAL(new bAlta());
        vs.bRbBajaAL(new bBaja());
        vs.bRbModiAl(new bModi());
        vs.bRbConsultaAL(new bConsulta());
        this.cv = cv;
    }

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.dispose();
        }
    }

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (vs.getRbAlta().isSelected()){

            }else if (vs.getRbBaja().isSelected()){

            }else if (vs.getRbModi().isSelected()){

            }else if (vs.getRbConsulta().isSelected()){

            }
        }
    }

    private class bAlta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.eleccionAlta();
        }
    }

    private class bBaja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.eleccionBaja();
        }
    }

    private class bModi implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.eleccionModi();
        }
    }

    private class bConsulta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.eleccionConsulta();
        }
    }
}
