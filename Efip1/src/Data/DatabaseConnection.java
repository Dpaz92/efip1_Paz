package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String url = "jdbc:mysql://localhost:3306/rus_videos";
    private static String user = "root";
    private static String password = "UccleSport2024!";

    public Connection connection = null;

    public DatabaseConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = this.StartConnection();
    }

    private Connection StartConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}


