package iss.service;

import iss.model.ISSLocation;
import iss.model.SpaceCrew;
import iss.utils.JsonOperations;

import java.math.RoundingMode;
import java.text.DecimalFormat;

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
    public String getSpeed() throws InterruptedException {

        ISSLocation location1 = getLocation();
        Thread.sleep(3000);
        ISSLocation location2 = getLocation();
        double distance = distanceOnGeoidInMeters(location1.getLatitude(), location1.getLongitude(),
                location2.getLatitude(), location2.getLongitude());
        double timestampsDifference = (location2.getTimestamp() - location1.getTimestamp())/1000.0;
        double speed_mps = distance/timestampsDifference;
        // value in kph
        double speed_kph = (speed_mps*3600.0) / 1000.0;
        System.out.println(speed_mps);
        System.out.println(speed_kph);


        final DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(speed_kph);
    }

    public double distanceOnGeoidInMeters (double lat1, double lon1, double lat2, double lon2) {
        // Convert degrees to radians
        lat1 = degreesToRadians(lat1);
        lon1 = degreesToRadians(lon1);
        lat2 = degreesToRadians(lat2);
        lon2 = degreesToRadians(lon2);

        // radius of earth in metres
        double r = 6378100;

        // P
        double rho1 = r * Math.cos(lat1);
        double z1 = r * Math.sin(lat1);
        double x1 = rho1 * Math.cos(lon1);
        double y1 = rho1 * Math.sin(lon1);

        //Q
        double rho2 = r * Math.cos(lat2);
        double z2 = r * Math.sin(lat2);
        double x2 = rho2 * Math.cos(lon2);
        double y2 = rho2 * Math.sin(lon2);

        //Dot product
        double dot = (x1 * x2 + y1 * y2 + z1 * z2);
        double cos_theta = dot / (r * r);
        double theta = Math.acos(cos_theta);

        //Distance in meters
        return r * theta;
    }

    public double degreesToRadians (double degrees) {
        return degrees * Math.PI/180;
    }




    //TODO: replace all this methods with those that provide data from API


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
