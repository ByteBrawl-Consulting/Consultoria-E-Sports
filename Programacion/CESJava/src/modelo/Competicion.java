package modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Competicion {
    private int codCompe;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int curso;
    private Equipo equipoGanador;
    private Juego codJuego;

    public Competicion() {
    }

    public Competicion(int codCompe, String nombre, LocalDate fechaInicio, LocalDate fechaFin, int curso, Equipo equipoGanador, Juego codJuego) {
        this.codCompe = codCompe;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.curso = curso;
        this.equipoGanador = equipoGanador;
        this.codJuego = codJuego;
    }

    public int getCodCompe() {
        return codCompe;
    }

    public void setCodCompe(int codCompe) {
        this.codCompe = codCompe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public Equipo getEquipoGanador() {
        return equipoGanador;
    }

    public void setEquipoGanador(Equipo equipoGanador) {
        this.equipoGanador = equipoGanador;
    }

    public Juego getCodJuego() {
        return codJuego;
    }

    public void setCodJuego(Juego codJuego) {
        this.codJuego = codJuego;
    }
}
