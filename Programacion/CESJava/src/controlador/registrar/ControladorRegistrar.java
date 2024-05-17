package controlador.registrar;

import controlador.ControladorVista;
import modelo.Usuario;
import view.VentanaRegistrarusu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorRegistrar {
    private VentanaRegistrarusu vru;
    private ControladorVista cv;

    public ControladorRegistrar(ControladorVista cv) {
        this.cv=cv;
        vru=new VentanaRegistrarusu();
        vru.setVisible(true);
        vru.bAceptarAL(new bAceptar());
        vru.bSalirAL(new bSalir());
    }

    public class bAceptar implements ActionListener{
        public void actionPerformed (ActionEvent e){
            try {
                Usuario usu = new Usuario();
                usu.setTipo(vru.getTfUsu().getText());
                usu.setContrasena(vru.getTfPass().getText());
                cv.altaUsu(usu);
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
    public class bSalir implements ActionListener{
        public void actionPerformed (ActionEvent e){
            vru.getTfUsu().setText("");
            vru.getTfPass().setText("");
            vru.dispose();
        }
    }
}

