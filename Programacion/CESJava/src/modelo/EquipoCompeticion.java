package modelo;

public class EquipoCompeticion {
    private int codEquipoCompe;
    private Equipo codEquipo;
    private Competicion codCompe;
    private int puntos;

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
