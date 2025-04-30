package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/localfarm";
    private static final String USER = "localfarm_user"; // <-- Change if needed
    private static final String PASSWORD = "localfarm_password"; // <-- Change if you have a MySQL password

    //public static Connection getConnection() throws SQLException {
     //   return DriverManager.getConnection(URL, USER, PASSWORD);
    //}
    
    public static Connection getConnection() throws SQLException {
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection made to DB");
            return connection;

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found");
            e.printStackTrace();
            throw new SQLException("MySQL JDBC Driver not found", e);

        } catch (SQLException e) {
            System.err.println("Failed to connect to database");
            e.printStackTrace();
            throw e; 
        }
    }
}
