package controlador.baseDeDatos;

import modelo.Equipo;
import modelo.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class TablaStaff {
    Connection con;
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
                throw new Exception("No se ha insertado ningún Staff");
            }else{
                throw new Exception("Staff insertado");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
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
                throw new Exception("Staff borrado");
            }else{
                throw new Exception("Staff no encontrado");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
            int n = sentenciaPre.executeUpdate();
            sentenciaPre.close();
            if (n == 1){
                throw new Exception("Staff actualizado");
            }else{
                throw new Exception("Staff no encontrado");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
