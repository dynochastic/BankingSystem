package views;

import views.customer.CustomerService;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Menu {
    private final Scanner scanner;
    private final CustomerService custAction;
    public Menu(Scanner scanner){
        this.scanner = scanner;
        custAction = new CustomerService(scanner);


    }
    public void startBank() {

        System.out.println("======================================");
        System.out.println("        WELCOME TO SYSTEM BANK");
        System.out.println("======================================");
        System.out.println("    Your trusted partner in banking.  ");
        System.out.println("======================================");

        while (true){
            System.out.println("======================================");

            System.out.println("1. Customer");
            System.out.println("2. Account");
            System.out.println("3. Transaction");
            System.out.println("4. Balance Inquiry");

            System.out.println("======================================");

            System.out.print("Please select an option using the numbers provided above: ");
            int option = scanner.nextInt();

            scanner.nextLine();
            try{
                switch (option) {
                    case 1 -> {
                        custAction.customerMenu();
                        break;
                    }
                    case 2 -> custAction.customerMenu();
                    case 3 -> custAction.customerMenu();
                    case 4 -> custAction.customerMenu();
                    default -> System.out.println("\u001B[31mOption Invalid.\u001B[0m");

                }
            }
            catch (InputMismatchException e){
                System.out.println("Please try again");
                scanner.nextLine();
            }
        }

    }

}
