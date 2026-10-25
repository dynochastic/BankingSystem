package controller;

import exceptions.InsufficientBalanceException;
import models.BankAccount;
import repositories.AccountRepository;
import repositories.TransactionRepository;

import java.sql.SQLException;

public class TransactionController {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionController(){
        this.transactionRepository = new TransactionRepository();
        this.accountRepository = new AccountRepository();
    }

    public boolean withdraw(BankAccount account , double amount){
        try{
            return transactionRepository.withdraw(account, amount);
        }catch (SQLException sqlException){
            sqlException.getMessage();
            return false;
        }
        catch (InsufficientBalanceException insufficientBalanceException){
            insufficientBalanceException.getMessage();
            return false;
        }
        catch (IllegalArgumentException illegalArgumentException){
            illegalArgumentException.getMessage();
            return false;
        }
    }
    public boolean deposit(BankAccount account, double amount){
        try{
            return transactionRepository.deposit(account, amount);
        }catch (SQLException sqlException){
            sqlException.getMessage();
            return false;

        }catch (InsufficientBalanceException insufficientBalanceException) {
            insufficientBalanceException.getMessage();
            return false;
        }
        catch (IllegalArgumentException illegalArgumentException){
            illegalArgumentException.getMessage();
            return false;
        }
    }
    public void transfer(BankAccount account){

    }
    public void balanceInquiry(BankAccount account){

    }

}
