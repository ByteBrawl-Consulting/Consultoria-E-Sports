package controlador;

import view.VentanaEquipos;
import view.VentanaPrincipalAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVentanaPrincipalAdmin {
    private VentanaPrincipalAdmin vpa;
    private VentanaEquipos ve;

    public ControladorVentanaPrincipalAdmin() {
        vpa = new VentanaPrincipalAdmin();
        vpa.addBEquipos(new addBEquipo());
    }
    public class addBEquipo implements ActionListener {
        public void actionPerformed(ActionEvent e){
            ve.setVisible(true);
        }
    }
}
