package controlador;

import controlador.baseDeDatos.ControladorBaseDeDatos;
import modelo.Equipos;
import modelo.Usuarios;
import view.VentanaLogin;

public class ControladorPrincipal {
    private ControladorVista cv;
    private ControladorBaseDeDatos cbd;
    private VentanaLogin vl;

    public ControladorPrincipal() {
        cv = new ControladorVista(this);
        cbd=new ControladorBaseDeDatos(this);

    }
    public String login (Usuarios usu){
        System.out.println("cp");
        return cbd.login(usu);
    }

    public void altaEquipo(Equipos eq) {
        cbd.altaEquipo(eq);
    }
}
