package views.account;

import controller.AccountController;

import java.util.Scanner;

public class SavingsAccount {

    private final Scanner scanner;
    private AccountController controller;
    public SavingsAccount(Scanner scanner){
        this.scanner = scanner;
        this.controller = new AccountController();
    }

    public void openSavings(int id){

        System.out.print("Please enter an initial deposit (minimum: 3000): ");
        int initialDeposit = scanner.nextInt();

        controller.addBalance(initialDeposit);

    }
}
