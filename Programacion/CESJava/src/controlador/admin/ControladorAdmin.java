package controlador.admin;

import controlador.ControladorVista;
import controlador.equipos.ControladorEquipo;
import view.VentanaEquipos;
import view.VentanaPrincipalAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAdmin {
    private ControladorVista cv;
    private VentanaPrincipalAdmin vpa;
    private ControladorEquipo ce;

    public ControladorAdmin(ControladorVista cv) {
        mostrar();
        botones();
        this.cv=cv;
    }
    public void mostrar(){
        vpa = new VentanaPrincipalAdmin();
        vpa.setVisible(true);
    }
    public void botones(){
        vpa.addBEquipos(new bEquipo());
    }
    public class bEquipo implements ActionListener{
        public void actionPerformed(ActionEvent e){
            ce = new ControladorEquipo(cv);
        }
    }
}
