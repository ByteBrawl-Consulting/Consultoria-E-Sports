package Modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "EQUIPOS_COMPE", schema = "EQDAW04", catalog = "")
public class EquiposCompe {
    @Basic
    @Column(name = "COD_EQUIPO")
    private short codEquipo;
    @Basic
    @Column(name = "NOMBRE_EQUIPO")
    private String nombreEquipo;
    @Basic
    @Column(name = "COD_COMPE")
    private short codCompe;
    @Basic
    @Column(name = "NOMBRE_COMPETICION")
    private String nombreCompeticion;
    @Basic
    @Column(name = "COD_JUEGO")
    private short codJuego;
    @Basic
    @Column(name = "NOMBRE_JUEGO")
    private String nombreJuego;

    public short getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(short codEquipo) {
        this.codEquipo = codEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public short getCodCompe() {
        return codCompe;
    }

    public void setCodCompe(short codCompe) {
        this.codCompe = codCompe;
    }

    public String getNombreCompeticion() {
        return nombreCompeticion;
    }

    public void setNombreCompeticion(String nombreCompeticion) {
        this.nombreCompeticion = nombreCompeticion;
    }

    public short getCodJuego() {
        return codJuego;
    }

    public void setCodJuego(short codJuego) {
        this.codJuego = codJuego;
    }

    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquiposCompe that = (EquiposCompe) o;

        if (codEquipo != that.codEquipo) return false;
        if (codCompe != that.codCompe) return false;
        if (codJuego != that.codJuego) return false;
        if (nombreEquipo != null ? !nombreEquipo.equals(that.nombreEquipo) : that.nombreEquipo != null) return false;
        if (nombreCompeticion != null ? !nombreCompeticion.equals(that.nombreCompeticion) : that.nombreCompeticion != null)
            return false;
        if (nombreJuego != null ? !nombreJuego.equals(that.nombreJuego) : that.nombreJuego != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) codEquipo;
        result = 31 * result + (nombreEquipo != null ? nombreEquipo.hashCode() : 0);
        result = 31 * result + (int) codCompe;
        result = 31 * result + (nombreCompeticion != null ? nombreCompeticion.hashCode() : 0);
        result = 31 * result + (int) codJuego;
        result = 31 * result + (nombreJuego != null ? nombreJuego.hashCode() : 0);
        return result;
    }
}
