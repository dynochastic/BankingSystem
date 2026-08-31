package repositories;

import config.DatabaseConnection;
import models.Customer;

import java.sql.*;

public class CustomerRepository {

    public final DatabaseConnection connectDB;

    public CustomerRepository() {
        this.connectDB = new DatabaseConnection();
    }

    public void createCustomer(Customer customer) throws SQLException {

        Connection connection = connectDB.connect();
        String query = "INSERT INTO customers(first_name, middle_name, last_name, birth_date, sex) values (?,?,?,?,?)";
        String query2 = "INSERT INTO address(brgy, municipality, province, country, postal_code, customer_id) values (?, ?, ?, ?, ?, ?)";
        String query3 = "INSERT INTO contacts(mobile_number, email_address, telephone_number, customer_id) values (?,?,?,?)";
        long customer_id = 0;

        connection.setAutoCommit(false);


        try (PreparedStatement statement = connection.prepareStatement(query);
             PreparedStatement addressStatement = connection.prepareStatement(query2);
             PreparedStatement contactStatement = connection.prepareStatement(query3);) {

            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getMiddleName());
            statement.setString(3, customer.getLastName());
            statement.setDate(4, Date.valueOf(customer.getBirthDate()));
            statement.setString(5, String.valueOf(customer.getSex()));

            try (ResultSet rs = statement.executeQuery()){
                if (!rs.next()) {
                    throw new SQLException("ID cannot be mapped.");
                }
                customer_id = rs.getLong("customer_id");
            }

            addressStatement.setString(1, customer.getAddress().getBrgy());
            addressStatement.setString(2, customer.getAddress().getMunicipality());
            addressStatement.setString(3, customer.getAddress().getProvince());
            addressStatement.setString(4, customer.getAddress().getCountry());
            addressStatement.setString(5, customer.getAddress().getPostal());
            addressStatement.setLong(6, customer_id);

            addressStatement.executeUpdate();

            contactStatement.setString(1, customer.getContact().getPhoneNumber());
            contactStatement.setString(2, customer.getContact().getEmailAddress());
            contactStatement.setString(3, customer.getContact().getTelephoneNumber());
            contactStatement.setLong(4, customer_id);

            contactStatement.executeUpdate();

            connection.commit();
            System.out.println("Customer Added to the database.");
        }
        catch (SQLException e){
            try {
                connection.rollback();
            }
             catch (SQLException rollbackException){
                rollbackException.printStackTrace();
            }
            System.out.println("Repository failed. Customer not saved");
            throw e;
        }
        finally {
            connection.close();
        }
    }
}
