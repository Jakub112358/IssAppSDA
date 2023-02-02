package iss.controller;

import iss.model.ISSLocation;
import iss.service.Service;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


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
    void onRefreshButton() {
        ISSLocation issLocation = service.getLocation();

        timeLabel.setText(String.valueOf(issLocation.getTimestamp()));
        speedLabel.setText(service.getSpeed());
        peopleLabel.setText(service.getPeople());
        latLabel.setText(String.valueOf(issLocation.getLatitude()));
        altLabel.setText(String.valueOf(issLocation.getLongitude()));
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