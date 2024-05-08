package controlador.BaseDeDatos;

import controlador.ControladorPrincipal;
import modelo.Usuarios;

public class ControladorBaseDeDatos {
    private ControladorPrincipal cp;
    private TablaUsuarios tu;
    public void login (Usuarios usu){
        tu.login(usu);
    }
}
