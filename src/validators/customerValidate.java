package validators;

import models.ContactDetails;
import models.Customer;
import models.CustomerAddress;

public class customerValidate {

    public boolean isValidCustomer(Customer customer, ContactDetails contact, CustomerAddress address) {

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

        if (contact.getPhoneNumber() == null || contact.getPhoneNumber().isBlank()) {
            return false;
        }

        if (contact.getEmailAddress() == null || contact.getEmailAddress().isBlank()) {
            return false;
        }

        if (address.getBrgy() == null || address.getBrgy().isBlank()) {
            return false;
        }

        if (address.getMunicipality() == null || address.getMunicipality().isBlank()) {
            return false;
        }

        if (address.getProvince() == null || address.getProvince().isBlank()) {
            return false;
        }

        if (address.getCountry() == null || address.getCountry().isBlank()) {
            return false;
        }

        return address.getPostal() != null && !address.getPostal().isBlank();
    }
}