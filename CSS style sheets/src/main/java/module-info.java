module com.example.lab5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.example.lab5 to javafx.fxml;
    exports pl.example.lab5;
}