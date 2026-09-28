package views.account;

import java.util.Scanner;
import controller.AccountController;
public class CheckAccount {

    private final Scanner scanner;
    private AccountController controller;
    public CheckAccount(Scanner scanner){

        this.scanner = scanner;
        this.controller = new AccountController();
    }

    public void openCheckAccount(int id){

        System.out.print("Please enter an initial deposit (minimum: 3000): ");
        int initialDeposit = scanner.nextInt();

        controller.addBalance(initialDeposit);

    }
}
