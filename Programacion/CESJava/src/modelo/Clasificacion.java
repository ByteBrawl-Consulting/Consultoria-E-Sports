package modelo;

/**
 * La clase Clasificacion representa la clasificación de un equipo en una competición.
 */

public class Clasificacion {
    private Equipo codequipo;
    private EquipoCompeticion puntos;
    private Competicion codcompe;

    /**
     * Constructor con parámetros para inicializar una clasificación.
     *
     * @param codequipo El equipo asociado a la clasificación.
     * @param puntos    Los puntos del equipo en la competición.
     * @param codcompe  La competición a la que pertenece la clasificación.
     */

    public Clasificacion(Equipo codequipo, EquipoCompeticion puntos, Competicion codcompe) {
        this.codequipo = codequipo;
        this.puntos = puntos;
        this.codcompe = codcompe;
    }

    public Clasificacion() {
    }

    public Equipo getCodequipo() {
        return codequipo;
    }

    public void setCodequipo(Equipo codequipo) {
        this.codequipo = codequipo;
    }

    public EquipoCompeticion getPuntos() {
        return puntos;
    }

    public void setPuntos(EquipoCompeticion puntos) {
        this.puntos = puntos;
    }

    public Competicion getCodcompe() {
        return codcompe;
    }

    public void setCodcompe(Competicion codcompe) {
        this.codcompe = codcompe;
    }
}

