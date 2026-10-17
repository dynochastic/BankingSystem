package models;

public class CheckAccount extends BankAccount{

    private double overDraftLimit;

    public CheckAccount(int AccountNo, double initialBalance, Customer customer){
        super(AccountNo, initialBalance, customer);
    }

    //Account Creation
    public CheckAccount(double balance,AccountType accountType , Customer customer , double overDraftLimit ) {
        super(balance,  customer);
        this.overDraftLimit = overDraftLimit;
    }

}
