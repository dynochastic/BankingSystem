package menu;

import controller.CustomerController;
import models.ContactDetails;
import models.Customer;
import models.CustomerAddress;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerService{

    private final Scanner scanner;
    private Customer customer;
    private CustomerAddress address;
    private ContactDetails contacts;
    private CustomerController controller;

    CustomerService(Scanner scanner){
        this.scanner = scanner;
        controller = new CustomerController();

    }

    public void customerMenu(){
        System.out.println("Select what you want to do.");
        System.out.println("1. Add Customer");
        System.out.println("2. Delete Customer");
        System.out.println("3. Edit Customer Details");
        System.out.println("4. Search Customer");

        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        try{
            switch (option) {
                case 1:
                    addCustomerDetails();
                    break;
                case 2:
                    deleteCustomer();
                    break;
                case 3:
                    editCustomer();
                    break;
                case 4:
                    searchCustomer();
                    break;
                default:
                    System.out.println("Option Invalid.");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Please try again");
            scanner.nextLine();
        }
    }
    public void addCustomerDetails() {
        System.out.print("Enter First name: ");
        String firstName = scanner.nextLine().toUpperCase();

        System.out.print("Enter Middle name: ");
        String middleName = scanner.nextLine().toUpperCase();

        System.out.print("Enter Last name: ");
        String lastName = scanner.nextLine().toUpperCase();


        LocalDate localdate = null;
        String birthDate = null;

        boolean isFormatted = false;
        while(!isFormatted){
            try {
                System.out.print("Enter Birthdate (mm-dd-yyyy): ");
                birthDate = scanner.nextLine();

                //Parse from string to DateTime Format
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                localdate = LocalDate.parse(birthDate, formatter);

                // Flag to stop the loop
                isFormatted = true;
            } catch (DateTimeParseException e) {
                System.out.println("Error: Invalid date format. Please use DD-MM-YYYY.");
            }
        }

        System.out.print("Enter Sex (F/M): ");
        char sex = Character.toUpperCase(scanner.nextLine().charAt(0));

        System.out.print("Enter Barangay: ");
        String brgy = scanner.nextLine().toUpperCase();

        System.out.print("Enter Municipality/City: ");
        String municipality = scanner.nextLine().toUpperCase();

        System.out.print("Enter Province: ");
        String province = scanner.nextLine().toUpperCase();

        System.out.print("Enter Country: ");
        String country = scanner.nextLine().toUpperCase();

        System.out.print("Enter Postal Code: ");
        String postal = scanner.nextLine();

        System.out.print("Enter Mobile Number Code: ");
        String mobileNo = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Telephone Number: ");
        String telNo = scanner.nextLine();

        System.out.println("\n========================================");
        System.out.println("          CUSTOMER INFORMATION          ");
        System.out.println("========================================");

        System.out.println("\n--- Personal Information ---");
        System.out.println("Full Name       : " + firstName + " " + middleName + " " + lastName);
        System.out.println("Birthdate       : " + birthDate);
        System.out.println("Sex             : " + sex);

        System.out.println("\n--- Contact Information ---");
        System.out.println("Mobile Number   : " + mobileNo);
        System.out.println("Telephone No.   : " + telNo);
        System.out.println("Email Address   : " + email);

        System.out.println("\n--- Address Information ---");
        System.out.println("Barangay        : " + brgy);
        System.out.println("Municipality    : " + municipality);
        System.out.println("Province        : " + province);
        System.out.println("Country         : " + country);
        System.out.println("Postal Code     : " + postal);

        System.out.println("\n========================================");
        System.out.println("Please review the information above.");

        System.out.print("Confirm customer information? (Y/N): ");

        System.out.print("Confirm? Y/N: ");
        char yn = scanner.nextLine().toUpperCase().charAt(0);

        if (yn == 'Y'){
            this.address = new CustomerAddress(brgy, municipality,province,country, postal);
            this.contacts = new ContactDetails(mobileNo, email, telNo);
            this.customer = new Customer(firstName, middleName, lastName, localdate, sex, address, contacts);


            controller.registerCustomer(customer);
        }
    }
    public void searchCustomer(){

    }
    public void deleteCustomer(){

    }
    public void editCustomer(){

        System.out.print("What do you want to change?");
        System.out.print("1. Name");
        System.out.print("2. Birthday");
        System.out.print("3. Sex");

        int edit = scanner.nextInt();
        scanner.nextLine();

    }

}
