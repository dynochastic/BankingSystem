package services;

import menu.CustomerService;
import models.Customer;
import models.CustomerAddress;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class customerServiceLogic {

    private Scanner scanner;
    private Customer customer;
    private CustomerAddress address;
    private CustomerService userUI;
    // To edit name date sex birthdate
    public void editCustomerDetails(){
        String[] editDetails =  {"Name", "Birthday", "Sex"};

        System.out.print("What do you want to change?");
        for(int i = 0; i <= editDetails.length - 1 ; i++){
            System.out.println( editDetails[i] +".) "+ editDetails[i]);
        }
        int edit = scanner.nextInt();
        scanner.nextLine();

    }

    // Allows edit address
    public void editCustomerAddress(){

    }
    public void addCustomerDetails() {


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

                //Parse from string to DateTime Format
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                localdate = LocalDate.parse(birthDate, formatter);

                // Flag to stop the loop
                isFormatted = true;
            } catch (DateTimeParseException e) {
                System.out.println("Error: Invalid date format. Please use DD-MM-YYYY.");
            }
        }
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
        System.out.println("Birthdate: " + birthDate);
        System.out.println("Sex: " + sex);
        System.out.println("Address: " + brgy + ", " + municipality + ", " + province + ", " + country + " " + postal);

        System.out.print("Confirm? Y/N: ");
        char yn = scanner.nextLine().toUpperCase().charAt(0);
        boolean isDone = true;

        while(true){
            //Customer Creation
            if (yn == 'Y'){
                customer = new Customer(1, firstName, middleName, lastName, localdate, sex);
                address  = new CustomerAddress(customer, brgy, municipality, province, country, postal);

                Customer dummy = new Customer(2,"john", "D", "Doe", LocalDate.now() , 'M');


                System.out.println("Customer has been created");
                userUI.customerMenu();
                break;
            }
            else if (yn == 'N'){
                System.out.println("Returned to menu");
                userUI.customerMenu();
                break;
            }
            else{
                System.out.println("Please try again");
            }
        }
    }

    //Allows Customer Search
    public void searchCustomer(){
        System.out.print("Search by ID or Name: ");
        String nameOrID = scanner.nextLine();

        //for ID search
        Pattern pattern = Pattern.compile("^[1-9]\\d*$");
        Matcher matcherID = pattern.matcher(nameOrID);

        //Regex for nameOrID search
        Pattern patternName = Pattern.compile("^[A-Za-z]+(?:\\\\s+[A-Za-z]+)*$");
        Matcher matcherName = patternName.matcher(nameOrID);

        if (matcherID.matches()){
            int id = Integer.parseInt(nameOrID);
            customer.displayInfoByID(id);
        }
        else if(matcherName.matches()){
            customer.displayInfoByName(nameOrID);
        }
        else{
            System.out.println("Cannot find the Customer");
        }
    }
    public void deleteCustomer(){

    }
}
