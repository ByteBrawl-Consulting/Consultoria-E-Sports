package modelo;

import jakarta.persistence.*;

@Entity
public class Patrocinadores {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_PATROCINADORES")
    private short codPatrocinadores;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;

    public short getCodPatrocinadores() {
        return codPatrocinadores;
    }

    public void setCodPatrocinadores(short codPatrocinadores) {
        this.codPatrocinadores = codPatrocinadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patrocinadores that = (Patrocinadores) o;

        if (codPatrocinadores != that.codPatrocinadores) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) codPatrocinadores;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
