package views.account;

import controller.AccountController;
import models.BankAccount;
import utils.Counter;

import java.util.Scanner;

public class ManageAccountStatus {

    private final Scanner scanner;
    private final AccountController controller;
    public ManageAccountStatus(
            Scanner scanner){
        this.scanner = scanner;
        this.controller = new AccountController();
    }

    public void manageAccountStatus(){

        System.out.println("====================");
        System.out.println("1. Search Accounts");
        System.out.println("2. Freeze Account");
        System.out.println("3. Reactivate Account");
        System.out.println("4. View Account Status");

        System.out.println("====================");

        System.out.print("What would you like to do? ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option){
            case 1 -> searchAccount();
            case 2 -> freezeAccount();
            case 3 -> reactivateAccount();
            case 4 -> viewAccountStatus();
        }

    }

    public void freezeAccount() {

        BankAccount account = searchAccount();
        if (account == null) {
            return;
        }
        else if ("FROZEN".equalsIgnoreCase(account.getAccountStatus())) {
            System.out.println("Account is Already Frozen");
            return;
        }
        boolean isSuccess = controller.freezeAccount(account);

        if (isSuccess){
            System.out.println("Account No. " + account.getAccountNo() + " Successfully Frozen.");
        }
        else {
            System.out.println("Account No. " + account.getAccountNo() + " Failed to freeze.\nPleasee Try Again.");
        }
    }
    public void reactivateAccount( ){

    }
    public void viewAccountStatus( ){

        BankAccount account = searchAccount();
        AccountDisplayDetails.displayAccount(account);
    }

    public BankAccount searchAccount(){
        System.out.print("Enter the Account No: ");
        long id = scanner.nextInt();
        scanner.nextLine();

        BankAccount account = controller.findAccountById(id);
        return account;
    }

}
