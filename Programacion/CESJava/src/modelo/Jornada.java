package modelo;

import java.time.LocalDate;

public class Jornada {
    private int codJornada;
    private int numJornada;
    private LocalDate dia;
    private Competicion codCompe;

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
