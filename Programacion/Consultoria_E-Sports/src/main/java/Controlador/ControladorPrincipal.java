package Controlador;

import Controlador.BaseDeDatos.ControladorBaseDeDatos;
import Controlador.Login.ControladorLogin;
import Modelo.Usuarios;

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
