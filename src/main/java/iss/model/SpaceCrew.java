package iss.model;

import javax.persistence.*;

@Entity
@Table(name = "members")
public class SpaceCrew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "craft")
    private String craft;

    SpaceCrew() {
    }

//removed id from constructor
    public SpaceCrew(String name, String craft) {
        this.name = name;
        this.craft = craft;
    }

    public String getName() {
        return name;
    }

    public String getCraft() {
        return craft;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", craft='" + craft + '\'';
    }
}
