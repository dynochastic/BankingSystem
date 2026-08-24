package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    String CONNECTION = url;
    String url = "jdbc:postgresql://localhost:5432/bank_management_db";

    //This method will be used for connecting database to the program
    void Connect(){
        try{
            Connection connection = DriverManager.getConnection(CONNECTION);
            System.out.println("Connection Connected Successfully");
        } catch(SQLException sqlEx){
            System.out.println("Failed");
            sqlEx.printStackTrace();
        }
    }
}
