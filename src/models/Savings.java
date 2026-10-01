package models;


import java.util.Date;

public class Savings extends BankAccount{

    private double interestRate;

    public Savings(int AccountNo, double initialBalance, AccountType accountType , Customer customer) {
        super(AccountNo, initialBalance, accountType,  customer);
    }

    //Account Creation
    public Savings(double initialBalance,AccountType accountType , Customer customer , double interestRate ) {
        super(initialBalance, accountType,  customer);
        this.interestRate = 0.0625;
    }

}

