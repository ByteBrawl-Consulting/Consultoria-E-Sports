package controlador.baseDeDatos;

import modelo.Equipo;
import modelo.Jugador;

import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class TablaJugadores {
    private Connection con;
    ControladorBaseDeDatos cbd;

    public TablaJugadores(Connection con, ControladorBaseDeDatos cbd) {
        this.con = con;
        this.cbd = cbd;
    }

    public void altaJugador(Jugador jugador) {
        try {
            String nombreProcedimiento = "GESTION_JUGADORES.AGREGAR_JUGADOR";
            String plantilla = "{call " + nombreProcedimiento + "(?,?,?,?,?,?,?)}";
            CallableStatement sentencia = con.prepareCall(plantilla);
            sentencia.setString(1, jugador.getNombreJugador());
            sentencia.setString(2, jugador.getNacionalidad());
            sentencia.setDate(3, Date.valueOf(jugador.getFechaNacimiento()));
            sentencia.setString(4, jugador.getNickname());
            sentencia.setString(5, jugador.getRol());
            sentencia.setInt(6, jugador.getSueldo());
            sentencia.setObject(7, jugador.getCodEquipo().getCodEquipo());
            int n = sentencia.executeUpdate();
            if (n != 1) {
                mostrar("No se ha insertado ningún jugador");
            } else {
                mostrar("Jugador insertado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void bajaJugador(Jugador jugador) {
        try {
            String nombreProcedimiento = "GESTION_JUGADORES.ELIMINAR_JUGADOR";
            String plantilla = "{call " + nombreProcedimiento + "(?)}";
            CallableStatement sentencia = con.prepareCall(plantilla);
            sentencia.setString(1, jugador.getNombreJugador());
            int n = sentencia.executeUpdate();
            sentencia.close();
            if (n == 1) {
                mostrar("Jugador borrado");
            } else {
                mostrar("Jugador no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void modiJugador(Jugador jugador, String fecha) {
        try {
            String nombreProcedimiento = "GESTION_JUGADORES.ACTUALIZAR_JUGADOR";
            String plantilla = "{call " + nombreProcedimiento + "(?,?,?,?,?,?,?)}";
            CallableStatement sentencia = con.prepareCall(plantilla);
            sentencia.setString(1, jugador.getNombreJugador());
            sentencia.setString(2, jugador.getNacionalidad());
            String fechaVentana = fecha;
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date fechaJava = formato.parse(fechaVentana);
            java.sql.Timestamp fechaSql = new java.sql.Timestamp(fechaJava.getTime());
            sentencia.setTimestamp(3, fechaSql);
            sentencia.setString(4, jugador.getNickname());
            sentencia.setString(5, jugador.getRol());
            sentencia.setInt(6, jugador.getSueldo());
            sentencia.setObject(7, jugador.getCodEquipo().getCodEquipo());
            int n = sentencia.executeUpdate();
            sentencia.close();
            if (n == 1) {
                mostrar("Jugador actualizado");
            } else {
                mostrar("Jugador no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public StringBuilder consultaJugador(String nombreJu) {
        try {
            String plantilla = "SELECT cod_jugador,nacionalidad,fecha_nac,nickname,rol,sueldo,cod_equipo FROM jugadores WHERE upper(nombre_jugador) = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nombreJu);
            ResultSet respuesta = sentenciaPre.executeQuery();
            StringBuilder pantalla = new StringBuilder();
            if (respuesta.next()) {
                Integer codJugador = respuesta.getInt("cod_jugador");
                String nacionalidad = respuesta.getString("nacionalidad");
                Date fechaBD = respuesta.getDate("fecha_nac");
                SimpleDateFormat formato = new SimpleDateFormat("yy-MM-dd");
                String fechaFormateada = formato.format(fechaBD);
                String nick = respuesta.getString("nickname");
                String rol = respuesta.getString("rol");
                Integer sueldo = respuesta.getInt("sueldo");
                int codEq = respuesta.getInt("cod_equipo");
                Equipo eq = cbd.getNombreEquipoPorCodigo(codEq);
                pantalla.append("CODIGO JUGADOR: ").append(codJugador).append("\n").append("NACIONALIDAD: ").append(nacionalidad).append("\n").append("FECHA NACIMIENTO: ").append(fechaFormateada).append("\n").append("NICKNAME: ").append(nick).append("\n").append("ROL: ").append(rol).append("\n").append("SUELDO: ").append(sueldo).append("\n").append("EQUIPO: ").append(eq.getNombre().toUpperCase());
            }
            return pantalla;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrar(String m) {
        JOptionPane.showMessageDialog(null, m);
    }
}
