package controlador.baseDeDatos;

import modelo.Jugador;

import java.sql.*;

public class TablaJugadores {
    private Connection con;
    public TablaJugadores(Connection con) {
        this.con = con;
    }
    public void altaJugador(Jugador jugador){
        try{
            String nombreProcedimiento = "GESTION_JUGADORES.AGREGAR_JUGADOR";
            String plantilla = "{call " + nombreProcedimiento + "(?,?,?,?,?,?,?)}";
            CallableStatement sentencia = con.prepareCall(plantilla);
            sentencia.setString(1, jugador.getNombreJugador());
            sentencia.setString(2, jugador.getNacionalidad());
            sentencia.setDate(3, Date.valueOf(jugador.getFechaNacimiento()));
            sentencia.setString(4, jugador.getNickname());
            sentencia.setString(5, jugador.getRol());
            sentencia.setInt(6, jugador.getSueldo());
            sentencia.setObject(7, jugador.getCodEquipo());
            int n = sentencia.executeUpdate();
            if (n != 1){
                throw new Exception("No se ha insertado ningún jugador");
            }else{
                throw new Exception("Jugador insertado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void bajaJugador(Jugador jugador){
        
    }
}
