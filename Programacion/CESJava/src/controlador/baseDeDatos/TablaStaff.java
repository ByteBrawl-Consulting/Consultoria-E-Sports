package controlador.baseDeDatos;

import modelo.Equipo;
import modelo.Staff;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class TablaStaff{
    Connection con;
    public TablaStaff(Connection con) {
        this.con = con;
    }
    public void altaStaff (Staff staff){
        try {
            String plantilla = "INSERT INTO staff (nombre,cargo,sueldo,cod_equipo) VALUES (?,?,?,?)";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, staff.getNombre());
            sentenciaPre.setString(2, staff.getCargo());
            sentenciaPre.setInt(3, staff.getSueldo());
            sentenciaPre.setObject(4, staff.getCodEquipo());
            int n =sentenciaPre.executeUpdate();
            if (n != 1){
                mostrar("No se ha insertado ningún Staff");
            }else{
                mostrar("Staff insertado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void bajaStaff(Staff staff){
        try {
            String plantilla = "DELETE FROM staff WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, staff.getNombre());
            int n = sentenciaPre.executeUpdate();
            sentenciaPre.close();
            if (n == 1){
                mostrar("Staff borrado");
            }else{
                mostrar("Staff no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void modiStaff(Staff staff){
        try {
            String plantilla = "UPDATE staff SET cargo = ? AND sueldo = ? AND cod_equipo = ? WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, staff.getCargo());
            sentenciaPre.setInt(2, staff.getSueldo());
            sentenciaPre.setObject(3, staff.getCodEquipo());
            sentenciaPre.setString(4, staff.getNombre());
            int n = sentenciaPre.executeUpdate();
            sentenciaPre.close();
            if (n == 1){
                mostrar("Staff actualizado");
            }else{
                mostrar("Staff no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Staff consultaStaff(String nombreStaff){
        Staff staff = null;
        try {
            String plantilla = "SELECT cargo,sueldo,cod_equipo FROM staff WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nombreStaff);
            ResultSet respuesta = sentenciaPre.executeQuery();
            if (respuesta.next()){
                Integer sueldo = respuesta.getInt("sueldo");
                String cargo = respuesta.getString("cargo");
                Equipo equipos = (Equipo)respuesta.getObject("cod_equipo");
                staff = new Staff();
                staff.setNombre(nombreStaff);
                staff.setCargo(cargo);
                staff.setSueldo(sueldo);
                staff.setCodEquipo(equipos);
            }
            return staff;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void mostrar(String m) {
        JOptionPane.showMessageDialog(null, m);
    }
}
