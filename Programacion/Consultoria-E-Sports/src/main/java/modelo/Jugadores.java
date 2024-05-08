package modelo;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Jugadores {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_JUGADOR")
    private short codJugador;
    @Basic
    @Column(name = "NOMBRE_JUGADOR")
    private String nombreJugador;
    @Basic
    @Column(name = "NACIONALIDAD")
    private String nacionalidad;
    @Basic
    @Column(name = "FECHA_NAC")
    private Date fechaNac;
    @Basic
    @Column(name = "NICKNAME")
    private String nickname;
    @Basic
    @Column(name = "ROL")
    private String rol;
    @Basic
    @Column(name = "SUELDO")
    private int sueldo;
    @Basic
    @Column(name = "COD_EQUIPO")
    private Short codEquipo;

    public short getCodJugador() {
        return codJugador;
    }

    public void setCodJugador(short codJugador) {
        this.codJugador = codJugador;
    }

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

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public Short getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(Short codEquipo) {
        this.codEquipo = codEquipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jugadores jugadores = (Jugadores) o;

        if (codJugador != jugadores.codJugador) return false;
        if (sueldo != jugadores.sueldo) return false;
        if (nombreJugador != null ? !nombreJugador.equals(jugadores.nombreJugador) : jugadores.nombreJugador != null)
            return false;
        if (nacionalidad != null ? !nacionalidad.equals(jugadores.nacionalidad) : jugadores.nacionalidad != null)
            return false;
        if (fechaNac != null ? !fechaNac.equals(jugadores.fechaNac) : jugadores.fechaNac != null) return false;
        if (nickname != null ? !nickname.equals(jugadores.nickname) : jugadores.nickname != null) return false;
        if (rol != null ? !rol.equals(jugadores.rol) : jugadores.rol != null) return false;
        if (codEquipo != null ? !codEquipo.equals(jugadores.codEquipo) : jugadores.codEquipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) codJugador;
        result = 31 * result + (nombreJugador != null ? nombreJugador.hashCode() : 0);
        result = 31 * result + (nacionalidad != null ? nacionalidad.hashCode() : 0);
        result = 31 * result + (fechaNac != null ? fechaNac.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (rol != null ? rol.hashCode() : 0);
        result = 31 * result + sueldo;
        result = 31 * result + (codEquipo != null ? codEquipo.hashCode() : 0);
        return result;
    }
}
