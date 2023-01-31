package iss;

import java.time.LocalTime;
import java.util.Random;

public class Service {
    //TODO: replace all this methods with those that provide data from API
    public String getTime(){
        return LocalTime.now().withNano(0).toString();
    }

    public String getSpeed() {
        Random random = new Random();
        return String.valueOf(random.nextInt(1000,2000));
    }

    public String getPeople() {
        Random random = new Random();
        return String.valueOf(random.nextInt(10,12));
    }

    public String getLatitude() {
        Random random = new Random();
        return String.valueOf(random.nextInt(-90,90));
    }

    public String getAltitude() {
        Random random = new Random();
        return String.valueOf(random.nextInt(-90,90));
    }
}
