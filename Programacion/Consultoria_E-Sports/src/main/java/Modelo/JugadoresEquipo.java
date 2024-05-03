package Modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "JUGADORES_EQUIPO", schema = "EQDAW04", catalog = "")
public class JugadoresEquipo {
    @Basic
    @Column(name = "NOMBRE_JUGADOR")
    private String nombreJugador;
    @Basic
    @Column(name = "NACIONALIDAD")
    private String nacionalidad;
    @Basic
    @Column(name = "ROL")
    private String rol;
    @Basic
    @Column(name = "SUELDO")
    private int sueldo;
    @Basic
    @Column(name = "Equipo")
    private String equipo;

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JugadoresEquipo that = (JugadoresEquipo) o;

        if (sueldo != that.sueldo) return false;
        if (nombreJugador != null ? !nombreJugador.equals(that.nombreJugador) : that.nombreJugador != null)
            return false;
        if (nacionalidad != null ? !nacionalidad.equals(that.nacionalidad) : that.nacionalidad != null) return false;
        if (rol != null ? !rol.equals(that.rol) : that.rol != null) return false;
        if (equipo != null ? !equipo.equals(that.equipo) : that.equipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nombreJugador != null ? nombreJugador.hashCode() : 0;
        result = 31 * result + (nacionalidad != null ? nacionalidad.hashCode() : 0);
        result = 31 * result + (rol != null ? rol.hashCode() : 0);
        result = 31 * result + sueldo;
        result = 31 * result + (equipo != null ? equipo.hashCode() : 0);
        return result;
    }
}
