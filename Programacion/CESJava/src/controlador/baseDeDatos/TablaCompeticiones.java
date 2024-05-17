package controlador.baseDeDatos;

import modelo.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TablaCompeticiones {
    Connection con;

    public TablaCompeticiones(Connection con) {
        this.con = con;
    }
    public void altaCompeticion(Competicion compe){
        try{
            String plantilla = "INSERT INTO competiciones (nombre,fecha_inicio,fecha_fin,juego) VALUES (?,?,?,?)";
            PreparedStatement sentencia = con.prepareStatement(plantilla);
            sentencia.setString(1, compe.getNombre());
            String fechaVentana1 = String.valueOf(compe.getFechaInicio());
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fechaJava1 = formato.parse(fechaVentana1);
            java.sql.Date fechaSql1 = new java.sql.Date(fechaJava1.getTime());
            sentencia.setDate(2, fechaSql1);
            String fechaVentana2 = String.valueOf(compe.getFechaFin());
            java.util.Date fechaJava2 = formato.parse(fechaVentana2);
            java.sql.Date fechaSql2 = new java.sql.Date(fechaJava2.getTime());
            sentencia.setDate(3, fechaSql2);
            sentencia.setObject(4, compe.getCodJuego());
            int n = sentencia.executeUpdate();
            if (n != 1){
                mostrar("No se ha insertado ninguna competición");
            }else{
                mostrar("Competición insertada");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void bajaCompeticion(Competicion compe){
        try{
            String plantilla = "DELETE FROM competiciones WHERE nombre = ?";
            PreparedStatement sentencia = con.prepareStatement(plantilla);
            int n = sentencia.executeUpdate();
            sentencia.close();
            if (n == 1){
                mostrar("Competición borrada");
            }else{
                mostrar("Competición no encontrada");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void modiCompeticion(Competicion compe){
        try {
            String plantilla = "UPDATE competiciones SET fecha_inicio = ? AND fecha_fin = ? AND juego = ? WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, compe.getNombre());
            String fechaVentana1 = String.valueOf(compe.getFechaInicio());
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fechaJava1 = formato.parse(fechaVentana1);
            java.sql.Date fechaSql1 = new java.sql.Date(fechaJava1.getTime());
            sentenciaPre.setDate(2, fechaSql1);
            String fechaVentana2 = String.valueOf(compe.getFechaFin());
            java.util.Date fechaJava2 = formato.parse(fechaVentana1);
            java.sql.Date fechaSql2 = new java.sql.Date(fechaJava1.getTime());
            sentenciaPre.setDate(3, fechaSql2);
            sentenciaPre.setObject(4, compe.getCodJuego());
            int n = sentenciaPre.executeUpdate();
            sentenciaPre.close();
            if (n == 1){
                mostrar("Competición actualizada");
            }else{
                mostrar("Competición no encontrada");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Competicion consultaCompeticion(String nombreCompe){
        Competicion compe = null;
        try{
            String plantilla = "SELECT fecha_inicio,fecha_fin,juego FROM competiciones WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nombreCompe);
            ResultSet respuesta = sentenciaPre.executeQuery();
            if (respuesta.next()){
                java.sql.Date fechaInicio = respuesta.getDate("fecha_inicio");
                java.sql.Date fechaFin = respuesta.getDate("fecha_fin");
                Juego juego = (Juego) respuesta.getObject("juego");
                compe = new Competicion();
                compe.setNombre(nombreCompe);
                compe.setFechaInicio(fechaInicio.toLocalDate());
                compe.setFechaFin(fechaFin.toLocalDate());
                compe.setCodJuego(juego);
            }
            return compe;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void mostrar(String m) {
        JOptionPane.showMessageDialog(null, m);
    }

    public int getCodigoCompeticionPorNombre(String nombreCompeticion) {
        try {
            String query = "SELECT cod_compe FROM competiciones WHERE nombre = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, nombreCompeticion);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("cod_compe");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList clasiEquipo() throws Exception{
        ArrayList<Competicion> lista = new ArrayList<>();
        String plantilla = "select nombre from competiciones";
        PreparedStatement pre = con.prepareStatement(plantilla);
        ResultSet res = pre.executeQuery();
        while (res.next()){
            Clasificacion cla = new Clasificacion();
            Competicion c = new Competicion();

            c.setNombre(res.getString(1));
            cla.setCodcompe(c);
            lista.add(c);
        }

        return lista;
    }
    public ArrayList clasificacionAdmin (Competicion com) {
        Clasificacion cla  = new Clasificacion();
        ArrayList<Clasificacion> lista=new ArrayList<>();
        try {
            String nombreCompe = com.getNombre();//solo hay nombre en com
            String plantilla= "select ec.cod_equipo, ec.puntos, ec.cod_competicion from equipo_competicion ec join competiciones c on ec.cod_competicion=c.cod_compe where c.nombre=? order by puntos desc";
            PreparedStatement pre = con.prepareStatement(plantilla);
            pre.setString(1,(nombreCompe));
            ResultSet res = pre.executeQuery();
            while (res.next()){

                EquipoCompeticion ec = new EquipoCompeticion();
                Equipo equi=new Equipo();
                Competicion compe=new Competicion();

                equi.setCodEquipo(res.getInt(1));
                ec.setCodEquipo(equi);
                compe.setCodCompe(res.getInt(3));
                ec.setCodCompe(compe);

                cla=datosCompletosClasi(ec,com);

                lista.add(cla);

            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Clasificacion datosCompletosClasi(EquipoCompeticion ec, Competicion com) {
        Clasificacion cla =new Clasificacion();
        Equipo eq = new Equipo();

        try {
            String nombreCompe = com.getNombre();
            int codigoEquipo = ec.getCodEquipo().getCodEquipo();
            int codigoCompe = ec.getCodCompe().getCodCompe();

            String plantilla= "select e.nombre from equipo_competicion ec join competiciones c on ec.cod_competicion=c.cod_compe join equipos e on ec.cod_equipo=e.cod_equipo where c.nombre= ? and e.cod_equipo=?";
            PreparedStatement pre = con.prepareStatement(plantilla);
            pre.setString(1, String.valueOf(nombreCompe));
            pre.setString(2, String.valueOf(codigoEquipo));
            ResultSet res = pre.executeQuery();

            while (res.next()) {
                eq.setNombre(res.getString("nombre"));

                ec.setCodEquipo(eq);
            }

            String plantilla1= "select puntos from equipo_competicion where cod_competicion=? and cod_equipo=?";
            PreparedStatement pre1 = con.prepareStatement(plantilla1);
            pre1.setString(1, String.valueOf(codigoCompe));
            pre1.setString(2, String.valueOf(codigoEquipo));
            ResultSet res1 = pre1.executeQuery();
            while (res1.next()){
                ec.setPuntos(res1.getInt(1));
            }

            cla.setCodequipo(eq);
            cla.setPuntos(ec);


            return cla;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
