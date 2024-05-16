package controlador.usuario;

import controlador.ControladorVista;
import controlador.login.ControladorLogin;
import modelo.Clasificacion;
import modelo.Competicion;
import modelo.Enfrentamiento;
import modelo.Jornada;
import view.VentanaPrincipalUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ControladorUsuario {
    private VentanaPrincipalUsuario vpu;
    private ControladorVista cv;

    public ControladorUsuario(ControladorVista cv) {
        mostrar();
        this.cv = cv;
        botones();
    }
    public void mostrar(){
        vpu = new VentanaPrincipalUsuario();
        vpu.setVisible(true);
    }
    public void botones (){
    vpu.getpJornada().setVisible(false);
    vpu.getpClasificacion().setVisible(false);
    vpu.rbClasiAL(new rbUsuClasi());
    vpu.rbJornadaAL(new rbUsuJornada());
    vpu.botonAceprtarJornadaAL(new bAceptarJornada());
    vpu.botonAceptarClasiAL(new bAceptarClasi());
    vpu.bSalirAL(new bSalirUsu());
    vpu.bSesion(new bSesionUsu());
    }
    public class rbUsuJornada implements ActionListener{
        public void actionPerformed (ActionEvent e) {

            if (vpu.getpJornada().isEnabled()) {
                vpu.getpJornada().setVisible(true);
                vpu.getpClasificacion().setVisible(false);
            }
        }
    }
    public class rbUsuClasi implements ActionListener{
        public void actionPerformed (ActionEvent e){
            vpu.getpClasificacion().setVisible(false);
            vpu.getpJornada().setVisible(false);

            if (vpu.getpClasificacion().isEnabled()) {
                vpu.getpJornada().setVisible(false);
                vpu.getpClasificacion().setVisible(true);
            }
        }
    }
    public class bAceptarJornada implements ActionListener {
        public void actionPerformed(ActionEvent e){
            int x=0;
            Competicion com = new Competicion();
            com.setNombre(vpu.getTfJornada().getText());
            Jornada jor = new Jornada();
            jor.setCodCompe(com);
            StringBuilder total = new StringBuilder();
            ArrayList<Enfrentamiento> lista = cv.ultimaJornada(com);
            for(x=0; x<lista.size();x++){
                total.append("Numero de jornada: "+lista.get(x).getCodJornada().getNumJornada()).append("\n").append("Hora: "+lista.get(x).getHora()).append("\n").append("Fecha de el enfrentamiento: "+lista.get(x).getFecha()).append("\n").append("Equipo Ganador: "+lista.get(x).getResultado()).append("\n").append("Equipo local: "+lista.get(x).getCodEquipoLocal().getCodEquipo()).append("\n").append("Equipo visitante: "+lista.get(x).getCodEquipoVisitante().getCodEquipo()).append("\n --------------------------------------  \n");
            }
            vpu.getTaJornada().setText(String.valueOf(total));
        }
    }
    public class bAceptarClasi implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Competicion com = new Competicion();
            StringBuilder resultado = new StringBuilder();
            com.setNombre(vpu.getTfClasi().getText());
            ArrayList<Clasificacion> lista = cv.clasificacion(com);
            for(int x=0;x<lista.size();x++){
                resultado.append("Nombre del equipo: " + lista.get(x).getCodequipo().getNombre()).append("\n").append("Puntos del equipo: " + lista.get(x).getPuntos().getPuntos()).append("\n").append(" ------------------------------ \n");
            }
            vpu.getTaClasi().setText(String.valueOf(resultado));
        }
    }
    public class bSalirUsu implements ActionListener{
        public void actionPerformed (ActionEvent e){
            System.exit(0);
        }
    }
    public class bSesionUsu implements ActionListener{
        public void actionPerformed (ActionEvent e){
            vpu.dispose();
            vpu.getTfJornada().setText("");
            vpu.getTfClasi().setText("");
        }
    }
}

