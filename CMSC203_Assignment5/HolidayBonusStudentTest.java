import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HolidayBonusStudentTest {

    private double[][] salesData = {
        {1000, 2000, 3000},
        {4000, 1000, 2000},
        {3000, 5000, 1000}
    };

    @Test
    public void testCalculateHolidayBonus() {
        double[] bonuses = HolidayBonus.calculateHolidayBonus(salesData);
        assertEquals(1000 + 5000 + 2000, bonuses[0], 0.001);
        assertEquals(5000 + 1000 + 2000, bonuses[1], 0.001);
        assertEquals(2000 + 5000 + 1000, bonuses[2], 0.001);
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double total = HolidayBonus.calculateTotalHolidayBonus(salesData);
        double[] bonuses = HolidayBonus.calculateHolidayBonus(salesData);
        double expectedTotal = 0;
        for (double b : bonuses) expectedTotal += b;
        assertEquals(expectedTotal, total, 0.001);
    }

    @Test
    public void testWithNegativeAndZeroSales() {
        double[][] data = {
            {0, -100, 2000},
            {3000, 0, 1000},
            {5000, 4000, 0}
        };
        double[] bonuses = HolidayBonus.calculateHolidayBonus(data);
        double total = HolidayBonus.calculateTotalHolidayBonus(data);
        assertTrue(total > 0);
        for (double b : bonuses) assertTrue(b >= 0);
    }
}