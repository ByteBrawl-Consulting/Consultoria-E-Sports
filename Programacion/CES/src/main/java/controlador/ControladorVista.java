package controlador;

import controlador.Jugadores.ControladorJugador;
import controlador.Login.ControladorUsuario;
import modelo.Equipos;
import modelo.Usuarios;

public class ControladorVista {
    private ControladorPrincipal cp;
    private ControladorUsuario cl;
    private ControladorJugador cj;

    public ControladorVista(ControladorPrincipal cp) {
        cl = new ControladorUsuario(this);



        this.cp=cp;
        cl.mostrar();
    }
    public String login (Usuarios usu){
        System.out.println("cv");
        return cp.login(usu);
    }

    public void altaEquipo(Equipos eq) {
        cp.altaEquipo(eq);
    }
}
