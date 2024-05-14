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
    public ArrayList ultimaJornada(Competicion com) {
        Enfrentamiento enfre;
        ArrayList lista = new ArrayList<>();
        try {
            String nomCompe = com.getNombre();
            String plantilla = "SELECT e.cod_jornada, e.hora, e.fecha, e.resultado, e.cod_equipo_local, e.cod_equipo_visitante FROM competiciones c JOIN jornadas j ON j.cod_compe = c.cod_compe JOIN enfrentamientos e ON e.cod_jornada = j.cod_jornadas WHERE j.num_jornada = (SELECT MAX(j.num_jornada) FROM jornadas j JOIN competiciones c ON j.cod_compe = c.cod_compe WHERE c.nombre = ?) AND c.nombre = ?";
            PreparedStatement pre = con.prepareStatement(plantilla);
            pre.setString(1, nomCompe);
            pre.setString(2, nomCompe);
            ResultSet respuesta = pre.executeQuery();
            while (respuesta.next()) {
                enfre = new Enfrentamiento();
                    Jornada jor = new Jornada();
                    jor.setCodJornada(respuesta.getInt(1));
//                enfre.setCodJornada(jor.);  He cambiado esto antes habia un error, ponia "enfre.setCodJornada(jor.);" no se si es porque alguno de vosotros iba a poner algo mas, por ahora lo dejo asi con esto comentado para revisar
                enfre.setCodJornada(jor);  // Borrar esta linea si la de arriba esta bien
                enfre.setHora(respuesta.getString(2));
                enfre.setFecha(respuesta.getDate(3).toLocalDate());
                enfre.setResultado(respuesta.getString(4));
                    Equipo eq = new Equipo();
                    eq.setCodEquipo(respuesta.getInt(5));
                enfre.setCodEquipoLocal(eq);
                    eq.setCodEquipo(respuesta.getInt(6));
                enfre.setCodEquipoVisitante(eq);
                lista.add(enfre);

            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
