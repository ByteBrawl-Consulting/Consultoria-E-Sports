package controlador;

import controlador.Login.ControladorUsuario;
import modelo.Usuarios;

public class ControladorVista {
    private ControladorPrincipal cp;
    private ControladorUsuario cl;

    public ControladorVista(ControladorPrincipal cp) {
        cl = new ControladorUsuario(this);


        this.cp=cp;
        cl.mostrar();
    }
    public String login (Usuarios usu){
        System.out.println("cv");
       return cp.login(usu);
    }
}
