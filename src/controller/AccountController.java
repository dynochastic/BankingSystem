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

    public long openChecking(CheckAccount checkAccount){
        long id;
        try {
            int product_ID = repository.findProductbyID("regular checking");
            id = repository.openCheckAccount(checkAccount, product_ID);
        }catch (SQLException e){
            e.getMessage();
            return 0;
        }
        return id;
    }

    public long openRegularSavings(Savings savings){
        long id;
        try {
            int product_ID = repository.findProductbyID("regular savings");
            id = repository.openSavingsAccount(savings, product_ID);
        }catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return id;
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

    public boolean reactivateAccount(BankAccount account){
        try{
            repository.reactivateAccount(account);
        }catch (ClosedAccountException closedAccountException){
            System.out.println(closedAccountException.getMessage());
            return false;
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            return false;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
