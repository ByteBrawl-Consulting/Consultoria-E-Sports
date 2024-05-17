package controlador.equipos;

import controlador.ControladorVista;
import modelo.Equipo;
import view.VentanaEquipos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ControladorEquipo {
    private VentanaEquipos ve;
    private ControladorVista cv;
    public ControladorEquipo(ControladorVista cv) {
        ve = new VentanaEquipos();

        mostrar();
        
        ve.bAceptarAl(new bAceptar());
        ve.bSalirAL(new bSalir());
        ve.bRbAltaAL(new bAlta());
        ve.bRbBajaAL(new bBaja());
        ve.bRbModiAl(new bModi());
        ve.bRbConsultaAL(new bConsulta());

        ve.clickRatonNombreAltaAL(new clickRatonNombreAlta());
        ve.clickRatonFechaAltaAL(new clickRatonFechaAlta());
        ve.clickRatonNombreBajaAL(new clickRatonNombreBaja());
        ve.clickRatonNombreModiAL(new clickRatonNombreModi());
        ve.clickRatonFechaModiAL(new clickRatonFechaModi());
        ve.clickRatonNombreConsAL(new clickRatonNombreConsul());

        this.cv = cv;
    }
    public void mostrar(){
        ve.setVisible(true);
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
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
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
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date fechaJava = formato.parse(fecha);
                    java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
                    eq.setNombre(nombre);
                    eq.setFechaFundacion(fechaSql.toLocalDate());
                    cv.modiEquipo(eq, fecha);
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

    public class clickRatonNombreAlta implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            if (ve.getTfNombreAlta().getText().equals("Nombre")) {
                ve.getTfNombreAlta().setText("");
            }
            if (ve.getTfFechaAlta().getText().isEmpty()) {
                ve.getTfFechaAlta().setText("Fecha");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public class clickRatonFechaAlta implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            if (ve.getTfFechaAlta().getText().equals("Fecha")) {
                ve.getTfFechaAlta().setText("");
            }
            if (ve.getTfNombreAlta().getText().isEmpty()) {
                ve.getTfNombreAlta().setText("Nombre");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public class clickRatonNombreBaja implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            if (ve.getTfNombreBaja().getText().equals("Nombre")) {
                ve.getTfNombreBaja().setText("");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public class clickRatonNombreModi implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            if (ve.getTfNombreModi().getText().equals("Nombre")) {
                ve.getTfNombreModi().setText("");
            }
            if (ve.getTfFechaModi().getText().isEmpty()) {
                ve.getTfFechaModi().setText("Fecha");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public class clickRatonFechaModi implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            if (ve.getTfFechaModi().getText().equals("Fecha")) {
                ve.getTfFechaModi().setText("");
            }
            if (ve.getTfNombreModi().getText().isEmpty()) {
                ve.getTfNombreModi().setText("Nombre");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public class clickRatonNombreConsul implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            if (ve.getTfNombreCons().getText().equals("Nombre")) {
                ve.getTfNombreCons().setText("");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
