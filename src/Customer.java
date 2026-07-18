public class Customer{
    int Id;
    String FirstName, MiddleName, LastName, Sex;
    int Age;

    public Customer(int Id, String FirstName, String MiddleName, String LastName, String Sex, int Age){
        this.Id = Id;
        this.FirstName = FirstName;
        this.MiddleName = MiddleName;
        this.LastName = LastName;
        this.Sex = Sex;
        this.Age = Age;
    }
    public String introduce(){
        return "Hello " + FirstName + "! Your ID is " + Id;
    }
}


