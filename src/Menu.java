
import java.util.InputMismatchException;
import java.util.Scanner;
public class Menu {
    private final Scanner scanner;

    Menu(Scanner scanner){
        this.scanner = scanner;
    }
    void startBank() {
        String[] choices = {"Customer", "Account", "Transaction", "Balance Inqury"};

        System.out.println("Welcome to the System Bank.\nUse numbers to choose");

        for (int i = 0; i <= choices.length -1; i++) {
            System.out.println(i + ".) " + choices[i]);
        }
        System.out.print("Choose an option: ");

        int option = scanner.nextInt();

        try{
            switch (option) {
                case 0:
                    CustomerMenu custMenu = new CustomerMenu(scanner);
                    custMenu.startCustomerMenu();
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
            scanner.next();
        }
    }

}
// Next Goal Abstraction for customer
