package controlador.baseDeDatos;

import modelo.Clasificacion;
import modelo.Competicion;
import modelo.Equipo;
import modelo.EquipoCompeticion;

import java.sql.*;
import java.util.ArrayList;

public class TablaClasi {
    private Connection con;

    public TablaClasi(Connection con) {
        this.con = con;
    }

    public ArrayList clasificacion(Competicion com) {

        ArrayList<Clasificacion> lista=new ArrayList<>();
        try {
            String nombreCompe=com.getNombre();
            String plantilla= "select ec.cod_equipo, ec.puntos, ec.cod_competicion from equipo_competicion ec join competiciones c on ec.cod_competicion=c.cod_compe where c.nombre=?";
            PreparedStatement pre = con.prepareStatement(plantilla);
            pre.setString(1, String.valueOf(nombreCompe));
            ResultSet res = pre.executeQuery();
            while (res.next()){
                Competicion comp= new Competicion();
                Equipo eq=new Equipo();
                EquipoCompeticion ec = new EquipoCompeticion();
                Clasificacion cla = new Clasificacion();

                com.setCodCompe(res.getInt(3));
                com.setNombre(nombreCompe);

                eq.setCodEquipo(res.getInt(1));

                ec.setPuntos(res.getInt(3));

                cla=datosCompletosClasi(eq,ec,com);

                lista.add(cla);

            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Clasificacion datosCompletosClasi(Equipo eq, EquipoCompeticion ec, Competicion com) {
        Clasificacion cla =new Clasificacion();
        try {
            int codigoCompe= com.getCodCompe();
            String nombreCompe = com.getNombre();
            String plantilla= "select e.cod_equipo, e.nombre from equipo_competicion ec join competiciones c on ec.cod_competicion=c.cod_compe join equipos e on ec.cod_equipo=e.cod_equipo where c.nombre= ?";
            PreparedStatement pre = con.prepareStatement(plantilla);
            pre.setString(1, String.valueOf(nombreCompe));
            ResultSet res = pre.executeQuery();
            while (res.next()) {
                eq.setCodEquipo(res.getInt(1));
                eq.setNombre(res.getString(2));
            }
            cla.setCodequipo(eq);
            String plantilla1= "select puntos from equipo_competicion where cod_competicion=? ";
            PreparedStatement pre1 = con.prepareStatement(plantilla1);
            pre1.setString(1, String.valueOf(codigoCompe));
            ResultSet res1 = pre1.executeQuery();
            while (res1.next()){
                ec.setPuntos(res1.getInt(1));
            }
            String plantilla2= "select cod_compe, nombre from competiciones where nombre= ? ";
            PreparedStatement pre2 = con.prepareStatement(plantilla2);
            pre2.setString(1, String.valueOf(codigoCompe));
            ResultSet res2 = pre2.executeQuery();
            while (res2.next()){
                com.setCodCompe(res2.getInt(1));
                com.setNombre(res2.getString(2));
            }
            cla.setCodequipo(eq);
            cla.setCodcompe(com);
            cla.setPuntos(ec);


            return cla;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
