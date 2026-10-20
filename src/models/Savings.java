package models;



public class Savings extends BankAccount{

    public Savings(int AccountNo, double balance , String accountType, Customer customer) {
        super(AccountNo, balance, accountType, customer);
    }

    //Account Creation
    public Savings(double balance , Customer customer) {
        super(balance, customer);
    }

}

