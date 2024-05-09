package modelo;

import java.sql.Date;

public class Competiciones {
    private int codCompe;
    private String nombre;
    private java.sql.Date fechaInicio;
    private java.sql.Date fechaFin;
    private int curso;
    private int equipoGanador;
    private int codJuego;

    public Competiciones(int codCompe, String nombre, Date fechaInicio, Date fechaFin, int curso, int equipoGanador, int codJuego) {
        this.codCompe = codCompe;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.curso = curso;
        this.equipoGanador = equipoGanador;
        this.codJuego = codJuego;
    }

    public Competiciones() {
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getEquipoGanador() {
        return equipoGanador;
    }

    public void setEquipoGanador(int equipoGanador) {
        this.equipoGanador = equipoGanador;
    }

    public int getCodJuego() {
        return codJuego;
    }

    public void setCodJuego(int codJuego) {
        this.codJuego = codJuego;
    }
}
