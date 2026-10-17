package repositories;

import config.DatabaseConnection;

import models.Savings;

import java.sql.*;

public class AccountRepository {

    private final DatabaseConnection connectDB;
    public AccountRepository (){
        this.connectDB = new DatabaseConnection();
    }

    public int findProductbyID(String productName) throws SQLException {
        String query = "SELECT product_id FROM account_products WHERE product_name = ?";

        try (Connection connection = connectDB.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, productName);
            connection.setAutoCommit(false);

           try(ResultSet rs = preparedStatement.executeQuery()){
               if (rs.next()){
                   return rs.getInt("product_id");
               }
               throw new SQLException("Product not found");
           }
        }
    }
    public boolean openSavingsAccount(Savings savings, int productId) throws SQLException {
        String query1 = "INSERT INTO bank_accounts (customer_id, product_id, balance) values (?,?,?)";
        try(Connection connection = connectDB.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query1);
        ){
            connection.setAutoCommit(false);

            try{
                preparedStatement.setLong(1, savings.getCustomer().getCustomerID());
                preparedStatement.setLong(2, productId);
                preparedStatement.setDouble(3, savings.getBalance());

                preparedStatement.executeUpdate();

                connection.commit();
            }
            catch (SQLException rollbackException ){
                connection.rollback();
                rollbackException.printStackTrace();
                return false;
            }
            return true;
        }
    }


    public void openCheckAccount(double initialAmount) throws SQLException {

        String query1 = "INSERT INTO values (?,?,?,?) WHERE customer_id = ?";
        try(Connection connection = connectDB.connect()){

        }
    }

}
