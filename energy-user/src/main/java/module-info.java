module org.example.energyuser {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.energyuser to javafx.fxml;
    exports org.example.energyuser;
}