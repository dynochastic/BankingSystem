package menu;

import services.customerServiceLogic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerService{

    private final Scanner scanner;
    private customerServiceLogic customerLogic;

    CustomerService(Scanner scanner){
        this.scanner = scanner;
        this.customerLogic = new customerServiceLogic();
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
                System.out.println("Enter Birthdate (mm-dd-yyyy): ");
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
        int postal = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\n--- User Information ---");
        System.out.println("Name: " + firstName + " " + middleName + " " + lastName);
        System.out.println("Birthdate: " + birthDate);
        System.out.println("Sex: " + sex);
        System.out.println("Address: " + brgy + ", " + municipality + ", " + province + ", " + country + " " + postal);

        System.out.print("Confirm? Y/N: ");
        char yn = scanner.nextLine().toUpperCase().charAt(0);
    }
    public void searchCustomer(){

    }
    public void deleteCustomer(){

    }
    public void editCustomer(){

    }

}
