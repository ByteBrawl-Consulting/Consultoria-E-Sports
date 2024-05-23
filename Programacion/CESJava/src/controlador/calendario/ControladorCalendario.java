package controlador.calendario;

import controlador.ControladorVista;
import modelo.Competicion;
import view.VentanaGenerarCalendario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * El ControladorCalendario gestiona la generación de calendarios para competiciones.
 */

public class ControladorCalendario {
    protected VentanaGenerarCalendario vc;
    private ControladorVista cv;

    /**
     * Constructor de la clase ControladorCalendario.
     *
     * @param cv El ControladorVista asociado.
     */

    public ControladorCalendario(ControladorVista cv) {
        this.cv = cv;
        vc = new VentanaGenerarCalendario();
        vc.bAceptarAL(new bAceptar());
        vc.bSalirAL(new bSalir());
        vc.setVisible(true);
        llenarCB();
    }

    /**
     * Llena el ComboBox de la ventana con las competiciones disponibles.
     */

    public void llenarCB() {
        try {
            ArrayList<Competicion> lista = cv.clasiEquipos();
            vc.getCbCalendario().addItem("Seleccione una competición");
            for (int x = 0; x < lista.size(); x++) {
                vc.getCbCalendario().addItem(lista.get(x).getNombre());
            }
        } catch (Exception ex) {
        }
    }

    /**
     * Clase interna para manejar el evento de salir.
     */

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vc.dispose();
        }
    }


    /**
     * Clase interna para manejar el evento de aceptar.
     */

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = vc.getCbCalendario().getSelectedItem().toString();
            int codCompeticion = cv.getCodigoCompeticionPorNombre(nombre);
            cv.generarCalendario(codCompeticion);
        }
    }
}
