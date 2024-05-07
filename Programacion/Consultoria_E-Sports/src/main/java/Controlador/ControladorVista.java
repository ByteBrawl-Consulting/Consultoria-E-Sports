package Controlador;

import Controlador.Login.ControladorLogin;
import Modelo.Usuarios;

public class ControladorVista {
    private ControladorPrincipal cp;
    private ControladorLogin cl;

    public ControladorVista(ControladorPrincipal cp) {
        this.cp=cp;
        cl = new ControladorLogin(this);

    }
    public void login (Usuarios usu){
        cp.login(usu);
    }
}
