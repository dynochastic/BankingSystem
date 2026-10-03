package models;


import java.util.Date;

public class Savings extends BankAccount{

    private double interestRate;

    public Savings(int AccountNo, double balance, AccountType accountType , Customer customer) {
        super(AccountNo, balance, accountType,  customer);
    }

    //Account Creation
    public Savings(double balance,AccountType accountType , Customer customer , double interestRate ) {
        super(balance, accountType,  customer);
        this.interestRate = interestRate;
    }

}

