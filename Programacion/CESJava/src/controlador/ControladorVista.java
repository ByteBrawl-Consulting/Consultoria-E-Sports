package controlador;

import controlador.competiciones.ControladorCompeticion;
import controlador.equipos.ControladorEquipo;
import controlador.juegos.ControladorJuego;
import controlador.jugadores.ControladorJugador;
import controlador.login.ControladorLogin;
import controlador.patrocinadores.ControladorPatrocinador;
import modelo.Equipos;
import modelo.Usuarios;
import view.VentanaEquipos;
import view.VentanaPrincipalAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ControladorVista {
    private ControladorPrincipal cp;
    private ControladorLogin cl;
    private VentanaPrincipalAdmin vpa;

    /* ----------- Controladores ----------- */
    private ControladorEquipo ce;
    private ControladorCompeticion cc;
    private ControladorJuego cjueg;
    private ControladorJugador cjuga;
    private ControladorPatrocinador cpat;

//    private VentanaEquipos ve;



    public ControladorVista(ControladorPrincipal cp) {
        cl = new ControladorLogin(this);
        this.cp=cp;
        iniciarBotones();
    }

    public String login (Usuarios usu) throws SQLException {
        System.out.println("cv");
        return cp.login(usu);
    }
    public void iniciarBotones(){
        vpa = new VentanaPrincipalAdmin();
        vpa.addMEquipos(new controlEquipos());
    }

    /* ----------- Botones Menus ------------- */
    public class controlEquipos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            ve = new VentanaEquipos();
            ce = new ControladorEquipo(ControladorVista.this);
        }
    }

    /* ----------- Metodos  ----------- */

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