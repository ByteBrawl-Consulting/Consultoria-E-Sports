package modelo;

public class PatrocinadoresEquipo {
    private int codPatrEqui;
    private Patrocinadores codPatrocinadores;
    private Equipos codEquipo;

    public PatrocinadoresEquipo(int codPatrEqui, Patrocinadores codPatrocinadores, Equipos codEquipo) {
        this.codPatrEqui = codPatrEqui;
        this.codPatrocinadores = codPatrocinadores;
        this.codEquipo = codEquipo;
    }

    public int getCodPatrEqui() {
        return codPatrEqui;
    }

    public void setCodPatrEqui(int codPatrEqui) {
        this.codPatrEqui = codPatrEqui;
    }

    public Patrocinadores getCodPatrocinadores() {
        return codPatrocinadores;
    }

    public void setCodPatrocinadores(Patrocinadores codPatrocinadores) {
        this.codPatrocinadores = codPatrocinadores;
    }

    public Equipos getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(Equipos codEquipo) {
        this.codEquipo = codEquipo;
    }
}
