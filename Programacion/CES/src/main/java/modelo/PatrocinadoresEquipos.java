package modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "PATROCINADORES_EQUIPOS", schema = "EQDAW04", catalog = "")
public class PatrocinadoresEquipos {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_PATR_EQUI")
    private short codPatrEqui;
    @Basic
    @Column(name = "COD_PATROCINADORES")
    private short codPatrocinadores;
    @Basic
    @Column(name = "COD_EQUIPO")
    private short codEquipo;
    @ManyToOne
    @JoinColumn(name = "COD_PATROCINADORES", referencedColumnName = "COD_PATROCINADORES", nullable = false)
    private modelo.Patrocinadores patrocinadoresByCodPatrocinadores;

    public short getCodPatrEqui() {
        return codPatrEqui;
    }

    public void setCodPatrEqui(short codPatrEqui) {
        this.codPatrEqui = codPatrEqui;
    }

    public short getCodPatrocinadores() {
        return codPatrocinadores;
    }

    public void setCodPatrocinadores(short codPatrocinadores) {
        this.codPatrocinadores = codPatrocinadores;
    }

    public short getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(short codEquipo) {
        this.codEquipo = codEquipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatrocinadoresEquipos that = (PatrocinadoresEquipos) o;

        if (codPatrEqui != that.codPatrEqui) return false;
        if (codPatrocinadores != that.codPatrocinadores) return false;
        if (codEquipo != that.codEquipo) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) codPatrEqui;
        result = 31 * result + (int) codPatrocinadores;
        result = 31 * result + (int) codEquipo;
        return result;
    }

    public Patrocinadores getPatrocinadoresByCodPatrocinadores() {
        return patrocinadoresByCodPatrocinadores;
    }

    public void setPatrocinadoresByCodPatrocinadores(Patrocinadores patrocinadoresByCodPatrocinadores) {
        this.patrocinadoresByCodPatrocinadores = patrocinadoresByCodPatrocinadores;
    }
}
