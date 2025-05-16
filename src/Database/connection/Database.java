package Database.connection;

import java.sql.*;

public class Database {
    private final static String password = "password";
    private final static String user = "admin";
    private final static String url = "jdbc:mariadb://localhost:3306/gemploye?user="+user+"&password="+password;


    private Database(){

    }

    public static Connection getConnection() throws SQLException {
        Connection connection =null;
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public static void closeConnection(Connection connection) throws SQLException{
        connection.close();
    }

    public static void closeStatement(Statement stmt) throws SQLException{
        stmt.close();
    }

    public static void closePrepareStatement(PreparedStatement ps) throws SQLException{
        ps.close();
    }

    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        resultSet.close();
    }
}
