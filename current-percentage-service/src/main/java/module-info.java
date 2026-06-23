module org.example.currentpercentageservice {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.currentpercentageservice to javafx.fxml;
    exports org.example.currentpercentageservice;
}