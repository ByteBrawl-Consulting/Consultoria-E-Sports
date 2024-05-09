package controlador.Jugadores;

import controlador.ControladorPrincipal;
import controlador.ControladorVista;
import modelo.Jugadores;
import view.VentanaAltaJugadores;

import javax.management.StringValueExp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControladorJugador {
    private ControladorVista cv;
    private Connection con;
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
            //Comprobar que los TF esten llenos
            try{
                String nombre = vaj.getTfNombre().getText();
                String nacimiento = vaj.getTfNacionalidad().getText();
                //Formateo fecha
                String fechaVentana = vaj.getTfFecha().getText();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date fechaJava = formato.parse(fechaVentana);
                java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
                //
                String nick = vaj.getTfNick().getText();
                String rol = vaj.getTfRol().getText();
                Integer sueldo = Integer.parseInt(vaj.getTfSueldo().getText());
            }catch (Exception ex){
                vaj.muestra("Alguno de los atributos esta vacío");
            }
        }
    }
}
