module com.example.issappsda {

    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.persistence;
    requires java.sql;


    exports com.example.issappsda;
    opens com.example.issappsda to javafx.fxml;
    exports hibernate;
    opens hibernate to javafx.fxml;

    requires okhttp3;
    requires com.fasterxml.jackson.databind;
    requires retrofit;

    opens com.example.jsonDeserialization to javafx.fxml, com.fasterxml.jackson.databind;
    exports com.example.issappsda;

    requires org.hibernate.orm.core;
    requires java.sql;


    opens iss to javafx.fxml;
    exports iss;


}