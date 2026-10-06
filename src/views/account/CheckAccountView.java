package views.account;

import java.util.Scanner;
import controller.AccountController;
import models.AccountType;
import models.BankAccount;
import models.CheckAccount;
import models.Customer;

public class CheckAccountView {

    private final Scanner scanner;
    private AccountController controller;

    public CheckAccountView(Scanner scanner){
        this.scanner = scanner;
        this.controller = new AccountController();
    }

    public void openCheckAccount(Customer customer ){

        System.out.print("Please enter an initial deposit (minimum: 3000): ");
        double initialDeposit = scanner.nextDouble();

        if (initialDeposit <= 0){
            System.out.println("Invalid Amount");
            return;
        }


    }
}
