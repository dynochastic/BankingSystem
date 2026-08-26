package repositories;

import config.DatabaseConnection;
import models.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerRepository {

    public final DatabaseConnection connectDB;

    CustomerRepository(DatabaseConnection connectDB) {
        this.connectDB = connectDB;

    }

    public void createCustomer(Customer customer) {
        String query = "INSERT INTO customers(first_name, middle_name, last_name, birth_date, sex) values (?,?,?,?,?)";


        try {
            Connection connection = connectDB.connect();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,customer.getFirstName());
            statement.setString(2, customer.getMiddleName());
            statement.setString(3, customer.getLastName());
            statement.setDate(4, Date.valueOf(customer.getBirthDate()));
            statement.setString(5, String.valueOf(customer.getSex()));

            statement.executeUpdate();

            statement.close();
            connection.close();
        }
        catch (SQLException e){
            System.out.println("Failed to save customer");
            e.printStackTrace();
        }
    }
}
