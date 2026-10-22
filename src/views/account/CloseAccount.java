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
             scanner.nextLine();

             account = controller.findAccountById(accountNo);

             if (account == null){
                 System.out.println("Account No. " + accountNo + " does not exist.");
                 return;
             }

             char confirm;
             while (true) {
                 System.out.print("Confirm close account no " + account.getAccountNo() + "? (Y/N): ");
                 confirm = scanner.nextLine().trim().toLowerCase().charAt(0);

                 if (confirm == 'y' || confirm == 'n') {
                     break;
                 }
                 System.out.println("Invalid input. Please enter y or n.");
             }

             if (confirm == 'n') {
                 return;
             }

             boolean isClosed = controller.closeAccount(account);
             if (isClosed) {
                 System.out.println("Account No.: " + account.getAccountNo() +" closed");
             }
             else {
                 System.out.println("Account No.: " + account.getAccountNo() +" failed to Close. Please Try Again");
             }

        }
    }
}
