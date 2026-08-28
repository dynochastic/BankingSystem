package repositories;

import config.DatabaseConnection;
import models.Customer;

import java.lang.annotation.Retention;
import java.sql.*;

public class CustomerRepository {

    public final DatabaseConnection connectDB;

    CustomerRepository(DatabaseConnection connectDB) {
        this.connectDB = connectDB;

    }

    public void createCustomer(Customer customer) {
        String query = "INSERT INTO customers(first_name, middle_name, last_name, birth_date, sex) values (?,?,?,?,?)";
        String addAddressQuery = "INSERT INTO address(brgy, municipality, province, postal_code, country) values (?, ?, ?, ?, ?) where customer_ID = ?";
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

            try{
                PreparedStatement addressStatement = connection.prepareStatement(addAddressQuery);
                statement.setString(1, customer.getAddress().getBrgy());
                statement.setString(2, customer.getAddress().getMunicipality());
                statement.setString(3, customer.getAddress().getProvince());
                statement.setString(4, customer.getAddress().getCountry());
                statement.setString(5, customer.getAddress().getPostal());

                //To check if the retrieval is correct
                statement.setLong(6, customer.getCustomerID());


            }catch (SQLException e){
                System.out.println("Failed to add Address");
            }
            connection.close();


        }
        catch (SQLException e){
            System.out.println("Failed to save customer");
            e.printStackTrace();
        }

    }
}
