/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Color guessing game with files
 * Due: 9/15/2025
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Paul Huaylinos
*/

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class ESPGame {
    public static void main(String[] args) throws Exception {

        final int MAX_COLORS = 16;
        final int TEN_COLORS = 10;
        final int FIVE_COLORS = 5;
        final int GUESSES = 3;
        final String OUTPUT_FILE = "EspGameResults.txt";

        Scanner keyboard = new Scanner(System.in);

        String continueGame = "Yes";
        int totalCorrect = 0;

        while (continueGame.equalsIgnoreCase("Yes")) {

            int choice;
            do {
                System.out.println("\nCMSC203 Assignment1: Test your ESP skills!");
                System.out.println("Welcome to ESP - extrasensory perception!");
                System.out.println("Would you please choose one of the 4 options from the menu:");
                System.out.println("1- read and display on the screen first 16 names of colors from a file colors.txt, so the player can select one of them names of colors.");
                System.out.println("2- read and display on the screen first 10 names of colors from a file colors.txt, so the player can select one of them names of colors.");
                System.out.println("3- read and display on the screen first 5 names of colors from a file colors.txt, so the player can select one of them names of colors.");
                System.out.println("4- Exit from a program");
                System.out.print("Enter the option: ");
                choice = keyboard.nextInt();
            } while (choice < 1 || choice > 4);

            keyboard.nextLine();

            if (choice == 4) break;

            System.out.print("Enter the filename: ");
            String COLORS_FILE = keyboard.nextLine();

            final String COLOR_1, COLOR_2, COLOR_3, COLOR_4, COLOR_5, COLOR_6, COLOR_7, COLOR_8, COLOR_9, COLOR_10, COLOR_11, COLOR_12, COLOR_13, COLOR_14, COLOR_15, COLOR_16;
            BufferedReader reader = new BufferedReader(new FileReader(COLORS_FILE));
            COLOR_1 = reader.readLine();
            COLOR_2 = reader.readLine();
            COLOR_3 = reader.readLine();
            COLOR_4 = reader.readLine();
            COLOR_5 = reader.readLine();
            COLOR_6 = reader.readLine();
            COLOR_7 = reader.readLine();
            COLOR_8 = reader.readLine();
            COLOR_9 = reader.readLine();
            COLOR_10 = reader.readLine();
            COLOR_11 = reader.readLine();
            COLOR_12 = reader.readLine();
            COLOR_13 = reader.readLine();
            COLOR_14 = reader.readLine();
            COLOR_15 = reader.readLine();
            COLOR_16 = reader.readLine();
            reader.close();

            int limit;
            if (choice == 1) limit = MAX_COLORS;
            else if (choice == 2) limit = TEN_COLORS;
            else limit = FIVE_COLORS;

            System.out.println("There are sixteen colors from a file:");
            if (limit >= 1) System.out.println("1 " + COLOR_1);
            if (limit >= 2) System.out.println("2 " + COLOR_2);
            if (limit >= 3) System.out.println("3 " + COLOR_3);
            if (limit >= 4) System.out.println("4 " + COLOR_4);
            if (limit >= 5) System.out.println("5 " + COLOR_5);
            if (limit >= 6) System.out.println("6 " + COLOR_6);
            if (limit >= 7) System.out.println("7 " + COLOR_7);
            if (limit >= 8) System.out.println("8 " + COLOR_8);
            if (limit >= 9) System.out.println("9 " + COLOR_9);
            if (limit >= 10) System.out.println("10 " + COLOR_10);
            if (limit >= 11) System.out.println("11 " + COLOR_11);
            if (limit >= 12) System.out.println("12 " + COLOR_12);
            if (limit >= 13) System.out.println("13 " + COLOR_13);
            if (limit >= 14) System.out.println("14 " + COLOR_14);
            if (limit >= 15) System.out.println("15 " + COLOR_15);
            if (limit >= 16) System.out.println("16 " + COLOR_16);

            int correct = 0;

            for (int round = 1; round <= GUESSES; round++) {
                System.out.println("\nRound " + round);
                System.out.println("I am thinking of a color.");
                System.out.println("Is it one of list of colors above?");
                int randomNumber = (int)(Math.random() * limit) + 1;
                String selectedColor = "";
                if (randomNumber == 1) selectedColor = COLOR_1;
                else if (randomNumber == 2) selectedColor = COLOR_2;
                else if (randomNumber == 3) selectedColor = COLOR_3;
                else if (randomNumber == 4) selectedColor = COLOR_4;
                else if (randomNumber == 5) selectedColor = COLOR_5;
                else if (randomNumber == 6) selectedColor = COLOR_6;
                else if (randomNumber == 7) selectedColor = COLOR_7;
                else if (randomNumber == 8) selectedColor = COLOR_8;
                else if (randomNumber == 9) selectedColor = COLOR_9;
                else if (randomNumber == 10) selectedColor = COLOR_10;
                else if (randomNumber == 11) selectedColor = COLOR_11;
                else if (randomNumber == 12) selectedColor = COLOR_12;
                else if (randomNumber == 13) selectedColor = COLOR_13;
                else if (randomNumber == 14) selectedColor = COLOR_14;
                else if (randomNumber == 15) selectedColor = COLOR_15;
                else if (randomNumber == 16) selectedColor = COLOR_16;

                System.out.print("Enter your guess: ");
                String guess = keyboard.nextLine();

                System.out.println("\nI was thinking of " + selectedColor + ".");

                if (guess.length() == selectedColor.length()) {
                    boolean match = true;
                    for (int i = 0; i < guess.length(); i++) {
                        char c1 = Character.toLowerCase(guess.charAt(i));
                        char c2 = Character.toLowerCase(selectedColor.charAt(i));
                        if (c1 != c2) {
                            match = false;
                            break;
                        }
                    }
                    if (match) correct++;
                }
            }

            System.out.println("Game Over");
            System.out.println("You guessed " + correct + " out of 3 colors correctly.");

            System.out.print("\nWould you like to continue a Game? Type Yes/No\n");
            continueGame = keyboard.nextLine();
            totalCorrect = correct;
        }
        
        System.out.print("Enter your name: ");
        String username = keyboard.nextLine();

        System.out.print("Describe yourself: ");
        String description = keyboard.nextLine();

        System.out.print("Due Date: ");
        String dueDate = keyboard.nextLine();
        
        String result = "Game Over\n" +
                        "You guessed " + totalCorrect + " out of 3 colors correctly.\n" +
                        "Due Date: " + dueDate + "\n" +
                        "Username: " + username + "\n" +
                        "User Description: " + description + "\n" +
                        "Date: " + dueDate;

        System.out.println("\n" + result);

        PrintWriter outFile = new PrintWriter(OUTPUT_FILE);
        outFile.println(result);
        outFile.close();

        keyboard.close();
    }
}
