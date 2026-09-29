package views.account;

import controller.AccountController;
import models.Customer;

import java.util.Scanner;

public class SavingsAccount {

    private final Scanner scanner;
    private final AccountController controller;
    public SavingsAccount(Scanner scanner){
        this.scanner = scanner;
        this.controller = new AccountController();
    }

    public void openSavings(Customer customer){

        System.out.print("Please enter an initial deposit (minimum: 3000): ");
        double initialDeposit = scanner.nextDouble();

        if (initialDeposit >= 0){
            controller.checkInitialDeposit(initialDeposit);

        }

    }
}
