package controlador.baseDeDatos;

import modelo.Competiciones;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TablaJornadas {
    private Connection con;

    public TablaJornadas(Connection con) {
        this.con = con;
    }

    public void ultimaJornada(Competiciones com) {
        int numCompe = com.getCodCompe();
        String plantilla = "SELECT e.cod_jornada, e.hora, e.fecha, e.resultado, \n" +
                "    e.cod_equipo_local, e.cod_equipo_visitante \n" +
                "FROM \n" +
                "    competiciones c \n" +
                "    JOIN jornadas j ON j.cod_compe = c.cod_compe \n" +
                "    JOIN enfrentamientos e ON e.cod_jornada = j.cod_jornadas \n" +
                "WHERE \n" +
                "    j.num_jornada = (\n" +
                "        SELECT \n" +
                "            MAX(j.num_jornada) \n" +
                "        FROM \n" +
                "            jornadas j \n" +
                "            JOIN competiciones c ON j.cod_compe = c.cod_compe \n" +
                "        WHERE \n" +
                "            c.nombre = ? \n" +
                "    )\n" +
                "    AND c.nombre = ? ;" +
                "";
        PreparedStatement pre = con.preparedStatement(plantilla);
    }
}
