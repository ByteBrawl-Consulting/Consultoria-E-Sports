package controlador;

import controlador.baseDeDatos.ControladorBaseDeDatos;
import modelo.Competiciones;
import modelo.Equipos;
import modelo.Usuarios;
import view.VentanaLogin;

import java.sql.SQLException;

public class ControladorPrincipal {
    private ControladorVista cv;
    private ControladorBaseDeDatos cbd;

    public ControladorPrincipal() {
        cv = new ControladorVista(this);
        cbd=new ControladorBaseDeDatos(this);

    }

    public String login (Usuarios usu) throws SQLException {
        return cbd.login(usu);
    }

    public void altaEquipo(Equipos eq) {
        cbd.altaEquipo(eq);
    }

    public void bajaEquipo(Equipos eq) {
        cbd.bajaEquipo(eq);
    }

    public void modiEquipo(Equipos eq) {
        cbd.modiEquipo(eq);
    }

    public String consultaEquipo(String nombreEq) {
        return cbd.consultaEquipo(nombreEq).toString();
    }

    public void ultimaJornada(Competiciones com) {
        cbd.ultimaJornada(com);
    }
}
