package iss.service;

import iss.model.ISSLocation;
import iss.model.SpaceCrew;
import iss.utils.JsonOperations;
import java.util.Random;

public class Service {
    private JsonOperations jsonOperations;
    private ISSLocation currentLocation;
    private SpaceCrew[] spaceCrew;

    public Service() {
        jsonOperations = new JsonOperations();
        currentLocation = jsonOperations.getLocation();
    }

    public ISSLocation getLocation(){
        currentLocation = jsonOperations.getLocation();
        // here DB operation
        return currentLocation;
    }



    //TODO: replace all this methods with those that provide data from API

    public String getSpeed() {
        Random random = new Random();
        return String.valueOf(random.nextInt(1000, 2000));
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
