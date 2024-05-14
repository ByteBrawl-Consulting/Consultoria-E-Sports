package controlador.usuario;

import controlador.ControladorVista;
import controlador.login.ControladorLogin;
import modelo.Competicion;
import modelo.Enfrentamiento;
import modelo.Jornada;
import view.VentanaPrincipalUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
                total.append(lista.get(x).getCodJornada()).append("\n").append(lista.get(x).getHora()).append("\n").append(lista.get(x).getFecha()).append("\n").append(lista.get(x).getResultado()).append("\n").append(lista.get(x).getCodEquipoLocal()).append("\n").append(lista.get(x).getCodEquipoVisitante()).append("\n -------------------");
            }
            vpu.getTaJornada().setText(String.valueOf(total));
        }
    }
    public class bAceptarClasi implements ActionListener{
        public void actionPerformed(ActionEvent e){

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

