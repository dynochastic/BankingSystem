package repositories;

import config.DatabaseConnection;
import models.Customer;

import java.lang.annotation.Retention;
import java.sql.*;

public class CustomerRepository {

    public final DatabaseConnection connectDB;

    public CustomerRepository() {
        this.connectDB = new DatabaseConnection();

    }
    long getID(){
        return Statement.RETURN_GENERATED_KEYS;
    }

    public void createCustomer(Customer customer) {
        String query = "INSERT INTO customers(first_name, middle_name, last_name, birth_date, sex) values (?,?,?,?,?) RETURNING customer_id";
        String query2 = "INSERT INTO address(brgy, municipality, province, postal_code, country) values (?, ?, ?, ?, ?) where customer_id = ?";
        String query3 = "INSERT INTO contacts(mobile_number, email_address, telephone_number) values (?,?,?) WHERE customer_id = ?";



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
                PreparedStatement addressStatement = connection.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
                addressStatement.setString(1, customer.getAddress().getBrgy());
                addressStatement.setString(2, customer.getAddress().getMunicipality());
                addressStatement.setString(3, customer.getAddress().getProvince());
                addressStatement.setString(4, customer.getAddress().getCountry());
                addressStatement.setString(5, customer.getAddress().getPostal());

                //To check if the retrieval is correct
                addressStatement.setLong(6, getID());

                addressStatement.executeUpdate();
                addressStatement.close();
                try{
                    PreparedStatement contactStatement = connection.prepareStatement(query3);
                    contactStatement.setString(1, customer.getContact().getPhoneNumber() );
                    contactStatement.setString(2, customer.getContact().getEmailAddress());
                    contactStatement.setString(3, customer.getContact().getTelephoneNumber());
                    contactStatement.setLong(4, getID());

                    contactStatement.executeUpdate();
                    contactStatement.close();
                }
                catch (SQLException e){
                    System.out.println("failed to add contact details");

                }

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
