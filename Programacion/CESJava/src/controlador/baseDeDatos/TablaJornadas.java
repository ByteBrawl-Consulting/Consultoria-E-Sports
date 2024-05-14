package controlador.baseDeDatos;

import modelo.Competicion;
import modelo.Enfrentamiento;
import modelo.Equipo;
import modelo.Jornada;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TablaJornadas {
    private Connection con;

    public TablaJornadas(Connection con) {
        this.con = con;
    }
    public Enfrentamiento ultimaJornada(Competicion com) {
        Enfrentamiento enfre = null;
        ArrayList lista = new ArrayList();
        try {
            String nomCompe = com.getNombre();
            String plantilla = "SELECT e.cod_jornada, e.hora, e.fecha, e.resultado, e.cod_equipo_local, e.cod_equipo_visitante FROM competiciones c JOIN jornadas j ON j.cod_compe = c.cod_compe JOIN enfrentamientos e ON e.cod_jornada = j.cod_jornadas WHERE j.num_jornada = (SELECT MAX(j.num_jornada) FROM jornadas j JOIN competiciones c ON j.cod_compe = c.cod_compe WHERE c.nombre = ?) AND c.nombre = ?";
            PreparedStatement pre = con.prepareStatement(plantilla);
            pre.setString(1, nomCompe);
            pre.setString(2, nomCompe);
            ResultSet respuesta = pre.executeQuery();
            if (respuesta.next()) {
                enfre = new Enfrentamiento();
                    Jornada jor = new Jornada();
                    jor.setCodJornada(respuesta.getInt("e.cod_jornada"));
                enfre.setCodJornada(jor);
                enfre.setHora(respuesta.getString("e.hora"));
                enfre.setFecha(respuesta.getDate("e.fecha").toLocalDate());
                enfre.setResultado(respuesta.getString(" e.resultado"));
                    Equipo eq = new Equipo();
                    eq.setCodEquipo(respuesta.getInt("e.cod_equipo_local"));
                enfre.setCodEquipoLocal(eq);
                    eq.setCodEquipo(respuesta.getInt("e.cod_equipo_visitante"));
                enfre.setCodEquipoVisitante(eq);
                lista.add(enfre);
            }

            return enfre;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
