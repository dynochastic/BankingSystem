package views.account;

import controller.CustomerController;
import models.Customer;

import java.util.Scanner;
import views.customer.CustomerDisplayDetails;

public class OpenAccount {

    private final Scanner scanner;
    private SavingsAccount savingsAccount;
    private CheckAccountView checkAccount;
    private CustomerController controller;

    public OpenAccount(Scanner scanner){

        this.scanner = scanner;
        this.savingsAccount = new SavingsAccount(scanner);
        this.checkAccount = new CheckAccountView(scanner);
        this.controller = new CustomerController();
    }

    public void openAccount(){
        Customer customer = null;

        do {
            System.out.print("Please Enter the user ID you would like to open an Account:  ");
            int id = scanner.nextInt();
            scanner.nextLine();
            customer = controller.findById(id);

            views.customer.CustomerDisplayDetails.displayDetails(customer);

        }
        while (customer == null);

        System.out.print("Confirm details? (Y/N): ");
        char yn = scanner.nextLine().toLowerCase().charAt(0);

        if(yn == 'n'){
            return;
        }

        System.out.println("1. Savings Account");
        System.out.println("2. Check Account");

        System.out.print("What account would you like to open?  ");

        int accountOption = scanner.nextInt();
        scanner.nextLine();

        switch (accountOption){
            case 1 -> savingsAccount.openSavings(customer); // customer goes to the open savings class delegates the opening account
            case 2 -> checkAccount.openCheckAccount(customer); // customer goes to the checking view delegates the opening account
        }
    }

}
