module com.example.issappsda {

    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.persistence;
    requires java.sql;
    requires okhttp3;
    requires com.fasterxml.jackson.databind;

    exports iss;

    opens iss to javafx.fxml, com.fasterxml.jackson.databind;
    exports iss.model;

    exports iss.controller;
    opens iss.controller to javafx.fxml;
    exports iss.service;
    opens iss.service to javafx.fxml;
    exports iss.DAO;
    opens iss.DAO to javafx.fxml;
    opens iss.utils to com.fasterxml.jackson.databind, javafx.fxml;
    opens iss.model to com.fasterxml.jackson.databind, javafx.fxml, org.hibernate.orm.core;
}