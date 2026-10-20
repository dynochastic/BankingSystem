package repositories;

import config.DatabaseConnection;

import models.*;

import java.sql.*;
import java.time.LocalDate;

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

    public boolean openSavingsAccount(Savings savings, int productId) throws SQLException {
        String query1 = "INSERT INTO bank_accounts (customer_id, product_id, balance) values (?,?,?)";

        try (Connection connection = connectDB.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query1)
        ) {
            connection.setAutoCommit(false);

            try {
                preparedStatement.setLong(1, savings.getCustomer().getCustomerID());
                preparedStatement.setInt(2, productId);
                preparedStatement.setDouble(3, savings.getBalance());

                preparedStatement.executeUpdate();

                connection.commit();
            } catch (SQLException rollbackException) {
                connection.rollback();
                rollbackException.printStackTrace();
                return false;
            }
        }
        return true;
    }


    public boolean openCheckAccount(CheckAccount checkAccount, int productId) throws SQLException {

        String query = "INSERT INTO bank_accounts (customer_id, product_id, balance) VALUES  (?,?,?);";
        try (Connection connection = connectDB.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);
            try {
                preparedStatement.setLong(1, checkAccount.getCustomer().getCustomerID());
                preparedStatement.setInt(2, productId);
                preparedStatement.setDouble(3, checkAccount.getBalance());

                preparedStatement.executeUpdate();

                connection.commit();
            } catch (SQLException rollbackException) {
                connection.rollback();
                rollbackException.printStackTrace();
                return false;
            }
        }
        return true;
    }

    // returns Account with customer details
    public BankAccount findByAccountId(long id) throws SQLException {

        String query = "SELECT c.customer_id, c.first_name, COALESCE(c.middle_name, '') as middle_name, c.last_name, c.birth_date, c.sex, " +
                "ba.account_no, ba.balance, ap.account_type " +
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
                long cust_id = rs.getLong("customer_id");
                String first_name = rs.getString("first_name");
                String middle_name = rs.getString("middle_name");
                String last_name = rs.getString("last_name");
                LocalDate birth_date = rs.getDate("birth_date").toLocalDate();
                char sex = rs.getString("sex").charAt(0);

                Customer customer = new Customer(cust_id, first_name, middle_name, last_name, birth_date, sex);

                if ("savings".equalsIgnoreCase(account_type)) {
                    return new Savings(account_no, balance, account_type, customer);
                } else if ("checking".equalsIgnoreCase(account_type)) {
                    return new CheckAccount(account_no, balance, account_type, customer);
                }
                else {
                    return null;
                }
            }
        }
    }
}


