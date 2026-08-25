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

    private Customer customer;
    private CustomerAddress address;
    private CustomerService mainMenu;

    public customerServiceLogic(){
    }
    /**
    public void editCustomerDetails(){
        String[] editDetails =  {"Name", "Birthday", "Sex"};

        System.out.print("What do you want to change?");
        System.out.print("1. Name");
        System.out.print("2. Birthday");
        System.out.print("3. Sex");

        int edit = scanner.nextInt();
        scanner.nextLine();

    }
     **/

}
