package views.account;

import java.util.Scanner;
import views.account.OpenAccount;
import views.account.CloseAccount;
import views.account.EditAccount;

public class Accounts {

    private final Scanner scanner;
    private OpenAccount openAccount;
    private CloseAccount closeAccount;
    private EditAccount editAccount;


    public Accounts(Scanner scanner){
        this.scanner = scanner;
        this.openAccount = new OpenAccount(scanner);
        this.closeAccount = new CloseAccount(scanner);
        this.editAccount = new EditAccount(scanner);
    }

    public void accountAction(){

        System.out.print("1. Open an Account");
        System.out.print("2. Close an Account");
        System.out.print("3. Edit an Account");

        System.out.print("What would you like to do?  ");

        int accountOption = scanner.nextInt();
        scanner.nextLine();

        switch (accountOption){
            case 1 -> openAccount.openAccount();
            case 2 -> closeAccount.closeAccount();
            case 3 -> editAccount.editAccount();
        }
    }
}
