package repositories;

import config.DatabaseConnection;
import models.BankAccount;
import models.Customer;

import javax.management.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountRepository {

    private final DatabaseConnection connectDB;
    private BankAccount bankAccount;
    public AccountRepository (){
        this.connectDB = new DatabaseConnection();
    }


    public void openSavingsAccount(double initialAmount) throws SQLException {

        String query1 = "INSERT INTO bank_accounts values (?,?,?,?) WHERE customer_id = ?";
        try(Connection connection = connectDB.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query1);
        ){
            connection.setAutoCommit(false);

            preparedStatement.setLong(1, bankAccount.getCustomer().getCustomerID());
            preparedStatement.setString(2,


            preparedStatement.executeUpdate();
            connection.commit();
        }
    }


    public void openCheckAccount(double initialAmount) throws SQLException {

        String query1 = "INSERT INTO values (?,?,?,?) WHERE customer_id = ?";
        try(Connection connection = connectDB.connect()){

        }
    }

}
