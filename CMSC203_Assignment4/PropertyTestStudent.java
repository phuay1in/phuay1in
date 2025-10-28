package mypackage;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PropertyTestStudent {
    private Property defaultProp;
    private Property customProp;
    private Property copyProp;

    @Before
    public void setUp() {
        defaultProp = new Property();
        customProp = new Property("Sunset Villa", "Orlando", 1200.0, "Alice", 1, 2, 10, 20);
        copyProp = new Property(customProp);
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals("", defaultProp.getPropertyName());
        assertEquals("", defaultProp.getCity());
        assertEquals(0.0, defaultProp.getRentAmount(), 0.001);
        assertEquals("", defaultProp.getOwner());
        assertNotNull(defaultProp.getPlot());
    }

    @Test
    public void testCustomConstructor() {
        assertEquals("Sunset Villa", customProp.getPropertyName());
        assertEquals("Orlando", customProp.getCity());
        assertEquals(1200.0, customProp.getRentAmount(), 0.001);
        assertEquals("Alice", customProp.getOwner());
        assertEquals(1, customProp.getPlot().getX());
        assertEquals(2, customProp.getPlot().getY());
    }

    @Test
    public void testCopyConstructor() {
        assertEquals(customProp.getPropertyName(), copyProp.getPropertyName());
        assertEquals(customProp.getCity(), copyProp.getCity());
        assertEquals(customProp.getRentAmount(), copyProp.getRentAmount(), 0.001);
        assertEquals(customProp.getOwner(), copyProp.getOwner());
        assertEquals(customProp.getPlot().getWidth(), copyProp.getPlot().getWidth());
    }

    @Test
    public void testToString() {
        assertEquals("Sunset Villa,Orlando,Alice,1200.0", customProp.toString());
    }

    @Test
    public void testGetPlotReturnsCopy() {
        Plot p = customProp.getPlot();
        p.setX(100);
        assertEquals(1, customProp.getPlot().getX());
    }
}