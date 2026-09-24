package views.account;

import java.util.Scanner;

public class Accounts {

    public final Scanner scanner;

    public Accounts(Scanner scanner){
        this.scanner = scanner;
    }

    public void accountAction(){

        System.out.print("1. Open an Account");
        System.out.print("2. Close an Account");
        System.out.print("3. Check Account Balance");
        System.out.print("4. Edit an Account");

        System.out.print("What would you like to do?  ");

        int accountOption = scanner.nextInt();

        switch (accountOption){

        }
    }
}
