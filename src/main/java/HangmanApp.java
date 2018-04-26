import java.util.Scanner;

public class HangmanApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("It's f@cking hangman, man!");
        System.out.println();

        boolean doYouWantToPlay = true;

        while (doYouWantToPlay) {
            System.out.println();
            System.out.println("Lets's play!\n");

            Hangman game = new Hangman();


            while (!game.gameOver()) {

            }

            System.out.println("Do you want to play more? Type Y if yes:");
            Character response = sc.next().toUpperCase().charAt(0);
            doYouWantToPlay = (response == 'Y');
        }
    }
}
