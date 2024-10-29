package org.example.regex_and_javadoc_assignment_week_09;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class is for initializing and launching the Registration Form JavaFX application.
 */
public class MainApplication extends Application {

    /**
     * This method initializes and displays the application.
     * @param stage This is the main stage where the scene of the application can be set.
     * @throws Exception In case if there's an error while loading the FXML file or initializing the application.
     */
    @Override
    public void start(Stage stage) throws Exception {
       // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("registration-form.fxml"));
        Parent root = loader.load();

        // Getting the controller and setting up the model
        RegistrationController rc = loader.getController();
        RegistrationModel rm = new RegistrationModel();
        rc.setModel(rm);

        // Setting up the scene and the stage
        Scene scene = new Scene(root,450,350);
        stage.setTitle("Registration Form");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method launches the Java FX application.
     * @param args Command line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch(args);
    }

}