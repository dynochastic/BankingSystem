package views.customer;

import controller.CustomerController;
import models.Customer;

import java.util.List;
import java.util.Scanner;

public class SearchCustomer {

    private Scanner scanner;
    private CustomerController controller;
    private Customer customer;

    SearchCustomer(Scanner scanner) {
        this.scanner = scanner;
        this.controller = new CustomerController();
    }

    public void searchCustomer() {

        System.out.println("============================");

        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");

        System.out.print("How would you like to search?: ");

        int search = scanner.nextInt();
        scanner.nextLine();

        switch (search) {
            case 1 -> searchByID();
            case 2 -> searchByName();
        }
    }

    public void searchByID() {
        System.out.print("Search ID: ");
        long Id = scanner.nextLong();

        customer = controller.findById(Id);

        CustomerDisplayDetails.displayDetails(customer);
    }

    public void searchByName() {
        System.out.print("Search Name: ");
        String name = scanner.nextLine().strip().toUpperCase();

        CustomerDisplayDetails.displayCustomerRows(controller.findByName(name));
    }
}
