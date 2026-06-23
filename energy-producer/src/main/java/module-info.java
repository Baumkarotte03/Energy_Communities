module org.example.energyproducer {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.energyproducer to javafx.fxml;
    exports org.example.energyproducer;
}