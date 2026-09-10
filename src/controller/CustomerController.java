package controller;

import models.Customer;

import repositories.CustomerRepository;
import validators.CustomerValidator;

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

    public Customer findById(long Id){
        try{
            return customerRepository.findCustomerById(Id);
        }
        catch (Exception e){
           e.printStackTrace();
           return null;
        }
    }
    public List<Customer> findByName(String name){

        try{
            return customerRepository.findCustomerByName(name);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
