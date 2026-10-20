package views.account;

import controller.AccountController;
import models.BankAccount;

import java.util.Scanner;

public class CloseAccount {

    private final Scanner scanner;
    private final AccountController controller;

    public CloseAccount(Scanner scanner ){
        controller = new AccountController();
        this.scanner = scanner;
    }

    public void closeAccount(){

        BankAccount account = null;

         while (account == null){

             System.out.print("Enter the account number to be closed: ");
             long accountNo = scanner.nextLong();

             account = controller.findAccountById(accountNo);

             if (account == null){
                 System.out.println("Account No. " + account + " does not exist.");
             }
        }
    }
}
