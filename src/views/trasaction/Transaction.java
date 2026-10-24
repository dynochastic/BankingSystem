package views.trasaction;

import java.util.Scanner;

public class Transaction {

    private final Withdraw withdraw;
    private final Transfer transfer;
    private final BalanceInquiry balanceInquiry;
    private final Deposit deposit;
    private Scanner scanner;
    public Transaction(Scanner scanner){
        this.scanner = scanner;
        this.withdraw = new Withdraw(scanner);
        this.transfer = new Transfer(scanner);
        this.balanceInquiry = new BalanceInquiry(scanner);
        this.deposit = new Deposit(scanner);

    }

    public void transactionMenu(){

        System.out.println("============================");

        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Balance Inquiry");
        System.out.println("5. Back");


        System.out.print("How would you like to do?: ");
        int option = scanner.nextInt();

        switch (option){
            case 1 -> withdraw.withdraw();
            case 2 -> deposit.deposit();
            case 3 -> transfer.transfer();
            case 4 -> balanceInquiry.balanceInquiry();
            case 5 -> {
                return;
            }
            default -> System.out.println("Please choose from the option");
        }
    }

}
