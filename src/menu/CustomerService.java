package menu;

import models.Customer;
import models.CustomerAddress;
import services.customerServiceLogic;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerService{

    private final Scanner scanner;
    private customerServiceLogic customerService;

    CustomerService(Scanner scanner){
        this.scanner = scanner;
    }
        public void customerMenu(){
        System.out.println("Select what you want to do");
        String[] choices = {"Add Customer", "Delete Customer", "Edit Customer Details", "Search Customer"};

        for (int i = 0; i <= choices.length -1; i++) {
            System.out.println(i + ".) " + choices[i]);
        }
        System.out.print("Choose an option: ");

        int option = scanner.nextInt();
        scanner.nextLine();

        try{
            switch (option) {
                case 0:
                    customerService.addCustomerDetails();
                    break;
                case 1:
                    customerService.deleteCustomer();
                    break;
                case 2:
                    editCustomer();
                    break;
                case 3:
                    customerService.searchCustomer();
                    break;
                default:
                    System.out.println("Option Invalid.");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Please try again");
            scanner.nextLine();
        }
    }

    void editCustomer(){
        System.out.print("What do you want to edit.");
        System.out.print("0. User Primary Details.\n1. User Address.\n: ");

        int editDetails = scanner.nextInt();
        scanner.nextLine();

        while (true) {
            try{
                switch (editDetails) {
                    case 0:
                        customerService.editCustomerDetails();
                        break;
                    case 1:
                        customerService.editCustomerAddress();
                        break;
                    default:
                        System.out.println("Option Invalid.");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Select 1 or 2");
            }
        }

    }
}
