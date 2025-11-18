public class HolidayBonus {

    public static final double HIGHEST_BONUS = 5000;
    public static final double LOWEST_BONUS = 1000;
    public static final double OTHER_BONUS = 2000;

    public HolidayBonus() { }

    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];

        int maxColumns = 0;
        for (double[] row : data) {
            if (row.length > maxColumns) {
                maxColumns = row.length;
            }
        }

        for (int col = 0; col < maxColumns; col++) {
            int highestIndex = -1;
            int lowestIndex = -1;

            double highestValue = Double.NEGATIVE_INFINITY;
            double lowestValue = Double.POSITIVE_INFINITY;

            int positiveCount = 0;

            for (int row = 0; row < data.length; row++) {
                if (data[row].length > col) {
                    double value = data[row][col];
                    if (value > 0) {
                        positiveCount++;
                        if (value > highestValue) {
                            highestValue = value;
                            highestIndex = row;
                        }
                        if (value < lowestValue) {
                            lowestValue = value;
                            lowestIndex = row;
                        }
                    }
                }
            }

            if (positiveCount == 0) continue;

            if (positiveCount == 1) {
                if (highestIndex != -1) bonuses[highestIndex] += HIGHEST_BONUS;
                continue;
            }

            for (int row = 0; row < data.length; row++) {
                if (data[row].length > col) {
                    double value = data[row][col];
                    if (value <= 0) continue;
                    if (row == highestIndex) bonuses[row] += HIGHEST_BONUS;
                    else if (row == lowestIndex) bonuses[row] += LOWEST_BONUS;
                    else bonuses[row] += OTHER_BONUS;
                }
            }
        }

        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] data) {
        double total = 0;
        double[] bonuses = calculateHolidayBonus(data);
        for (double b : bonuses) total += b;
        return total;
    }
}