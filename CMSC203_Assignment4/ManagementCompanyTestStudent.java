package mypackage;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
    private ManagementCompany mgmt;
    private Property p1, p2, p3;

    @Before
    public void setUp() {
        mgmt = new ManagementCompany("Railey", "555555555", 6);
        p1 = new Property("Almost Aspen", "Glendale", 4844.0, "Sammy Smith", 1, 1, 2, 2);
        p2 = new Property("Ambiance", "Lakewood", 4114.0, "Tammy Taylor", 3, 3, 2, 2);
        p3 = new Property("Bear Creek Lodge", "Peninsula", 4905.0, "Bubba Burley", 5, 5, 2, 2);
    }

    @Test
    public void testAddProperty() {
        assertEquals(0, mgmt.addProperty(p1));
        assertEquals(1, mgmt.addProperty(p2));
        assertEquals(2, mgmt.addProperty(p3));
    }

    @Test
    public void testAddPropertyFull() {
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            mgmt.addProperty(new Property("P"+i, "City", 1000 + i, "Owner"+i, i*2, i*2, 2, 2));
        }
        assertEquals(-1, mgmt.addProperty(p1));
    }

    @Test
    public void testAddPropertyOverlaps() {
        mgmt.addProperty(p1);
        Property overlapping = new Property("Overlap", "City", 1000, "Owner", 1, 1, 2, 2);
        assertEquals(-4, mgmt.addProperty(overlapping));
    }

    @Test
    public void testAddPropertyOutsidePlot() {
        Property outside = new Property("Outside", "City", 1000, "Owner", 20, 20, 2, 2);
        assertEquals(-3, mgmt.addProperty(outside));
    }

    @Test
    public void testRemoveLastProperty() {
        mgmt.addProperty(p1);
        mgmt.addProperty(p2);
        mgmt.removeLastProperty();
        assertEquals(1, mgmt.getPropertiesCount());
    }

    @Test
    public void testGetHighestRentProperty() {
        mgmt.addProperty(p1);
        mgmt.addProperty(p2);
        mgmt.addProperty(p3);
        assertEquals(p3.getRentAmount(), mgmt.getHighestRentProperty().getRentAmount(), 0.001);
    }

    @Test
    public void testGetTotalRent() {
        mgmt.addProperty(p1);
        mgmt.addProperty(p2);
        mgmt.addProperty(p3);
        assertEquals(4844.0 + 4114.0 + 4905.0, mgmt.getTotalRent(), 0.001);
    }

    @Test
    public void testIsPropertiesFull() {
        assertFalse(mgmt.isPropertiesFull());
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            mgmt.addProperty(new Property("P"+i, "City", 1000 + i, "Owner"+i, i*2, i*2, 2, 2));
        }
        assertTrue(mgmt.isPropertiesFull());
    }

    @Test
    public void testIsManagementFeeValid() {
        assertTrue(mgmt.isMangementFeeValid());
        ManagementCompany invalidFee = new ManagementCompany("Test", "123", 120);
        assertFalse(invalidFee.isMangementFeeValid());
    }

    @Test
    public void testToStringContainsProperties() {
        mgmt.addProperty(p1);
        mgmt.addProperty(p2);
        String result = mgmt.toString();
        assertTrue(result.contains("Almost Aspen"));
        assertTrue(result.contains("Ambiance"));
        assertTrue(result.contains("total management Fee"));
    }
}