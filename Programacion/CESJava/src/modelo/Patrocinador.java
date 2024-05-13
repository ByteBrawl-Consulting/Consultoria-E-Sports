package modelo;

public class Patrocinador {
    private int codPatrocinadores;
    private String nombre;

    public Patrocinador(int codPatrocinadores, String nombre) {
        this.codPatrocinadores = codPatrocinadores;
        this.nombre = nombre;
    }

    public Patrocinador() {
    }

    public int getCodPatrocinadores() {
        return codPatrocinadores;
    }

    public void setCodPatrocinadores(int codPatrocinadores) {
        this.codPatrocinadores = codPatrocinadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
