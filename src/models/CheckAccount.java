package models;

public class CheckAccount extends BankAccount{

    public CheckAccount(int AccountNo, double initialBalance, String accountType, Customer customer){
        super(AccountNo, initialBalance, accountType,  customer);
    }

    //Account Creation
    public CheckAccount(double balance, Customer customer  ) {
        super(balance, customer);
    }

}
