package controller;

import repositories.AccountRepository;

import java.sql.SQLException;

public class AccountController {

    private AccountRepository repository;
    public AccountController(){
        this.repository = new AccountRepository();
    }

    public void checkInitialDeposit(double balance){
        try {
            repository.openCheckAccount(balance);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void savingsInitialDeposit(double balance){
        try {
            repository.openSavingsAccount(balance);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
