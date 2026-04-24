module org.example.energyjavafxgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.boot;


    opens org.example.energyjavafxgui to javafx.fxml;
    exports org.example.energyjavafxgui;
}