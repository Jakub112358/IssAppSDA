package iss.model;

import javax.persistence.*;

@Entity
public class ISSLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iss_id")
    int issId;
    @Column(name = "timestamp")
    private int timestamp;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;

    public ISSLocation() {
    }

    public ISSLocation(int timestamp, double latitude, double longitude) {
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "ISSLocation{" +
                "timestamp=" + timestamp +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
