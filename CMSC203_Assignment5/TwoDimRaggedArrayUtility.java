import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Helps work with uneven 2D arrays of numbers, like reading from files,
 * writing to files, and finding totals, averages, and biggest or smallest values.
 * Due: 11/17/2025
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Paul Huaylinos
*/


public final class TwoDimRaggedArrayUtility {

    public static final int MAX_ROW = 10;
    public static final int MAX_COLUMN = 10;

    public TwoDimRaggedArrayUtility() { }

    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        String[][] temp = new String[MAX_ROW][MAX_COLUMN];
        int row = 0;

        while (scan.hasNextLine() && row < MAX_ROW) {
            String line = scan.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split(" ");
            for (int c = 0; c < parts.length && c < MAX_COLUMN; c++) {
                temp[row][c] = parts[c];
            }
            row++;
        }
        scan.close();

        if (row == 0) return null;

        double[][] data = new double[row][];

        for (int r = 0; r < row; r++) {
            int colCount = 0;
            for (int c = 0; c < MAX_COLUMN; c++) {
                if (temp[r][c] != null)
                    colCount++;
                else
                    break;
            }

            data[r] = new double[colCount];

            for (int c = 0; c < colCount; c++) {
                data[r][c] = Double.parseDouble(temp[r][c]);
            }
        }

        return data;
    }

    public static void writeToFile(double[][] data, File outputFile)
            throws FileNotFoundException {

        PrintWriter pw = new PrintWriter(outputFile);

        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                pw.print(data[r][c]);
                if (c < data[r].length - 1)
                    pw.print(" ");
            }
            pw.println();
        }

        pw.close();
    }

    public static double getTotal(double[][] data) {
        double sum = 0;
        for (double[] row : data)
            for (double val : row)
                sum += val;
        return sum;
    }

    public static double getAverage(double[][] data) {
        double total = 0;
        int count = 0;

        for (double[] row : data) {
            for (double val : row) {
                total += val;
                count++;
            }
        }

        return total / count;
    }

    public static double getRowTotal(double[][] data, int row) {
        double sum = 0;
        for (double v : data[row]) {
            sum += v;
        }
        return sum;
    }

    public static double getHighestInRow(double[][] data, int row) {
        double max = data[row][0];
        for (double v : data[row]) {
            if (v > max) max = v;
        }
        return max;
    }

    public static int getHighestInRowIndex(double[][] data, int row) {
        int index = 0;
        for (int c = 1; c < data[row].length; c++) {
            if (data[row][c] > data[row][index])
                index = c;
        }
        return index;
    }

    public static double getLowestInRow(double[][] data, int row) {
        double min = data[row][0];
        for (double v : data[row]) {
            if (v < min) min = v;
        }
        return min;
    }

    public static int getLowestInRowIndex(double[][] data, int row) {
        int index = 0;
        for (int c = 1; c < data[row].length; c++) {
            if (data[row][c] < data[row][index])
                index = c;
        }
        return index;
    }

    public static double getColumnTotal(double[][] data, int col) {
        double sum = 0;
        for (int r = 0; r < data.length; r++) {
            if (data[r].length > col) {
                sum += data[r][col];
            }
        }
        return sum;
    }

    public static double getHighestInColumn(double[][] data, int col) {
        double max = Double.NEGATIVE_INFINITY;
        for (int r = 0; r < data.length; r++) {
            if (data[r].length > col) {
                if (data[r][col] > max) {
                    max = data[r][col];
                }
            }
        }
        return max;
    }

    public static int getHighestInColumnIndex(double[][] data, int col) {
        double max = Double.NEGATIVE_INFINITY;
        int index = -1;

        for (int r = 0; r < data.length; r++) {
            if (data[r].length > col) {
                if (data[r][col] > max) {
                    max = data[r][col];
                    index = r;
                }
            }
        }
        return index;
    }

    public static double getLowestInColumn(double[][] data, int col) {
        double min = Double.POSITIVE_INFINITY;
        for (int r = 0; r < data.length; r++) {
            if (data[r].length > col) {
                if (data[r][col] < min) {
                    min = data[r][col];
                }
            }
        }
        return min;
    }

    public static int getLowestInColumnIndex(double[][] data, int col) {
        double min = Double.POSITIVE_INFINITY;
        int index = -1;

        for (int r = 0; r < data.length; r++) {
            if (data[r].length > col) {
                if (data[r][col] < min) {
                    min = data[r][col];
                    index = r;
                }
            }
        }
        return index;
    }

    public static double getHighestInArray(double[][] data) {
        double max = data[0][0];
        for (double[] row : data) {
            for (double v : row) {
                if (v > max) max = v;
            }
        }
        return max;
    }

    public static double getLowestInArray(double[][] data) {
        double min = data[0][0];
        for (double[] row : data) {
            for (double v : row) {
                if (v < min) min = v;
            }
        }
        return min;
    }
}