package models;

public class ContactDetails {
    private String phoneNumber;
    private String emailAddress;
    private String telNumber;

    // Constructor
    public ContactDetails(Customer customer, String phoneNumber, String emailAddress, String telNumber) {
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.telNumber = telNumber;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmailAddress() {
        return  this.emailAddress;
    }

    public String getTelephoneNumber() {
        return this.telNumber;
    }

    // Public Setter Methods
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
}
