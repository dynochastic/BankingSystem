package views.customer;

import controller.CustomerController;
import models.Customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class EditCustomer {

    CustomerController controller;
    private Scanner scanner;
    private Customer customer;
    EditCustomer(Scanner scanner){
        this.scanner = scanner;
        controller = new CustomerController();
    }

    public void editCustomer() {

        long customerID;
        while (true){
            System.out.println("Enter the ID of the user to be edited: ");
            customerID = scanner.nextInt();
            scanner.nextLine();

            customer = controller.findById(customerID);

            if (customer.getCustomerID() == 0 || customer == null){
                System.out.println("Customer does not exist");
                return;
            }
            CustomerDisplayDetails.displayDetails(customer);

            System.out.println("1. Name");
            System.out.println("2. Sex");
            System.out.println("3. Birthday");
            System.out.println("4. Address Details");
            System.out.println("5. Contact Details");

          System.out.print("What do you want to update? ");

            int edit = scanner.nextInt();
            scanner.nextLine();
            while(edit <= 0|| edit >= 6){
                switch (edit) {
                    case 1 -> editName();
                    case 2 -> editSex();
                    case 3 -> editBirthdate();
                    case 4 -> editAddress();
                    case 5 -> editContacts();
                    default -> System.out.println("Please try again.");
                }
            }
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
                String firstName = scanner.nextLine();
                customer.setFirstName(firstName);
                break;

            case 2:
                System.out.print("Enter new middle name: ");
                String middleName = scanner.nextLine();
                customer.setFirstName(middleName);

                break;

            case 3:
                System.out.print("Enter new last name: ");
                String lastName = scanner.nextLine();
                customer.setFirstName(lastName);
                break;

            default:
                System.out.println("Invalid selection.");
        }
    }

    public void editSex(){
        System.out.print("Enter new sex (M/F): ");
        char sex = scanner.nextLine().charAt(0);
        customer.setSex(sex);
    }

    public void editBirthdate(){
        LocalDate localdate = null;
        String birthDate = null;

        boolean isFormatted = false;
        while(!isFormatted) {
            try {
                System.out.print("Enter Birthdate (mm-dd-yyyy): ");
                birthDate = scanner.nextLine();

                //Parse from string to DateTime Format
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                localdate = LocalDate.parse(birthDate, formatter);
                customer.setBirthDate(localdate);

                // Flag to stop the loop
                isFormatted = true;
            } catch (DateTimeParseException e) {
                System.out.println("Error: Invalid date format. Please use DD-MM-YYYY.");
            }
        }
    }
    public void editAddress(){


        System.out.print("1. Brgy ");
        System.out.print("2. Municipality ");
        System.out.print("3. Province ");
        System.out.print("4. Country ");
        System.out.print("5 . Postal ");
        System.out.print("Select what to update: ");


        System.out.print("Select what to update: ");

        int address = scanner.nextInt();
        scanner.nextLine();

        switch (address) {
            case 1:
                System.out.print("Enter new barangay: ");
                String brgy = scanner.nextLine();
                customer.getAddress().setBrgy(brgy);
                controller.updateDetails(customer);
                break;

            case 2:
                System.out.print("Enter new municipality: ");
                String municipality = scanner.nextLine();
                customer.getAddress().setMunicipality(municipality);
                break;

            case 3:
                System.out.print("Enter new province: ");
                String province = scanner.nextLine();
                customer.getAddress().setProvince(province);
                break;
            case 4:
                System.out.print("Enter new country: ");
                String country = scanner.nextLine();
                customer.getAddress().setCountry(country);
                break;

            case 5:
                System.out.print("Enter new postal: ");
                String postal = scanner.nextLine();
                customer.getAddress().setMunicipality(postal);
                break;

            default:
                System.out.println("Invalid selection.");
        }
    }
    public void editContacts(){

        System.out.print("1. Mobile No. ");
        System.out.print("2. Email Address ");
        System.out.print("3. Tel No ");
        System.out.print("Select what to update: ");

        int address = scanner.nextInt();
        scanner.nextLine();
        switch (address) {
            case 1:
                System.out.print("Enter new barangay: ");
                String brgy = scanner.nextLine();
                customer.getAddress().setBrgy(brgy);
                break;

            case 2:
                System.out.print("Enter new municipality: ");
                String municipality = scanner.nextLine();
                customer.getAddress().setMunicipality(municipality);
                break;

            case 3:
                System.out.print("Enter new province: ");
                String province = scanner.nextLine();
                customer.getAddress().setProvince(province);
                break;

            default:
                System.out.println("Invalid selection.");
        }
    }
}
