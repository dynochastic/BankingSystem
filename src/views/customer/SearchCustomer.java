package views.customer;

import java.util.Scanner;

public class SearchCustomer {

    private Scanner scanner;

    SearchCustomer(Scanner scanner){
        this.scanner = scanner;
    }

    public void searchCustomer(){

        System.out.print("============================");

        System.out.print("1. Search by ID");
        System.out.print("2. Search by Name");
        System.out.print("3. Batch Search");

        System.out.print("How would you like to search?: ");

        int search = scanner.nextInt();
        scanner.nextLine();

        switch (search){
            case 1: searchByID();
            case 2: searchByName();
            case 3: batchSearch();
        }
    }

    public void searchByID(){
        System.out.print("Search ID: ");

        int search = scanner.nextInt();

    }

    public  void searchByName(){

    }
    public void batchSearch(){

    }

}
