package pl.example.lab5;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Controller {

    @FXML
    private Button animatedBtn;

    @FXML
    private Label myLabel;

    @FXML
    public void initialize() {
        // Efekt graficzny: cień
        DropShadow shadow = new DropShadow();
        shadow.setRadius(5.0);
        shadow.setOffsetX(3.0);
        shadow.setOffsetY(3.0);
        shadow.setColor(Color.color(0.4, 0.5, 0.5));
        myLabel.setEffect(shadow);

        // Animacja: przesunięcie + obrót
        TranslateTransition tt = new TranslateTransition(Duration.seconds(2), animatedBtn);
        tt.setByX(100);
        tt.setAutoReverse(true);
        tt.setCycleCount(TranslateTransition.INDEFINITE);
        tt.play();

        RotateTransition rt = new RotateTransition(Duration.seconds(2), animatedBtn);
        rt.setByAngle(360);
        rt.setCycleCount(RotateTransition.INDEFINITE);
        rt.play();
    }
}

