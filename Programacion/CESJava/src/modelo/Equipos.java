package modelo;

import java.sql.Date;

public class Equipos {
    private int codEquipo;
    private String nombre;
    private java.sql.Date fechaFundacion;

    public Equipos(int codEquipo, String nombre, Date fechaFundacion) {
        this.codEquipo = codEquipo;
        this.nombre = nombre;
        this.fechaFundacion = fechaFundacion;
    }

    public Equipos() {
    }

    public int getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(int codEquipo) {
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
}
