package controlador;

import controlador.Login.ControladorUsuario;
import modelo.Usuarios;

public class ControladorVista {
    private ControladorPrincipal cp;
    private ControladorUsuario cl;

    public ControladorVista(ControladorPrincipal cp) {
        this.cp=cp;
        cl = new ControladorUsuario(this);

    }
    public void login (Usuarios usu){
        cp.login(usu);
    }
}
