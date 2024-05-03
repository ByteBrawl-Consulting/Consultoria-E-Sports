package Modelo;

import jakarta.persistence.*;

@Entity
public class Clasificaciones {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_EQUIPO")
    private short codEquipo;
    @Basic
    @Column(name = "PUNTOS")
    private short puntos;
    @Basic
    @Column(name = "COD_COMPE")
    private short codCompe;

    public short getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(short codEquipo) {
        this.codEquipo = codEquipo;
    }

    public short getPuntos() {
        return puntos;
    }

    public void setPuntos(short puntos) {
        this.puntos = puntos;
    }

    public short getCodCompe() {
        return codCompe;
    }

    public void setCodCompe(short codCompe) {
        this.codCompe = codCompe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clasificaciones that = (Clasificaciones) o;

        if (codEquipo != that.codEquipo) return false;
        if (puntos != that.puntos) return false;
        if (codCompe != that.codCompe) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) codEquipo;
        result = 31 * result + (int) puntos;
        result = 31 * result + (int) codCompe;
        return result;
    }
}
