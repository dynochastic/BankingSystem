package views.trasaction;

import controller.AccountController;
import controller.TransactionController;
import models.BankAccount;

import java.util.Scanner;

public class Transfer {

    private AccountController controller;
    private TransactionController transactionController;
    private Scanner scanner;
    public Transfer(Scanner scanner){
        this.scanner = scanner;
        this.controller = new AccountController();
        this.transactionController = new TransactionController();

    }

    public void transfer(BankAccount senderAccnt){
        System.out.println("Enter The Account Number of Recipient: ");
        int account_number = scanner.nextInt();
        scanner.nextLine();

        BankAccount recipientAccount = controller.findAccountById(account_number);

        if (recipientAccount == null || "CLOSED".equalsIgnoreCase(recipientAccount .getAccountStatus())){
            System.out.println("Account Does Not Exist.");
            return;
        }
        else if ("FROZEN".equalsIgnoreCase(recipientAccount.getAccountStatus())){
            System.out.println("Account is Currently Frozen. Please Try Again");
            return;
        }

        System.out.println("Enter Amount to Transfer: ");
        double amount = scanner.nextInt();
        scanner.nextLine();

        boolean success = transactionController.transfer(senderAccnt, recipientAccount , amount);

        if (success) {
            System.out.println("\nTransfer completed successfully!");
            System.out.printf("Amount Transferred: PHP %.2f%n", amount);
            System.out.printf("Sender's Updated Balance: PHP %.2f%n", senderAccnt.getBalance());
        } else {
            System.out.println("\nTransfer failed. Please try again.");
        }

    }
}
