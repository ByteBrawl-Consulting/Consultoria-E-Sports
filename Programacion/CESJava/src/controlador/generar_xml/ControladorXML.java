package controlador.generar_xml;

import controlador.ControladorVista;
import view.VentanaMostrarXML;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * El ControladorXML gestiona la interacción entre la vista de generar XML y el modelo de datos.
 */

public class ControladorXML {

    private VentanaMostrarXML vxml;
    private ControladorVista cv;

    /**
     * Constructor de la clase ControladorXML.
     *
     * Inicializa la ventana de visualización de XML, establece las propiedades
     * de los componentes de texto y configura los eventos.
     *
     * @param cv El ControladorVista asociado.
     */

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

    /**
     * Muestra la clasificación en el área de texto correspondiente.
     */

    public void mostrarClasificacion() {
        vxml.getTaConsultaClasi().setText(cv.generarXMLClasificacion());
    }

    /**
     * Muestra la última jornada en el área de texto correspondiente.
     */

    public void mostrarJornada() {
        vxml.getTaConsultaJornada().setText(cv.generarXMLJornada());
    }

    /**
     * Muestra todas las jornadas en el área de texto correspondiente.
     */

    public void mostrarTodasJornadas() {
        vxml.getTaConsultaTodasJornadas().setText(cv.generarXMLTodasJornadas());
    }

    /**
     * Clase interna para manejar el evento de salida de la ventana.
     */

    private class bSalir implements ActionListener {

        /**
         * Maneja el evento de clic en el botón de salir, cerrando la ventana.
         *
         * @param e El evento de acción.
         */

        @Override
        public void actionPerformed(ActionEvent e) {
            vxml.dispose();
        }
    }
}
