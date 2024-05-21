package modelo;

import java.time.LocalDate;

/**
 * La clase Jornada representa una jornada dentro de una competición, incluyendo su código, número de jornada, día y la competición asociada.
 */

public class Jornada {
    private int codJornada;
    private int numJornada;
    private LocalDate dia;
    private Competicion codCompe;

    /**
     * Constructor con parámetros para inicializar una jornada.
     *
     * @param codJornada El código de la jornada.
     * @param numJornada El número de la jornada.
     * @param dia        El día de la jornada.
     * @param codCompe   La competición asociada a la jornada.
     */

    public Jornada(int codJornada, int numJornada, LocalDate dia, Competicion codCompe) {
        this.codJornada = codJornada;
        this.numJornada = numJornada;
        this.dia = dia;
        this.codCompe = codCompe;
    }

    public Jornada() {
    }

    public int getCodJornada() {
        return codJornada;
    }

    public void setCodJornada(int codJornada) {
        this.codJornada = codJornada;
    }

    public int getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(int numJornada) {
        this.numJornada = numJornada;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public Competicion getCodCompe() {
        return codCompe;
    }

    public void setCodCompe(Competicion codCompe) {
        this.codCompe = codCompe;
    }


}
