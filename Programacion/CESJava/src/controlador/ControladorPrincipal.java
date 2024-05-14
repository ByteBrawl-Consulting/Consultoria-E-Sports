package controlador;

import controlador.baseDeDatos.ControladorBaseDeDatos;
import modelo.*;

import java.sql.SQLException;
import java.util.ArrayList;

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

    public Enfrentamiento ultimaJornada(Competicion com) {
        return cbd.ultimaJornada(com);
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

    public void modiStaff(Staff staff) {
        cbd.modiStaff(staff);
    }

    public String consultaStaff(String nombreSt) {
        return cbd.consultaStaff(nombreSt).toString();
    }
}
