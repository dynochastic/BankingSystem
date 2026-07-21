package Bank;

public class BankAccount {
     private int AccountNumber;
     private double Balance;

    BankAccount(int AccountNumber, double Balance){
        this.AccountNumber = AccountNumber;
        this.Balance = Balance;
    }
    BankAccount(){
        this.AccountNumber = 0;
        this.Balance = 0;
    }
    void setBalance(double Balance){
        this.Balance = Balance;
    }

    double getBalance(){
        return Balance;
    }

    int getAccountNumber(){ return AccountNumber;}

    void withdraw(int amount){
        Balance -= amount;
    }
    void deposit(int amount){
        Balance += amount;
    }

}
