package modelo;

import java.sql.Date;

public class Enfrentamientos {
    private int codEnfrentamiento;
    private java.sql.Date fecha;
    private int codJornada;
    private String hora;
    private String resultado;
    private int codEquipoLocal;
    private int codEquipoVisitante;

    public Enfrentamientos(int codEnfrentamiento, Date fecha, int codJornada, String hora, String resultado, int codEquipoLocal, int codEquipoVisitante) {
        this.codEnfrentamiento = codEnfrentamiento;
        this.fecha = fecha;
        this.codJornada = codJornada;
        this.hora = hora;
        this.resultado = resultado;
        this.codEquipoLocal = codEquipoLocal;
        this.codEquipoVisitante = codEquipoVisitante;
    }

    public Enfrentamientos() {
    }

    public int getCodEnfrentamiento() {
        return codEnfrentamiento;
    }

    public void setCodEnfrentamiento(int codEnfrentamiento) {
        this.codEnfrentamiento = codEnfrentamiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCodJornada() {
        return codJornada;
    }

    public void setCodJornada(int codJornada) {
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

    public int getCodEquipoLocal() {
        return codEquipoLocal;
    }

    public void setCodEquipoLocal(int codEquipoLocal) {
        this.codEquipoLocal = codEquipoLocal;
    }

    public int getCodEquipoVisitante() {
        return codEquipoVisitante;
    }

    public void setCodEquipoVisitante(int codEquipoVisitante) {
        this.codEquipoVisitante = codEquipoVisitante;
    }
}
