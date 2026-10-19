package views.account;

import controller.AccountController;

import java.util.Scanner;

public class CloseAccount {

    private final Scanner scanner;
    private final AccountController controller;

    public CloseAccount(Scanner scanner ){
        controller = new AccountController();
        this.scanner = scanner;
    }

    public void closeAccount(){
        System.out.print("Enter the account number to be closed: ");
        long accountNo = scanner.nextLong();

        controller.findAccountById(accountNo);
    }
}
