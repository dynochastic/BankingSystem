package views.account;

import models.BankAccount;

public class AccountDisplayDetails  {

    public static void displayAccount(BankAccount bankAccount){

        String fullName = bankAccount.getCustomer().getFirstName() + " " + bankAccount.getCustomer().getMiddleName()+ " " + bankAccount.getCustomer().getLastName();

        if (bankAccount == null) {
            System.out.println("Account not Found");
            return;
        }

        //For improvements of displaying
        System.out.println( bankAccount.getAccountNo() + " " +  bankAccount.getBalance() + " " + bankAccount.getAccountType()+ " " +fullName);
    }
}
