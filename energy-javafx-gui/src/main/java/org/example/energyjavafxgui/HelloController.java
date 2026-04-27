package org.example.energyjavafxgui;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelloController {

    private GridModel model = new GridModel();

    private static final DateTimeFormatter ISO_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd 'T'HH:mm:ss");

    @FXML
    private Label labelCommunityPool;
    @FXML
    private Label labelGridPortion;
    @FXML
    private DatePicker start;
    @FXML
    private DatePicker end;
    @FXML
    private Label labelCommunityProduced;
    @FXML
    private Label labelCommunityUsed;
    @FXML
    private Label labelGridUsed;
    @FXML
    private Label labelError;

    @FXML
    public void initialize(){
        start.setValue(LocalDate.of(2026, 3, 27));
        end.setValue(LocalDate.of(2026, 4, 27));
    }
    @FXML
    public void onRefreshClick(){
        model.fetchCurrentPercentageData();
        labelCommunityPool.setText(model.getCommunityPool());
        labelGridPortion.setText(model.getGridPortion());
    }

    @FXML
    public void onShowDataClick(){
        model.fetchUsageData(start.getValue(), end.getValue());
        labelCommunityProduced.setText(model.getCommunityProduced());
        labelCommunityUsed.setText(model.getCommunityUsed());
        labelGridUsed.setText(model.getGridUsed());
    }
}
