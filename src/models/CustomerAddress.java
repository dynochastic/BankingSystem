package models;

public class CustomerAddress {
    private String Brgy, Municipality, Province, Country;
    private int Postal;
    CustomerAddress(int id, String firstName,String middleName,String lastName, int age , char sex,
                    String brgy,  String municipality, String province, String country, int postal){
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
