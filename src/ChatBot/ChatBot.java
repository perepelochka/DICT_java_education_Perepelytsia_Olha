
import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args){
        String bot_name = "WALL-E";
        int birth_year = 2021;
        System.out.println("Hello! My name is "+bot_name+".\n"+"I was created in "+birth_year+".");

        Scanner in = new Scanner(System.in);
        System.out.println("Please, remind me your name: ");
        Scanner scanner = new Scanner(System.in);
        String user_name = scanner.nextLine();
        System.out.println("What a great name you have, "+ user_name+"!");

    }
}
