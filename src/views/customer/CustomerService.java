package views.customer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerService{

    private final Scanner scanner;

    private CreateCustomer createCustomer;
    private EditCustomer editCustomer;
    private SearchCustomer searchCustomer;
    private DeleteCustomer deleteCustomer;

    public CustomerService(Scanner scanner){
        this.scanner = scanner;
        this.createCustomer = new CreateCustomer(scanner);
        this.editCustomer = new EditCustomer(scanner);
        this.searchCustomer = new SearchCustomer(scanner);
        this.deleteCustomer = new DeleteCustomer(scanner);
    }

    public void customerMenu(){


        while (true){
            try{
                System.out.println("Select what you want to do.");
                System.out.println("1. Add Customer");
                System.out.println("2. Search Customer");
                System.out.println("3. Edit Customer Details");
                System.out.println("4. Delete Customer");
                System.out.println("5. Back");

                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                case 1 -> {
                    createCustomer.addCustomerDetails();
                    break;
                }
                    case 2 -> searchCustomer.searchCustomer();
                    case 3 -> editCustomer.editCustomer();
                    case 4 -> deleteCustomer.deleteCustomer();
                    case 5 -> {
                        return ;
                    }
                    default -> System.out.println("\u001B[31mOption Invalid.\u001B[0m");
                }
            }
            catch (InputMismatchException e){
                System.out.println("\u001B[31mPlease try again.\u001B[0m");
                scanner.nextLine();
            }
        }

    }

}
