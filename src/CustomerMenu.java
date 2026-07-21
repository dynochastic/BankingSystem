import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerMenu {
    private Scanner customer;
    CustomerMenu(Scanner scanner){
        this.customer = scanner;
    }
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
                    addCustomer();
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
    void addCustomer(){
        String firstName = customer.nextLine();
        String middleName = customer.nextLine();
        String lastName = customer.nextLine();
        String sex = customer.nextLine();
        int age = customer.nextInt();

        Customer customerDetails = new Customer(1, firstName, middleName, lastName, sex, age);
        customerDetails.introduce();
    }
    void updateCustomer(){

    }
    void editCustomer(){

    }
    void deleteCustomer(){

    }
}
