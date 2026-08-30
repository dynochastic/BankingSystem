package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {


    //This  will be used for connecting database to the program
    public Connection connect() throws SQLException{

        String CONNECTION = System.getenv("CONNECTION");
        String username = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");


        Connection connection = DriverManager.getConnection(CONNECTION,username,password);

        System.out.println("Connection Connected Successfully");

        return connection;
    }
}
