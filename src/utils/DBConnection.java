package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static final String url = "jdbc:mysql://server:port/name";
    private static final String user = "user";
    private static final String password = "password";
    private static Connection con = null;
    private static Properties properties = new Properties();

    public static Connection getConnection() {
    	
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        properties.setProperty("useUnicode", "true");
        properties.setProperty("characterEncoding", "UTF-8");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

}