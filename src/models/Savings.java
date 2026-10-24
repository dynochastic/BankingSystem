package models;



public class Savings extends BankAccount{

    public Savings(int AccountNo, double balance , String accountType, String accountStatus, Customer customer) {
        super(AccountNo, balance, accountType, accountStatus, customer);
    }

    //Account Creation
    public Savings(double balance , Customer customer) {
        super(balance, customer);
    }

}

