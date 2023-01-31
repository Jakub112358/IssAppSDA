module com.example.issappsda {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires com.fasterxml.jackson.databind;


    opens com.example.issappsda to javafx.fxml;
    exports com.example.issappsda;
}