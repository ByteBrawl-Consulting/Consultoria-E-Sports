package controlador.baseDeDatos;

import modelo.Clasificacion;
import modelo.Competicion;
import modelo.Equipo;
import modelo.EquipoCompeticion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TablaClasi {
    private Connection con;

    public TablaClasi(Connection con) {
        this.con = con;
    }

    public ArrayList clasificacion(Competicion com) {
        Competicion comp= new Competicion();
        Equipo eq=new Equipo();
        EquipoCompeticion ec = new EquipoCompeticion();
        Clasificacion cla = new Clasificacion();
        ArrayList<Clasificacion> lista=new ArrayList<>();
        try {
            int codCompe=com.getCodCompe();
            String plantilla= "select ec.cod_equipo, ec.puntos, ec.cod_competicion from equipo_competicion ec join competiciones c on ec.cod_competicion=c.cod_compe where c.nombre=?";
            PreparedStatement pre = con.prepareStatement(plantilla);
            pre.setString(1, String.valueOf(codCompe));
            ResultSet res = pre.executeQuery();
            while (res.next()){
                comp.setCodCompe(res.getInt(1));
            cla.setCodcompe(comp);
                eq.setCodEquipo(res.getInt(3));
            cla.setCodequipo(eq);
                ec.setPuntos(res.getInt(2));
            cla.setPuntos(ec);
            lista.add(cla);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
