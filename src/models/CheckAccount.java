package models;

public class CheckAccount extends BankAccount{

    public CheckAccount(int AccountNo, double initialBalance, Customer customer){
        super(AccountNo, initialBalance, customer);
    }

    public CheckAccount(int AccountNo, double balance) {
        super(AccountNo, balance);
    }

    //Account Creation
    public CheckAccount(double balance, Customer customer  ) {
        super(balance, customer);
    }

}
