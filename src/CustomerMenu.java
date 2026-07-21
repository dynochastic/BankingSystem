import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerMenu {
    void startCustomerMenu(){
        Scanner customerAction = new Scanner(System.in);
        System.out.println("Welcome to the System Bank.\nUse numbers to choose");
        String[] customerChoices = {"Add Customer", "Update Customer Details", "Delete Customer", "Search Customer"};

        for (int i = 0; i <= customerChoices.length -1; i++) {
            System.out.println(i + ".) " + customerChoices[i]);
        }
        System.out.print("Choose an option: ");
        int option = customerAction.nextInt();

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
                    System.out.println("Customer Option Invalid.");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Please try again");
            customerAction.nextInt();
        }
    }
}
