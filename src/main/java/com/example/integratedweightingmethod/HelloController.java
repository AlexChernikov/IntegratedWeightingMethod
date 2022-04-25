package com.example.integratedweightingmethod;

import java.awt.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HelloController {

    private Stage parentStage;
    private final Desktop desktop = Desktop.getDesktop();

    Workbook workbook = null;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onLoadButtonClick() throws IOException {
        welcomeText.setText("Hello Lyra! Welcome to JavaFX Application!");
        // Runtime.getRuntime().exec("explorer.exe /select, path");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Открыть файл");
        File file = fileChooser.showOpenDialog(parentStage);
        FileInputStream inputStream = new FileInputStream(file);
        if(file.getName().endsWith("xlsx")){
            workbook = new XSSFWorkbook(inputStream);
            welcomeText.setText("xlsx - успешно - " + file.getName());
        }else if(file.getName().endsWith("xls")){
            workbook = new HSSFWorkbook(inputStream);
            welcomeText.setText("xls - успешно - " + file.getName());
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (Row cells : sheet) {
            for (Cell cell : cells) {
                Cell cell1 = cell;
            }
        }
    }

    @FXML
    MenuItem HelpMethod;

    @FXML
    void initialize() {
        HelpMethod.addEventHandler(ActionEvent.ACTION, event -> onHelpMenuMethodButtonClick());
    }

    void onHelpMenuMethodButtonClick() {
        //welcomeText.setText("При нажатии этой кнопки должно открываться другое окно (Stage) с содержимым - справкой о методе.");
        Label secondLabel = new Label("I'm a Label on new Window");

        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(secondLabel);

        Scene secondScene = new Scene(secondaryLayout, 230, 100);

        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Second Stage");
        newWindow.setScene(secondScene);

        // Specifies the modality for new window.
        newWindow.initModality(Modality.WINDOW_MODAL);

        // Specifies the owner Window (parent) for new window
        newWindow.initOwner(parentStage);

        // Set position of second window, related to primary window.
        newWindow.setX(parentStage.getX() + 200);
        newWindow.setY(parentStage.getY() + 100);

        newWindow.show();
    }

    public Stage getParentStage() {
        return parentStage;
    }

    public void setParentStage(Stage parentStage) {
        this.parentStage = parentStage;
    }

}