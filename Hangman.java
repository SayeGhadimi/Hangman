import java.util.Scanner;
import java.util.Random;

public class Hangman {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] words = {"write", "that", "read", "game", "computer", "java"};
        Random random = new Random();
        String playAgain;

        do {
            
            String word = words[random.nextInt(words.length)];
            char[] hiddenWord = new char[word.length()];
            for (int i = 0; i < hiddenWord.length; i++) {
                hiddenWord[i] = '*';
            }

            int missed = 0;
            while (new String(hiddenWord).contains("*")) {
                System.out.print("(Guess) Enter a letter in word " + new String(hiddenWord) + " > ");
                char guess = input.next().charAt(0);

                boolean guessCorrect = false;
                boolean alreadyGuessed = false;

                for (int i = 0; i < word.length(); i++) {
                    if (hiddenWord[i] == guess) {
                        alreadyGuessed = true;
                        break;
                    }
                }

                if (alreadyGuessed) {
                    System.out.println("\t" + guess + " is already in the word.");
                    continue;
                }

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        hiddenWord[i] = guess;
                        guessCorrect = true;
                    }
                }

                if (!guessCorrect) {
                    System.out.println("\t" + guess + " is not in the word.");
                    missed++;
                }
            }

            System.out.println("The word is " + word + ". You missed " + missed + " time(s).");

            System.out.print("Do you want to guess another word? Enter y or n > ");
            playAgain = input.next();

        } while (playAgain.equalsIgnoreCase("y"));

        input.close();
    }
}
