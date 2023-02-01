module com.example.issappsda {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires com.fasterxml.jackson.databind;
    requires retrofit;


    opens com.example.issappsda to javafx.fxml;
    opens com.example.jsonDeserialization to javafx.fxml, com.fasterxml.jackson.databind;
    exports com.example.issappsda;
}