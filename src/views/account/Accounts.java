package views.account;

import java.util.Scanner;
import views.account.OpenAccount;
import views.account.CloseAccount;
import views.account.EditAccount;

public class Accounts {

    private final Scanner scanner;
    private final OpenAccount openAccount;
    private final CloseAccount closeAccount;
    private final EditAccount editAccount;
    private final SearchAccount searchAccount;

    public Accounts(Scanner scanner){
        this.scanner = scanner;
        this.openAccount = new OpenAccount(scanner);
        this.closeAccount = new CloseAccount(scanner);
        this.editAccount = new EditAccount(scanner);
        this.searchAccount = new SearchAccount(scanner);
    }

    public void accountAction(){

        System.out.println("1. Open an Account");
        System.out.println("2. Search Account");
        System.out.println("3. Edit an Account");
        System.out.println("4. Close an Account");


        System.out.print("What would you like to do?  ");

        int accountOption = scanner.nextInt();
        scanner.nextLine();

        switch (accountOption){
            case 1 -> openAccount.openAccount();
            case 2 -> searchAccount.searchAccount();
            case 3 -> editAccount.editAccount();
            case 4 -> closeAccount.closeAccount();
        }
    }
}
