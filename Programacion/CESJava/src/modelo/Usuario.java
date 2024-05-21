package modelo;

/**
 * Representa un usuario del sistema.
 */

public class Usuario {
    private int codUsuario;
    private String tipo;
    private String contrasena;

    /**
     * Constructor para crear una instancia de Usuario con todos los atributos.
     *
     * @param codUsuario  el código del usuario
     * @param tipo        el tipo de usuario (por ejemplo, "admin" o "usuario")
     * @param contrasena  la contraseña del usuario
     */

    public Usuario(int codUsuario, String tipo, String contrasena) {
        this.codUsuario = codUsuario;
        this.tipo = tipo;
        this.contrasena = contrasena;
    }

    public Usuario() {
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
