package modelo;

public class PatrocinadorEquipo {
    private int codPatrEqui;
    private Patrocinador codPatrocinadores;
    private Equipo codEquipo;

    public PatrocinadorEquipo(int codPatrEqui, Patrocinador codPatrocinadores, Equipo codEquipo) {
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

    public Patrocinador getCodPatrocinadores() {
        return codPatrocinadores;
    }

    public void setCodPatrocinadores(Patrocinador codPatrocinadores) {
        this.codPatrocinadores = codPatrocinadores;
    }

    public Equipo getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(Equipo codEquipo) {
        this.codEquipo = codEquipo;
    }
}
