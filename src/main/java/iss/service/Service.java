package iss.service;

import iss.DAO.ISSLocationDAO;
import iss.model.ISSLocation;
import iss.model.ISSVelocity;
import iss.model.SpaceCrew;
import iss.utils.JsonOperations;
import iss.utils.SpeedCalculator;

public class Service {
    private JsonOperations jsonOperations;
    private ISSLocation currentLocation;
    private ISSVelocity issVelocity;
    private SpaceCrew[] spaceCrew;
    private ISSLocationDAO issLocationDAO;
    private SpeedCalculator speedCalculator;

    public Service() {
        jsonOperations = new JsonOperations();
        issLocationDAO = new ISSLocationDAO();
        speedCalculator = new SpeedCalculator();
    }

    public ISSLocation getLocation() {
        currentLocation = jsonOperations.getLocation();
        issVelocity = speedCalculator.calculateSpeed(issLocationDAO.loadNthFromEndISSLocation(10),currentLocation);
        currentLocation.setVelocity(issVelocity);
        issLocationDAO.create(currentLocation);
        return currentLocation;
    }

    public SpaceCrew[] getSpaceCrew() {
        spaceCrew = jsonOperations.getSpaceCrew();
        // here DB operation
        return spaceCrew;
    }


    public boolean validateInputLat(String inputLat) {
        int input;
        try {
            input = Integer.parseInt(inputLat);
        } catch (NumberFormatException e) {
            return false;
        }
        return input >= -80 && input <= 80;
    }

    public boolean validateInputAlt(String inputAlt) {
        int input;
        try {
            input = Integer.parseInt(inputAlt);
        } catch (NumberFormatException e) {
            return false;
        }
        return input >= -180 && input <= 180;
    }

}
