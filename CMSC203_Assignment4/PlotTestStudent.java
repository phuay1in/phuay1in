package mypackage;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PlotTestStudent {
    private Plot defaultPlot;
    private Plot customPlot;
    private Plot copyPlot;

    @Before
    public void setUp() {
        defaultPlot = new Plot();
        customPlot = new Plot(2, 3, 5, 6);
        copyPlot = new Plot(customPlot);
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(1, defaultPlot.getWidth());
        assertEquals(1, defaultPlot.getDepth());
        assertEquals(0, defaultPlot.getX());
        assertEquals(0, defaultPlot.getY());
    }

    @Test
    public void testCustomConstructor() {
        assertEquals(2, customPlot.getX());
        assertEquals(3, customPlot.getY());
        assertEquals(5, customPlot.getWidth());
        assertEquals(6, customPlot.getDepth());
    }

    @Test
    public void testCopyConstructor() {
        assertEquals(customPlot.getX(), copyPlot.getX());
        assertEquals(customPlot.getY(), copyPlot.getY());
        assertEquals(customPlot.getWidth(), copyPlot.getWidth());
        assertEquals(customPlot.getDepth(), copyPlot.getDepth());
    }

    @Test
    public void testSettersAndGetters() {
        defaultPlot.setX(10);
        defaultPlot.setY(20);
        defaultPlot.setWidth(15);
        defaultPlot.setDepth(25);

        assertEquals(10, defaultPlot.getX());
        assertEquals(20, defaultPlot.getY());
        assertEquals(15, defaultPlot.getWidth());
        assertEquals(25, defaultPlot.getDepth());
    }

    @Test
    public void testEncompasses() {
        Plot small = new Plot(1, 1, 2, 2);
        Plot big = new Plot(0, 0, 5, 5);
        assertTrue(big.encompasses(small));
        assertFalse(small.encompasses(big));
    }

    @Test
    public void testOverlaps() {
        Plot p1 = new Plot(0, 0, 5, 5);
        Plot p2 = new Plot(3, 3, 5, 5);
        Plot p3 = new Plot(6, 6, 2, 2);

        assertTrue(p1.overlaps(p2));
        assertFalse(p1.overlaps(p3));
    }

    @Test
    public void testToString() {
        assertEquals("2,3,5,6", customPlot.toString());
    }
}