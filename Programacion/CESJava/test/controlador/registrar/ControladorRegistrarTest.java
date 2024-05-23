package controlador.registrar;

import controlador.ControladorPrincipal;
import controlador.ControladorVista;
import modelo.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.VentanaRegistrarusu;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class ControladorRegistrarTest {

    private ControladorVista controladorVista;
    private VentanaRegistrarusu ventanaRegistrarusu;
    private ControladorRegistrar controladorRegistrar;

    @BeforeEach
    void setUp() {
        controladorVista = new ControladorVista(new ControladorPrincipal());
        ventanaRegistrarusu = new VentanaRegistrarusu();
        controladorRegistrar = new ControladorRegistrar(controladorVista);
        controladorRegistrar.vru = ventanaRegistrarusu;
    }

    @Test
    void testBAceptar_CamposValidos() {
        ventanaRegistrarusu.getTfUsu().setText("usuario");
        ventanaRegistrarusu.getTfPass().setText("1234");

        ControladorRegistrar.bAceptar bAceptar = controladorRegistrar.new bAceptar();
        bAceptar.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        assertEquals("", ventanaRegistrarusu.getTfUsu().getText());
        assertEquals("", ventanaRegistrarusu.getTfPass().getText());
    }

    @Test
    void testBAceptar_CamposInvalidos() {
        ventanaRegistrarusu.getTfUsu().setText("");
        ventanaRegistrarusu.getTfPass().setText("");

        ControladorRegistrar.bAceptar bAceptar = controladorRegistrar.new bAceptar();
        bAceptar.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        assertNotEquals("", ventanaRegistrarusu.getTfUsu().getText());
        assertNotEquals("", ventanaRegistrarusu.getTfPass().getText());
    }

    @Test
    void testBAceptar_ContrasenaNoNumerica() {
        ventanaRegistrarusu.getTfUsu().setText("usuario");
        ventanaRegistrarusu.getTfPass().setText("password");

        ControladorRegistrar.bAceptar bAceptar = controladorRegistrar.new bAceptar();
        bAceptar.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        assertEquals("usuario", ventanaRegistrarusu.getTfUsu().getText());
        assertEquals("password", ventanaRegistrarusu.getTfPass().getText());
    }

    @Test
    void testBAceptar_NombreUsuarioInvalido() {
        ventanaRegistrarusu.getTfUsu().setText("user123");
        ventanaRegistrarusu.getTfPass().setText("1234");

        ControladorRegistrar.bAceptar bAceptar = controladorRegistrar.new bAceptar();
        bAceptar.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        assertEquals("user123", ventanaRegistrarusu.getTfUsu().getText());
        assertEquals("1234", ventanaRegistrarusu.getTfPass().getText());
    }

    @Test
    void testBSalir() {
        ventanaRegistrarusu.getTfUsu().setText("usuario");
        ventanaRegistrarusu.getTfPass().setText("1234");

        ControladorRegistrar.bSalir bSalir = controladorRegistrar.new bSalir();
        bSalir.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        assertEquals("", ventanaRegistrarusu.getTfUsu().getText());
        assertEquals("", ventanaRegistrarusu.getTfPass().getText());
    }
}
