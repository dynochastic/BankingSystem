package views.account;

import java.util.Scanner;

public class OpenAccount {

    private final Scanner scanner;
    private SavingsAccount savingsAccount;
    private CheckAccount checkAccount;

    public OpenAccount(Scanner scanner){

        this.scanner = scanner;
        this.savingsAccount = new SavingsAccount(scanner);
        this.checkAccount = new CheckAccount(scanner);

    }

    public void openAccount(){

        System.out.print("1. Savings Account");
        System.out.print("2. Check Account");

        System.out.print("What account would you like to open?  ");

        int accountOption = scanner.nextInt();

        switch (accountOption){
            case 1 -> savingsAccount.openSavings();
            case 2 -> checkAccount.openCheckAccount();
        }
    }

}
