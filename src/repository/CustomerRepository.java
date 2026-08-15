package repository;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomerRepository{

    String CONNECTION = "eqwewq";


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
