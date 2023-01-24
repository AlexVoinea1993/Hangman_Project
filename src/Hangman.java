import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {

        // TODO: 1. The game will stop when the word is complete
        //       2. We need to establish the number of tries
        //       3. We need to create a list of minimum 20 words and the list must be random
        System.out.println("Welcome, to HangMan!");
        ArrayList<String> words = new ArrayList<>(Arrays.asList("helicopter", "drill", "excavator", "coach",
                "tourist", "christmas", "criminal", "convict", "encyclopedia", "alphabet book", "arithmetic book",
                "programmer", "laptop", "crocodile", "chocolate", "pizza", "pork", "liver", "lasagna", "strawberry cake"));

        // We are going to declare a project using the random method

        Random random = new Random();

        // We are going to generate a random number from 0 until the whole length of the word list. And we are going to
        // save the number into a variable
        // ThePositionOfTheNumberInTheList

        int ThePositionOfTheNumberInTheList = random.nextInt(words.size());

        // We make sure that the element, is being taken out from the world list from the name of the variable
        // "ThePositionOfTheNumberInTheList" and we are going to save this element into a variable called
        // playedWord, so we can play that certain word

        String playedWord = words.get(ThePositionOfTheNumberInTheList);

        char[] stars = new char[playedWord.length()];

        Arrays.fill(stars, '*');
        System.out.println("The word for today is: " + String.valueOf(stars));
        int numberoftries = 5;
        Scanner reader = new Scanner(System.in);
        while (true) {
            boolean guessedWord = false;
            System.out.print("Please enter a letter");

            char letter = reader.next().charAt(0);
            System.out.println("You have entered a letter " + letter);

            for (int i = 0; i < playedWord.length(); i++) {
                if (letter == playedWord.charAt(i)) {
                    stars[i] = letter;
                    guessedWord = true;
                }
            }
            if (!guessedWord) {
                numberoftries--;
                System.out.println("You still have " + numberoftries + " tries");
                if (numberoftries <= 0) {
                    System.out.println("Have a nice day!");
                    break;
                }

            }
            if (!String.valueOf(stars).contains("*")) {
                System.out.println("Nice, you won!");
                System.out.println("The word you have played is:" + playedWord);
                break;
            }
            System.out.println(String.valueOf(stars));
        }
    }
}
