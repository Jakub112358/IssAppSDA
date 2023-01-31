module com.example.issappsda {
    requires javafx.controls;
    requires javafx.fxml;


    opens iss to javafx.fxml;
    exports iss;
}