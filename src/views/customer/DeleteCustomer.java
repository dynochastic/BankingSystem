package views.customer;

import controller.CustomerController;
import models.Customer;

import java.util.Scanner;

public class DeleteCustomer {

    private Scanner scanner;
    private CustomerController controller;

    DeleteCustomer(Scanner scanner){
        this.scanner = scanner;
        controller = new CustomerController();

    }

    public void deleteCustomer(){

        while(true){
            System.out.println("============================");

            System.out.println("1. Delete by ID");
            System.out.println("2. Search Name");

            System.out.print("Please enter choice: ");

            int search = scanner.nextInt();
            scanner.nextLine();

            switch (search) {
                case 1 -> deleteCustomerbyID();
                case 2 -> searchName();
            }
        }
    }
    public void searchName(){


    }
    public void deleteCustomerbyID(){

        System.out.print("Enter ID: ");

        long id = scanner.nextLong();
        scanner.nextLine();

         Customer customer = controller.findById(id);

         if (customer == null){
             System.out.print("Customer does not exist ");

         }

        boolean isSuccessful =  controller.deleteCustomer(customer);

         if(isSuccessful){
             System.out.print("Customer was removed successfully ");

         }
         else{
             System.out.print("Failed to remove customer " + id );

         }
    }
}
