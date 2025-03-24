package com.example.lab2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Lab2Launcher extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Lab2Launcher.class.getResource("lab2-view.fxml"));
        Scene mainScene = new Scene(loader.load());
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Lab Exercise 2");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}