package iss.model;

import javax.persistence.*;

@Entity
public class ISSVelocity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_id")
    private int measurementId;
    @Column(name = "velocity")
    private int velocity;

    ISSVelocity() {
    }

    public ISSVelocity(int velocity) {
        this.velocity = velocity;
    }

    public double getVelocity() {
        return velocity;
    }
}
