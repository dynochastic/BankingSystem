package models;

import java.time.LocalDate;

public class Customer{
    private final int UserId;
    private String FirstName, MiddleName, LastName;
    char Sex;
    private LocalDate BirthDate;
    private int Age;

    public Customer(int Id, String FirstName, String MiddleName, String LastName, LocalDate BirthDate,
    char Sex, int Age){
        this.UserId = Id;
        this.FirstName = FirstName;
        this.MiddleName = MiddleName;
        this.LastName = LastName;
        this.Sex = Sex;
        this.BirthDate = BirthDate;
        this.Age = Age;
    }
    public void confirm(){
        System.out.println("Account ID: "+ UserId + "\nFull Name: ");
    }
    void setFirstName (String FirstName){
        this.FirstName = FirstName;
    }
    void setMiddleName(String MiddleName){
        this.MiddleName = MiddleName;
    }
    void setLastName (String LastName){
        this.LastName = LastName;
    }
    void setBirthDate(LocalDate BirthDate){ this.BirthDate = BirthDate; }
    void setAge(int Age){
        this.Age = Age;
    }
    int getUserId(){
       return UserId;
    }
    String getFirstName(){
        return FirstName;
    }
    String getMiddleName(){
        return MiddleName;
    }
    String getLastName(){
        return LastName;
    }
    char getSex(){
        return Sex;
    }
    int getAge(){
        return Age;
    }
    LocalDate getBirthDate(){return BirthDate;}

    void displayInfo(){
        System.out.println("\n--- User Information ---");
        System.out.println("Name: " + this.FirstName + " " + this.MiddleName + " " + this.LastName);
        System.out.println("Age: " + this.Age);
        System.out.println("Birthdate: " + this.BirthDate);
        System.out.println("Sex: " + this.Sex);
    }
}


