package menu;

import models.Customer;

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

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Sex: ");
            String sex = scanner.nextLine();

            Customer customer = new Customer(1, firstName, middleName, lastName, );
    }
    void deleteCustomer(){

    }
    void editCustomer(){

    }
    void searchCustomer(){

    }
    void displayInfo(){
        System.out.println("\n--- User Information ---");
        System.out.println("Name: " + firstName + " " + middleName + " " + lastName);
        System.out.println("Age: " + age);
        System.out.println("Sex: " + sex);
    }
}
