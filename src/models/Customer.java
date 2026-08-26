package models;

import java.time.LocalDate;

public class Customer{
    private long customerID;
    private String FirstName, MiddleName, LastName;
    char Sex;
    private LocalDate BirthDate;

    private CustomerAddress address;
    private ContactDetails contact;

    //Creating customer
    public Customer(String firstName, String middleName, String lastName, LocalDate birthDate, char sex, CustomerAddress address, ContactDetails contact ){
        this.FirstName = firstName;
        this.MiddleName = middleName;
        this.LastName = lastName;
        this.Sex = sex;
        this.BirthDate = birthDate;
        this.address = address;
        this.contact = contact;
    }

    //Loading Customer from the Database
    public Customer(long customerNo, String FirstName, String MiddleName, String LastName, LocalDate BirthDate,
                    char Sex, CustomerAddress address, ContactDetails contact){
        this.customerID = customerNo;
        this.FirstName = FirstName;
        this.MiddleName = MiddleName;
        this.LastName = LastName;
        this.Sex = Sex;
        this.BirthDate = BirthDate;
        this.address = address;
        this.contact = contact;
    }

    void setFirstName (String FirstName){
        this.FirstName = FirstName;
    }
    void setMiddleName(String MiddleName){
        this.MiddleName = MiddleName;
    }
    void setLastName (String LastName){ this.LastName = LastName; }
    void setBirthDate(LocalDate BirthDate){ this.BirthDate = BirthDate; }
    public long getCustomerID(){return customerID;}
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

    //Address
    public void setAddress(CustomerAddress address){
        this.address = address;
    }
    public void setContactDetails(ContactDetails contact){
        this.contact = contact;
    }
    public CustomerAddress getAddress(){
        return this.address;
    }

    public ContactDetails getContact() {
        return this.contact;
    }
}


