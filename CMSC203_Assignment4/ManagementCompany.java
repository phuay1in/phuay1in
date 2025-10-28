package mypackage;

/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: The ManagementCompany class manages a number of fields in its plot, managing details.
 * Due: 10/27/2025
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Paul Huaylinos
*/

public class ManagementCompany {
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    private String name;
    private String taxID;
    private double mgmFeePer;
    private Plot plot;
    private Property[] properties;
    private int numberOfProperties;

    public ManagementCompany() {
        this("", "", 0.0, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFeePer) {
        this(name, taxID, mgmFeePer, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    public ManagementCompany(ManagementCompany otherCompany) {
        this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFeePer,
             otherCompany.plot.getX(), otherCompany.plot.getY(),
             otherCompany.plot.getWidth(), otherCompany.plot.getDepth());
        for (int i = 0; i < otherCompany.numberOfProperties; i++) {
            this.properties[i] = otherCompany.properties[i];
        }
        this.numberOfProperties = otherCompany.numberOfProperties;
    }

    public String getName() { return name; }
    public String getTaxID() { return taxID; }
    public double getMgmFeePer() { return mgmFeePer; }
    public Plot getPlot() { return new Plot(plot); }
    public Property[] getProperties() { return properties; }
    public int getPropertiesCount() { return numberOfProperties; }

    public boolean isMangementFeeValid() {
        return mgmFeePer >= 0 && mgmFeePer <= 100;
    }

    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }

    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    public int addProperty(Property property) {
        if (property == null) return -2;
        if (isPropertiesFull()) return -1;
        if (!plot.encompasses(property.getPlot())) return -3;

        for (int i = 0; i < numberOfProperties; i++) {
            if (property.getPlot().overlaps(properties[i].getPlot())) return -4;
        }

        properties[numberOfProperties] = property; // store original object
        numberOfProperties++;
        return numberOfProperties - 1;
    }

    public int addProperty(String name, String city, double rent, String owner) {
        Property property = new Property(name, city, rent, owner);
        return addProperty(property);
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        Property property = new Property(name, city, rent, owner, x, y, width, depth);
        return addProperty(property);
    }

    public double getTotalRent() {
        double total = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            total += properties[i].getRentAmount();
        }
        return total;
    }

    private int getHighestRentPropertyIndex() {
        if (numberOfProperties == 0) return -1;
        int index = 0;
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > properties[index].getRentAmount()) {
                index = i;
            }
        }
        return index;
    }

    public Property getHighestRentProperty() {
        int index = getHighestRentPropertyIndex();
        if (index == -1) return null;
        return properties[index];
    }

    @Override
    public String toString() {
        String result = "List of the properties for " + name + ", taxID: " + taxID + "\n";
        result += "______________________________________________________\n";
        for (int i = 0; i < numberOfProperties; i++) {
            result += properties[i].toString() + "\n";
        }
        result += "______________________________________________________\n";
        result += "\n";
        result += " total management Fee: " + (getTotalRent() * mgmFeePer / 100);
        return result;
    }
}