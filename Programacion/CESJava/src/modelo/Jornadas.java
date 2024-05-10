package modelo;

import java.sql.Date;

public class Jornadas {
    private int codJornada;
    private int numJornada;
    private java.sql.Date dia;
    private Competiciones codCompe;

    public Jornadas(int codJornada, int numJornada, Date dia, Competiciones codCompe) {
        this.codJornada = codJornada;
        this.numJornada = numJornada;
        this.dia = dia;
        this.codCompe = codCompe;
    }

    public Jornadas() {
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

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Competiciones getCodCompe() {
        return codCompe;
    }

    public void setCodCompe(Competiciones codCompe) {
        this.codCompe = codCompe;
    }


}
