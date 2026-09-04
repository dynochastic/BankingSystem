package views.customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class EditCustomer {

    private Scanner scanner;
    EditCustomer(Scanner scanner){
        this.scanner = scanner;
    }

    public void editCustomer() {

        int customerID = scanner.nextInt();
        scanner.nextLine();


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
                // update first name here
                break;

            case 2:
                System.out.print("Enter new middle name: ");
                String middleName = scanner.nextLine();
                // update middle name here
                break;

            case 3:
                System.out.print("Enter new last name: ");
                String lastName = scanner.nextLine();
                // update last name here
                break;

            default:
                System.out.println("Invalid selection.");
        }
    }
    public void editSex(){
        System.out.print("Enter new sex (M/F): ");
        char sex = scanner.nextLine().charAt(0);
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

                // Flag to stop the loop
                isFormatted = true;
            } catch (DateTimeParseException e) {
                System.out.println("Error: Invalid date format. Please use DD-MM-YYYY.");
            }
        }
    }
    public void editAddress(){

    }
    public void editContacts(){

    }
}
