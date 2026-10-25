package views.trasaction;

import controller.AccountController;
import controller.TransactionController;
import models.BankAccount;

import java.util.Scanner;

public class Withdraw {

    private TransactionController controller;
    private Scanner scanner;
    public Withdraw(Scanner scanner){
        this.scanner = scanner;
        this.controller = new TransactionController();
    }

    public void withdraw(BankAccount account){
        System.out.print("Enter Amount to Withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount < 500){
            System.out.print(" Please Try Again. Minimum Withdrawal: 500.");
            return;
        }
        boolean isSuccess = controller.withdraw(account, amount);

        if(isSuccess){
            System.out.print( amount+ "Successfully withdrawn. New Balance: PHP" + account.getBalance());
        }
        else{
            System.out.print("Withdraw Failed. Please Try Again");

        }
    }
}
