import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Hangman {
    String word;
    StringBuilder currentGuess;
    ArrayList<Character> previousGuesses = new ArrayList<Character>();

    int maxTries = 6;
    int currentTry = 0;

    ArrayList<String> dictionary = new ArrayList<String>();
    private static FileReader fileReader;
    private static BufferedReader bufferedFileReader;


    public Hangman()  throws IOException {
        initializeStreams();
        this.word = pickWord();
        this.currentGuess = initializeCurrentGuess();

    }

    public void initializeStreams() throws IOException {
        try {
            File inFile = new File("dictionary.txt");
        } catch (IOException e) {

        }
    }
}
