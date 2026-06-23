module org.example.usageservice {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.usageservice to javafx.fxml;
    exports org.example.usageservice;
}