package modelo;

public class PatrocinadoresEquipo {
    private int codPatrEqui;
    private int codPatrocinadores;
    private int codEquipo;

    public PatrocinadoresEquipo(int codPatrEqui, int codPatrocinadores, int codEquipo) {
        this.codPatrEqui = codPatrEqui;
        this.codPatrocinadores = codPatrocinadores;
        this.codEquipo = codEquipo;
    }

    public PatrocinadoresEquipo() {
    }

    public int getCodPatrEqui() {
        return codPatrEqui;
    }

    public void setCodPatrEqui(int codPatrEqui) {
        this.codPatrEqui = codPatrEqui;
    }

    public int getCodPatrocinadores() {
        return codPatrocinadores;
    }

    public void setCodPatrocinadores(int codPatrocinadores) {
        this.codPatrocinadores = codPatrocinadores;
    }

    public int getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(int codEquipo) {
        this.codEquipo = codEquipo;
    }
}
