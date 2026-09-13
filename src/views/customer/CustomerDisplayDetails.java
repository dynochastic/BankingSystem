package views.customer;

import models.Customer;

import java.util.List;

public class CustomerDisplayDetails {

    public static void displayDetails(Customer customer) {

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

    public static void displayCustomerRows(List<Customer> customers) {

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

        System.out.println(CYAN + line + RESET);

        System.out.println(
                CYAN + BOLD +
                        "Total Customers: " +
                        customers.size() +
                        RESET
        );
    }
}
