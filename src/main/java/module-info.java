module com.example.issappsda {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;


    opens com.example.issappsda to javafx.fxml;
    exports com.example.issappsda;
}