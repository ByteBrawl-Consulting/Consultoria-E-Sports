package controlador.baseDeDatos;

import modelo.Competiciones;

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

    public ArrayList ultimaJornada(Competiciones com) {
        ArrayList arra = new ArrayList<>();
        try {
        String nomCompe = com.getNombre();
        String plantilla = "SELECT e.cod_jornada, e.hora, e.fecha, e.resultado, e.cod_equipo_local, e.cod_equipo_visitante FROM competiciones c JOIN jornadas j ON j.cod_compe = c.cod_compe JOIN enfrentamientos e ON e.cod_jornada = j.cod_jornadas WHERE j.num_jornada = (SELECT MAX(j.num_jornada) FROM jornadas j JOIN competiciones c ON j.cod_compe = c.cod_compe WHERE c.nombre = ?) AND c.nombre = ?";
        PreparedStatement pre = con.prepareStatement(plantilla);
        pre.setString(1, nomCompe);
        pre.setString(2, nomCompe);
        ResultSet respuesta = pre.executeQuery();
        if (respuesta.next()){
            arra.add(respuesta);

        }

        return arra;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
