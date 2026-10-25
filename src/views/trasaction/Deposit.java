package views.trasaction;

import controller.TransactionController;
import models.BankAccount;

import java.util.Scanner;

public class Deposit {

    private Scanner scanner;
    private TransactionController controller;
    public Deposit(Scanner scanner){
        this.scanner = scanner;
        this.controller = new TransactionController();

    }
    public void deposit(BankAccount account){
        System.out.print("Enter Amount to Deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount < 500){
            System.out.print(" Please Try Again. Minimum Deposit: 500.");
            return;
        }
        boolean isSuccess = controller.deposit(account, amount);

        if(isSuccess){
            System.out.print("PHP "+amount+ " Successfully Deposited. New Balance: PHP" + account.getBalance());
        }
        else{
            System.out.print("Deposit Failed. Please Try Again");

        }
    }
}
