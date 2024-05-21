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
    }

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vxml.dispose();
        }
    }
}
