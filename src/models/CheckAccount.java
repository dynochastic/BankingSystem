package models;

public class CheckAccount extends BankAccount{

    public CheckAccount(int AccountNo, double initialBalance, String accountType, String accountStatus , Customer customer){
        super(AccountNo, initialBalance, accountType, accountStatus ,customer);
    }

    //Account Creation
    public CheckAccount(double balance, Customer customer  ) {
        super(balance, customer);
    }

}
