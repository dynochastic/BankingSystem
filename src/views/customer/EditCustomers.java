package views.customer;

import controller.CustomerController;
import models.Customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class EditCustomers {

    private final Scanner scanner;
    private final CustomerController controller;

    private Customer customer;

    public EditCustomers(Scanner scanner) {
        this.scanner = scanner;
        this.controller = new CustomerController();
    }

    // =========================================================
    // MAIN FLOW
    // =========================================================

    public void editCustomer() {

        findCustomer();

        if (!selectCustomer()) {
            return;
        }

        CustomerDisplayDetails.displayDetails(customer);

        int choice = getEditChoice();

        switch (choice) {
            case 1 -> editName();
            case 2 -> editSex();
            case 3 -> editBirthdate();
            case 4 -> editAddress();
            case 5 -> editContacts();
        }
    }

    // =========================================================
    // FIND CUSTOMER
    // =========================================================

    private void findCustomer() {

        System.out.print("Search Name: ");

        String name = scanner.nextLine()
                .toUpperCase()
                .strip();

        CustomerDisplayDetails.displayCustomerRows(
                controller.findByName(name)
        );
    }

    private boolean selectCustomer() {

        System.out.print("Enter the ID of the user to be edited: ");

        long customerID = scanner.nextLong();
        scanner.nextLine();

        customer = controller.findById(customerID);

        if (customer == null || customer.getCustomerID() == 0) {
            System.out.println("Customer does not exist.");
            return false;
        }

        return true;
    }

    // =========================================================
    // EDIT MENU
    // =========================================================

    private int getEditChoice() {

        System.out.println("\nWhat do you want to update?");
        System.out.println("1. Name");
        System.out.println("2. Sex");
        System.out.println("3. Birthday");
        System.out.println("4. Address Details");
        System.out.println("5. Contact Details");

        System.out.print("Select: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
    }

    // =========================================================
    // NAME
    // =========================================================

    private void editName() {

        System.out.println("\n1. First Name");
        System.out.println("2. Middle Name");
        System.out.println("3. Last Name");

        System.out.print("Select what to update: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

            case 1 -> {
                System.out.print("Enter new first name: ");
                String name = getStringInput();

                customer.setFirstName(name);
            }

            case 2 -> {
                System.out.print("Enter new middle name: ");
                String name = getStringInput();

                customer.setMiddleName(name);
            }

            case 3 -> {
                System.out.print("Enter new last name: ");
                String name = getStringInput();

                customer.setLastName(name);
            }

            default -> {
                System.out.println("Invalid selection.");
                return;
            }
        }

        saveUpdate();
    }

    // =========================================================
    // SEX
    // =========================================================

    private void editSex() {

        System.out.print("Enter new sex (M/F): ");

        char sex = scanner.nextLine()
                .toUpperCase()
                .charAt(0);

        customer.setSex(sex);

        saveUpdate();
    }

    // =========================================================
    // BIRTHDATE
    // =========================================================

    private void editBirthdate() {

        LocalDate birthDate = getBirthdate();

        customer.setBirthDate(birthDate);

        saveUpdate();
    }

    private LocalDate getBirthdate() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("MM-dd-yyyy");

        while (true) {

            try {

                System.out.print("Enter Birthdate (MM-dd-yyyy): ");

                String input = scanner.nextLine();

                return LocalDate.parse(input, formatter);

            } catch (DateTimeParseException e) {

                System.out.println(
                        "Invalid date. Please try again."
                );
            }
        }
    }

    // =========================================================
    // ADDRESS
    // =========================================================

    private void editAddress() {

        System.out.print("Enter new barangay: ");
        String brgy = getStringInput();

        System.out.print("Enter new municipality: ");
        String municipality = getStringInput();

        System.out.print("Enter new province: ");
        String province = getStringInput();

        System.out.print("Enter new country: ");
        String country = getStringInput();

        System.out.print("Enter new postal: ");
        String postal = getStringInput();

        customer.getAddress().setBrgy(brgy);
        customer.getAddress().setMunicipality(municipality);
        customer.getAddress().setProvince(province);
        customer.getAddress().setCountry(country);
        customer.getAddress().setPostal(postal);

        saveUpdate();
    }

    // =========================================================
    // CONTACT
    // =========================================================

    private void editContacts() {

        System.out.println("Please fill all the details.");

        System.out.print("Enter updated mobile number: ");
        String mobileNo = scanner.nextLine();

        System.out.print("Enter updated email address: ");
        String emailAddress = scanner.nextLine();

        System.out.print("Enter updated telephone number: ");
        String telephoneNo = scanner.nextLine();

        customer.getContact().setPhoneNumber(mobileNo);
        customer.getContact().setEmailAddress(emailAddress);
        customer.getContact().setTelNumber(telephoneNo);

        saveUpdate();
    }

    // =========================================================
    // SAVE
    // =========================================================

    private void saveUpdate() {

        if (!confirmUpdate()) {
            System.out.println("Update cancelled.");
            return;
        }

        boolean success = controller.updateDetails(customer);

        if (success) {

            System.out.println("\nCustomer updated successfully.");

            CustomerDisplayDetails.displayDetails(customer);

        } else {

            System.out.println("\nCustomer was NOT updated.");
        }
    }

    // =========================================================
    // INPUT / CONFIRMATION
    // =========================================================

    private String getStringInput() {

        return scanner.nextLine()
                .toUpperCase()
                .strip();
    }

    private boolean confirmUpdate() {

        while (true) {

            System.out.print("Confirm details? (Y/N): ");

            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("Y")) {
                return true;
            }

            if (input.equals("N")) {
                return false;
            }

            System.out.println("Please enter Y or N.");
        }
    }
}