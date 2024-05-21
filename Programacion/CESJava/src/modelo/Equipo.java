package modelo;

import java.sql.Date;
import java.time.LocalDate;


/**
 * La clase Equipo representa un equipo con su código, nombre y fecha de fundación.
 */

public class Equipo {
    private int codEquipo;
    private String nombre;
    private LocalDate fechaFundacion;

    /**
     * Constructor con parámetros para inicializar un equipo.
     *
     * @param codEquipo      El código del equipo.
     * @param nombre         El nombre del equipo.
     * @param fechaFundacion La fecha de fundación del equipo.
     */

    public Equipo(int codEquipo, String nombre, LocalDate fechaFundacion) {
        this.codEquipo = codEquipo;
        this.nombre = nombre;
        this.fechaFundacion = fechaFundacion;
    }

    public Equipo() {
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

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }
}
