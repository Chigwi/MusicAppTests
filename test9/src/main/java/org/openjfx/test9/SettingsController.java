package org.openjfx.test9;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SettingsController {

    @FXML
    private Label OutError;

    @FXML
    private Button backButton;

    @FXML
    void backToMainScreen(ActionEvent event) throws IOException {
    	App.setRoot("MainScreen");
    }

}
