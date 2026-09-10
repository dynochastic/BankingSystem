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

        displayDetails(customer);
    }

    public void searchByName() {
        System.out.print("Search Name: ");
        String name = scanner.nextLine().strip().toUpperCase();

        displayCustomerRows(controller.findByName(name));

    }

    public void displayDetails(Customer customer) {

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

    public void displayCustomerRows(List<Customer> customers) {

        // ANSI Colors
        final String RESET = "\u001B[0m";
        final String CYAN = "\u001B[36m";
        final String GREEN = "\u001B[32m";
        final String YELLOW = "\u001B[33m";
        final String GRAY = "\u001B[90m";
        final String BOLD = "\u001B[1m";

        String line = "====================================================================================================";
        String separator = "----------------------------------------------------------------------------------------------------";

        // HEADER

        System.out.println("\n" + CYAN + line + RESET);

        System.out.printf(
                CYAN + BOLD + "%-6s %-40s %-10s %-15s%n" + RESET,
                "ID",
                "FULL NAME",
                "SEX",
                "BIRTHDATE"
        );

        System.out.println(CYAN + line + RESET);

        // RECORDS

        for (Customer customer : customers) {

            String fullName = customer.getFirstName() + " "
                    + customer.getMiddleName() + " "
                    + customer.getLastName();

            String address = customer.getAddress().getBrgy() + ", "
                    + customer.getAddress().getMunicipality() + ", "
                    + customer.getAddress().getProvince() + ", "
                    + customer.getAddress().getCountry();

            // PERSONAL INFORMATION

            System.out.printf("%-6d %-40s %-10s %-15s%n",
                    customer.getCustomerID(),
                    fullName,
                    customer.getSex(),
                    customer.getBirthDate()
            );

            System.out.println();

            // CONTACT INFORMATION

            System.out.println(GREEN + BOLD + "       CONTACT INFORMATION" + RESET);

            System.out.printf(
                    GREEN + "       %-15s : " + RESET + "%s%n",
                    "MOBILE",
                    customer.getContact().getPhoneNumber()
            );

            System.out.printf(
                    GREEN + "       %-15s : " + RESET + "%s%n",
                    "TELEPHONE",
                    customer.getContact().getTelephoneNumber()
            );

            System.out.printf(
                    GREEN + "       %-15s : " + RESET + "%s%n",
                    "EMAIL",
                    customer.getContact().getEmailAddress()
            );

            System.out.println();

            // =====================================================
            // ADDRESS INFORMATION
            // =====================================================

            System.out.println(YELLOW + BOLD + "       ADDRESS INFORMATION" + RESET);

            System.out.printf(
                    YELLOW + "       %-15s : " + RESET + "%s%n",
                    "ADDRESS",
                    address
            );

            System.out.printf(
                    YELLOW + "       %-15s : " + RESET + "%s%n",
                    "POSTAL CODE",
                    customer.getAddress().getPostal()
            );

            // Customer separator
            System.out.println(GRAY + separator + RESET);
        }

        // =========================================================
        // FOOTER
        // =========================================================

        System.out.println(CYAN + line + RESET);

        System.out.println(
                CYAN + BOLD +
                        "Total Customers: " +
                        customers.size() +
                        RESET
        );
    }
}
