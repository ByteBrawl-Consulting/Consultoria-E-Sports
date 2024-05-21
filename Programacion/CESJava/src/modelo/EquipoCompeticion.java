package modelo;

/**
 * La clase EquipoCompeticion representa la participación de un equipo en una competición, incluyendo su código, equipo, competición y puntos.
 */

public class EquipoCompeticion {
    private int codEquipoCompe;
    private Equipo codEquipo;
    private Competicion codCompe;
    private int puntos;

    public EquipoCompeticion() {
    }

    /**
     * Constructor con parámetros para inicializar una relación entre un equipo y una competición.
     *
     * @param codEquipoCompe El código de la relación equipo-competición.
     * @param codEquipo      El equipo participante.
     * @param codCompe       La competición en la que participa el equipo.
     * @param puntos         Los puntos del equipo en la competición.
     */

    public EquipoCompeticion(int codEquipoCompe, Equipo codEquipo, Competicion codCompe, int puntos) {
        this.codEquipoCompe = codEquipoCompe;
        this.codEquipo = codEquipo;
        this.codCompe = codCompe;
        this.puntos = puntos;
    }

    public int getCodEquipoCompe() {
        return codEquipoCompe;
    }

    public void setCodEquipoCompe(int codEquipoCompe) {
        this.codEquipoCompe = codEquipoCompe;
    }

    public Equipo getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(Equipo codEquipo) {
        this.codEquipo = codEquipo;
    }

    public Competicion getCodCompe() {
        return codCompe;
    }

    public void setCodCompe(Competicion codCompe) {
        this.codCompe = codCompe;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
