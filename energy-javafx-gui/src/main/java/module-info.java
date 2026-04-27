module org.example.energyjavafxgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.boot;
    requires com.fasterxml.jackson.databind;
    requires java.net.http;


    opens org.example.energyjavafxgui to javafx.fxml;
    exports org.example.energyjavafxgui;
}