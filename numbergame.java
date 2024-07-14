//Task 1 number game
import java.util.Random;
import java.util.Scanner;

public class numbergame
{
    private static final int MAX_ATTEMPTS = 5;
    private static int totalRounds = 0;
    private static int totalWins = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            playRound(scanner);
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
            totalRounds++;
        } while (playAgain);

        // Display final score
        System.out.println("Game Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Total Wins: " + totalWins);
        System.out.println("Final Score: " + calculateScore());
    }

    private static void playRound(Scanner scanner) {
        int numberToGuess = generateRandomNumber(1, 100);
        int attemptsLeft = MAX_ATTEMPTS;
        boolean guessedCorrectly = false;

        System.out.println("Guess the number between 1 and 100:");

        while (attemptsLeft > 0 && !guessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess < numberToGuess) {
                System.out.println("Too low!");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the number!");
                guessedCorrectly = true;
                totalWins++;
            }

            attemptsLeft--;
            if (!guessedCorrectly) {
                System.out.println("Attempts left: " + attemptsLeft);
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess);
        }
    }

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private static int calculateScore() {
        // Example scoring: one point for each win
        return totalWins;
    }
}