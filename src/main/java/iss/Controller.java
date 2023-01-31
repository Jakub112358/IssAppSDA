package iss;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


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
    void onRefreshButton() {
        timeLabel.setText(service.getTime());
        speedLabel.setText(service.getSpeed());
        peopleLabel.setText(service.getPeople());
        latLabel.setText(service.getLatitude());
        altLabel.setText(service.getAltitude());
    }

}