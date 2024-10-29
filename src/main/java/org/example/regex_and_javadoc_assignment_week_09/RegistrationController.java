package org.example.regex_and_javadoc_assignment_week_09;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {

    // FXML/UI components
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField dob;
    @FXML
    private TextField zipCode;
    @FXML
    private Button addButton;
    @FXML
    private Label firstNameError;
    @FXML
    private Label lastNameError;
    @FXML
    private Label emailError;
    @FXML
    private Label dobError;
    @FXML
    private Label zipCodeError;

    // Model for registration data and validation
    private RegistrationModel rm;

    /**
     * Sets the registration model in the controller.
     * @param rm This model is used for data handling and validation.
     */
    public void setModel(RegistrationModel rm) {
        this.rm = rm;
    }

    /**
     * This method initializes the controller and is automatically called after the FXML file is loaded.
     */
    @FXML
    public void initialize() {
        // Add listeners to validate fields
        firstName.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) validateFirstName();
        });
        lastName.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) validateLastName();
        });
        email.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) validateEmail();
        });
        dob.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) validateDOB();
        });
        zipCode.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) validateZipCode();
        });
    }

    // Validation methods for each field
    private void validateFirstName() {
        boolean isValid = rm.validateFirstName(firstName.getText());
        updateFieldStatus(firstName, firstNameError, isValid, "Minimum of 2 characters and maximum of 25 characters.");
    }

    private void validateLastName() {
        boolean isValid = rm.validateLastName(lastName.getText());
        updateFieldStatus(lastName, lastNameError, isValid, "Minimum of 2 characters and maximum of 25 characters.");
    }

    private void validateEmail() {
        boolean isValid = rm.validateEmail(email.getText());
        updateFieldStatus(email, emailError, isValid, "\"Enter a valid Farmingdale email address.");
    }

    private void validateDOB() {
        boolean isValid = rm.validateDOB(dob.getText());
        updateFieldStatus(dob, dobError, isValid, "Enter a valid date in MM/DD/YYYY format");
    }

    private void validateZipCode() {
        boolean isValid = rm.validateZipCode(zipCode.getText());
        updateFieldStatus(zipCode, zipCodeError, isValid, "Enter a valid 5-digit zip code");
    }

    /**
     * Update UI to reflect validation status of the field.
     * @param field The TextField to update.
     * @param errorLabel The Label which shows error messages.
     * @param isValid Proves if the field's content is valid.
     * @param errorMessage The error message that shows when invalid.
     */
    private void updateFieldStatus(TextField field, Label errorLabel, boolean isValid, String errorMessage) {
        if (!isValid) {
            errorLabel.setText(errorMessage);
            field.setStyle("-fx-border-color: red;");
        } else {
            errorLabel.setText("");
            field.setStyle("");
        }
        updateAddButtonState();
    }

    // Updates state of the Add button based on validity
    private void updateAddButtonState() {
        addButton.setDisable(!rm.isValid());
    }

    /**
     * Handles Add button click event.
     * @param event The ActionEvent is activated by clicking the add button.
     */
    @FXML
    private void handleAddButton(ActionEvent event) {
        if (rm.isValid()) {
            rm.setFirstName(firstName.getText());
            rm.setLastName(lastName.getText());
            rm.setEmail(email.getText());
            rm.setDOB(dob.getText());
            rm.setZipCode(zipCode.getText());
            rm.submit();

            try {
                // Loads the second UI
                FXMLLoader loader = new FXMLLoader(getClass().getResource("registration-successful.fxml"));
                Parent secondUI = loader.load();

                // Create a new stage for the second UI
                Stage secondStage = new Stage();
                secondStage.setTitle("Registration Successful");
                secondStage.setScene(new Scene(secondUI));

                // Show the new stage
                secondStage.show();

                // Optionally, close the current stage
                ((Stage) addButton.getScene().getWindow()).close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error loading second UI: " + e.getMessage());
            }
        }
    }
}

