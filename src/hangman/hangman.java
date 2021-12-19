
package hangman;
import java.util.Scanner;

public class hangman {

    public static void main(String[] args) {
        System.out.println("HANGMAN\n" + "The game will be available soon.");

        String words = "java";
        Scanner in = new Scanner(System.in);
        System.out.println("Guess the word: ");
        Scanner scanner = new Scanner(System.in);

        String user_input = scanner.nextLine();

            if (words.equals(user_input)) {
                System.out.println("You survived!");

            } else {
                System.out.println("You lost!:(");
            }
    }


}
