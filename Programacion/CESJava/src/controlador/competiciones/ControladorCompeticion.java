package controlador.competiciones;

import controlador.ControladorVista;
import modelo.Competicion;
import modelo.Juego;
import view.VentanaCompeticiones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ControladorCompeticion {
    private VentanaCompeticiones vc;
    private ControladorVista cv;

    public ControladorCompeticion(ControladorVista cv) {
        vc = new VentanaCompeticiones();
        mostrar();
        vc.bAceptarAl(new bAceptar());
        vc.bSalirAL(new bSalir());
        vc.bRbAltaAL(new bAlta());
        vc.bRbBajaAL(new bBaja());
        vc.bRbModiAl(new bModi());
        vc.bRbConsultaAL(new bConsulta());
        this.cv = cv;
    }

    private void mostrar() {
        vc.setVisible(true);
    }

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vc.dispose();
        }
    }
    private class bAlta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vc.eleccionAlta();
        }
    }

    private class bBaja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vc.eleccionBaja();
        }
    }

    private class bModi implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vc.eleccionModi();
        }
    }

    private class bConsulta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vc.eleccionConsulta();
        }
    }

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Competicion compe = new Competicion();
            if (vc.getRbAlta().isSelected()){
                try {
                    String nombre = vc.getTfNombreAlta().getText();
                    String fecha1 = vc.getTfFechaIniAlta().getText();
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date fechaJava1 = null;
                    fechaJava1 = formato.parse(fecha1);
                    java.sql.Date fechaSql1 = new java.sql.Date(fechaJava1.getTime());
                    String fecha2 = vc.getTfFechaFinAlta().getText();
                    java.util.Date fechaJava2 = null;
                    fechaJava2 = formato.parse(fecha2);
                    java.sql.Date fechaSql2 = new java.sql.Date(fechaJava2.getTime());
                    compe.setNombre(nombre);
                    compe.setFechaInicio(fechaSql1.toLocalDate());
                    compe.setFechaFin(fechaSql2.toLocalDate());
                    compe.setCodJuego(cv.buscarJuego(nombre));
                    cv.altaCompeticion(compe);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }else if (vc.getRbBaja().isSelected()){
                try{
                    String nombre = vc.getTfNombreBaja().getText();
                    compe.setNombre(nombre);
                    cv.bajaCompeticion(compe);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }else if (vc.getRbModi().isSelected()){
                try {
                    String nombre = vc.getTfNombreModi().getText();
                    String fecha1 = vc.getTfFechaIniModi().getText();
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date fechaJava1 = null;
                    fechaJava1 = formato.parse(fecha1);
                    java.sql.Date fechaSql1 = new java.sql.Date(fechaJava1.getTime());
                    String fecha2 = vc.getTfFechaFinModi().getText();
                    java.util.Date fechaJava2 = null;
                    fechaJava2 = formato.parse(fecha2);
                    java.sql.Date fechaSql2 = new java.sql.Date(fechaJava2.getTime());
                    compe.setNombre(nombre);
                    compe.setFechaInicio(fechaSql1.toLocalDate());
                    compe.setFechaFin(fechaSql2.toLocalDate());
                    compe.setCodJuego(cv.buscarJuego(nombre));
                    cv.modiCompeticion(compe);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }else if (vc.getRbCons().isSelected()){
                try {
                    String nombre = vc.getTfNombreCons().getText();
                    compe.setNombre(nombre);
                    vc.getTaCons().setText(cv.consultaCompeticion(nombre));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
