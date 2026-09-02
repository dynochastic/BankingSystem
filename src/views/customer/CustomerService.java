package views.customer;

import controller.CustomerController;
import models.ContactDetails;
import models.Customer;
import models.CustomerAddress;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerService{

    private final Scanner scanner;

    private CreateCustomer createCustomer;
    private EditCustomer editCustomer;
    private SearchCustomer searchCustomer;
    private DeleteCustomer deleteCustomer;

    CustomerService(Scanner scanner){
        this.scanner = scanner;
        this.createCustomer = new CreateCustomer(scanner);
        this.editCustomer = new EditCustomer(scanner);
        this.searchCustomer = new SearchCustomer(scanner);
        this.deleteCustomer = new DeleteCustomer(scanner);
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
                case 1 -> createCustomer.addCustomerDetails();
                case 2 -> deleteCustomer.deleteCustomer();
                case 3 -> editCustomer.editCustomer();
                case 4 -> searchCustomer.searchCustomer();
                default -> System.out.println("Option Invalid.");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Please try again");
            scanner.nextLine();
        }
    }

}
