package assignment5;

import java.util.Arrays;
import java.util.Scanner;

public class A5QHangman {

    public static void main(String[] args) {

        boolean start = true;
        int player = 2;
        int playerOneScore = 0;
        int playerTwoScore = 0;

        while (start) {

            // imports scanner
            Scanner input = new Scanner(System.in);

            // prints the score
            System.out.println("The score is:   (player one) " + playerOneScore + " | " + playerTwoScore + " (player two)");
            // asks for a word and stores it
            System.out.print("Enter a word for Player " + player + " to guess: ");
            String wordOrig = input.nextLine();
            // converts the word to all lower case
            String word = wordOrig.toLowerCase();

            // creates a bunch of variables and arrays
            boolean wordIsGuessed = false;
            boolean letterIsGuessed = false;
            int length = word.length();
            char[] letterArray = word.toCharArray();
            char[] modLetterArray = new char[length];
            int lives = 6;

            // sets modLetterArray to underscores
            for (int u = 0; u < length; u++) {

                modLetterArray[u] = '_';
            }



            // prints out 15 spaces and modLetterArray
            spaces();
            System.out.println(Arrays.toString(modLetterArray));

            // while wordIsGuessed is false
            while (!wordIsGuessed) {

                // prints "Enter a letter" and stores the input
                System.out.println("You have " + lives + " lives left.");
                System.out.print("Enter a letter to guess: ");
                char letter = input.next().charAt(0);

                for (int i = 0; i < length; i++) {

                    // if listLetterArray has the letter sub it in modLetterArray
                    if (Arrays.asList(letterArray[i]).contains(letter)) {

                        modLetterArray[i] = letter;
                        letterIsGuessed = true;
                    }
                }

                // if the letter is guessed add a life and set letterIsGuessed to false
                if (letterIsGuessed) {
                    lives++;
                    letterIsGuessed = false;
                }

                // removes a life
                lives--;

                // if modLetterArray does not have any underscores left prints "you win"
                if (!Arrays.toString(modLetterArray).contains("_")) {
                    spaces();
                    System.out.println("Congratulations! You won!");

                    // if player 2 was playing, add a score to him, if it was player 1, add a score to him
                    if (player == 2) {
                        playerTwoScore++;
                    } else if (player == 1) {
                        playerOneScore++;
                    }

                    wordIsGuessed = true;

                    // prints out the "hangman" accordingly to the lives
                } else if (lives == 6) {
                    System.out.println("");
                    incorrect0();
                } else if (lives == 5) {
                    System.out.println("");
                    incorrect1();
                } else if (lives == 4) {
                    System.out.println("");
                    incorrect2();
                } else if (lives == 3) {
                    System.out.println("");
                    incorrect3();
                } else if (lives == 2) {
                    System.out.println("");
                    incorrect4();
                } else if (lives == 1) {
                    System.out.println("");
                    incorrect5();

                    // if player has no lives, prints "you lost" and what the word was, also breaks the loop
                } else if (lives == 0) {
                    System.out.println("");
                    incorrect6();
                    System.out.println("You lost.");
                    System.out.println("The word was '" + word + "'");
                    
                    if(player == 1){
                        playerTwoScore++;
                    } else if(player == 2){
                        playerOneScore++;
                    }
                    break;

                }
                // prints the modLetterArray after player entered a letter
                System.out.println("");
                System.out.println(Arrays.toString(modLetterArray));


            }

            // activates after the game is done
            while (true) {

                // asks if user wants to play again and stores the answer
                System.out.println("Would you like to play again? (y/n): ");
                String des = input.next();

                // if the answer is "y" asks "who is guessing next" and stores the answer and breaks the loop
                if (des.equals("y") || des.equals("Y")) {

                    System.out.println("Who is guessing next? Player 1 or Player 2? (1/2): ");
                    player = input.nextInt();

                    spaces();

                    break;

                    // if the answer is "n" prints the final score and says "thanks for playing", ends the game
                } else if (des.equals("n") || des.equals("N")) {
                    System.out.println("");
                    System.out.println("The final score is:   " + playerOneScore + " (player one) | " + playerTwoScore + " (player two)");
                    System.out.println("Thank you for playing!");

                    start = false;
                    break;

                    // if the answer is not Y or N, prints "sorry i couldnt understand"
                } else {
                    System.out.println("Sorry. I could not understand that.");
                }
            }
        }
    }

    // method that makes 15 spaces
    public static void spaces() {
        // prints 13 spaces
        for (int space = 0; space < 15; space++) {
            System.out.println("");
        }

    }

    // prints the hangman when you have 0 incorrect answers
    public static void incorrect0() {

        System.out.println("     *---*");
        System.out.println("     |   |");
        System.out.println("         |");
        System.out.println("         |   Incorrect - 0");
        System.out.println("         |");
        System.out.println("         |");
        System.out.println("==========");
    }

    // prints the hangman when you have 1 incorrect answer
    public static void incorrect1() {

        System.out.println("     *---*");
        System.out.println("     |   |");
        System.out.println("     0   |");
        System.out.println("         |   Incorrect - 1");
        System.out.println("         |");
        System.out.println("         |");
        System.out.println("==========");
    }

    // prints the hangman when you have 2 incorrect answers
    public static void incorrect2() {

        System.out.println("     *---*");
        System.out.println("     |   |");
        System.out.println("     0   |");
        System.out.println("     |   |   Incorrect - 2");
        System.out.println("         |");
        System.out.println("         |");
        System.out.println("==========");
    }

    // prints the hangman when you have 3 incorrect answers
    public static void incorrect3() {

        System.out.println("     *---*");
        System.out.println("     |   |");
        System.out.println("     0   |");
        System.out.println("    /|   |   Incorrect - 3");
        System.out.println("         |");
        System.out.println("         |");
        System.out.println("==========");
    }

    // prints the hangman when you have 4 incorrect answers
    public static void incorrect4() {

        System.out.println("     *---*");
        System.out.println("     |   |");
        System.out.println("     0   |");
        System.out.println("    /|\\  |   Incorrect - 4");
        System.out.println("         |");
        System.out.println("         |");
        System.out.println("==========");
    }

    // prints the hangman when you have 5 incorrect answers
    public static void incorrect5() {

        System.out.println("     *---*");
        System.out.println("     |   |");
        System.out.println("     0   |");
        System.out.println("    /|\\  |   Incorrect - 5");
        System.out.println("    /    |");
        System.out.println("         |");
        System.out.println("==========");
    }

    // prints the hangman when you have 6 incorrect answers
    public static void incorrect6() {

        System.out.println("     *---*");
        System.out.println("     |   |");
        System.out.println("     0   |");
        System.out.println("    /|\\  |   Incorrect - 6");
        System.out.println("    / \\   |");
        System.out.println("         |");
        System.out.println("==========");
    }
}