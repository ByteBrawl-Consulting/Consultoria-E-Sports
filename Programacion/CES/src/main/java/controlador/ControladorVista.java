package controlador;

import controlador.Jugadores.ControladorJugador;
import controlador.Login.ControladorUsuario;
import modelo.Usuarios;

public class ControladorVista {
    private ControladorPrincipal cp;
    private ControladorUsuario cl;
    private ControladorJugador cj;

    public ControladorVista(ControladorPrincipal cp) {
        this.cp=cp;
        cl = new ControladorUsuario(this);
        cj = new ControladorJugador(this);

    }
    public String login (Usuarios usu){
        System.out.println("cv");
       return cp.login(usu);
    }
}
