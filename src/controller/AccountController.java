package controller;

import models.BankAccount;
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

    public void openSavings(BankAccount bankAccount){
        try {
            repository.openSavingsAccount(bankAccount);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
