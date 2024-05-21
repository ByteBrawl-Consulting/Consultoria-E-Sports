package controlador.baseDeDatos;

import modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * La clase TablaUsuarios gestiona las operaciones relacionadas con los usuarios en la base de datos.
 */

public class TablaUsuarios {
    private Connection connection;

    /**
     * Constructor de la clase TablaUsuarios.
     *
     * @param connection La conexión a la base de datos.
     */

    public TablaUsuarios(Connection connection) {
        this.connection = connection;
    }

    /**
     * Realiza el proceso de inicio de sesión de un usuario.
     *
     * @param usu El objeto Usuario que contiene la información del usuario que intenta iniciar sesión.
     * @return El tipo de usuario si el inicio de sesión es exitoso.
     * @throws SQLException Si ocurre un error de SQL durante la operación.
     */

    public String login(Usuario usu) throws SQLException {
        String usuario = usu.getTipo();
        String pass = usu.getContrasena();
        String tipoUsuario = "";

        String query = "SELECT * FROM Usuarios WHERE TIPO = ? AND CONTRASENNA = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, pass);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    tipoUsuario = resultSet.getString("TIPO");
                } else {
                    throw new Exception("Usuario o contraseña incorrecto");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return tipoUsuario;
    }

    /**
     * Agrega un nuevo usuario a la base de datos.
     *
     * @param usu El objeto Usuario que representa al nuevo usuario a agregar.
     * @throws Exception Si ocurre un error durante la operación.
     */


    public void altaUsu(Usuario usu) throws Exception {
        String tipo = usu.getTipo();
        int pass = Integer.parseInt(usu.getContrasena());

        String plantilla = "insert into usuarios (tipo,contrasenna) values(?,?)";
        PreparedStatement pre = connection.prepareCall(plantilla);
        pre.setString(1, tipo);
        pre.setString(2, String.valueOf(pass));
        int x = pre.executeUpdate();
        if (x != 1) {
            System.out.println("Error en insercion");
        } else {
            System.out.println("Insertado correctamente");
        }
    }

    /**
     * Comprueba si un usuario existe en la base de datos.
     *
     * @param usu El objeto Usuario que representa al usuario a comprobar.
     * @return El objeto Usuario si el usuario existe en la base de datos.
     * @throws Exception Si ocurre un error durante la operación.
     */

    public Usuario comprobarUsu(Usuario usu) throws Exception {
        String usuario = usu.getTipo();
        String pass = usu.getContrasena();

        String query = "SELECT * FROM Usuarios WHERE TIPO = ? AND CONTRASENNA = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, pass);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                usu.setTipo(res.getString(1));
                usu.setContrasena(res.getString(2));
            }
            return usu;
        }
    }
}