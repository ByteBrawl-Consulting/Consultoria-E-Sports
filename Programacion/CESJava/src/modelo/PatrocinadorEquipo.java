package modelo;

/**
 * Representa la relación entre un patrocinador y un equipo.
 */

public class PatrocinadorEquipo {
    private int codPatrEqui;
    private Patrocinador codPatrocinadores;
    private Equipo codEquipo;

    /**
     * Constructor para crear una instancia de PatrocinadorEquipo con todos los atributos.
     *
     * @param codPatrEqui       el código de la relación patrocinador-equipo
     * @param codPatrocinadores el patrocinador asociado
     * @param codEquipo         el equipo asociado
     */

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
