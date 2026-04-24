module org.example.energyjavafxgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.energyjavafxgui to javafx.fxml;
    exports org.example.energyjavafxgui;
}