package modelo;

public class Clasificacion {
    private int codequipo;
    private int puntos;
    private int codcompe;

    public Clasificacion(int codequipo, int puntos, int codcompe) {
        this.codequipo = codequipo;
        this.puntos = puntos;
        this.codcompe = codcompe;
    }

    public Clasificacion() {
    }

    public int getCodequipo() {
        return codequipo;
    }

    public void setCodequipo(int codequipo) {
        this.codequipo = codequipo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getCodcompe() {
        return codcompe;
    }

    public void setCodcompe(int codcompe) {
        this.codcompe = codcompe;
    }
}
