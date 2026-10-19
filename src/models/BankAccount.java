package models;
import java.time.LocalDate;

public abstract class BankAccount {
    private int AccountNo;
    private double Balance;
    private LocalDate dateOpened;
    private Customer Customer;

    public BankAccount(int AccountNo, double initialBalance, Customer customer) {
        this.AccountNo = AccountNo;
        this.Balance = initialBalance;
        this.dateOpened = LocalDate.now();
        this.Customer = customer;
    }

    //Account Search
    public BankAccount(int AccountNo, double initialBalance) {
        this.AccountNo = AccountNo;
        this.Balance = initialBalance;
    }

    //For Account Opening
    public BankAccount(double initialBalance, Customer customer) {
        this.Balance = initialBalance;
        this.dateOpened = LocalDate.now();
        this.Customer = customer;
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

    public void setCustomer(Customer customer) {
        this.Customer = customer;
    }
}
