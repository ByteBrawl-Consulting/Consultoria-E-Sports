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
        try{
            String nombreProcedimiento = "GESTION_JUGADORES.ELIMINAR_JUGADOR";
            String plantilla = "{call " + nombreProcedimiento + "(?)}";
            CallableStatement sentencia = con.prepareCall(plantilla);
            sentencia.setString(1, jugador.getNombreJugador());
            int n = sentencia.executeUpdate();
            sentencia.close();
            if (n == 1){
                throw new Exception("Jugador borrado");
            }else{
                throw new Exception("Jugador no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void modiJugador(Jugador jugador){
        try{
            String nombreProcedimiento = "GESTION_JUGADORES.ACTUALIZAR_JUGADOR";
            String plantilla = "{call " + nombreProcedimiento + "(?,?,?,?,?,?)}";
            CallableStatement sentencia = con.prepareCall(plantilla);
            sentencia.setString(1, jugador.getNombreJugador());
            sentencia.setString(2, jugador.getNacionalidad());
            sentencia.setDate(3, Date.valueOf(jugador.getFechaNacimiento()));
            sentencia.setString(4, jugador.getNickname());
            sentencia.setString(5, jugador.getRol());
            sentencia.setInt(6, jugador.getSueldo());
            int n = sentencia.executeUpdate();
            sentencia.close();
            if (n == 1){
                throw new Exception("Jugador actualizado");
            }else{
                throw new Exception("Jugador no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Jugador consultaJugador(String nombreJu){
        Jugador jugador = null;
        try {
            String plantilla = "SELECT cod_jugador,nacionalidad,fecha_nac,nickname,rol,sueldo,cod_equipo FROM equipos WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nombreJu);
            ResultSet respuesta = sentenciaPre.executeQuery();
            if (respuesta.next()){
                Integer codJugador = respuesta.getInt("cod_jugador");
                String nacionalidad = respuesta.getString("nacionalidad");
                java.sql.Date fecha = respuesta.getDate("fecha_nac");
                String nick = respuesta.getString("nickname");
                String rol = respuesta.getString("rol");
                int sueldo = respuesta.getInt("sueldo");
                Object eq = respuesta.getObject("cod_equipo");
                jugador = new Jugador();
                jugador.setNombreJugador(nombreJu);
                jugador.setNacionalidad(nacionalidad);
                jugador.setFechaNacimiento(fecha.toLocalDate());
            }
            return jugador;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
