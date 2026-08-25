package validators;

import models.Customer;

public class customerServiceLogic {

    private boolean isValidFirstName(String firstName) {
        return firstName != null && !firstName.isBlank();
    }

    private boolean isValidMiddleName(String middleName) {
        return middleName != null && !middleName.isBlank();
    }

    private boolean isValidLastName(String lastName) {
        return lastName != null && !lastName.isBlank();
    }

    private boolean isValidBirthDate(String birthDate) {
        return birthDate != null && !birthDate.isBlank();
    }

    private boolean isValidSex(String sex) {
        return sex != null && !sex.isBlank();
    }

    private boolean isValidMobileNo(String mobileNo) {
        return mobileNo != null && !mobileNo.isBlank();
    }

    private boolean isValidEmail(String email) {
        return email != null && !email.isBlank();
    }

    private boolean isValidBarangay(String brgy) {
        return brgy != null && !brgy.isBlank();
    }

    private boolean isValidMunicipality(String municipality) {
        return municipality != null && !municipality.isBlank();
    }

    private boolean isValidProvince(String province) {
        return province != null && !province.isBlank();
    }

    private boolean isValidCountry(String country) {
        return country != null && !country.isBlank();
    }

    private boolean isValidPostalCode(String postal) {
        return postal != null && !postal.isBlank();
    }
}
