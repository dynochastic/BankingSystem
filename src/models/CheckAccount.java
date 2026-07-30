package models;

public class CheckAccount extends BankAccount{
    private double overDraftLimit;

    CheckAccount(String AccountNo, double initialBalance, Customer customer){
        super(AccountNo, initialBalance, customer);
    }
}
