package controlador.admin;

import controlador.ControladorVista;
import view.VentanaEquipos;
import view.VentanaPrincipalAdmin;

public class ControladorAdmin {
    private VentanaPrincipalAdmin vpa;
    private VentanaEquipos ve;
    private ControladorVista cv;

    public ControladorAdmin(ControladorVista cv) {
        mostrar();
        this.cv=cv;
    }
    public void mostrar(){
        vpa = new VentanaPrincipalAdmin();
        vpa.setVisible(true);
    }

}
