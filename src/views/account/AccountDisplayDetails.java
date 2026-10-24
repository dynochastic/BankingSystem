package views.account;

import models.BankAccount;
import models.Customer;
import utils.Counter;

import java.util.List;

public class AccountDisplayDetails  {

    public static void displayAccount(BankAccount bankAccount){

        if (bankAccount == null) {
            System.out.println("Account not Found");
            return;
        }

        String fullName = bankAccount.getCustomer().getFirstName() + " " + (bankAccount.getCustomer().getMiddleName() == null || bankAccount.getCustomer().getMiddleName().isBlank()
                ? "" : bankAccount.getCustomer().getMiddleName() + " ")
                + bankAccount.getCustomer().getLastName();

        System.out.println("================ ACCOUNT DETAILS ================");
        System.out.println("Account No.   : " + bankAccount.getAccountNo());
        System.out.println("Account Type  : " + bankAccount.getAccountType());
        System.out.println("Account Holder: " + fullName);
        System.out.printf("Balance       : %,.2f%n", bankAccount.getBalance());
        System.out.println("Account Status: " + bankAccount.getAccountStatus());

        System.out.println("==================================================");

        Counter.threeSecondsCounter();
    }
    public static void displayCustomerAccounts(List<BankAccount> accounts) {

        //Status Colors
        final String RESET = "\u001B[0m";
        final String CYAN = "\u001B[36m";
        final String GREEN = "\u001B[32m";
        final String ICY_BLUE = "\u001B[96m";
        final String GRAY = "\u001B[90m";
        final String BOLD = "\u001B[1m";

        String line = "================================================================================";
        String separator = "--------------------------------------------------------------------------------";

        if (accounts == null || accounts.isEmpty()) {
            System.out.println(CYAN + line + RESET);
            System.out.println("No bank accounts found.");
            System.out.println(CYAN + line + RESET);
            return;
        }

        // CUSTOMER INFORMATION
        BankAccount firstAccount = accounts.get(0);

        String fullName = firstAccount.getCustomer().getFirstName() + " " + (firstAccount.getCustomer().getMiddleName() == null || firstAccount.getCustomer().getMiddleName().isBlank()
                ? "" : firstAccount.getCustomer().getMiddleName() + " ")
                + firstAccount.getCustomer().getLastName();

        System.out.println("\n" + CYAN + line + RESET);

        System.out.println(
                GREEN + BOLD + "CUSTOMER: " + fullName + RESET
        );

        System.out.println(CYAN + separator + RESET);

        // ACCOUNT HEADER
        System.out.printf(
                CYAN + BOLD + "%-15s %-20s %-15s %-15s%n" + RESET,
                "ACCOUNT NO.",
                "ACCOUNT TYPE",
                "BALANCE",
                "STATUS"
        );

        System.out.println(CYAN + separator + RESET);

        // ACCOUNT RECORDS
        for (BankAccount account : accounts) {

            String status = account.getAccountStatus();
            String coloredStatus;

            if ("ACTIVE".equalsIgnoreCase(status)) {
                coloredStatus = GREEN + status + RESET;
            } else if ("FROZEN".equalsIgnoreCase(status)
                    || "CLOSED".equalsIgnoreCase(status)) {
                coloredStatus = ICY_BLUE + status + RESET;
            } else {
                coloredStatus = status;
            }

            System.out.printf(
                    "%-15s %-20s " + GREEN + "%-15,.2f" + RESET + " %s%n",
                    account.getAccountNo(),
                    account.getAccountType(),
                    account.getBalance(),
                    coloredStatus
            );
        }

        System.out.println(CYAN + line + RESET);

        System.out.println(
                CYAN + BOLD + "Total Accounts: " + accounts.size() + RESET
        );

        System.out.println(CYAN + line + RESET);

        Counter.threeSecondsCounter();
    }
}
