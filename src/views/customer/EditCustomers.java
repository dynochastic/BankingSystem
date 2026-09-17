package views.customer;

import controller.CustomerController;
import models.Customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class EditCustomers {

    CustomerController controller;
    private final Scanner scanner;
    private Customer customer;

    EditCustomers(Scanner scanner) {
        this.scanner = scanner;
        controller = new CustomerController();
    }

    public void editCustomer() {

        long customerID;
        while (true) {
            System.out.print("Enter the ID of the user to be edited: ");
            customerID = scanner.nextInt();
            scanner.nextLine();

            customer = controller.findById(customerID);

            if (customer == null || customer.getCustomerID() == 0 ) {
                System.out.println("Customer does not exist");
                return;
            }
            CustomerDisplayDetails.displayDetails(customer);

            System.out.println("1. Name");
            System.out.println("2. Sex");
            System.out.println("3. Birthday");
            System.out.println("4. Address Details");
            System.out.println("5. Contact Details");


            int edit;
            do {
                System.out.print("What do you want to update? ");

                edit = scanner.nextInt();
                scanner.nextLine();
                switch (edit) {
                    case 1 -> editName();
                    case 2 -> editSex();
                    case 3 -> editBirthdate();
                    case 4 -> editAddress();
                    case 5 -> editContacts();
                    default -> System.out.println("Please try again.");
                }
            }
            while (edit <= 0 || edit >= 6);
        }

    }

    public void editName() {

        System.out.println("1. First Name");
        System.out.println("2. Middle Name");
        System.out.println("3. Last Name");
        System.out.print("Select what to update: ");

        int selectName = scanner.nextInt();
        scanner.nextLine();

        switch (selectName) {
            case 1:
                System.out.print("Enter new first name: ");
                String firstName = scanner.nextLine().toUpperCase().strip();
                customer.setFirstName(firstName);
                break;

            case 2:
                System.out.print("Enter new middle name: ");
                String middleName = scanner.nextLine().toUpperCase().strip();
                customer.setMiddleName(middleName);
                break;

            case 3:
                System.out.print("Enter new last name: ");
                String lastName = scanner.nextLine().toUpperCase().strip();
                customer.setLastName(lastName);

                break;

            default:
                System.out.println("Invalid selection.");
        }

        if (confirmUpdate()) {

            saveUpdatedCustomer();
            System.out.println("Name updated successfully.");

        } else  {
            System.out.println("Name updated unsuccessfully.");
        }
    }

    public void editSex() {
        System.out.print("Enter new sex (M/F): ");
        char sex = scanner.nextLine().toUpperCase().charAt(0);

        if (confirmUpdate()) {

            customer.setSex(sex);
            saveUpdatedCustomer();
            System.out.println("Sex updated successfully.");


        } else  {
            System.out.println("Sex updated unsuccessfully.");
        }
    }

    public void editBirthdate(){

        LocalDate localDate = null;

        while (localDate == null) {
            try {
                System.out.print("Enter Birthdate (MM-dd-yyyy): ");
                String birthDate = scanner.nextLine();

                DateTimeFormatter formatter =
                        DateTimeFormatter.ofPattern("MM-dd-yyyy");

                localDate = LocalDate.parse(birthDate, formatter);

            } catch (DateTimeParseException e) {
                System.out.println("Invalid date. Please try again."); }
        }

        if (confirmUpdate()){

            customer.setBirthDate(localDate);
            saveUpdatedCustomer();
            System.out.println("Birthdate updated successfully.");

        }else {
            System.out.println("Birthdate updated unsuccessfully.");
        }
    }

    public void editAddress(){

        System.out.print("Enter new barangay: ");
        String brgy = scanner.nextLine().toUpperCase().strip();

        System.out.print("Enter new municipality: ");
        String municipality = scanner.nextLine().toUpperCase().strip();

        System.out.print("Enter new province: ");
        String province = scanner.nextLine().toUpperCase().strip();

        System.out.print("Enter new country: ");
        String country = scanner.nextLine().toUpperCase().strip();

        System.out.print("Enter new postal: ");
        String postal = scanner.nextLine().toUpperCase().strip();

        if (confirmUpdate()){

            customer.getAddress().setBrgy(brgy);
            customer.getAddress().setMunicipality(municipality);
            customer.getAddress().setProvince(province);
            customer.getAddress().setCountry(country);
            customer.getAddress().setPostal(postal);

            saveUpdatedCustomer();

            System.out.println("Address was updated.");


        }else {
            System.out.println("Address was not updated.");
        }
    }

    public void editContacts(){

        System.out.println("Please fill all the details.");

        System.out.print("Enter updated mobile number: ");
        String mobileNo = scanner.nextLine();

        System.out.print("Enter updated email address: ");
        String emailAddress = scanner.nextLine();

        System.out.print("Enter updated telephone number: ");
        String telNo = scanner.nextLine();

        if (confirmUpdate()){

            customer.getContact().setPhoneNumber(mobileNo);
            customer.getContact().setEmailAddress(emailAddress);
            customer.getContact().setTelNumber(telNo);

            saveUpdatedCustomer();

            System.out.println("Contact details updated successfully.");

        } else {
            System.out.println("Contact details updated unsuccessfully.");
        }
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
    private void saveUpdatedCustomer(){

        controller.updateDetails(customer);
        CustomerDisplayDetails.displayDetails(customer);

    }
}
