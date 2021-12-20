package hangman;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.*;

public class hangman {

    public static void main(String[] args) {
        System.out.println("HANGMAN\n" + "The game will be available soon.");


            Random random = new Random();
            Scanner scanner = new Scanner(System.in);
            List<String> words = new ArrayList<>();
            words.add("kotlin");
            words.add("java");
            words.add("js");
            words.add("python");

            String secretword = words.get(random.nextInt(words.size()));

            Scanner in = new Scanner(System.in);
            System.out.println("Guess the word: ");

            String user_input = scanner.nextLine();

            if (secretword.equals(user_input)) {
                System.out.println("You survived!");

            } else {
                System.out.println("You lost!:(");
            }


    }
}
