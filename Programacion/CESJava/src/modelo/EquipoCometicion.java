package modelo;

public class EquipoCometicion {
    private int codEquipoCompe;
    private int codEquipo;
    private int codCompe;
    private int puntos;

    public EquipoCometicion(int codEquipoCompe, int codEquipo, int codCompe, int puntos) {
        this.codEquipoCompe = codEquipoCompe;
        this.codEquipo = codEquipo;
        this.codCompe = codCompe;
        this.puntos = puntos;
    }

    public EquipoCometicion() {
    }

    public int getCodEquipoCompe() {
        return codEquipoCompe;
    }

    public void setCodEquipoCompe(int codEquipoCompe) {
        this.codEquipoCompe = codEquipoCompe;
    }

    public int getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(int codEquipo) {
        this.codEquipo = codEquipo;
    }

    public int getCodCompe() {
        return codCompe;
    }

    public void setCodCompe(int codCompe) {
        this.codCompe = codCompe;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
