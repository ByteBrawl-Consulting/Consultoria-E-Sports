package controlador.staff;

import controlador.ControladorVista;
import modelo.Equipo;
import modelo.Staff;
import view.VentanaStaff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorStaff {
    VentanaStaff vs;
    ControladorVista cv;

    public ControladorStaff(ControladorVista cv) {
        vs = new VentanaStaff();
        vs.bAceptarAL(new bAceptar());
        vs.bSalirAL(new bSalir());
        vs.bRbAltaAL(new bAlta());
        vs.bRbBajaAL(new bBaja());
        vs.bRbModiAl(new bModi());
        vs.bRbConsultaAL(new bConsulta());
        this.cv = cv;
    }

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.dispose();
        }
    }

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Staff staff = new Staff();
            if (vs.getRbAlta().isSelected()){
                String nombre = vs.getTfNombreAlta().getText();
                String cargo = vs.getTfCargoAlta().getText();
                Integer sueldo = Integer.valueOf(vs.getTfSueldoAlta().getText());
                //Buscar equipo
                Equipo eq = cv.buscarEquipo(nombre);
                staff.setNombre(nombre);
                staff.setCargo(cargo);
                staff.setSueldo(sueldo);
                staff.setCodEquipo(eq);
                cv.altaStaff(staff);
            }else if (vs.getRbBaja().isSelected()){
                String nombre = vs.getTfNombreBaja().getText();
                staff.setNombre(nombre);
                cv.bajaStaff(staff);
            }else if (vs.getRbModi().isSelected()){

            }else if (vs.getRbConsulta().isSelected()){

            }
        }
    }

    private class bAlta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.eleccionAlta();
        }
    }

    private class bBaja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.eleccionBaja();
        }
    }

    private class bModi implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.eleccionModi();
        }
    }

    private class bConsulta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.eleccionConsulta();
        }
    }
}
