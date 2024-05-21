package controlador.baseDeDatos;

import modelo.Competicion;
import modelo.Enfrentamiento;
import modelo.Equipo;
import modelo.Jornada;
import oracle.jdbc.proxy.annotation.Pre;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TablaEnfrentamientos {

    private Connection con;
    private TablaEquipos tablaEquipos;
    private TablaEquipoCompeticion tablaEquipoCompeticion;

    public TablaEnfrentamientos(Connection con, TablaEquipos TablaEquipos,TablaEquipoCompeticion tablaEquipoCompeticion) {
        this.con = con;
        this.tablaEquipos = TablaEquipos;
        this.tablaEquipoCompeticion=tablaEquipoCompeticion;
    }

    public ArrayList<Enfrentamiento> obtenerEnfrentamientosPorCompeticionYJornada(Competicion com, int numJornada) {
        Enfrentamiento enfre;
        ArrayList<Enfrentamiento> lista = new ArrayList<>();
        try {
            String nomCompe = com.getNombre();
            String plantilla = "SELECT e.cod_enfrentamiento, e.cod_jornada, e.hora, e.fecha, e.resultado, e.cod_equipo_local, e.cod_equipo_visitante " +
                    "FROM competiciones c " +
                    "JOIN jornadas j ON j.cod_compe = c.cod_compe " +
                    "JOIN enfrentamientos e ON e.cod_jornada = j.cod_jornadas " +
                    "WHERE c.nombre = ? AND j.num_jornada = ?";
            PreparedStatement pre = con.prepareStatement(plantilla);
            pre.setString(1, nomCompe);
            pre.setInt(2, numJornada);
            ResultSet respuesta = pre.executeQuery();
            while (respuesta.next()) {
                enfre = new Enfrentamiento();
                enfre.setCodEnfrentamiento(respuesta.getInt(1));
                Jornada jor = new Jornada();
                jor.setNumJornada(respuesta.getInt(2));
                enfre.setCodJornada(jor);
                enfre.setHora(respuesta.getString(3));
                enfre.setFecha(respuesta.getDate(4).toLocalDate());
                enfre.setResultado(respuesta.getString(5));

                // Obtener nombres de los equipos
                Equipo eqLocal = tablaEquipos.getNombreEquipoPorCodigo(respuesta.getInt(6));
                enfre.setCodEquipoLocal(eqLocal);
                Equipo eqVisitante = tablaEquipos.getNombreEquipoPorCodigo(respuesta.getInt(7));
                enfre.setCodEquipoVisitante(eqVisitante);

                lista.add(enfre);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertarResultadoEnfrentamiento(String codEnfrentamiento, String equipoGanador) {
        try {
            String equipoGanadorActual = obtenerEquipoGanadorEnfrentamiento(codEnfrentamiento);
            if (!equipoGanador.equals(equipoGanadorActual)) {
                String query = "UPDATE enfrentamientos " +
                        "SET resultado = ? " +
                        "WHERE cod_enfrentamiento = ?";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, equipoGanador);
                preparedStatement.setString(2, codEnfrentamiento);
                preparedStatement.executeUpdate();
                tablaEquipoCompeticion.aumentarPuntos(equipoGanador,codEnfrentamiento);
            } else {
                JOptionPane.showMessageDialog(null, "El equipo seleccionado ya está asignado como ganador del enfrentamiento.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void actualizarResultadoEnfrentamiento(String codEnfrentamiento, String equipoGanador) {
        try {
            String equipoGanadorActual = obtenerEquipoGanadorEnfrentamiento(codEnfrentamiento);
            if (!equipoGanador.equals(equipoGanadorActual)) {
                String query = "UPDATE enfrentamientos " +
                        "SET resultado = ? " +
                        "WHERE cod_enfrentamiento = ?";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, equipoGanador);
                preparedStatement.setString(2, codEnfrentamiento);
                preparedStatement.executeUpdate();
            } else {
                JOptionPane.showMessageDialog(null, "El equipo seleccionado ya está asignado como ganador del enfrentamiento.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public String obtenerEquipoGanadorEnfrentamiento(String codEnfrentamiento) {
        try {
            String query = "SELECT resultado FROM enfrentamientos WHERE cod_enfrentamiento = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, codEnfrentamiento);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("resultado");
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
