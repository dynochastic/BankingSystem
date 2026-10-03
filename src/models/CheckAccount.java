package models;

public class CheckAccount extends BankAccount{

    private double overDraftLimit;

    public CheckAccount(int AccountNo, double initialBalance, AccountType accountType, Customer customer){
        super(AccountNo, initialBalance, accountType, customer);
    }

    //Account Creation
    public CheckAccount(double balance,AccountType accountType , Customer customer , double overDraftLimit ) {
        super(balance, accountType,  customer);
        this.overDraftLimit = overDraftLimit;
    }

}
