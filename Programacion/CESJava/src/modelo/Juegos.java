package modelo;

import java.sql.Date;

public class Juegos {
    private int codJuego;
    private String nombre;
    private String desarrolladora;
    private java.sql.Date fechaLanzamiento;

    public Juegos(int codJuego, String nombre, String desarrolladora, Date fechaLanzamiento) {
        this.codJuego = codJuego;
        this.nombre = nombre;
        this.desarrolladora = desarrolladora;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Juegos() {
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

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
}
