    package views.customer;

    import controller.CustomerController;
    import models.Customer;

    import java.util.InputMismatchException;
    import java.util.List;
    import java.util.Scanner;

    public class DeleteCustomer {

        private Scanner scanner;
        private CustomerController controller;
        private Customer customer;

        DeleteCustomer(Scanner scanner){
            this.scanner = scanner;
            this.controller = new CustomerController();
        }

        public void deleteCustomer() {

            while (true) {
                System.out.println("============================");

                System.out.println("1. Delete by ID");
                System.out.println("2. Search Name");
                System.out.println("3. Back");

                System.out.print("Please enter an option: ");

                int search = scanner.nextInt();
                scanner.nextLine();

                switch (search) {
                    case 1 -> deleteCustomerByID();
                    case 2 -> searchName();
                    case 3 -> {
                        return;
                    }
                    default -> {
                        System.out.println("Option Invalid. Please try again.");
                    }
                }
            }
        }

        public void searchName(){

            System.out.print("Enter Name: ");

            String name = scanner.nextLine().toUpperCase().strip() ;

            List<Customer> customerList = controller.findByName(name);

            if (customerList.isEmpty()){
                System.out.println("\u001B[31mNo customers exist.\u001B[0m");
                 return;
            }

            CustomerDisplayDetails.displayCustomerRows(customerList);
            System.out.print("Enter the ID would you like to remove: ");
            long id = scanner.nextLong();
            scanner.nextLine();

            customer = controller.findById(id);

            if (customer == null) {
                System.out.print("No customer exist");
                return;
            }

            CustomerDisplayDetails.displayDetails(customer);

            confirmDelete(customer);

        }
        public void deleteCustomerByID(){

            System.out.print("Enter ID: ");

            long id = scanner.nextLong();
            scanner.nextLine();

            customer = controller.findById(id);

             if (customer == null) {
                 System.out.print("Customer does not exist ");
                 return;
             }

             CustomerDisplayDetails.displayDetails(customer);

             confirmDelete(customer);

        }
        public void confirmDelete(Customer customer){

            char yn;
            do{
                System.out.print("\u001B[31mAre you sure you want to delete user " + customer.getCustomerID() + "? (Y/N): \u001B[0m");
                yn = scanner.nextLine().toUpperCase().charAt(0);

                if (yn == 'Y'){
                    boolean isSuccessful =  controller.deleteCustomer(customer);

                    if(!isSuccessful) {
                        System.out.print("Failed to remove customer " + customer.getCustomerID());
                        return;
                    }
                    System.out.println("Customer " + customer.getCustomerID() + " was removed successfully");

                } else if (yn == 'N'){
                    System.out.print("Cancelled. Failed to remove customer " + customer.getCustomerID() );
                }

            } while (yn != 'Y' && yn != 'N');

        }
    }
