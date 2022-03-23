package com.genspark;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(20) + 1;

        System.out.println(numberToGuess);
        playGame(s, numberToGuess);

        while (true) {
            // Play again prompt
            System.out.println("Would you like to play again? (y or n)");
            String playAgain = s.next().toLowerCase();

            if (playAgain.equals("y"))
                playGame(s, random.nextInt(20) + 1);
            else
                break;
        }

    }

    public static void playGame(Scanner s, int numberToGuess) {
        int guessesCount = 0;

        System.out.println("Hello! What is your name?");

        String name = s.nextLine();

        System.out.printf("Well, %s, I am thinking of a number between 1 and 20.\n", name);

        int userGuess = -1;

        while (userGuess != numberToGuess) {
            System.out.println("Take a guess.");
            userGuess = s.nextInt();

            // Too low
            if (userGuess < numberToGuess)
                System.out.println("Your guess is too low.");
            // Too high
            else if (userGuess > numberToGuess)
                System.out.println("Your guess is too high.");

            guessesCount++;
        }

        // Correct guess
        System.out.printf("Good job, %s! You guess my number in %d guesses!\n", name, guessesCount);
    }
}
