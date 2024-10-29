module org.example.regex_and_javadoc_assignment_week_09 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.regex_and_javadoc_assignment_week_09 to javafx.fxml;
    exports org.example.regex_and_javadoc_assignment_week_09;
}