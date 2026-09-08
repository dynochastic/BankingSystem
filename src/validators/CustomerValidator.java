package validators;

import models.Customer;

public class CustomerValidator {

    public boolean isValidCustomer(Customer customer) {

        if (customer == null) {
            System.out.println("Error: Customer is null.");
            return false;
        }

        if (customer.getFirstName() == null
                || customer.getFirstName().isBlank()
                || customer.getFirstName().length() <= 1) {

            System.out.println("Error: First name is invalid.");
            return false;
        }

        if (customer.getMiddleName() == null
                || customer.getMiddleName().isBlank()) {

            System.out.println("Error: Middle name is invalid.");
            return false;
        }

        if (customer.getLastName() == null
                || customer.getLastName().isBlank()) {

            System.out.println("Error: Last name is invalid.");
            return false;
        }

        if (customer.getBirthDate() == null) {
            System.out.println("Error: Birth date is missing.");
            return false;
        }

        if (customer.getSex() == '\0'
                || Character.isWhitespace(customer.getSex())) {

            System.out.println("Error: Sex is invalid.");
            return false;
        }

        if (customer.getContact() == null) {
            System.out.println("Error: Contact details are missing.");
            return false;
        }

        if (customer.getContact().getPhoneNumber() == null
                || customer.getContact().getPhoneNumber().isBlank()) {

            System.out.println("Error: Phone number is missing.");
            return false;
        }

        if (customer.getContact().getEmailAddress() == null
                || customer.getContact().getEmailAddress().isBlank()) {

            System.out.println("Error: Email address is missing.");
            return false;
        }

        if (customer.getAddress() == null) {
            System.out.println("Error: Customer address is missing.");
            return false;
        }

        if (customer.getAddress().getBrgy() == null
                || customer.getAddress().getBrgy().isBlank()) {

            System.out.println("Error: Barangay is missing.");
            return false;
        }

        if (customer.getAddress().getMunicipality() == null
                || customer.getAddress().getMunicipality().isBlank()) {

            System.out.println("Error: Municipality is missing.");
            return false;
        }

        if (customer.getAddress().getProvince() == null
                || customer.getAddress().getProvince().isBlank()) {

            System.out.println("Error: Province is missing.");
            return false;
        }

        if (customer.getAddress().getCountry() == null
                || customer.getAddress().getCountry().isBlank()) {

            System.out.println("Error: Country is missing.");
            return false;
        }

        if (customer.getAddress().getPostal() == null
                || customer.getAddress().getPostal().isBlank()) {

            System.out.println("Error: Postal code is missing.");
            return false;
        }

        return true;
    }
}