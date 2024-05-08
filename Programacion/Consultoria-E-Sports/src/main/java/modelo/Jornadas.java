package modelo;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Jornadas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_JORNADAS")
    private short codJornadas;
    @Basic
    @Column(name = "NUM_JORNADA")
    private byte numJornada;
    @Basic
    @Column(name = "DIA")
    private Date dia;
    @Basic
    @Column(name = "COD_COMPE")
    private short codCompe;

    public short getCodJornadas() {
        return codJornadas;
    }

    public void setCodJornadas(short codJornadas) {
        this.codJornadas = codJornadas;
    }

    public byte getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(byte numJornada) {
        this.numJornada = numJornada;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public short getCodCompe() {
        return codCompe;
    }

    public void setCodCompe(short codCompe) {
        this.codCompe = codCompe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jornadas jornadas = (Jornadas) o;

        if (codJornadas != jornadas.codJornadas) return false;
        if (numJornada != jornadas.numJornada) return false;
        if (codCompe != jornadas.codCompe) return false;
        if (dia != null ? !dia.equals(jornadas.dia) : jornadas.dia != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) codJornadas;
        result = 31 * result + (int) numJornada;
        result = 31 * result + (dia != null ? dia.hashCode() : 0);
        result = 31 * result + (int) codCompe;
        return result;
    }
}
