package org.example.regex_and_javadoc_assignment_week_09;

import java.util.regex.Pattern;

/**
 * This class handles registration data and validation.
 */
public class RegistrationModel {
    // Regular expression patterns for input validation
    private static final Pattern namePattern = Pattern.compile("^[a-zA-Z]{2,25}$");
    private static final Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@farmingdale\\.edu$");
    private static final Pattern dobPattern = Pattern.compile("^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\d{4}$");
    private static final Pattern zipcodePattern = Pattern.compile("^\\d{5}$");

    // Fields to store registration data
    private String firstName, lastName, email, dob, zipCode;

    // Flags to track validation status of each field
    private boolean isFirstNameValid, isLastNameValid, isEmailValid, isDOBValid, isZipCodeValid;

    /**
     * Validates the given first name against the name pattern.
     * @param firstName The first name to validate.
     * @return true if the first name is valid, otherwise false.
     */
    public boolean validateFirstName(String firstName) {
        isFirstNameValid = namePattern.matcher(firstName).matches();
        return isFirstNameValid;
    }

    /**
     * Validates the given last name against the name pattern.
     * @param lastName The last name to validate.
     * @return true if the last name is valid, otherwise false.
     */
    public boolean validateLastName(String lastName) {
        isLastNameValid = namePattern.matcher(lastName).matches();
        return isLastNameValid;
    }

    /**
     * Validates the given email against the email pattern.
     * @param email The email to validate.
     * @return true if the email is valid, otherwise false.
     */
    public boolean validateEmail(String email) {
        isEmailValid = emailPattern.matcher(email).matches();
        return isEmailValid;
    }

    /**
     * Validates the given date of birth against the DOB pattern.
     * @param dob The date of birth to validate.
     * @return true if the date of birth is valid, otherwise false.
     */
    public boolean validateDOB(String dob) {
        isDOBValid = dobPattern.matcher(dob).matches();
        return isDOBValid;
    }

    /**
     * Validates the given zip code against the zipcode pattern.
     * @param zipCode The zip code to validate.
     * @return true if the zip code is valid, otherwise false.
     */
    public boolean validateZipCode(String zipCode) {
        isZipCodeValid = zipcodePattern.matcher(zipCode).matches();
        return isZipCodeValid;
    }

    /**
     * Checks if the fields are valid.
     * @return true if the fields are valid, otherwise false.
     */
    public boolean isValid() {
        return isFirstNameValid && isLastNameValid && isEmailValid && isDOBValid && isZipCodeValid;
    }

    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setDOB(String dob) { this.dob = dob; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    /**
     * This method submits the registration data to UI.
     */
    public void submit() {
        System.out.println("Submitting: " + firstName + " " + lastName + ", " + email + ", " + dob + ", " + zipCode);
    }
}
