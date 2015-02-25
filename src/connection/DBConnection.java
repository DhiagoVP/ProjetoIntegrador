package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Giseli e Keyve
 */
public class DBConnection {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        return connection = connect();
    }

    private static Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/projetointegradorcompleto";
        String driverMySQL = "com.mysql.jdbc.Driver";
        String user = "root";
        String pass = "aluno";
        try {
            Class.forName(driverMySQL);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        connection = DriverManager.getConnection(url, user, pass);
        return connection;
    }

    public static void close() throws SQLException {
        connection.close();
    }
}
