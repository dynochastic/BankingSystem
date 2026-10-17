package controller;

import models.BankAccount;
import models.Savings;
import repositories.AccountRepository;

import java.sql.SQLException;

public class AccountController {

    private AccountRepository repository;
    public AccountController(){
        this.repository = new AccountRepository();
    }

    public void openChecking(double balance){
        try {
            repository.openCheckAccount(balance);
        }catch (SQLException e){
            e.printStackTrace();
        }
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


}
