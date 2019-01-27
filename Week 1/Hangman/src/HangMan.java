import java.util.Arrays;
import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) {
        String[] words = {"HelloWorld", "Objects", "loops"};
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to HangMan a would you like to play Random word or Input word");
        System.out.println("1 for Random, 2 for Input");
        int gameType = 0;
        String word = " ";
        // used to select the game mode
        do {
            gameType = in.nextInt();
            if (gameType == 1) {
                word = words[(int) (Math.random() * words.length)];
            } else if (gameType == 2) {
                System.out.println("What is your word");
                word = in.next();
                System.out.println("\n\n\n\n\n\n\n\n\n");
            } else {
                System.out.println("this is not a game type");
            }
        } while (gameType != 1 && gameType != 2);

        // this sets the word to all lower case to avoid capitalization errors
        word = word.toLowerCase();
        char[] wordChar = word.toCharArray();
        int misses = 0;
        char[] lettersFound = new char[word.length()];
        boolean arraysEqual = false;

        // loop to ask user to type in letters and checks compatibility with string.
        while (misses < 6 && !arraysEqual) {

            System.out.println("guess a letter");
            String pre = in.next();
            char letter = Character.toLowerCase(pre.charAt(0));
            boolean HasLetters = false;
            for (int i = 0; i < word.length(); i++) {
                if (letter == word.charAt(i)) {
                    HasLetters = true;
                    lettersFound[i] = letter;
                }
            }
            if (!HasLetters) {
                misses++;
                System.out.println("WRONG TRY AGAIN\n");
            }
            // prints ascii art hang man depending on how many trys taken
            System.out.println(Arrays.toString(lettersFound));
            System.out.print(" _________     \n");
            System.out.print("|         |    \n");
            if (misses >= 1) {
                System.out.print("|         0    \n");
            } else {
                System.out.print("|              \n");
            }
            if (misses == 2) {
                System.out.print("|         |  \n");
            } else if (misses == 3) {
                System.out.print("|        /|  \n");
            } else if (misses >= 4) {
                System.out.print("|        /|\\  \n");
            } else {
                System.out.println("|");
            }
            if (misses == 5) {
                System.out.print("|        /   \n");
            } else if (misses == 6) {
                System.out.print("|        / \\  \n");
            } else {
                System.out.println("|");
            }
            System.out.print("|              \n");
            System.out.print("|              \n");
            System.out.printf("You have %d trys left\n\n", 6 - misses);

            // if the arrays are equal this will stop loop
            arraysEqual = true;
            for (int j = 0; j < word.length(); j++) {
                if (lettersFound[j] == word.toCharArray()[j]) {
                    // these boolean seem backwords due to the way they are set up in the loop above and im lazy\


                } else {
                    arraysEqual = false;
                }
            }
        }
        if (misses == 6) {
            System.out.println("You lost");
        } else if (arraysEqual) {
            System.out.println("Congratulations you win");
        } else {
            System.out.println("How the hell did you get this message ERROR");
        }
    }
}
