package controlador;

import controlador.baseDeDatos.ControladorBaseDeDatos;
import modelo.Competicion;
import modelo.Equipo;
import modelo.Staff;
import modelo.Usuario;

import java.sql.SQLException;

public class ControladorPrincipal {
    private ControladorVista cv;
    private ControladorBaseDeDatos cbd;

    public ControladorPrincipal() {
        cv = new ControladorVista(this);
        cbd=new ControladorBaseDeDatos(this);

    }

    public String login (Usuario usu) throws SQLException {
        return cbd.login(usu);
    }

    public void altaEquipo(Equipo eq) {
        cbd.altaEquipo(eq);
    }

    public void bajaEquipo(Equipo eq) {
        cbd.bajaEquipo(eq);
    }

    public void modiEquipo(Equipo eq) {
        cbd.modiEquipo(eq);
    }

    public String consultaEquipo(String nombreEq) {
        return cbd.consultaEquipo(nombreEq).toString();
    }

    public void ultimaJornada(Competicion com) {
        cbd.ultimaJornada(com);
    }

    public Equipo buscarEquipo(String nombreEq) {
        return cbd.buscarEquipo(nombreEq);
    }

    public void altaStaff(Staff staff) {
        cbd.altaStaff(staff);
    }

    public void bajaStaff(Staff staff) {
        cbd.bajaStaff(staff);
    }
}
