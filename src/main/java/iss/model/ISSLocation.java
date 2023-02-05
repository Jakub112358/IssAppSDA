package iss.model;

import javax.persistence.*;

@Entity
@Table(name = "iss_location")
public class ISSLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iss_id")
    private int issId;
    @Column(name = "timestamp")
    private int timestamp;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "issLocation")
    @JoinColumn(name = "velocity_id")
    private ISSVelocity velocity;

    ISSLocation() {
    }

    public ISSLocation(int timestamp, double latitude, double longitude) {
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
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
