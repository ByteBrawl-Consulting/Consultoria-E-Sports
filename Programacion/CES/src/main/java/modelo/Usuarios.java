package modelo;

import jakarta.persistence.*;

@Entity
public class Usuarios {
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_USUARIO")
    private byte codUsuario;
    @Basic
    @Column(name = "TIPO")
    private String tipo;
    @Basic
    @Column(name = "CONTRASEÑA")
    private String contraseña;

    public byte getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(byte codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuarios usuarios = (Usuarios) o;

        if (codUsuario != usuarios.codUsuario) return false;
        if (tipo != null ? !tipo.equals(usuarios.tipo) : usuarios.tipo != null) return false;
        if (contraseña != null ? !contraseña.equals(usuarios.contraseña) : usuarios.contraseña != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) codUsuario;
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (contraseña != null ? contraseña.hashCode() : 0);
        return result;
    }
}
