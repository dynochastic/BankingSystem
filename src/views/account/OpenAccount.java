package views.account;

import controller.CustomerController;
import models.Customer;

import java.util.Scanner;

public class OpenAccount {

    private final Scanner scanner;
    private SavingsAccount savingsAccount;
    private CheckAccount checkAccount;
    private CustomerController controller;

    public OpenAccount(Scanner scanner){

        this.scanner = scanner;
        this.savingsAccount = new SavingsAccount(scanner);
        this.checkAccount = new CheckAccount(scanner);
        this.controller = new CustomerController();
    }

    public void openAccount(){

        System.out.print("Please Enter the user ID you would like to open an ");

        int id = scanner.nextInt();
        Customer customer = controller.findById(id);

        System.out.print("1. Savings Account");
        System.out.print("2. Check Account");

        System.out.print("What account would you like to open?  ");

        int accountOption = scanner.nextInt();
        scanner.nextLine();

        switch (accountOption){
            case 1 -> savingsAccount.openSavings(customer); // customer goes to the open savings class delegates the opening account
            case 2 -> checkAccount.openCheckAccount(customer); // customer goes to the checking view delegates the opening account
        }
    }

}
