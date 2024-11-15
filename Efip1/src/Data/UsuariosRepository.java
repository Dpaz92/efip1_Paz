package Data;

import Models.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuariosRepository {

    public Usuario getUsuarioByEmail(String email) throws SQLException, ClassNotFoundException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String query = "SELECT * FROM usuario WHERE email = ?";
        PreparedStatement statement = databaseConnection.connection.prepareStatement(query);
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();
        return mapResultSetToUsuario(resultSet);
    }

    private Usuario mapResultSetToUsuario(ResultSet resultSet) throws SQLException {
        Usuario usuario = null;
        while (resultSet.next()) {
            usuario = new Usuario();
            usuario.setEmail(resultSet.getString("email"));
            usuario.setContrasena(resultSet.getString("contrasena"));
            usuario.setNombre(resultSet.getString("nombre"));
            usuario.setApellido(resultSet.getString("apellido"));
            usuario.setRol(usuario.mapRolFromString(resultSet.getString("rol")));
        }
        return usuario;
    }

    private ArrayList<Usuario> mapResultSetToArrayList() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        return usuarios;
    }
}
