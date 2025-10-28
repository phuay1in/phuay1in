package mypackage;

/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: The Property class represents a property with its details and plot.
 * Due: 10/27/2025
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Paul Huaylinos
*/

public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    public Property() {
        this("", "", 0.0, "");
        this.plot = new Plot();
    }

    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot();
    }

    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this(propertyName, city, rentAmount, owner);
        this.plot = new Plot(x, y, width, depth);
    }

    public Property(Property otherProperty) {
        this(otherProperty.propertyName, otherProperty.city, otherProperty.rentAmount, otherProperty.owner);
        this.plot = new Plot(otherProperty.plot);
    }

    // Getters
    public String getPropertyName() {
        return propertyName;
    }

    public String getCity() {
        return city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getOwner() {
        return owner;
    }

    public Plot getPlot() {
        return new Plot(plot);
    }

    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}