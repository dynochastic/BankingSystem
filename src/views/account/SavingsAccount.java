package views.account;

import controller.AccountController;
import models.BankAccount;
import models.Customer;
import java.util.Scanner;
import models.AccountType;
import models.Savings;

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

        if (initialDeposit <= 0){
            System.out.println("Invalid Amount. Make sure its under 3000");
            return;
        }

        Savings savingsAccount = new Savings(initialDeposit, customer);
        boolean isSuccess = controller.openRegularSavings(savingsAccount);

        if (isSuccess){
            System.out.println("");
            System.out.println("\u001B[32mAccount Successfully Created.\u001B[0m");

        }
        else{
            System.out.println("\u001B[31mAccount Opening Failed. Please Try Again.\u001B[31m");

        }
    }

}
