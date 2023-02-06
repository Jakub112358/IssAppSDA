package iss.controller;

import iss.model.ISSLocation;
import iss.model.SpaceCrew;
import iss.service.Service;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Arrays;


public class Controller {
    private final Service service = new Service();
    private Timeline timeLine;
    private Timeline timeLineCrew;


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
    void onStartButton() {
        if (timeLine == null || timeLineCrew == null) {
            setTimeLine();
            setTimeLineCrew();
        }
        timeLine.play();
        timeLineCrew.play();
    }

    @FXML
    void onStopButton() {
        timeLine.stop();
        timeLineCrew.stop();
    }

    private void setTimeLine() {
        timeLine = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        actionEvent -> refreshData()),
                new KeyFrame(Duration.seconds(1))
        );
        timeLine.setCycleCount(Timeline.INDEFINITE);
    }
    private void setTimeLineCrew() {
        timeLineCrew = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        actionEvent -> refreshCrew()),
                new KeyFrame(Duration.seconds(10))
        );
        timeLineCrew.setCycleCount(Timeline.INDEFINITE);
    }

    private void refreshData() {
        ISSLocation issLocation = service.getLocation();
        Instant instant = Instant.ofEpochSecond(issLocation.getTimestamp());

        latLabel.setText(String.valueOf(issLocation.getLatitude()));
        altLabel.setText(String.valueOf(issLocation.getLongitude()));
        timeLabel.setText(LocalTime.ofInstant(instant, ZoneOffset.UTC).toString());
        speedLabel.setText(String.valueOf(issLocation.getVelocity().toString()));
    }

    private void refreshCrew(){
        SpaceCrew[] spaceCrew = service.getSpaceCrew();
        ObservableList<SpaceCrew> spaceCrewList = FXCollections.observableList(Arrays.asList(spaceCrew));
        boxAstronauts.setItems(spaceCrewList);
        peopleLabel.setText(String.valueOf(spaceCrew.length));
    }

    @FXML
    void onCurrentInfoButton() {
        onStartButton();
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
        if (service.validateInputLat(latInputString) && service.validateInputAlt(altInputString)) {
            nextPassLabel.setText("someday...");
        } else {
            nextPassLabel.setText("incorrect input");
        }
    }

}