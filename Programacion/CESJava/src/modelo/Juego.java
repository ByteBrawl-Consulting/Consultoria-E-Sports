package modelo;

import java.sql.Date;
import java.time.LocalDate;


/**
 * La clase Juego representa un videojuego, incluyendo su código, nombre, desarrolladora y fecha de lanzamiento.
 */

public class Juego {
    private int codJuego;
    private String nombre;
    private String desarrolladora;
    private LocalDate fechaLanzamiento;

    /**
     * Constructor con parámetros para inicializar un juego.
     *
     * @param codJuego         El código del juego.
     * @param nombre           El nombre del juego.
     * @param desarrolladora   La desarrolladora del juego.
     * @param fechaLanzamiento La fecha de lanzamiento del juego.
     */

    public Juego(int codJuego, String nombre, String desarrolladora, LocalDate fechaLanzamiento) {
        this.codJuego = codJuego;
        this.nombre = nombre;
        this.desarrolladora = desarrolladora;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Juego() {
    }

    public int getCodJuego() {
        return codJuego;
    }

    public void setCodJuego(int codJuego) {
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

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
}
