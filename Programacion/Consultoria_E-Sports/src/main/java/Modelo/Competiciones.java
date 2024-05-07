package Modelo;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Competiciones {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_COMPE")
    private short codCompe;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "FECHA_INICIO")
    private Date fechaInicio;
    @Basic
    @Column(name = "FECHA_FIN")
    private Date fechaFin;
    @Basic
    @Column(name = "CURSO")
    private boolean curso;
    @Basic
    @Column(name = "EQUIPO_GANADOR")
    private Short equipoGanador;
    @Basic
    @Column(name = "COD_JUEGO")
    private short codJuego;

    public short getCodCompe() {
        return codCompe;
    }

    public void setCodCompe(short codCompe) {
        this.codCompe = codCompe;
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

    public boolean isCurso() {
        return curso;
    }

    public void setCurso(boolean curso) {
        this.curso = curso;
    }

    public Short getEquipoGanador() {
        return equipoGanador;
    }

    public void setEquipoGanador(Short equipoGanador) {
        this.equipoGanador = equipoGanador;
    }

    public short getCodJuego() {
        return codJuego;
    }

    public void setCodJuego(short codJuego) {
        this.codJuego = codJuego;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Competiciones that = (Competiciones) o;

        if (codCompe != that.codCompe) return false;
        if (curso != that.curso) return false;
        if (codJuego != that.codJuego) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;
        if (fechaFin != null ? !fechaFin.equals(that.fechaFin) : that.fechaFin != null) return false;
        if (equipoGanador != null ? !equipoGanador.equals(that.equipoGanador) : that.equipoGanador != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) codCompe;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (fechaFin != null ? fechaFin.hashCode() : 0);
        result = 31 * result + (curso ? 1 : 0);
        result = 31 * result + (equipoGanador != null ? equipoGanador.hashCode() : 0);
        result = 31 * result + (int) codJuego;
        return result;
    }
}
