package hibernate;

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

    public SpaceCrew(int id, String name, String craft) {
        this.id = id;
        this.name = name;
        this.craft = craft;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCraft() {
        return craft;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    @Override
    public String toString() {
        return "SpaceCrew{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", craft='" + craft + '\'' +
                '}';
    }
}
