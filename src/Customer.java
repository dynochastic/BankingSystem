public class Customer{
    private final int UserId;
    private String FirstName, MiddleName, LastName, Sex;
    private int Age;

    Customer(){
        this.UserId = 0;
        this.FirstName = null;
        this.MiddleName = null;
        this.LastName = null;
        this.Sex = null;
        this.Age = 0;
    }
    public Customer(int Id, String FirstName, String MiddleName, String LastName, String Sex, int Age){
        this.UserId = Id;
        this.FirstName = FirstName;
        this.MiddleName = MiddleName;
        this.LastName = LastName;
        this.Sex = Sex;
        this.Age = Age;
    }
    public Customer(int Id, String FirstName, String LastName){
        this.UserId = Id;
        this.FirstName = FirstName;
        this.LastName = LastName;
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
    void setSex(String Sex){
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
    String getSex(){
        return Sex;
    }
}


