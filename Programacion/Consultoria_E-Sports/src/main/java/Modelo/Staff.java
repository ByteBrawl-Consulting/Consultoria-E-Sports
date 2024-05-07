package Modelo;

import jakarta.persistence.*;

@Entity
public class Staff {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_STAFF")
    private short codStaff;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "CARGO")
    private String cargo;
    @Basic
    @Column(name = "SUELDO")
    private double sueldo;
    @Basic
    @Column(name = "COD_EQUIPO")
    private Short codEquipo;
    @ManyToOne
    @JoinColumn(name = "COD_EQUIPO", referencedColumnName = "COD_EQUIPO")
    private Equipos equiposByCodEquipo;

    public short getCodStaff() {
        return codStaff;
    }

    public void setCodStaff(short codStaff) {
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

    public Short getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(Short codEquipo) {
        this.codEquipo = codEquipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (codStaff != staff.codStaff) return false;
        if (Double.compare(staff.sueldo, sueldo) != 0) return false;
        if (nombre != null ? !nombre.equals(staff.nombre) : staff.nombre != null) return false;
        if (cargo != null ? !cargo.equals(staff.cargo) : staff.cargo != null) return false;
        if (codEquipo != null ? !codEquipo.equals(staff.codEquipo) : staff.codEquipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) codStaff;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (cargo != null ? cargo.hashCode() : 0);
        temp = Double.doubleToLongBits(sueldo);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (codEquipo != null ? codEquipo.hashCode() : 0);
        return result;
    }

    public Equipos getEquiposByCodEquipo() {
        return equiposByCodEquipo;
    }

    public void setEquiposByCodEquipo(Equipos equiposByCodEquipo) {
        this.equiposByCodEquipo = equiposByCodEquipo;
    }
}
