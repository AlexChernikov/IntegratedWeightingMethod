package com.example.integratedweightingmethod;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloOldController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}