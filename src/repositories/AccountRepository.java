package repositories;

import config.DatabaseConnection;
import models.BankAccount;
import models.Customer;

import javax.management.Query;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountRepository {

    private final DatabaseConnection connectDB;
    private BankAccount bankAccount;
    public AccountRepository (){
        this.connectDB = new DatabaseConnection();
    }


    public void openSavingsAccount(BankAccount bankAccount) throws SQLException {
        String query1 = "INSERT INTO bank_accounts (customer_id, product_id, balance, opened_date) values (?,?,?,?)";
        try(Connection connection = connectDB.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query1);
        ){
            connection.setAutoCommit(false);

            try{
                preparedStatement.setLong(1, bankAccount.getCustomer().getCustomerID());
                //To add the product_id here
                preparedStatement.setString(2, bankAccount.getAccountType().toString());
                preparedStatement.setDouble(3, bankAccount.getBalance());
                preparedStatement.setDate(4, Date.valueOf(bankAccount.getDateOpened()));

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
