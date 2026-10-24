package controller;

import exceptions.ClosedAccountException;
import exceptions.FrozenAccountException;
import exceptions.NonZeroBalanceException;
import models.BankAccount;
import models.CheckAccount;
import models.Savings;
import repositories.AccountRepository;

import java.sql.SQLException;

public class AccountController {

    private final AccountRepository repository;
    public AccountController(){
        this.repository = new AccountRepository();
    }

    public boolean openChecking(CheckAccount checkAccount){
        try {
            int product_ID = repository.findProductbyID("regular checking");
            repository.openCheckAccount(checkAccount, product_ID);

        }catch (SQLException e){
            return false;
        }
        return true;

    }

    public boolean openRegularSavings(Savings savings){

        try {
            int product_ID = repository.findProductbyID("regular savings");
            repository.openSavingsAccount(savings, product_ID);
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public BankAccount findAccountById(long id){
        try{
            return repository.findByAccountId(id);
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            return null;
        }
    }

    public boolean closeAccount(BankAccount account){
        try{
            repository.closeAccount(account);
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
            return false;
        }
        catch (NonZeroBalanceException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public boolean freezeAccount(BankAccount account){
        try{
           repository.freezeAccount(account);
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            return false;
        }
        catch (ClosedAccountException closedAccountException){
            System.out.println(closedAccountException.getMessage());
            return false;
        }
        catch (FrozenAccountException frozenAccountException){
            System.out.println(frozenAccountException.getMessage());
            return false;
        }
        return true;
    }
}
