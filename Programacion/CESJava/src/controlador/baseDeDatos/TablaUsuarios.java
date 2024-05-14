package controlador.baseDeDatos;

import modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TablaUsuarios {
    private Connection connection;

    public TablaUsuarios(Connection connection) {
        this.connection = connection;
    }

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
}