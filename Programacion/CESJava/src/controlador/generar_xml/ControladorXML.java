package controlador.generar_xml;

import controlador.ControladorVista;
import view.VentanaMostrarXML;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorXML {

    private VentanaMostrarXML vxml;
    private ControladorVista cv;

    public ControladorXML(ControladorVista cv) {
        this.cv = cv;
        vxml = new VentanaMostrarXML();

        vxml.setVisible(true);

        vxml.getTaConsultaClasi().setEditable(false);
        vxml.getTaConsultaClasi().setBackground(new Color(205, 205, 205));
        vxml.getTaConsultaJornada().setEditable(false);
        vxml.getTaConsultaJornada().setBackground(new Color(205, 205, 205));
        vxml.getTaConsultaTodasJornadas().setEditable(false);
        vxml.getTaConsultaTodasJornadas().setBackground(new Color(205, 205, 205));

        vxml.addBSalir(new bSalir());

        mostrarClasificacion();
        mostrarJornada();
        mostrarTodasJornadas();
    }

    public void mostrarClasificacion() {
        vxml.getTaConsultaClasi().setText(cv.generarXMLClasificacion());
    }

    public void mostrarJornada() {
        vxml.getTaConsultaJornada().setText(cv.generarXMLJornada());
    }

    public void mostrarTodasJornadas() {
        vxml.getTaConsultaTodasJornadas().setText(cv.generarXMLTodasJornadas());
    }

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vxml.dispose();
        }
    }
}
