package modelo;

public class Patrocinadores {
    private int codPatrocinadores;
    private String nombre;

    public Patrocinadores(int codPatrocinadores, String nombre) {
        this.codPatrocinadores = codPatrocinadores;
        this.nombre = nombre;
    }

    public Patrocinadores() {
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
