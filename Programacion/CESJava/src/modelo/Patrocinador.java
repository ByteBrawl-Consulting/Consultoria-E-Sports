package modelo;

/**
 * Representa un patrocinador.
 */

public class Patrocinador {
    private int codPatrocinadores;
    private String nombre;

    /**
     * Constructor para crear una instancia de Patrocinador con todos los atributos.
     *
     * @param codPatrocinadores el código del patrocinador
     * @param nombre            el nombre del patrocinador
     */

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
