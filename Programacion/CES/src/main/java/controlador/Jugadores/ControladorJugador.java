package controlador.Jugadores;

import controlador.ControladorPrincipal;
import controlador.ControladorVista;
import modelo.Jugadores;
import view.VentanaAltaJugadores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ControladorJugador {
    private ControladorVista cv;
    private VentanaAltaJugadores vaj;
    public ControladorJugador(ControladorVista cv) {
        this.cv = cv;
        mostrar();
        vaj.bAceptarAL(new bAceptar());
        vaj.bSalirAL(new bSalir());
    }
    public void mostrar(){
        vaj = new VentanaAltaJugadores();
        vaj.setVisible(true);
    }

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Pasar los TF a variables
            String nombre = vaj.getTfNombre().getText();
            String nacionalidad = vaj.getTfNacionalidad().getText();
            //Formateo de fecha
            try {
                String fecha = vaj.getTfFecha().getText();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date fechaJava = null;
                fechaJava = formato.parse(fecha);
                java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            String nickname = vaj.getTfNick().getText();
            String rol = vaj.getTfRol().getText();
            Integer sueldo = Integer.parseInt(vaj.getTfSueldo().getText());
            String equipo = vaj.getTfEquipo().getText();
            if (equipo.equals("")){
                //No tiene equipo
                equipo = null;
            }
            //Comprobamos que todos los campos esten llenos
        }
    }
}
