package Modelo;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Enfrentamientos {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_ENFRENTAMIENTO")
    private short codEnfrentamiento;
    @Basic
    @Column(name = "FECHA")
    private Date fecha;
    @Basic
    @Column(name = "COD_JORNADA")
    private short codJornada;
    @Basic
    @Column(name = "HORA")
    private String hora;
    @Basic
    @Column(name = "RESULTADO")
    private String resultado;
    @Basic
    @Column(name = "COD_EQUIPO_LOCAL")
    private short codEquipoLocal;
    @Basic
    @Column(name = "COD_EQUIPO_VISITANTE")
    private short codEquipoVisitante;
    @ManyToOne
    @JoinColumn(name = "COD_JORNADA", referencedColumnName = "COD_JORNADAS", nullable = false)
    private Jornadas jornadasByCodJornada;

    public short getCodEnfrentamiento() {
        return codEnfrentamiento;
    }

    public void setCodEnfrentamiento(short codEnfrentamiento) {
        this.codEnfrentamiento = codEnfrentamiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public short getCodJornada() {
        return codJornada;
    }

    public void setCodJornada(short codJornada) {
        this.codJornada = codJornada;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public short getCodEquipoLocal() {
        return codEquipoLocal;
    }

    public void setCodEquipoLocal(short codEquipoLocal) {
        this.codEquipoLocal = codEquipoLocal;
    }

    public short getCodEquipoVisitante() {
        return codEquipoVisitante;
    }

    public void setCodEquipoVisitante(short codEquipoVisitante) {
        this.codEquipoVisitante = codEquipoVisitante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enfrentamientos that = (Enfrentamientos) o;

        if (codEnfrentamiento != that.codEnfrentamiento) return false;
        if (codJornada != that.codJornada) return false;
        if (codEquipoLocal != that.codEquipoLocal) return false;
        if (codEquipoVisitante != that.codEquipoVisitante) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (hora != null ? !hora.equals(that.hora) : that.hora != null) return false;
        if (resultado != null ? !resultado.equals(that.resultado) : that.resultado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) codEnfrentamiento;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (int) codJornada;
        result = 31 * result + (hora != null ? hora.hashCode() : 0);
        result = 31 * result + (resultado != null ? resultado.hashCode() : 0);
        result = 31 * result + (int) codEquipoLocal;
        result = 31 * result + (int) codEquipoVisitante;
        return result;
    }

    public Jornadas getJornadasByCodJornada() {
        return jornadasByCodJornada;
    }

    public void setJornadasByCodJornada(Jornadas jornadasByCodJornada) {
        this.jornadasByCodJornada = jornadasByCodJornada;
    }
}
