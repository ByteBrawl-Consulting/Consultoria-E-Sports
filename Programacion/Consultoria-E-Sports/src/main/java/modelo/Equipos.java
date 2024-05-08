package modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Equipos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_EQUIPO")
    private short codEquipo;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "FECHA_FUNDACION")
    private Date fechaFundacion;
    @OneToMany(mappedBy = "equiposByCodEquipo")
    private Collection<Jugadores> jugadoresByCodEquipo;
    @OneToMany(mappedBy = "equiposByCodEquipo")
    private Collection<Staff> staffByCodEquipo;

    public short getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(short codEquipo) {
        this.codEquipo = codEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(Date fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipos equipos = (Equipos) o;

        if (codEquipo != equipos.codEquipo) return false;
        if (nombre != null ? !nombre.equals(equipos.nombre) : equipos.nombre != null) return false;
        if (fechaFundacion != null ? !fechaFundacion.equals(equipos.fechaFundacion) : equipos.fechaFundacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) codEquipo;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (fechaFundacion != null ? fechaFundacion.hashCode() : 0);
        return result;
    }

    public Collection<Jugadores> getJugadoresByCodEquipo() {
        return jugadoresByCodEquipo;
    }

    public void setJugadoresByCodEquipo(Collection<Jugadores> jugadoresByCodEquipo) {
        this.jugadoresByCodEquipo = jugadoresByCodEquipo;
    }

    public Collection<Staff> getStaffByCodEquipo() {
        return staffByCodEquipo;
    }

    public void setStaffByCodEquipo(Collection<Staff> staffByCodEquipo) {
        this.staffByCodEquipo = staffByCodEquipo;
    }
}
