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