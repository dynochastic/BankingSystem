package repositories;

import config.DatabaseConnection;

public class AccountRepository {

    public final DatabaseConnection connectDB;

    public AccountRepository (){
        this.connectDB = new DatabaseConnection();
    }

    public void addBalance(){

    }
}
