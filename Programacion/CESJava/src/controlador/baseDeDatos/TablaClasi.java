package controlador.baseDeDatos;

import modelo.Clasificacion;
import modelo.Competicion;
import modelo.Equipo;
import modelo.EquipoCompeticion;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.CompletionException;

public class TablaClasi {
    private Connection con;

    public TablaClasi(Connection con) {
        this.con = con;
    }

    public ArrayList clasificacion(Competicion com) {
        Clasificacion cla  = new Clasificacion();
        ArrayList<Clasificacion> lista=new ArrayList<>();
        try {
            String nombreCompe=com.getNombre();//solo hay nombre en com
            String plantilla= "select ec.cod_equipo, ec.puntos, ec.cod_competicion from equipo_competicion ec join competiciones c on ec.cod_competicion=c.cod_compe where c.nombre=?";
            PreparedStatement pre = con.prepareStatement(plantilla);
            pre.setString(1, String.valueOf(nombreCompe));
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
        try {
            String nombreCompe = com.getNombre();
            int codigoEquipo = ec.getCodEquipo().getCodEquipo();
            int codigoCompe = ec.getCodCompe().getCodCompe();

            String plantilla= "select e.nombre from equipo_competicion ec join competiciones c on ec.cod_competicion=c.cod_compe join equipos e on ec.cod_equipo=e.cod_equipo where c.nombre= ? and e.cod_equipo=?";
            PreparedStatement pre = con.prepareStatement(plantilla);
            pre.setString(1, String.valueOf(nombreCompe));
            ResultSet res = pre.executeQuery();

            while (res.next()) {
                
            }

            String plantilla1= "select puntos from equipo_competicion where cod_competicion=? and cod_equipo=?";
            PreparedStatement pre1 = con.prepareStatement(plantilla1);
            pre1.setString(1, String.valueOf(codigoCompe));
            pre1.setString(2, String.valueOf(eq.getCodEquipo()));
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
