module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    opens application to javafx.graphics, javafx.fxml;
    exports application;
}
