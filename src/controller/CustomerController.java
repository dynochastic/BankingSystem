package controller;

import models.Customer;
import models.CustomerAddress;
import models.ContactDetails;

import repositories.CustomerRepository;
import validators.customerValidate;

public class CustomerController {

    private customerValidate validation;
    private CustomerRepository customerRepository;
    public
    CustomerController(){
        this.validation = new customerValidate();
        this.customerRepository = new CustomerRepository();
    }

    public void registerCustomer(Customer customer){
        try{
            if (validation.isValidCustomer(customer)){

                customerRepository.createCustomer(customer);

                // All customer information is valid
                System.out.println("Controller: Customer is ADDED.");

            } else {
                // At least one field is invalid
                System.out.println("Customer information is invalid.");

            }
        }catch (Exception e){
            e.printStackTrace();

        }

    }

    public void updateCustomer(Customer customer){


        try{
        }
        catch (Exception e){
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }
}
