package controller;

import models.Customer;
import models.CustomerAddress;
import models.ContactDetails;

import repositories.CustomerRepository;
import validators.customerValidate;

public class CustomerController {

    private customerValidate validation;
    private CustomerRepository customerRepository;

    public  void registerCustomer(Customer customer){
        if (validation.isValidCustomer(customer)){

            customerRepository.createCustomer(customer);

            // All customer information is valid
            System.out.println("Customer is ADDED.");

        } else {
            // At least one field is invalid
            System.out.println("Customer information is invalid.");
            return;
        }
    }
}
