package models;

public class Savings extends BankAccount{

    private double interestRate;

    Savings(String AccountNo, double initialBalance, Customer customer) {
        super(AccountNo, initialBalance, customer);
    }
}

