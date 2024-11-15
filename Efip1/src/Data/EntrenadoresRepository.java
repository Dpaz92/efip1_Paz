package Data;

import Models.Entrenador;
import Models.dto.EntrenadorDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EntrenadoresRepository {

    public boolean Insertar(EntrenadorDTO entrenadorDTO) throws SQLException, ClassNotFoundException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String sql = "INSERT INTO entrenador (nombre, apellido, email) VALUES (?,?,?)";
        PreparedStatement statement = databaseConnection.connection.prepareStatement(sql);
        statement.setString(1, entrenadorDTO.nombre);
        statement.setString(2, entrenadorDTO.apellido);
        statement.setString(3, entrenadorDTO.email);
        if (statement.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

    public ArrayList<Entrenador> Listar() throws SQLException, ClassNotFoundException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String sql = "SELECT * FROM entrenador";
        PreparedStatement statement = databaseConnection.connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        return MapResultSetToArrayList(resultSet);
    }

    private ArrayList<Entrenador> MapResultSetToArrayList(ResultSet resultSet) throws SQLException {
        ArrayList<Entrenador> entrenadores = new ArrayList<>();
        while (resultSet.next()) {
            Entrenador entrenador = new Entrenador();
            entrenador.setId(resultSet.getInt("id"));
            entrenador.setNombre(resultSet.getString("nombre"));
            entrenador.setApellido(resultSet.getString("apellido"));
            entrenador.setEmail(resultSet.getString("email"));
            entrenadores.add(entrenador);
        }
        return entrenadores;
    }
}
