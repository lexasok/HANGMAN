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

    public StringBuilder initializeCurrentGuess() {
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < word.length() * 2; i++) {
            if (i % 2 == 0) {
                current.append("_");
            } else {
                current.append(" ");
            }
        }
        return current;
    }

    public String drawPic() {
        return "Left: " + (maxTries - currentTry) + " life's!";
    }

    public String getFormalCurrentGuess() {
        return "Current guess: " + currentGuess.toString();
    }

    public boolean gameOver() {
        if (!currentGuess.toString().contains("_")) {
            System.out.println("\nYOU WIN\nYOU WIN\nYOU WIN\n");
            return true;
        }
        if (currentTry == 6) {
            System.out.println("\nGAME OVER MAN!\nGAME OVER MAN!\nGAME OVER MAN!");
            return true;
        }
        return currentTry == maxTries;
    }

    public boolean playGuess(char guess) {
        boolean isItAGoodGuess = false;
        previousGuesses.add(guess);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                currentGuess.setCharAt(i * 2, guess);
                isItAGoodGuess = true;
            }
        }
        if (!isItAGoodGuess) {
            currentTry++;
        }
        return isItAGoodGuess;
    }

    public boolean isGuessedAlready(char guess) {
        return previousGuesses.contains(guess);
    }
}
