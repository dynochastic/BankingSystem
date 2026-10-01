package models;
import java.time.LocalDate;

public class BankAccount {
    private int AccountNo;
    private double Balance;
    private AccountType AccountType;
    private final LocalDate dateOpened;
    private Customer Customer;

    public BankAccount(int AccountNo, double initialBalance,  AccountType accountType, Customer Customer) {
        this.AccountNo = AccountNo;
        this.Balance = initialBalance;
        this.AccountType = accountType;
        this.dateOpened = LocalDate.now();
        this.Customer = Customer;
    }

    //For Account Opening
    public BankAccount(double initialBalance, AccountType accountType, Customer Customer) {
         this.Balance = initialBalance;
        this.AccountType = accountType;
        this.dateOpened = LocalDate.now();
        this.Customer = Customer;
    }

    public AccountType getAccountType(){
        return AccountType;
    }

    public  int getAccountNo() {
        return AccountNo;
    }

    public LocalDate getDateOpened() {
        return dateOpened;
    }

    public Customer getCustomer() {
        return Customer;
    }

    public Double getBalance() {
        return Balance;
    }

    public void setAccountType(AccountType accountType){
        this.AccountType = accountType;
    }
    public void setCustomer(Customer customer) {
        this.Customer = customer;
    }
}

    /*
    public void withdraw(double amount) {
        if (amount > 0 && amount <= Balance) {
            Balance -= amount;
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            Balance += amount;
        }
    }
*/