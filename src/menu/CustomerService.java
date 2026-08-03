package menu;

import models.Customer;

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
        String firstName = scanner.nextLine();

        System.out.print("Enter Middle name: ");
        String middleName = scanner.nextLine();

        System.out.print("Enter Last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter Birthdate dd-mm-yyyy: ");
        String birthDate = scanner.nextLine();
        LocalDate localdate = null;

        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            localdate = LocalDate.parse(birthDate, formatter);
        }
        catch (DateTimeParseException e){
            System.out.println("Error: Invalid date format. Please use DD-MM-YYYY." + e);
        }

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Sex: F/M");
        char sex = scanner.nextLine().charAt(0);

        Customer customer = new Customer(1, firstName, middleName, lastName, localdate, sex, age);


    }
    void deleteCustomer(){

    }
    void editCustomer(){

    }
    void searchCustomer(){

    }

}
