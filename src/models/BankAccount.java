package models;
import java.time.LocalDate;

public abstract class BankAccount {
    private int AccountNo;
    private double Balance;
    private LocalDate dateOpened;
    private String AccountType;
    private String AccountStatus;
    private Customer Customer;


    public BankAccount(int accountNo, double initialBalance, String accountType, String accountStatus, Customer customer) {
        this.AccountNo = accountNo;
        this.Balance = initialBalance;
        this.AccountType = accountType;
        this.AccountStatus = accountStatus;
        this.Customer = customer;
    }

    //For Account Opening
    public BankAccount(double initialBalance, Customer customer) {
        this.Balance = initialBalance;
        this.dateOpened = LocalDate.now();
        this.Customer = customer;
    }

    public  int getAccountNo() {
        return this.AccountNo;
    }

    public LocalDate getDateOpened() {
        return this.dateOpened;
    }

    public Customer getCustomer() {
        return this.Customer;
    }

    public Double getBalance() {
        return this.Balance;
    }

    public String getAccountType(){
        return this.AccountType;
    }
    public String getAccountStatus(){
        return this.AccountStatus;
    }

    public void setBalance(double balance){
        this.Balance = balance;

    }
    public void setCustomer(Customer customer) {
        this.Customer = customer;
    }


}
