package com.example.lab2;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Lab2Handler {
    @FXML private Label displayLabel;
    @FXML private ImageView displayImage;

    @FXML
    private void applyBlueColor(){
        updateTextColor(Color.BLUE);
    }

    @FXML
    private void applyGreenColor(){
        updateTextColor(Color.GREEN);
    }

    @FXML
    private void applyRedColor(){
        updateTextColor(Color.RED);
    }

    private void updateTextColor(Color color) {
        displayLabel.setTextFill(color);
    }

    @FXML
    private void updateLabelWithNumber(String number){
        displayLabel.setText("Lab Exercise 2: " + number);
    }

    @FXML
    private void changeImage(String imagePath){
        displayImage.setImage(new Image(getClass().getResourceAsStream(imagePath)));
    }

    @FXML
    private void selectOptionOne(){ updateLabelWithNumber("1"); }
    @FXML
    private void selectOptionTwo(){ updateLabelWithNumber("2"); }
    @FXML
    private void selectOptionThree(){ updateLabelWithNumber("3"); }

    @FXML
    private void showCalendarImage(){ changeImage("Calendar.jpg"); }
    @FXML
    private void showContactsImage(){ changeImage("Contacts.jpg"); }
    @FXML
    private void showHomeImage(){ changeImage("Home.jpg"); }

    @FXML
    private void closeApplication(){ Platform.exit(); }
}