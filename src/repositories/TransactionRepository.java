package repositories;

import config.DatabaseConnection;
import exceptions.InsufficientBalanceException;
import models.BankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionRepository {

    private DatabaseConnection connectDB;

    public TransactionRepository(){
        this.connectDB = new DatabaseConnection();
    }

    public boolean withdraw(BankAccount account, double amount)throws SQLException {
        String query = "UPDATE bank_accounts SET balance = balance - ? WHERE account_no = ? AND balance >= ? RETURNING balance";

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
        try (Connection connection = connectDB.connect()) {
            connection.setAutoCommit(false);

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setDouble(1, amount);
                ps.setLong(2, account.getAccountNo());
                ps.setDouble(3, amount);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        double updatedBalance = rs.getDouble("balance");
                        connection.commit();
                        account.setBalance(updatedBalance);
                        return true;
                    }
                    connection.rollback();

                    if (amount > account.getBalance()) {
                        throw new InsufficientBalanceException(
                                "Insufficient balance. Please try again.");
                    }
                    throw new SQLException("Withdrawal failed. Account may not exist or its balance changed.");
                }
            } catch (SQLException | InsufficientBalanceException e) {
                if (!connection.isClosed()) {
                    connection.rollback();
                }
                throw e;
            }
        }
    }

    public boolean deposit(BankAccount account, double amount) throws SQLException {

        String query = "UPDATE bank_accounts SET balance = balance + ? WHERE account_no = ? RETURNING balance";

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }

        try (Connection connection = connectDB.connect()) {
            connection.setAutoCommit(false);

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setDouble(1, amount);
                ps.setLong(2, account.getAccountNo());

                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        connection.rollback();
                        throw new SQLException("Account not found.");
                    }

                    double updatedBalance = rs.getDouble("balance");

                    connection.commit();
                    account.setBalance(updatedBalance);

                    return true;
                }

            } catch (SQLException e) {
                if (!connection.isClosed()) {
                    connection.rollback();
                }
                throw e;
            }
        }
    }

    public boolean transfer(BankAccount account, double amount)throws SQLException, InsufficientBalanceException {

        String deductQuery = "UPDATE bank_accounts SET balance = balance - ? WHERE account_no = ?"; //Source
        String addQuery = "UPDATE bank_accounts SET balance = balance + ? WHERE account_no = ?"; //Destination

        try(Connection connection = connectDB.connect();
            PreparedStatement deductStatement = connection.prepareStatement(deductQuery);
            PreparedStatement addStatement = connection.prepareStatement(addQuery);
            ){
            connection.setAutoCommit(false);


            if (amount > account.getBalance()){
                throw new InsufficientBalanceException("Insufficient Balance. Please Try Again.");
            }
            deductStatement.setDouble(1, amount);
            deductStatement.setLong(2, account.getAccountNo());

            connection.commit();

        }
        return true;
    }
    public void checkReceipient(){
    }

}
