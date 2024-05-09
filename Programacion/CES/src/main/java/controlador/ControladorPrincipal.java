package controlador;

import controlador.BaseDeDatos.ControladorBaseDeDatos;
import modelo.Usuarios;

public class ControladorPrincipal {
    private ControladorVista cv;
    private ControladorBaseDeDatos cbd;

    public ControladorPrincipal() {
        cv=new ControladorVista(this);
        cbd=new ControladorBaseDeDatos(this);
    }
    public String login (Usuarios usu){
        System.out.println("cp");
     return cbd.login(usu);
    }

}
