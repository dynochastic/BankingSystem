package models;

import java.time.LocalDate;

public class Customer{
    private long customerNo;
    private String FirstName, MiddleName, LastName;
    char Sex;
    private LocalDate BirthDate;

    //Creating customer to the Database
    public Customer(String firstName, String middleName, String lastName, LocalDate birthDate, char sex){
        this.FirstName = firstName;
        this.MiddleName = middleName;
        this.LastName = middleName;
        this.Sex = sex;
        this.BirthDate = birthDate;
    }

    //Loading Customer from the Database
    public Customer(long customerNo, String FirstName, String MiddleName, String LastName, LocalDate BirthDate,
                    char Sex){
        this.customerNo = customerNo;
        this.FirstName = FirstName;
        this.MiddleName = MiddleName;
        this.LastName = LastName;
        this.Sex = Sex;
        this.BirthDate = BirthDate;
    }
    public void confirm(){
        System.out.println("Account ID: "+ this.customerNo + "\nFull Name: ");
    }
    void setFirstName (String FirstName){
        this.FirstName = FirstName;
    }
    void setMiddleName(String MiddleName){
        this.MiddleName = MiddleName;
    }
    void setLastName (String LastName){ this.LastName = LastName; }
    void setBirthDate(LocalDate BirthDate){ this.BirthDate = BirthDate; }
    public long getCustomerNo(){
       return customerNo;
    }
    public String getFirstName(){
        return FirstName;
    }
    public String getMiddleName(){
        return MiddleName;
    }
    public String getLastName(){
        return LastName;
    }
    public char getSex(){
        return Sex;
    }
    public LocalDate getBirthDate(){return BirthDate;}

    /***
    public void displayInfoByID(int ID){
        System.out.println("\n--- User Information ---");
        System.out.println("Customer ID: " + getUserId());
        System.out.println("Name: " + getFirstName()+ " " + getMiddleName() + " " + getLastName());
        System.out.println("Birthdate: " +  getBirthDate());
        System.out.println("Sex: " + getSex());
    }
    public void displayInfoByName(String name){
        System.out.println("\n--- User Information ---");
        System.out.println("Customer ID: " + getUserId());
        System.out.println("Name: " + getFirstName()+ " " + getMiddleName() + " " + getLastName());
        System.out.println("Birthdate: " +  getBirthDate());
        System.out.println("Sex: " + getSex());
    }
     ***/
}


