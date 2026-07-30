package models;
import java.time.LocalDate;

public class BankAccount {
    private final String AccountNo;
    private double Balance;
    private final LocalDate dateOpened;
    private Customer Customer;

    BankAccount(String AccountNo, double initialBalance, Customer Customer) {
        this.AccountNo = AccountNo;
        this.Balance = initialBalance;
        this.dateOpened = LocalDate.now();
        this.Customer = Customer;
    }

    public String getAccountNo() {
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