package menu;

import models.Customer;
import models.CustomerAddress;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CustomerService{

    public Scanner scanner;
    CustomerService(Scanner scanner){
        this.scanner = scanner;
    }
    void customerMenu(){
        System.out.println("Select what you want to do");
        String[] choices = {"Add Customer", "Delete Customer", "Edit Customer Details", "Search Customer"};

    }
    void addCustomer(){

        System.out.print("Enter First name: ");
        String firstName = scanner.nextLine().toUpperCase();

        System.out.print("Enter Middle name: ");
        String middleName = scanner.nextLine().toUpperCase();

        System.out.print("Enter Last name: ");
        String lastName = scanner.nextLine().toUpperCase();

        System.out.println("Enter Birthdate (dd-MM-yyyy): ");
        String birthDate = scanner.nextLine();

        LocalDate localdate = null;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            localdate = LocalDate.parse(birthDate, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format. Please use DD-MM-YYYY.");
        }

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

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
        System.out.println("Age: " +age);
        System.out.println("Birthdate: " + birthDate);
        System.out.println("Sex: " + sex);
        System.out.println("Address: " + brgy + ", " + municipality + ", " + province + ", " + country + " " + postal);

        System.out.println("Confirm? Y/N");
        char yn = scanner.nextLine().toUpperCase().charAt(0);
        boolean isDone = true;

        while(true){
            if (yn == 'Y'){
                Customer customer = new Customer(1, firstName, middleName, lastName, localdate, sex, age);
                CustomerAddress address  = new CustomerAddress(customer, brgy, municipality, province, country, postal);
                System.out.println("Customer has been created");
                customerMenu();
                break;
            }
            else if (yn == 'N'){
                System.out.println("Returned to menu");
                customerMenu();
                break;
            }
            else{
                System.out.println("Please try again");
            }
        }


    }
    void deleteCustomer(){

    }
    void editCustomer(){

    }
    void searchCustomer(){

    }

}
