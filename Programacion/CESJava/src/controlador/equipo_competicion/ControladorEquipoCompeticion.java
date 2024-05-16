package controlador.equipo_competicion;

import controlador.ControladorVista;
import controlador.login.ControladorLogin;
import view.VentanaAsociacionEquipoCompe;
import view.VentanaLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorEquipoCompeticion {
    private VentanaAsociacionEquipoCompe vaec;
    private ControladorVista cv;

    public ControladorEquipoCompeticion(ControladorVista cv) {
        this.cv = cv;
        vaec = new VentanaAsociacionEquipoCompe();

        vaec.clickRatonCompeAL(new clickRatonCompe());
        vaec.clickRatonEquiAL(new clickRatonEqui());
        vaec.bAceptarAL(new bAceptar());
        vaec.bSalirAL(new bSalir());

        vaec.setVisible(true);
    }

    public class clickRatonCompe implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            if (vaec.getTfCompeticion().getText().equals("Competición")) {
                vaec.getTfCompeticion().setText("");
            }
            if (vaec.getTfEquipo().getText().isEmpty()) {
                vaec.getTfEquipo().setText("Competición");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public class clickRatonEqui implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            if (vaec.getTfEquipo().getText().equals("Equipo")) {
                vaec.getTfEquipo().setText("");
            }
            if (vaec.getTfCompeticion().getText().isEmpty()) {
                vaec.getTfCompeticion().setText("Equipo");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vaec.dispose();
        }
    }
}