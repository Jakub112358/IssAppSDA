package iss.model;

public class Astronaut {
     String name;
     String craft;

    public Astronaut() {
    }

    public Astronaut(String name, String craft) {
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
        return "Astronaut{" +
                "name='" + name + '\'' +
                ", craft='" + craft + '\'' +
                '}';
    }
}
