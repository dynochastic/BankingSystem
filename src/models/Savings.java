package models;



public class Savings extends BankAccount{

    public Savings(int AccountNo, double balance , Customer customer) {
        super(AccountNo, balance,  customer);
    }

    //Account Creation
    public Savings(double balance , Customer customer) {
        super(balance, customer);
    }
}

