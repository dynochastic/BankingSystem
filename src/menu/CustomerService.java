package menu;

import models.Customer;
import models.CustomerAddress;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerService{

    public Scanner scanner;
    private Customer customer;
    private CustomerAddress address;
    CustomerService(Scanner scanner){
        this.scanner = scanner;
    }
    void customerMenu(){
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
                    addCustomer();
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
            scanner.nextLine();
        }
    }
    void addCustomer(){

        System.out.print("Enter First name: ");
        String firstName = scanner.nextLine().toUpperCase();

        System.out.print("Enter Middle name: ");
        String middleName = scanner.nextLine().toUpperCase();

        System.out.print("Enter Last name: ");
        String lastName = scanner.nextLine().toUpperCase();


        LocalDate localdate = null;
        String birthDate = null;

        boolean isFormatted = false;
        while(!isFormatted){
            try {
                System.out.println("Enter Birthdate (mm-dd-yyyy): ");
                birthDate = scanner.nextLine();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                localdate = LocalDate.parse(birthDate, formatter);
                isFormatted = true;
            } catch (DateTimeParseException e) {
                System.out.println("Error: Invalid date format. Please use DD-MM-YYYY.");
            }
        }

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Sex (F/M): ");
        char sex = Character.toUpperCase(scanner.nextLine().charAt(0));

        System.out.print("Enter Barangay: ");
        String brgy = scanner.nextLine().toUpperCase();

        System.out.print("Enter Municipality/City: ");
        String municipality = scanner.nextLine().toUpperCase();

        System.out.print("Enter Province: ");
        String province = scanner.nextLine().toUpperCase();

        System.out.print("Enter Country: ");
        String country = scanner.nextLine().toUpperCase();

        System.out.print("Enter Postal Code: ");
        int postal = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\n--- User Information ---");
        System.out.println("Name: " + firstName + " " + middleName + " " + lastName);
        System.out.println("Age: " +age);
        System.out.println("Birthdate: " + birthDate);
        System.out.println("Sex: " + sex);
        System.out.println("Address: " + brgy + ", " + municipality + ", " + province + ", " + country + " " + postal);

        System.out.print("Confirm? Y/N: ");
        char yn = scanner.nextLine().toUpperCase().charAt(0);
        boolean isDone = true;

        while(true){
            //Customer Creation
            if (yn == 'Y'){
                customer = new Customer(1, firstName, middleName, lastName, localdate, sex, age);
                address  = new CustomerAddress(customer, brgy, municipality, province, country, postal);

                Customer dummy = new Customer(2,"john", "D", "Doe", LocalDate.now() , 'M', 23);


                System.out.println("Customer has been created");
                customerMenu();
                break;
            }
            else if (yn == 'N'){
                System.out.println("Returned to menu");
                customerMenu();
                break;
            }
            else{
                System.out.println("Please try again");
            }
        }


    }
    void deleteCustomer(){

    }
    void editCustomer(){
        System.out.print("What do you want to edit.");
        String editDetails = scanner.nextLine();

    }
    void searchCustomer(){
        System.out.print("Search by ID or Name: ");
        String name = scanner.nextLine();

        //for ID search
        Pattern pattern = Pattern.compile("^[1-9]\\d*$");
        Matcher matcherID = pattern.matcher(name);

        //Regex for name search
        Pattern patternName = Pattern.compile("^[A-Za-z]+(?:\\\\s+[A-Za-z]+)*$");
        Matcher matcherName = patternName.matcher(name);

        if (matcherID.matches()){
            int id = Integer.parseInt(name);
            customer.displayInfoByID(id);
        }
        else if(matcherName.matches()){
            customer.displayInfoByName(name);
        }
    }
}
