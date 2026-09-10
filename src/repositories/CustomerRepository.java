    package repositories;

    import config.DatabaseConnection;
    import models.ContactDetails;
    import models.Customer;
    import models.CustomerAddress;

    import java.sql.*;
    import java.util.ArrayList;
    import java.util.List;


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
                 PreparedStatement contactStatement = connection.prepareStatement(query3)) {

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

        public List<Customer> findCustomerByName(String name) throws SQLException{

            List<Customer> customers = new ArrayList<>();

            String query = "SELECT " +
                    "c.customer_id, " +
                    "c.first_name, " + "c.middle_name, " + "c.last_name, " +
                    "c.birth_date, " + "c.sex, " +
                    "a.brgy, " + "a.municipality, " + "a.province, " + "a.postal_code, " + "a.country, " +
                    "ct.mobile_number, " + "ct.email_address, " + "ct.telephone_number " +
                    "FROM customers c " +
                    "LEFT JOIN address a " +
                    "ON c.customer_id = a.customer_id " +
                    "LEFT JOIN contacts ct " +
                    "ON c.customer_id = ct.customer_id WHERE c.first_name LIKE ? OR " +
                    "c.middle_name LIKE ?" + " OR c.last_name LIKE ?;";
            try (Connection connection = connectDB.connect();
                 PreparedStatement preparedStatement = connection.prepareStatement(query))
            {
                preparedStatement.setString(1,  "%"+ name + "%");
                preparedStatement.setString(2,  "%"+ name + "%");
                preparedStatement.setString(3,  "%"+ name + "%");

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    CustomerAddress address = new CustomerAddress(
                            resultSet.getString("brgy"),
                            resultSet.getString("municipality"),
                            resultSet.getString("province"),
                            resultSet.getString("postal_code"),
                            resultSet.getString("country")
                    );
                    ContactDetails contacts = new ContactDetails(
                            resultSet.getString("mobile_number"),
                            resultSet.getString("email_address"),
                            resultSet.getString("telephone_number")
                    );

                    Customer customer = new Customer(
                            resultSet.getLong("customer_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("middle_name"),
                            resultSet.getString("last_name"),
                            resultSet.getDate("birth_date").toLocalDate(),
                            resultSet.getString("sex").charAt(0),
                            address, contacts
                    );

                    customers.add(customer);
            }
            }catch (Exception e){
                e.printStackTrace();

            }
            return customers;
        }

        public Customer findCustomerById(long id) throws SQLException {

            String query = "SELECT c.customer_id," +
                    "c.first_name, " + "c.middle_name, " + "c.last_name, " +
                    "c.birth_date, " + "c.sex, " +
                    "a.brgy, " + "a.municipality, " + "a.province, " + "a.postal_code, " + "a.country, " +
                    "ct.mobile_number, " + "ct.email_address, " +
                    "ct.telephone_number FROM customers c LEFT JOIN address a ON " +
                    "c.customer_id = a.customer_id LEFT JOIN contacts ct ON a.customer_id = ct.customer_id " +
                    "WHERE c.customer_id = ?;";

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