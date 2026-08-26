package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private String CONNECTION = "jdbc:postgresql://localhost:5432/bank_management_db";
    private String username = "postgres";
    private String password = "passwordHere";
    //This  will be used for connecting database to the program
    public Connection connect() {
        try {
            DriverManager.getConnection(CONNECTION);
            System.out.println("Connection Connected Successfully");
        } catch (SQLException sqlEx) {
            System.out.println("Failed");
            sqlEx.printStackTrace();

        }
        return null;
    }
}
