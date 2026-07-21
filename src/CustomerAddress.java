public class CustomerAddress extends Customer{
    private String Brgy, Municipality, Province, Country;
    private int Postal;
    CustomerAddress(int id, String firstName,String middleName,String lastName, int age , String sex,
                    String brgy,  String municipality, String province, String country, int postal){
        super(id, firstName, middleName, lastName, sex, age);
        this.Brgy = brgy;
        this.Municipality = municipality;
        this.Province = province;
        this.Country = country;
        this.Postal = postal;
    }
    void setBrgy(String brgy){ this.Brgy = brgy;}
    void setMunicipality(String municipality){this.Municipality = municipality; }
    void setProvince(String province){this.Province = province;}
    void setCountry(String country){ this.Country = country; }
    void setPostal(int postal){ this.Postal = postal; }
}
