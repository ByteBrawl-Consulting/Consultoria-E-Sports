package Modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "JUEGOS_COMPE", schema = "EQDAW04", catalog = "")
public class JuegosCompe {
    @Basic
    @Column(name = "COD_JUEGO")
    private short codJuego;
    @Basic
    @Column(name = "juego")
    private String juego;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "FECHA_INICIO")
    private Date fechaInicio;
    @Basic
    @Column(name = "FECHA_FIN")
    private Date fechaFin;

    public short getCodJuego() {
        return codJuego;
    }

    public void setCodJuego(short codJuego) {
        this.codJuego = codJuego;
    }

    public String getJuego() {
        return juego;
    }

    public void setJuego(String juego) {
        this.juego = juego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JuegosCompe that = (JuegosCompe) o;

        if (codJuego != that.codJuego) return false;
        if (juego != null ? !juego.equals(that.juego) : that.juego != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;
        if (fechaFin != null ? !fechaFin.equals(that.fechaFin) : that.fechaFin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) codJuego;
        result = 31 * result + (juego != null ? juego.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (fechaFin != null ? fechaFin.hashCode() : 0);
        return result;
    }
}
