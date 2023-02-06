package iss.controller;

import iss.model.ISSLocation;
import iss.model.SpaceCrew;
import iss.service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Arrays;


public class Controller {
    Service service = new Service();


    @FXML
    private Label altLabel;

    @FXML
    private Label latLabel;

    @FXML
    private Label peopleLabel;

    @FXML
    private Label speedLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private GridPane currrentInfoPane;

    @FXML
    private GridPane issPassPane;

    @FXML
    private TextField latInput;

    @FXML
    private TextField altInput;

    @FXML
    private Label nextPassLabel;

    @FXML
    private ComboBox<SpaceCrew> boxAstronauts;

    @FXML
    void onRefreshButton() {
        ISSLocation issLocation = service.getLocation();
        SpaceCrew[] spaceCrew = service.getSpaceCrew();
        Instant instant =  Instant.ofEpochSecond(issLocation.getTimestamp());

        latLabel.setText(String.valueOf(issLocation.getLatitude()));
        altLabel.setText(String.valueOf(issLocation.getLongitude()));
        timeLabel.setText(LocalTime.ofInstant(instant, ZoneOffset.UTC).toString());


        speedLabel.setText(String.valueOf(service.getLocation().getVelocity().toString()));


        peopleLabel.setText(String.valueOf(spaceCrew.length));

        ObservableList<SpaceCrew> spaceCrewList = FXCollections.observableList(Arrays.asList(spaceCrew));
        boxAstronauts.setItems(spaceCrewList);

    }

    @FXML
    void onCurrentInfoButton() {
        onRefreshButton();
        issPassPane.setVisible(false);
        currrentInfoPane.setVisible(true);
    }

    @FXML
    void onIssPassButton() {
        issPassPane.setVisible(true);
        currrentInfoPane.setVisible(false);
    }

    @FXML
    void onCalculateIssPass() {
        String latInputString = latInput.getCharacters().toString();
        String altInputString = altInput.getCharacters().toString();
        if(service.validateInputLat(latInputString) && service.validateInputAlt(altInputString)){
            nextPassLabel.setText("someday...");
        } else {
            nextPassLabel.setText("incorrect input");
        }
    }

}