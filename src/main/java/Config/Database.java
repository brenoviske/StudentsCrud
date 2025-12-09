package Config;

import java.sql.*;

public class Database {

    private static  String URL = "jdbc:mysql://localhost:3306/students";
    private static String username = "root";
    private static String password = "Ivimorcega1";

    public  static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, username, password);
    }
}