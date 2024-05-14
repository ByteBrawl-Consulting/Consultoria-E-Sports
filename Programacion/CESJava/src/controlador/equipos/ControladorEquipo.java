package controlador.equipos;

import controlador.ControladorVista;
import modelo.Equipo;
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
        ve.bRbAltaAL(new bAlta());
        ve.bRbBajaAL(new bBaja());
        ve.bRbModiAl(new bModi());
        ve.bRbConsultaAL(new bConsulta());
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
            Equipo eq = new Equipo();
            if(ve.getRbAlta().isSelected()){
                try {
                    String nombre = ve.getTfNombreAlta().getText();
                    String fecha = ve.getTfFechaAlta().getText();
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date fechaJava = null;
                    fechaJava = formato.parse(fecha);
                    java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
                    eq.setNombre(nombre);
                    eq.setFechaFundacion(fechaSql.toLocalDate());
                    cv.altaEquipo(eq);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }else if (ve.getRbBaja().isSelected()){
                try{
                    String nombre = ve.getTfNombreBaja().getText();
                    eq.setNombre(nombre);
                    cv.bajaEquipo(eq);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
            else if (ve.getRbModificacion().isSelected()){
                try {
                    String nombre = ve.getTfNombreModi().getText();
                    String fecha = ve.getTfFechaModi().getText();
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date fechaJava = null;
                    fechaJava = formato.parse(fecha);
                    java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
                    eq.setNombre(nombre);
                    eq.setFechaFundacion(fechaSql.toLocalDate());
                    cv.modiEquipo(eq);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }else if (ve.getRbConsulta().isSelected()){
                try {
                    String nombre = ve.getTfNombreCons().getText();
                    eq.setNombre(nombre);
                    ve.getTaConsulta().setText(cv.consultaEquipo(nombre));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    private class bAlta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ve.eleccionAlta();
        }
    }

    private class bBaja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ve.eleccionBaja();
        }
    }

    private class bModi implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ve.eleccionModi();
        }
    }

    private class bConsulta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ve.eleccionConsulta();
        }
    }
}
