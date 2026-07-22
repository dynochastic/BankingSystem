public class Customer{
    private final int UserId;
    private String FirstName, MiddleName, LastName;
    char Sex;
    private int Age;

    public Customer(int Id, String FirstName, String MiddleName, String LastName, char Sex, int Age){
        this.UserId = Id;
        this.FirstName = FirstName;
        this.MiddleName = MiddleName;
        this.LastName = LastName;
        this.Sex = Sex;
        this.Age = Age;
    }
    public String introduce(){
        return "Hello " + FirstName + " " + MiddleName + " "+ LastName + "! Your ID is " + UserId;
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
    void setSex(char Sex){
        this.Sex = Sex;
    }
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
}


