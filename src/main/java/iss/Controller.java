package iss;

import javafx.event.ActionEvent;
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
        timeLabel.setText(service.getTime());
        speedLabel.setText(service.getSpeed());
        peopleLabel.setText(service.getPeople());
        latLabel.setText(service.getLatitude());
        altLabel.setText(service.getAltitude());
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