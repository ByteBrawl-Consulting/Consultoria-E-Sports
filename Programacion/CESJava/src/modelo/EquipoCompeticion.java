package modelo;

public class EquipoCompeticion {
    private int codEquipoCompe;
    private Equipos codEquipo;
    private Equipos codCompe;
    private int puntos;

    public EquipoCompeticion(int codEquipoCompe, Equipos codEquipo, Equipos codCompe, int puntos) {
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

    public Equipos getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(Equipos codEquipo) {
        this.codEquipo = codEquipo;
    }

    public Equipos getCodCompe() {
        return codCompe;
    }

    public void setCodCompe(Equipos codCompe) {
        this.codCompe = codCompe;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
