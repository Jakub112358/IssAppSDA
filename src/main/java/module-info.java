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
}