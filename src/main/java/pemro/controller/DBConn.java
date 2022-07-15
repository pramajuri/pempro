package pemro.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DBConn {
    public Connection databaseLink;
    String dbName       = "pemrograman";
    String dbUsername   = "root";
    String dbPassword   = "";
    String url          = "jdbc:mysql://localhost/" + dbName;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, dbUsername, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaseLink;
    }

}




