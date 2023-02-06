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
    private int measurementId;
    @Column(name = "velocity")
    private int velocity;

    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "iss_location_id")
    private ISSLocation issLocation;

    ISSVelocity() {
    }

    public ISSVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getVelocity() {
        return velocity;
    }

    @Override
    public String toString() {
        return String.valueOf(velocity);
    }
}
