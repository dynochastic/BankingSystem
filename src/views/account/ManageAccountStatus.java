package views.account;

import controller.AccountController;
import models.BankAccount;
import java.util.Scanner;

public class ManageAccountStatus {

    private final Scanner scanner;
    private final AccountController controller;
    public ManageAccountStatus(Scanner scanner){
        this.scanner = scanner;
        this.controller = new AccountController();
    }

    public void manageAccountStatus(){

        System.out.println("====================");
        System.out.println("1. Freeze Account");
        System.out.println("2. Reactivate Account");
        System.out.println("3. View Account Status");
        System.out.println("4. Back");

        System.out.println("====================");

        System.out.print("What would you like to do? ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option){
            case 1 -> freezeAccount();
            case 2 -> reactivateAccount();
            case 3 -> viewAccountStatus();
            case 4 -> {
                return;
            }
            default -> System.out.println("Invalid option. Please choose between 1 and 4.");

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
            System.out.println("Account No. " + account.getAccountNo() + " Failed to freeze.\nPlease Try Again.");
        }
    }
    public void reactivateAccount( ){

        BankAccount account = searchAccount();
        if (account == null) {
            return;
        } else if ("ACTIVE".equalsIgnoreCase(account.getAccountStatus())) {
            System.out.println("Account is Already Active");
            return;
        }

        boolean isSuccess = controller.reactivateAccount(account);
        if (isSuccess){
            System.out.println("Account No. " + account.getAccountNo() + " Successfully reactivated.");
        }
        else {
            System.out.println("Account No. " + account.getAccountNo() + " Failed to reativate.\nPlease Try Again.");
        }
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
