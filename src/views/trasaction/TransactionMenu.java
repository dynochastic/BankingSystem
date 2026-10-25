package views.trasaction;

import controller.AccountController;
import models.BankAccount;

import java.util.Scanner;

public class TransactionMenu {

    private final Withdraw withdraw;
    private final Transfer transfer;
    private final BalanceInquiry balanceInquiry;
    private final Deposit deposit;
    private final  AccountController controller;

    private Scanner scanner;
    public TransactionMenu(Scanner scanner){
        this.scanner = scanner;
        this.withdraw = new Withdraw(scanner);
        this.transfer = new Transfer(scanner);
        this.balanceInquiry = new BalanceInquiry(scanner);
        this.deposit = new Deposit(scanner);
        this.controller = new AccountController();

    }

    public void transactionMenu(){


        System.out.println("============================");
        BankAccount account = searchAccount();
        if (account == null || "CLOSED".equalsIgnoreCase(account.getAccountStatus())){
            System.out.println("Account Does Not Exist.");
            return;
        }
        else if ("FROZEN".equalsIgnoreCase(account.getAccountStatus())){
            System.out.println("Account is Currently Frozen");
            return;
        }
        System.out.println("============================");

        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Balance Inquiry");
        System.out.println("5. Back");


        System.out.print("How would you like to do?: ");
        int option = scanner.nextInt();

        switch (option){
            case 1 -> withdraw.withdraw(account);
            case 2 -> deposit.deposit(account);
            case 3 -> transfer.transfer(account);
            case 4 -> balanceInquiry.balanceInquiry(account);
            case 5 -> {
                return;
            }
            default -> System.out.println("Please choose from the option");
        }
    }
    public BankAccount searchAccount(){
        System.out.print("Enter the Account No: ");
        long id = scanner.nextInt();
        scanner.nextLine();

        BankAccount account = controller.findAccountById(id);
        return account;

    }
}
