package iss.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Entity
@Table(name = "iss_velocity")
public class ISSVelocity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_id")
    private double measurementId;
    @Column(name = "velocity")
    private double velocity;

    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "iss_location_id")
    private ISSLocation issLocation;

    ISSVelocity() {
    }

    public ISSVelocity(int velocity) {
        this.velocity = velocity;
    }

    public double getVelocity() {
        return velocity;
    }
}
