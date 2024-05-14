package controlador.jugadores;

import controlador.ControladorVista;
import modelo.Jugador;
import view.VentanaJugadores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ControladorJugador {
    private VentanaJugadores vj;
    private ControladorVista cv;

    public ControladorJugador(ControladorVista cv) {
        vj = new VentanaJugadores();
        mostrar();
        vj.bAceptarAL(new bAceptar());
        vj.bSalirAL(new bSalir());
        vj.bRbAltaAL(new bAlta());
        vj.bRbBajaAL(new bBaja());
        vj.bRbModiAl(new bModi());
        vj.bRbConsultaAL(new bCons());
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
            Jugador ju = new Jugador();
            if (vj.getRbAlta().isSelected()){
                try{
                    String nombre = vj.getTfNombreAlta().getText();
                    String nacionalidad = vj.getTfNacionalidadAlta().getText();
                    String fecha = vj.getTfFechaAlta().getText();
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date fechaJava = null;
                    fechaJava = formato.parse(fecha);
                    java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
                    String nick = vj.getTfNickAlta().getText();
                    String rol = vj.getTfRolAlta().getText();
                    Integer sueldo = Integer.parseInt(vj.getTfSueldoAlta().getText());
                    ju.setNombreJugador(nombre);
                    ju.setNacionalidad(nacionalidad);
                    ju.setFechaNacimiento(fechaSql.toLocalDate());
                    ju.setNickname(nick);
                    ju.setRol(rol);
                    ju.setSueldo(sueldo);
                    cv.altaJugador(ju);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }else if (vj.getRbBaja().isSelected()){
                try{
                    String nombre = vj.getTfNombreBaja().getText();
                    ju.setNombreJugador(nombre);
                    cv.bajaJugador(ju);
                }catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }else if (vj.getRbModi().isSelected()){
                try{
                    String nombre = vj.getTfNombreModi().getText();
                    String nacionalidad = vj.getTfNacionalidadModi().getText();
                    String fecha = vj.getTfFechaModi().getText();
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date fechaJava = null;
                    fechaJava = formato.parse(fecha);
                    java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
                    String nick = vj.getTfNickModi().getText();
                    String rol = vj.getTfRolModi().getText();
                    Integer sueldo = Integer.parseInt(vj.getTfSueldoModi().getText());
                    ju.setNombreJugador(nombre);
                    ju.setNacionalidad(nacionalidad);
                    ju.setFechaNacimiento(fechaSql.toLocalDate());
                    ju.setNickname(nick);
                    ju.setRol(rol);
                    ju.setSueldo(sueldo);
                    cv.modiJugador(ju);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }else if (vj.getRbCons().isSelected()){
                try{
                    String nombre = vj.getTfNombreCons().getText();
                    ju.setNombreJugador(nombre);
                    vj.getTaCons().setText(cv.consultaJugador(nombre));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
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

    private class bCons implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vj.eleccionConsulta();
        }
    }
    public void mostrar(){
        vj.setVisible(true);
    }
}
