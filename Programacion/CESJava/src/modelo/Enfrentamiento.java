package modelo;

import java.time.LocalDate;


/**
 * La clase Enfrentamiento representa un enfrentamiento entre dos equipos dentro de una jornada de una competición.
 */

public class Enfrentamiento {
    private int codEnfrentamiento;
    private LocalDate fecha;
    private Jornada codJornada;
    private String hora;
    private String resultado;
    private Equipo codEquipoLocal;
    private Equipo codEquipoVisitante;

    public Enfrentamiento() {
    }

    /**
     * Constructor con parámetros para inicializar un enfrentamiento.
     *
     * @param codEnfrentamiento   El código del enfrentamiento.
     * @param fecha               La fecha del enfrentamiento.
     * @param codJornada          La jornada a la que pertenece el enfrentamiento.
     * @param hora                La hora del enfrentamiento.
     * @param resultado           El resultado del enfrentamiento.
     * @param codEquipoLocal      El equipo local del enfrentamiento.
     * @param codEquipoVisitante  El equipo visitante del enfrentamiento.
     */

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
