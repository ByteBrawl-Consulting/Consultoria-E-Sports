package modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "EQUIPO_COMPETICION", schema = "EQDAW04", catalog = "")
public class EquipoCompeticion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_EQUIPO_COMPE")
    private short codEquipoCompe;
    @Basic
    @Column(name = "COD_EQUIPO")
    private short codEquipo;
    @Basic
    @Column(name = "COD_COMPETICION")
    private short codCompeticion;
    @Basic
    @Column(name = "PUNTOS")
    private byte puntos;
    @ManyToOne
    @JoinColumn(name = "COD_COMPETICION", referencedColumnName = "COD_COMPE", nullable = false)
    private Competiciones competicionesByCodCompeticion;

    public short getCodEquipoCompe() {
        return codEquipoCompe;
    }

    public void setCodEquipoCompe(short codEquipoCompe) {
        this.codEquipoCompe = codEquipoCompe;
    }

    public short getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(short codEquipo) {
        this.codEquipo = codEquipo;
    }

    public short getCodCompeticion() {
        return codCompeticion;
    }

    public void setCodCompeticion(short codCompeticion) {
        this.codCompeticion = codCompeticion;
    }

    public byte getPuntos() {
        return puntos;
    }

    public void setPuntos(byte puntos) {
        this.puntos = puntos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EquipoCompeticion that = (EquipoCompeticion) o;

        if (codEquipoCompe != that.codEquipoCompe) return false;
        if (codEquipo != that.codEquipo) return false;
        if (codCompeticion != that.codCompeticion) return false;
        if (puntos != that.puntos) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) codEquipoCompe;
        result = 31 * result + (int) codEquipo;
        result = 31 * result + (int) codCompeticion;
        result = 31 * result + (int) puntos;
        return result;
    }

    public Competiciones getCompeticionesByCodCompeticion() {
        return competicionesByCodCompeticion;
    }

    public void setCompeticionesByCodCompeticion(Competiciones competicionesByCodCompeticion) {
        this.competicionesByCodCompeticion = competicionesByCodCompeticion;
    }
}
