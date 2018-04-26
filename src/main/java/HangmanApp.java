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
            }
            while (!game.gameOver());

            System.out.println("Do you want to play more? Type Y if yes:");
            Character response = sc.next().toUpperCase().charAt(0);
            doYouWantToPlay = (response == 'Y');
        }

        System.out.println("\nBye bye!");
    }
}
