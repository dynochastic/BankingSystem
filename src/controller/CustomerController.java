package controller;

import models.Customer;

import repositories.CustomerRepository;
import validators.CustomerValidator;

import java.sql.SQLException;
import java.util.List;


public class CustomerController {

    private CustomerValidator validation;
    private CustomerRepository customerRepository;
    public
    CustomerController(){
        this.validation = new CustomerValidator();
        this.customerRepository = new CustomerRepository();
    }

    public long registerCustomer(Customer customer) {

        try {
            if (!validation.isValidCustomer(customer)) {
                return 0;
            }
            return customerRepository.createCustomer(customer);
        }
        catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //retrieve single customer object
    public Customer findById(long Id){
        try{
            return customerRepository.findCustomerById(Id);
        }
        catch (Exception e){
           e.printStackTrace();
           return null;
        }
    }
    //Batch search
    public List<Customer> findByName(String name){

        try{
            return customerRepository.findCustomerByName(name);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteCustomer(Customer customer){

        try {
            return customerRepository.deleteCustomer(customer);
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        catch (NullPointerException npe){
            npe.printStackTrace();
            return false;
        }
    }

    public boolean updateDetails(Customer customer){

        try {
            if (validation.isValidCustomer(customer)){
                customerRepository.updateCustomer(customer);
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
