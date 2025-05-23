package com.employe.org.dao.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Database {

    private static String password ;
    private static String user ;
    private static String url ;
    private static Logger logger = LogManager.getLogger(Database.class);
    static {

        try (FileInputStream input = new FileInputStream("config.properties")) {
            Properties props = new Properties();
            props.load(input);

            url = props.getProperty("db.url");
            user = props.getProperty("db.user");
            password = props.getProperty("db.password");

            logger.trace(url);
            logger.trace(user);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur de chargement du fichier de configuration !");
        }
    }

    private Database() {

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
