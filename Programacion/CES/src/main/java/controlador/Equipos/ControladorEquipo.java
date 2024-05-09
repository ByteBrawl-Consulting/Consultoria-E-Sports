package controlador.equipos;

import controlador.ControladorVista;
import view.VentanaEquipos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ControladorEquipo {
    private VentanaEquipos ve;
    private ControladorVista cv;
    public ControladorEquipo(ControladorVista cv) {
        ve = new VentanaEquipos();
        ve.elegirCRUD();
        ve.bAceptarAl(new bAceptar());
        ve.bSalirAL(new bSalir());
        this.cv = cv;
    }

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ve.dispose();
        }
    }

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(ve.getRbAlta().isSelected()){
                try {
                    String nombre = ve.getTfNombreAlta().getText();
                    String fecha = ve.getTfFechaAlta().getText();
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date fechaJava = null;
                    fechaJava = formato.parse(fecha);
                    java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
                    Equipos eq = new Equipos();
                    eq.setNombre(nombre);
                    eq.setFechaFundacion(fechaSql);
                    cv.altaEquipo(eq);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
