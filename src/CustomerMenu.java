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
        System.out.println("Last Name: ");
        String lastName = customer.nextLine().toUpperCase();
        System.out.println("First Name: ");
        String firstName = customer.nextLine().toUpperCase();
        System.out.println("Middle Name: ");
        String middleName = customer.nextLine().toUpperCase();

        System.out.println("Sex: (1. Male, 2. Female, 3. Prefer not to Say)\n: ");
        int sexOption = customer.nextLine();
        char sex = null;
        switch (sexOption){
            case 0: sex = "Male"; break;
            case 1: sex = 'Female'; break;
            case 2: sex = 'Pre  ';
            default:
                System.out.println("Invalid Layout.");

        }
        System.out.println("Age: ");

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
