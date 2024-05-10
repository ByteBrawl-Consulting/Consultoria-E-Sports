package controlador.equipos;

import controlador.ControladorVista;
import modelo.Equipos;
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
            Equipos eq = new Equipos();
            if(ve.getRbAlta().isSelected()){
                //Ocultar paneles
                ve.eleccionAlta();
                try {
                    String nombre = ve.getTfNombreAlta().getText();
                    String fecha = ve.getTfFechaAlta().getText();
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date fechaJava = null;
                    fechaJava = formato.parse(fecha);
                    java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
                    eq.setNombre(nombre);
                    eq.setFechaFundacion(fechaSql);
                    cv.altaEquipo(eq);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }else if (ve.getRbBaja().isSelected()){
                //Ocultar paneles
                ve.eleccionBaja();
                try{
                    String nombre = ve.getTfNombreBaja().getText();
                    eq.setNombre(nombre);
                    cv.bajaEquipo(eq);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
            else if (ve.getRbModificacion().isSelected()){
                //Ocultar paneles
                ve.eleccionModi();
                try {
                    String nombre = ve.getTfNombreModi().getText();
                    String fecha = ve.getTfFechaModi().getText();
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date fechaJava = null;
                    fechaJava = formato.parse(fecha);
                    java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
                    eq.setNombre(nombre);
                    eq.setFechaFundacion(fechaSql);
                    cv.modiEquipo(eq);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }else if (ve.getRbConsulta().isSelected()){
                //Ocultar paneles
                ve.eleccionConsulta();
                String nombre = ve.getTfNombreCons().getText();
                eq.setNombre(nombre);
                ve.setTaConsulta(cv.consultaEquipo(eq));
            }
        }
    }
}
