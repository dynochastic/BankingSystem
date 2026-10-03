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


    public void openSavingsAccount(BankAccount bankAccount) throws SQLException {

        String query1 = "INSERT INTO bank_accounts (customer_id, account_type, balance) values (?,?,?)";
        try(Connection connection = connectDB.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query1);
        ){
            connection.setAutoCommit(false);

            try{
                preparedStatement.setLong(1, bankAccount.getCustomer().getCustomerID());
                preparedStatement.setString(2, bankAccount.getAccountType().toString());
                preparedStatement.setDouble(3, bankAccount.getBalance());

                preparedStatement.executeUpdate();
                connection.commit();
            }
            catch (SQLException rollbackException ){
                connection.rollback();
                rollbackException.printStackTrace();
            }
        }
    }


    public void openCheckAccount(double initialAmount) throws SQLException {

        String query1 = "INSERT INTO values (?,?,?,?) WHERE customer_id = ?";
        try(Connection connection = connectDB.connect()){

        }
    }

}
