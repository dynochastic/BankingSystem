package validators;

import models.ContactDetails;
import models.Customer;
import models.CustomerAddress;

public class customerValidate {

    public boolean isValidCustomer(Customer customer) {

        if (customer == null) { return false; }

        if (customer.getFirstName() == null || customer.getFirstName().isBlank() || customer.getFirstName().length() != 1) {
            return false;
        }

        if (customer.getMiddleName() == null || customer.getMiddleName().isBlank()) {
            return false;
        }

        if (customer.getLastName() == null
                || customer.getLastName().isBlank()) {
            return false;
        }

        if (customer.getBirthDate() == null) {
            return false;
        }

        if (customer.getSex() == '\0'
                || Character.isWhitespace(customer.getSex())) {
            return false;
        }
        if (customer.getContact() == null) {
            return false;
        }

        if (customer.getContact().getPhoneNumber() == null
                || customer.getContact().getPhoneNumber().isBlank()) {
            return false;
        }

        if (customer.getContact().getEmailAddress() == null
                || customer.getContact().getEmailAddress().isBlank()) {
            return false;
        }

        if (customer.getAddress() == null) {
            return false;
        }

        if (customer.getAddress().getBrgy() == null
                || customer.getAddress().getBrgy().isBlank()) {
            return false;
        }

        if (customer.getAddress().getMunicipality() == null
                || customer.getAddress().getMunicipality().isBlank()) {
            return false;
        }

        if (customer.getAddress().getProvince() == null
                || customer.getAddress().getProvince().isBlank()) {
            return false;
        }

        if (customer.getAddress().getCountry() == null
                || customer.getAddress().getCountry().isBlank()) {
            return false;
        }

        return customer.getAddress().getPostal() != null
                && !customer.getAddress().getPostal().isBlank();
    }
}