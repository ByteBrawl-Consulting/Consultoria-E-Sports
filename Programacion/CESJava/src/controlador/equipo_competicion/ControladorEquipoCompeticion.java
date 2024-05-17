package controlador.equipo_competicion;

import controlador.ControladorVista;
import view.VentanaAsociacionEquipoCompe;

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

        vaec.clickRatonCompeAltaAL(new clickRatonCompeAltaAL());
        vaec.clickRatonEquiAltaAL(new clickRatonEquiAltaAL());
        vaec.clickRatonCompeBajaAL(new clickRatonCompeBajaAL());
        vaec.clickRatonEquiBajaAL(new clickRatonEquiBajaAL());

        vaec.bAceptarAL(new bAceptar());
        vaec.bSalirAL(new bSalir());

        vaec.bRbAltaAL(new bAlta());
        vaec.bRbBajaAL(new bBaja());

        vaec.setVisible(true);
    }

    public class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (vaec.getAltaRadioButton().isSelected()) {
                String nombreEquipo = vaec.getTfEquiAlta().getText();
                String nombreCompeticion = vaec.getTfCompeAlta().getText();

                if (nombreEquipo.isEmpty() || nombreCompeticion.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar nombre de equipo y competición");
                    return;
                }

                try {
                    cv.asociarEquipoCompeticion(nombreEquipo, nombreCompeticion);
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(null, "Error al asociar equipo y competición: " + ex.getMessage());
                }
            } else if (vaec.getBajaRadioButton().isSelected()) {
                //TODO HACER BAJA DE EQUIPO COMPETICION
//                String nombreEquipo = vaec.getTfEquipo().getText();
//                String nombreCompeticion = vaec.getTfCompeticion().getText();
//
//                if (nombreEquipo.isEmpty() || nombreCompeticion.isEmpty()) {
//                    JOptionPane.showMessageDialog(null, "Debe ingresar nombre de equipo y competición");
//                    return;
//                }
//
//                try {
//                    cv.desasociarEquipoCompeticion(nombreEquipo, nombreCompeticion);
//                } catch (RuntimeException ex) {
//                    JOptionPane.showMessageDialog(null, "Error al desasociar equipo y competición: " + ex.getMessage());
//                }
            }
        }
    }

    public class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vaec.dispose();
        }
    }

    private class bAlta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vaec.eleccionAlta();
        }
    }

    private class bBaja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vaec.eleccionBaja();
        }
    }

    public class clickRatonCompeAltaAL implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            if (vaec.getTfCompeAlta().getText().equals("Competición")) {
                vaec.getTfCompeAlta().setText("");
            }
            if (vaec.getTfEquiAlta().getText().isEmpty()) {
                vaec.getTfEquiAlta().setText("Equipo");
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

    public class clickRatonEquiAltaAL implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            if (vaec.getTfEquiAlta().getText().equals("Equipo")) {
                vaec.getTfEquiAlta().setText("");
            }
            if (vaec.getTfCompeAlta().getText().isEmpty()) {
                vaec.getTfCompeAlta().setText("Competición");
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

    public class clickRatonCompeBajaAL implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            if (vaec.getTfCompeBaja().getText().equals("Competición")) {
                vaec.getTfCompeBaja().setText("");
            }
            if (vaec.getTfEquiBaja().getText().isEmpty()) {
                vaec.getTfEquiBaja().setText("Equipo");
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

    public class clickRatonEquiBajaAL implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            if (vaec.getTfEquiBaja().getText().equals("Equipo")) {
                vaec.getTfEquiBaja().setText("");
            }
            if (vaec.getTfCompeBaja().getText().isEmpty()) {
                vaec.getTfCompeBaja().setText("Competicion");
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
}