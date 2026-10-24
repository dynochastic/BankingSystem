package views.account;

import java.util.Scanner;
import controller.AccountController;
import models.*;

public class CheckAccountView {

    private final Scanner scanner;
    private AccountController controller;

    public CheckAccountView(Scanner scanner){
        this.scanner = scanner;
        this.controller = new AccountController();
    }

    public void openCheckAccount(Customer customer){

        System.out.print("Please enter an initial deposit (minimum: 10000): ");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine();

        if (initialDeposit < 10000) {
            System.out.println("Invalid Amount. Must be at least: 10000");
            return;
        }

        CheckAccount checkAccount = new CheckAccount(initialDeposit, customer);
        long id = controller.openChecking(checkAccount);

        if (id == 0){
            System.out.println("\u001B[31mAccount Opening Failed. Please Try Again.\u001B[31m");
        }
        else{
            System.out.println("\u001B[32mAccount NO. "+ id + " Successfully Created.\u001B[0m"); //To add to the Account display
        }
    }
}
