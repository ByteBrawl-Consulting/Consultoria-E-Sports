package modelo;


/**
 * Representa un miembro del staff de un equipo.
 */

public class Staff {
    private int codStaff;
    private String nombre;
    private String cargo;
    private int sueldo;
    private Equipo codEquipo;

    /**
     * Constructor para crear una instancia de Staff con todos los atributos.
     *
     * @param codStaff   el código del miembro del staff
     * @param nombre     el nombre del miembro del staff
     * @param cargo      el cargo del miembro del staff
     * @param sueldo     el sueldo del miembro del staff
     * @param codEquipo  el equipo al que pertenece el miembro del staff
     */

    public Staff(int codStaff, String nombre, String cargo, int sueldo, Equipo codEquipo) {
        this.codStaff = codStaff;
        this.nombre = nombre;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.codEquipo = codEquipo;
    }

    public Staff() {

    }

    public int getCodStaff() {
        return codStaff;
    }

    public void setCodStaff(int codStaff) {
        this.codStaff = codStaff;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public Equipo getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(Equipo codEquipo) {
        this.codEquipo = codEquipo;
    }
}
