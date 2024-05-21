package controlador.clasificacion;

import controlador.ControladorPrincipal;
import controlador.ControladorVista;
import modelo.Clasificacion;
import modelo.Competicion;
import view.VentanaClasificacionAdmin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * El ControladorClasificacion gestiona la visualización de la clasificación de una competición en una ventana de administrador.
 */

public class ControladorClasificacion {
    private VentanaClasificacionAdmin vca;
    private ControladorVista cv;

    /**
     * Constructor de la clase ControladorClasificacion.
     *
     * @param cv El ControladorVista asociado.
     */

    public ControladorClasificacion(ControladorVista cv) {
        this.cv = cv;
        vca = new VentanaClasificacionAdmin();
        vca.setVisible(true);
        vca.getTaClasi().setEditable(false);

        llenarCB();
        vca.cbClasiAL(new taClasi());
        vca.addBSalirAL(new bSalir());
    }

    /**
     * Llena el JComboBox con las competiciones disponibles.
     */

    public void llenarCB() {
        try {
            ArrayList<Competicion> lista = cv.clasiEquipos();
            vca.getCbClasi().addItem("Seleccione una competición");
            for (int x = 0; x < lista.size(); x++) {
                vca.getCbClasi().addItem(lista.get(x).getNombre());
            }
        } catch (Exception ex) {
        }
    }

    /**
     * Clase interna para manejar los eventos del JComboBox de competiciones.
     */

    public class taClasi implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Competicion com = new Competicion();
            com.setNombre(vca.getCbClasi().getSelectedItem().toString());
            StringBuilder resultado = new StringBuilder();
            ArrayList<Clasificacion> lista = cv.clasificacionAdmin(com);
            int x1 = 1;
            for (int x = 0; x < lista.size(); x++, x1++) {
                resultado.append("Posicion en la clasificacion es: " + x1 + "º \n").append("Nombre del equipo: " + lista.get(x).getCodequipo().getNombre()).append("\n").append("Puntos del equipo: " + lista.get(x).getPuntos().getPuntos()).append("\n").append(" ---------------------------------------------------- \n");

            }
            vca.getTaClasi().setText(String.valueOf(resultado));
        }
    }

    /**
     * Clase interna para manejar el evento de salir.
     */

    public class bSalir implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            vca.dispose();
        }
    }
}

