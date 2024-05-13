package modelo;

import java.time.LocalDate;

public class Enfrentamiento {
    private int codEnfrentamiento;
    private LocalDate fecha;
    private Jornada codJornada;
    private String hora;
    private String resultado;
    private Equipo codEquipoLocal;
    private Equipo codEquipoVisitante;

    public Enfrentamiento(int codEnfrentamiento, LocalDate fecha, Jornada codJornada, String hora, String resultado, Equipo codEquipoLocal, Equipo codEquipoVisitante) {
        this.codEnfrentamiento = codEnfrentamiento;
        this.fecha = fecha;
        this.codJornada = codJornada;
        this.hora = hora;
        this.resultado = resultado;
        this.codEquipoLocal = codEquipoLocal;
        this.codEquipoVisitante = codEquipoVisitante;
    }

    public int getCodEnfrentamiento() {
        return codEnfrentamiento;
    }

    public void setCodEnfrentamiento(int codEnfrentamiento) {
        this.codEnfrentamiento = codEnfrentamiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Jornada getCodJornada() {
        return codJornada;
    }

    public void setCodJornada(Jornada codJornada) {
        this.codJornada = codJornada;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Equipo getCodEquipoLocal() {
        return codEquipoLocal;
    }

    public void setCodEquipoLocal(Equipo codEquipoLocal) {
        this.codEquipoLocal = codEquipoLocal;
    }

    public Equipo getCodEquipoVisitante() {
        return codEquipoVisitante;
    }

    public void setCodEquipoVisitante(Equipo codEquipoVisitante) {
        this.codEquipoVisitante = codEquipoVisitante;
    }
}
