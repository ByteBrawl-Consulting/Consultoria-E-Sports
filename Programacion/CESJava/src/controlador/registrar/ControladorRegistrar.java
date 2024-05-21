package controlador.registrar;

import controlador.ControladorVista;
import modelo.Usuario;
import view.VentanaRegistrarusu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ControladorRegistrar es el controlador que gestiona la interacción entre la vista de registro de usuarios
 * (VentanaRegistrarusu) y el modelo de negocio a través del ControladorVista.
 */

public class ControladorRegistrar {
    private VentanaRegistrarusu vru;
    private ControladorVista cv;

    /**
     * Constructor de ControladorRegistrar.
     *
     * @param cv El controlador principal de la vista.
     */

    public ControladorRegistrar(ControladorVista cv) {
        this.cv = cv;

        vru = new VentanaRegistrarusu();

        vru.setVisible(true);
        vru.bAceptarAL(new bAceptar());
        vru.bSalirAL(new bSalir());
    }


    /**
     * Clase interna que maneja el evento de clic en el botón "Aceptar".
     * Realiza la operación de registro de un nuevo usuario validando su nombre de usuario y contraseña.
     */

    public class bAceptar implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Usuario usu = new Usuario();
                usu.setTipo(vru.getTfUsu().getText());
                usu.setContrasena(vru.getTfPass().getText());
                Pattern pat = Pattern.compile("^[0-9]*$");
                Matcher mach = pat.matcher(usu.getContrasena());
                if (!mach.matches())
                    throw new Exception("Error en el formato de la contraseña 'Solo pueden ser numeros'");
                Pattern pat1 = Pattern.compile("^[a-z\sA-Z]*$");
                Matcher mach1 = pat1.matcher(usu.getTipo());
                if (!mach1.matches()) throw new Exception("El nombre de usuario solo puede contener letras");
                cv.altaUsu(usu);
                vru.getTfUsu().setText("");
                vru.getTfPass().setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    /**
     * Clase interna que maneja el evento de clic en el botón "Salir".
     * Limpia los campos de texto y cierra la ventana de registro de usuarios.
     */

    public class bSalir implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            vru.getTfUsu().setText("");
            vru.getTfPass().setText("");
            vru.dispose();
        }
    }
}

