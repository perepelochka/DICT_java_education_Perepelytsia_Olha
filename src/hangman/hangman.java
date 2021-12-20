package hangman;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.*;

public class hangman {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        for(int m = 1; m > m - 1; m++){
            System.out.print("""
                    HANGMAN\s
                    Type "play" to play the game, "exit" to quit:>\s
                    """);
            String answer = scanner.nextLine();
            if(Objects.equals(answer,"play")){
                game();
            }else {
                break;
            }
        }
    }

    static void game() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        words.add("monday");
        words.add("tuesday");
        words.add("wednesday");
        words.add("thursday");
        words.add("friday");
        words.add("saturday");
        words.add("sunday");
        String secretword = words.get(random.nextInt(words.size()));
        Set<String> word = new HashSet<>();
        List<String> letters = new ArrayList<>();
        for (int i = 0; i < secretword.length(); i++){
            word.add(String.valueOf(secretword.charAt(i)));
        }
        String replaceword;
        System.out.println(secretword.replaceAll("[a-zA-Z]","-"));
        for(int i = 8; i >= 1;){
            System.out.print("Input a letter:> ");
            String letter = scanner.nextLine();
            if(letters.contains(letter)){
                System.out.println("You've already guessed this letter.");
            }
            if(letter.length() > 1){
                System.out.println("You should input a single letter.");
            }
            if(word.contains(letter) && !letters.contains(letter)){
                letters.add(letter);
                replaceword = secretword.replaceAll("[^"+letters+"]","-");
                System.out.println(replaceword);}
            if (letter.matches("[A-Z]")){
                System.out.println("Please enter a lowercase English letter.");
            }
            if (!word.contains(letter) && letter.length() < 2){
                System.out.println("That letter doesn't appear in the word");
                i--;
            }
            if (letters.size() == word.size()) {
                System.out.println("You survived!");
                break;
            }
            if (i == 0){
                System.out.println("You lost!");
            }
        }
    }

}
