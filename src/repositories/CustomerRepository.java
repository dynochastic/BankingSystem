    package repositories;

    import config.DatabaseConnection;
    import models.ContactDetails;
    import models.Customer;
    import models.CustomerAddress;

    import javax.xml.transform.Result;
    import java.sql.*;


    public class CustomerRepository {

        public final DatabaseConnection connectDB;

        public CustomerRepository() {
            this.connectDB = new DatabaseConnection();
        }

        public long createCustomer(Customer customer) throws SQLException {

            Connection connection = connectDB.connect();
            String query = "INSERT INTO customers(first_name, middle_name, last_name, birth_date, sex) values (?,?,?,?,?)";
            String query2 = "INSERT INTO address(brgy, municipality, province, country, postal_code, customer_id) values (?, ?, ?, ?, ?, ?)";
            String query3 = "INSERT INTO contacts(mobile_number, email_address, telephone_number, customer_id) values (?,?,?,?)";
            long customer_id = 0;

            connection.setAutoCommit(false);


            try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement addressStatement = connection.prepareStatement(query2);
                 PreparedStatement contactStatement = connection.prepareStatement(query3);) {

                statement.setString(1, customer.getFirstName());
                statement.setString(2, customer.getMiddleName());
                statement.setString(3, customer.getLastName());
                statement.setDate(4, Date.valueOf(customer.getBirthDate()));
                statement.setString(5, String.valueOf(customer.getSex()));

                statement.executeUpdate();
                try (ResultSet rs = statement.getGeneratedKeys()){
                    if (!rs.next()) {
                        throw new SQLException("Failed to retrieve customer ID");
                    }
                    customer_id = rs.getLong(1);
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
            return customer_id;
        }
        public void editCustomer(Customer customer) throws SQLException{

            String query = "UPDATE customers SET first_name = ? WHERE customer_id = ?";
            String query1 = "UPDATE customers SET second_name = ? WHERE customer_id = ?";

            try (Connection connection = connectDB.connect();
                 PreparedStatement preparedStatement = connection.prepareStatement(query))
            {
                preparedStatement.setString(1, customer.getFirstName());
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        public Customer findCustomerById(long id) throws SQLException {

            String query = "SELECT c.customer_id," +
                    "c.first_name, " +
                    "c.middle_name, " +
                    "c.last_name, " +
                    "c.birth_date, " +
                    "c.sex, " +
                    "a.brgy, " +
                    "a.municipality, " +
                    "a.province, " +
                    "a.postal_code, " +
                    "a.country, " +
                    "ct.mobile_number, " +
                    "ct.email_address, " +
                    "ct.telephone_number FROM customers c LEFT JOIN address a ON " +
                    "c.customer_id = a.customer_id LEFT JOIN contacts ct ON a.customer_id = ct.customer_id " +
                    "WHERE c.customer_id = ?";

            try (Connection connection = connectDB.connect();
                 PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setLong(1, id);

                ResultSet result = statement.executeQuery();

                if(result.next()){
                    CustomerAddress address = new CustomerAddress(
                            result.getString("brgy"),
                            result.getString("municipality"),
                            result.getString("province"),
                            result.getString("postal_code"),
                            result.getString("country")
                    );
                    ContactDetails contacts = new ContactDetails(
                            result.getString("mobile_number"),
                            result.getString("email_address"),
                            result.getString("telephone_number")
                    );

                    Customer customer = new Customer(
                            result.getLong("customer_id"),
                            result.getString("first_name"),
                            result.getString("middle_name"),
                            result.getString("last_name"),
                            result.getDate("birth_date").toLocalDate(),
                            result.getString("sex").charAt(0),
                            address, contacts
                            );

                    return customer;

                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            return null;
        }
    }