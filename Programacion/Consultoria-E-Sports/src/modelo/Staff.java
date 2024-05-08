package modelo;

public class Staff {
    private int codStaff;
    private String nombre;
    private String cargo;
    private double sueldo;
    private int codEquipo;

    public Staff(int codStaff, String nombre, String cargo, double sueldo, int codEquipo) {
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

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(int codEquipo) {
        this.codEquipo = codEquipo;
    }
}
