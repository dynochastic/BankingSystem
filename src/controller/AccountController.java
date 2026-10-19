package controller;

import models.BankAccount;
import models.CheckAccount;
import models.Savings;
import repositories.AccountRepository;

import java.sql.SQLException;

public class AccountController {

    private AccountRepository repository;
    public AccountController(){
        this.repository = new AccountRepository();
    }

    public boolean openChecking(CheckAccount checkAccount){
        try {
            int product_ID = repository.findProductbyID("regular checking");
            repository.openCheckAccount(checkAccount, product_ID);
        }catch (SQLException e){
            e.printStackTrace();
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

    public long findAccountById(long id){
        try{
            repository.findByAccountId(id);
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
