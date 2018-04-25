import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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
            fileReader = new FileReader(inFile);
            bufferedFileReader = new BufferedReader(fileReader);
            String currentLine = bufferedFileReader.readLine();
            while (currentLine != null) {
                dictionary.add(currentLine);
                currentLine = bufferedFileReader.readLine();
            }
            bufferedFileReader.close();
            fileReader.close();

        } catch (IOException e) {
            System.out.println("Could not init streams");
        }
    }

    public String pickWord() {
        Random random = new Random();
        int wordIndex = Math.abs(random.nextInt() % dictionary.size());
        return dictionary.get(wordIndex);
    }
}
