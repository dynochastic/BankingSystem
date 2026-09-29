package views.account;

import java.util.Scanner;
import controller.AccountController;
import models.Customer;

public class CheckAccount {

    private final Scanner scanner;
    private AccountController controller;
    public CheckAccount(Scanner scanner){

        this.scanner = scanner;
        this.controller = new AccountController();
    }

    public void openCheckAccount(Customer customer  ){

        System.out.print("Please enter an initial deposit (minimum: 3000): ");
        int initialDeposit = scanner.nextInt();

        controller.checkInitialDeposit(initialDeposit);

    }
}
