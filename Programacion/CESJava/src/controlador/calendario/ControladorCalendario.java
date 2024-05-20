package controlador.calendario;

import controlador.ControladorVista;
import modelo.Competicion;
import view.VentanaGenerarCalendario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorCalendario {
    private VentanaGenerarCalendario vc;
    private ControladorVista cv;

    public ControladorCalendario(ControladorVista cv) {
        this.cv = cv;
        vc = new VentanaGenerarCalendario();
        vc.bAceptarAL(new bAceptar());
        vc.bSalirAL(new bSalir());
        vc.setVisible(true);
        llenarCB();
    }
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

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vc.dispose();
        }
    }

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Competicion compe = new Competicion();
            compe.setNombre(vc.getCbCalendario().getSelectedItem().toString());
        }
    }
}
