package repositories;

import config.DatabaseConnection;

import exceptions.ClosedAccountException;
import exceptions.FrozenAccountException;
import exceptions.NonZeroBalanceException;
import models.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class AccountRepository {

    private final DatabaseConnection connectDB;

    public AccountRepository() {
        this.connectDB = new DatabaseConnection();
    }

    public int findProductbyID(String productName) throws SQLException {
        String query = "SELECT product_id FROM account_products WHERE product_name = ?";

        try (Connection connection = connectDB.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, productName);
            connection.setAutoCommit(false);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("product_id");
                }
                throw new SQLException("Product not found");
            }
        }
    }

    public long openSavingsAccount(Savings savings, int productId) throws SQLException {
        String query1 = "INSERT INTO bank_accounts (customer_id, product_id, balance) values (?,?,?)";
        long account_no = 0;

        try (Connection connection = connectDB.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query1,  new String[]{"account_no"})//returns the column of generated ids
        ) {
            connection.setAutoCommit(false);

            try {
                preparedStatement.setLong(1, savings.getCustomer().getCustomerID());
                preparedStatement.setInt(2, productId);
                preparedStatement.setDouble(3, savings.getBalance());

                preparedStatement.executeUpdate();

                connection.commit();

                try(ResultSet rs = preparedStatement.getGeneratedKeys()){
                    if (rs.next()){
                        account_no =  rs.getLong(1);
                    }
                }
            } catch (SQLException rollbackException) {
                connection.rollback();
                throw rollbackException;
            }
        }
        return account_no;
    }


    public long openCheckAccount(CheckAccount checkAccount, int productId) throws SQLException {

        long account_no = 0;
        String query = "INSERT INTO bank_accounts (customer_id, product_id, balance) VALUES  (?,?,?);";
        try (Connection connection = connectDB.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query, new String[]{"account_no"})) {
            connection.setAutoCommit(false);
            try {
                preparedStatement.setLong(1, checkAccount.getCustomer().getCustomerID());
                preparedStatement.setInt(2, productId);
                preparedStatement.setDouble(3, checkAccount.getBalance());

                preparedStatement.executeUpdate();

                connection.commit();

                try(ResultSet rs = preparedStatement.getGeneratedKeys()){
                    if(rs.next()){
                        account_no = rs.getLong("account_no");
                    }
                }
            } catch (SQLException rollbackException) {
                connection.rollback();
                throw rollbackException;
            }
        }
        return account_no;
    }

    // returns Account with customer details
    public BankAccount findByAccountId(long id) throws SQLException {

        String query = "SELECT c.customer_id, c.first_name, COALESCE(c.middle_name, '') as middle_name, c.last_name, c.birth_date, c.sex, " +
                "ba.account_no, ba.balance, ba.status, ap.account_type " +
                " FROM bank_accounts ba LEFT JOIN account_products ap ON ba.product_id = ap.product_id LEFT JOIN customers c ON c.customer_id = ba.customer_id WHERE ba.account_no = ?";

        try (Connection connection = connectDB.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }

                String account_type = rs.getString("account_type");
                int account_no = rs.getInt("account_no");
                double balance = rs.getDouble("balance");
                String account_status = rs.getString("status");
                long cust_id = rs.getLong("customer_id");
                String first_name = rs.getString("first_name");
                String middle_name = rs.getString("middle_name");
                String last_name = rs.getString("last_name");
                LocalDate birth_date = rs.getDate("birth_date").toLocalDate();
                char sex = rs.getString("sex").charAt(0);

                Customer customer = new Customer(cust_id, first_name, middle_name, last_name, birth_date, sex);

                if ("savings".equalsIgnoreCase(account_type)) {
                    return new Savings(account_no, balance, account_type, account_status,customer);
                } else if ("checking".equalsIgnoreCase(account_type)) {
                    return new CheckAccount(account_no, balance, account_type, account_status ,customer);
                }
                else {
                    throw new SQLException();
                }
            }
        }
    }

    public boolean closeAccount(BankAccount account) throws NonZeroBalanceException, SQLException{
        String query = "UPDATE bank_accounts SET status = 'CLOSED' WHERE account_no = ?";

        try(Connection connection = connectDB.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            connection.setAutoCommit(false);
            try{
                if (account.getBalance() > 0) {
                    throw new NonZeroBalanceException("Cannot close account: balance is not zero.\nAccount Balance: " + account.getBalance());
                }

                preparedStatement.setLong(1, account.getAccountNo());
                preparedStatement.executeUpdate();
                connection.commit();
                return true;

            }catch (SQLException sqlException){
                connection.rollback();
                throw sqlException;
            }
        }
    }
    public boolean freezeAccount(BankAccount account) throws SQLException, ClosedAccountException{
        String status = "";
        String query = "UPDATE bank_accounts SET status = 'FROZEN' WHERE account_no = ?";
        String confirmQuery = "SELECT * FROM bank_accounts WHERE account_no = ?"; // check if account is close
        try(Connection connection = connectDB.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            PreparedStatement preparedStatement2 = connection.prepareStatement(confirmQuery)){
            connection.setAutoCommit(false);

            preparedStatement2.setLong(1, account.getAccountNo());
            try (ResultSet rs = preparedStatement2.executeQuery()) {
                if (rs.next()) {
                    status = rs.getString("status");
                }
                if (status.equalsIgnoreCase("CLOSED")) throw new ClosedAccountException("Account Not Found");
                else if (status.equalsIgnoreCase("FROZEN"))
                    throw new FrozenAccountException("Account is already FROZEN");
            }

            try{
                preparedStatement.setLong(1, account.getAccountNo());
                preparedStatement.executeUpdate();
                connection.commit();

            }catch (SQLException sqlException){
                connection.rollback();
                throw sqlException;
            }
        }
        return true;
    }
    public boolean reactivateAccount(BankAccount account) throws SQLException, ClosedAccountException, Exception{

        String status = "";
        String query = "UPDATE bank_accounts SET status = 'ACTIVE' WHERE account_no = ?";
        String confirmQuery = "SELECT * FROM bank_accounts WHERE account_no = ?"; // check if account is currently active or close

        try(Connection connection = connectDB.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            PreparedStatement preparedStatement2 = connection.prepareStatement(confirmQuery)){
            connection.setAutoCommit(false);

            preparedStatement2.setLong(1, account.getAccountNo());
            try (ResultSet rs = preparedStatement2.executeQuery()) {
                if (rs.next()) {
                    status = rs.getString("status");
                }
                if (status.equalsIgnoreCase("CLOSED")) throw new ClosedAccountException("Account Not Found");
                else if (status.equalsIgnoreCase("ACTIVE")) throw new Exception("Account is currently Active.");
            }
            try{
                preparedStatement.setLong(1, account.getAccountNo());
                preparedStatement.executeUpdate();
                connection.commit();

            }catch (SQLException sqlException){
                connection.rollback();
                throw sqlException;
            }
        }
        return true;
    }
}


