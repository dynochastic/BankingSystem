import Customer.Customer;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Menu {

    void startBank() {
        Scanner inquiry = new Scanner(System.in);
        System.out.println("Welcome to the System Bank.\nUse numbers to choose");
        String[] choices = {"Customer", "Account", "Transaction", "Balance Inqury"};

        for (int i = 0; i <= choices.length -1; i++) {
            System.out.println(i + ".) " + choices[i]);
        }
        System.out.print("Choose an option: ");
        int option = inquiry.nextInt();

        try{
            switch (option) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Option Invalid.");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Please try again");
            inquiry.nextInt();
        }
    }

}
