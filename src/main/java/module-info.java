module com.example.issappsda {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.issappsda to javafx.fxml;
    exports com.example.issappsda;
}