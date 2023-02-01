package iss;

import java.time.LocalTime;
import java.util.Random;

public class Service {
    //TODO: replace all this methods with those that provide data from API
    public String getTime() {
        return LocalTime.now().withNano(0).toString();
    }

    public String getSpeed() {
        Random random = new Random();
        return String.valueOf(random.nextInt(1000, 2000));
    }

    public String getPeople() {
        Random random = new Random();
        return String.valueOf(random.nextInt(10, 12));
    }

    public String getLatitude() {
        Random random = new Random();
        return String.valueOf(random.nextInt(-90, 90));
    }

    public String getAltitude() {
        Random random = new Random();
        return String.valueOf(random.nextInt(-90, 90));
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
