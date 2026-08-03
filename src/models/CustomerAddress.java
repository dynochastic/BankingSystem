package models;

public class CustomerAddress {
    private String Brgy, Municipality, Province, Country;
    private int Postal;
    private Customer customer;
    CustomerAddress(Customer customer, String brgy,  String municipality, String province, String country, int postal){
        this.customer = customer;
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
    String getBrgy(){ return Brgy; }
    String getMunicipality(){return Municipality;}
    String getProvince(){ return Province; }
    String getCountry(){ return Country; }
    int getPostal(){ return Postal; }
}
