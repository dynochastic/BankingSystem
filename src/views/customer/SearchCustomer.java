package views.customer;

import controller.CustomerController;
import models.Customer;

import java.util.Scanner;

public class SearchCustomer {

    private Scanner scanner;
    private CustomerController controller;
    private Customer customer;

    SearchCustomer(Scanner scanner){
        this.scanner = scanner;
        this.controller = new CustomerController();
    }

    public void searchCustomer(){

        System.out.println("============================");

        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");

        System.out.print("How would you like to search?: ");

        int search = scanner.nextInt();
        scanner.nextLine();

        switch (search){
            case 1 -> searchByID();
            case 2 -> searchByName();
        }


    }

    public void searchByID(){
        System.out.print("Search ID: ");
        long Id = scanner.nextLong();

        customer = controller.findById(Id);

        displayDetails(customer);
    }

    public void searchByName(){
        System.out.print("Search Name: ");
        String name = scanner.nextLine().strip();

    }

    public void displayDetails(Customer customer){

        System.out.println("\n========================================");
        System.out.println("          CUSTOMER INFORMATION          ");
        System.out.println("========================================");

        System.out.println("\n--- Personal Information ---");

        System.out.println("Full Name       : "
                + customer.getFirstName() + " "
                + customer.getMiddleName() + " "
                + customer.getLastName());

        System.out.println("Birthdate       : " + customer.getBirthDate());
        System.out.println("Sex             : " + customer.getSex());

        System.out.println("\n--- Contact Information ---");

        System.out.println("Mobile Number   : "
                + customer.getContact().getPhoneNumber());

        System.out.println("Telephone No.   : "
                + customer.getContact().getTelephoneNumber());

        System.out.println("Email Address   : "
                + customer.getContact().getEmailAddress());

        System.out.println("\n--- Address Information ---");

        System.out.println("Barangay        : "
                + customer.getAddress().getBrgy());

        System.out.println("Municipality    : "
                + customer.getAddress().getMunicipality());

        System.out.println("Province        : "
                + customer.getAddress().getProvince());

        System.out.println("Country         : "
                + customer.getAddress().getCountry());

        System.out.println("Postal Code     : "
                + customer.getAddress().getPostal());

        System.out.println("\n========================================");
    }
}
