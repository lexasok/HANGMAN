import java.io.IOException;
import java.util.Scanner;

public class HangmanApp {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("It's f@cking hangman, man!");

        boolean doYouWantToPlay = true;

        while (doYouWantToPlay) {
            System.out.println();
            System.out.println("Lets's play!\n");

            Hangman game = new Hangman();

            do {
                System.out.println(game.drawPic());
                System.out.println(game.getFormalCurrentGuess());

                System.out.println(game.word);

                System.out.println("Enter a character: ");
                char guess = sc.next().toLowerCase().charAt(0);
                while (game.isGuessedAlready(guess)) {
                    System.out.println("You've already guessed that character! Try again: ");
                    guess = sc.next().toLowerCase().charAt(0);
                }

                if (game.playGuess(guess)) {
                    System.out.println("Great guess!");
                } else {
                    System.out.println("You miss!");
                }

            }
            while (!game.gameOver());

            System.out.println("Do you want to play more? Type Y if yes:");
            Character response = sc.next().toUpperCase().charAt(0);
            doYouWantToPlay = (response == 'Y');
        }

        System.out.println("\nBye bye!");
    }
}
