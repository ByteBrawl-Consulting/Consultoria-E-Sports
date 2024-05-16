package controlador.juegos;

import controlador.ControladorVista;
import controlador.equipos.ControladorEquipo;
import modelo.Juego;
import view.VentanaJuegos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ControladorJuego {
    private VentanaJuegos vj;
    private ControladorVista cv;

    public ControladorJuego(ControladorVista cv) {
        vj = new VentanaJuegos();
        mostar();
        vj.bAceptarAl(new bAceptar());
        vj.bSalirAL(new bSalir());
        vj.bRbAltaAL(new bAlta());
        vj.bRbBajaAL(new bBaja());
        vj.bRbModiAl(new bModi());
        vj.bRbConsultaAL(new bConsulta());
        this.cv = cv;
    }
    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.dispose();
        }
    }

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Juego juego = new Juego();
            if (vj.getRbAlta().isSelected()){
                try{
                    String nombre = vj.getTfNombreAlta().getText();
                    String desarrolladora = vj.getTfDesaAlta().getText();
                    String fecha = vj.getTfFechaAlta().getText();
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date fechaJava = null;
                    fechaJava = formato.parse(fecha);
                    java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
                    juego.setNombre(nombre);
                    juego.setDesarrolladora(desarrolladora);
                    juego.setFechaLanzamiento(fechaSql.toLocalDate());
                    cv.altaJuego(juego);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }else if (vj.getRbBaja().isSelected()){
                try{
                    String nombre = vj.getTfNombreBaja().getText();
                    juego.setNombre(nombre);
                    cv.bajaJuego(juego);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }else if (vj.getRbModi().isSelected()){
                try{
                    String nombre = vj.getTfNombreModi().getText();
                    String desarrolladora = vj.getTfDesaModi().getText();
                    String fecha = vj.getTfFechaModi().getText();
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date fechaJava = null;
                    fechaJava = formato.parse(fecha);
                    java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
                    juego.setNombre(nombre);
                    juego.setDesarrolladora(desarrolladora);
                    juego.setFechaLanzamiento(fechaSql.toLocalDate());
                    cv.modiJuego(juego);
                }catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }else if (vj.getRbCons().isSelected()){
                try {
                    String nombre = vj.getTfNombreCons().getText();
                    juego.setNombre(nombre);
                    vj.getTaCons().setText(cv.consultaJuego(nombre));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
    private void mostar() {
        vj.setVisible(true);
    }
    private class bAlta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.eleccionAlta();
        }
    }

    private class bBaja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.eleccionBaja();
        }
    }

    private class bModi implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.eleccionModi();
        }
    }

    private class bConsulta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.eleccionConsulta();
        }
    }
}
