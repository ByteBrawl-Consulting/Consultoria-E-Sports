package controlador;

import controlador.baseDeDatos.ControladorBaseDeDatos;
import modelo.Usuarios;

public class ControladorPrincipal {
    private ControladorVista cv;
    private ControladorBaseDeDatos cbd;

    public ControladorPrincipal() {
        cv=new ControladorVista(this);
        cbd=new ControladorBaseDeDatos();
    }
    public void login (Usuarios usu){
    cbd.login(usu);
    }

}
