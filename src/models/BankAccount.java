package models;
import java.time.LocalDate;

public class BankAccount {
    private final long AccountNo;
    private double Balance;
    private String AccountType;
    private final LocalDate dateOpened;
    private Customer Customer;

    BankAccount(int AccountNo, double initialBalance, Customer Customer, String accountType) {
        this.AccountNo = AccountNo;
        this.Balance = initialBalance;
        this.AccountType = accountType;
        this.dateOpened = LocalDate.now();
        this.Customer = Customer;
    }

    public String getAccountType(){return AccountType;}
    public long getAccountNo() {
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

    public void setAccountType(String accountType){
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