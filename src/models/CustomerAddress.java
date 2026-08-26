package models;

public class CustomerAddress {

    private String Brgy, Municipality, Province, Country , Postal;
    public CustomerAddress(String brgy,  String municipality, String province, String country, String postal){
        this.Brgy = brgy;
        this.Municipality = municipality;
        this.Province = province;
        this.Country = country;
        this.Postal = postal;
    }
    public void setBrgy(String brgy) {
        this.Brgy = brgy;
    }

    public void setMunicipality(String municipality) {
        this.Municipality = municipality;
    }

    public void setProvince(String province) {
        this.Province = province;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public void setPostal(String postal) {
        this.Postal = postal;
    }

    public String getBrgy() {
        return Brgy;
    }

    public String getMunicipality() {
        return Municipality;
    }

    public String getProvince() {
        return Province;
    }

    public String getCountry() {
        return Country;
    }

    public String getPostal() {
        return Postal;
    }

    void DisplayAddress(){
        System.out.println("Address: " + this.Brgy + ", " + this.Municipality + ", " + this.Province + ", " + this.Country + " " + this.Postal);
    }
}
