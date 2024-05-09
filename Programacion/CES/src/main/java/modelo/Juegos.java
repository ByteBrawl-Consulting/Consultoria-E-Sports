package modelo;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Juegos {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_JUEGO")
    private short codJuego;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "DESARROLLADORA")
    private String desarrolladora;
    @Basic
    @Column(name = "FECHA_LANZAMIENTO")
    private Date fechaLanzamiento;

    public short getCodJuego() {
        return codJuego;
    }

    public void setCodJuego(short codJuego) {
        this.codJuego = codJuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Juegos juegos = (Juegos) o;

        if (codJuego != juegos.codJuego) return false;
        if (nombre != null ? !nombre.equals(juegos.nombre) : juegos.nombre != null) return false;
        if (desarrolladora != null ? !desarrolladora.equals(juegos.desarrolladora) : juegos.desarrolladora != null)
            return false;
        if (fechaLanzamiento != null ? !fechaLanzamiento.equals(juegos.fechaLanzamiento) : juegos.fechaLanzamiento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) codJuego;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (desarrolladora != null ? desarrolladora.hashCode() : 0);
        result = 31 * result + (fechaLanzamiento != null ? fechaLanzamiento.hashCode() : 0);
        return result;
    }
}
