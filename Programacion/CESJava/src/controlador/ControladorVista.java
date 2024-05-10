package controlador;

import controlador.login.ControladorLogin;
import modelo.Equipos;
import modelo.Usuarios;
import view.VentanaEquipos;
import view.VentanaPrincipalAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ControladorVista {
    private ControladorPrincipal cp;
    private VentanaEquipos ve;
    private VentanaPrincipalAdmin vpa;
    private ControladorLogin cl;

    public ControladorVista(ControladorPrincipal cp) {
        cl = new ControladorLogin(this);
        this.cp=cp;
        iniciarBotones();
//        cl.mostrar();
    }

    public String login (Usuarios usu) throws SQLException {
        return cp.login(usu);
    }
    public void iniciarBotones(){
        vpa = new VentanaPrincipalAdmin();
        vpa.addMEquipos(new controlEquipos());
    }
    public class controlEquipos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ve = new VentanaEquipos();
        }
    }

    public void altaEquipo(Equipos eq) {
        cp.altaEquipo(eq);
    }

    public void bajaEquipo(Equipos eq) {
        cp.bajaEquipo(eq);
    }

    public void modiEquipo(Equipos eq) {
        cp.modiEquipo(eq);
    }

    public String consultaEquipo(String nombreEq) {
        return cp.consultaEquipo(nombreEq).toString();
    }
}