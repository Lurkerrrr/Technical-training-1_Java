package pl.example.lab5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/pl/example/lab5/layout.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/pl/example/lab5/style.css").toExternalForm());
        stage.setTitle("Lab5 - JavaFX Style & Animation");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

