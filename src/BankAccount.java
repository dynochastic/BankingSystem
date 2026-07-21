public class BankAccount extends Customer{
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

}
