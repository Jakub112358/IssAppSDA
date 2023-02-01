module com.example.issappsda {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.sql;


    opens iss to javafx.fxml;
    exports iss;
}