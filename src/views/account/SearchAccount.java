package views.account;

import controller.AccountController;
import models.BankAccount;

import java.util.Scanner;

public class SearchAccount {

    private final Scanner scanner;
    private final AccountController controller;

    public SearchAccount(Scanner scanner){
        this.scanner = scanner;
        this.controller = new AccountController();
    }

    public void searchAccount(){

        int accountId;
        BankAccount account;

        System.out.print("Enter Account ID: ");
        accountId= scanner.nextInt();
        scanner.nextLine();

        account = controller.findAccountById(accountId);

        if (account == null){
            System.out.println("Account ID " + accountId + " does not exist.");
        }
        else {
            AccountDisplayDetails.displayAccount(account);
        }
    }
}
