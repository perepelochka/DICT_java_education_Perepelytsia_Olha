
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

        System.out.println("Let me guess your age.\n"+"Enter remainders of dividing your age by 3, 5 and 7");
        int remainder3 = scanner.nextInt();
        int remainder5 = scanner.nextInt();
        int remainder7 = scanner.nextInt();
        int age = (remainder3*70+remainder5*21+remainder7*15)%105;
        System.out.println("Your age is "+age+", that is a good time to start programming!");

        System.out.println("Now I will prove to you that I can count to any number you want");
        int number = scanner.nextInt();
        for (int i=0; i<number+1; i++){
            System.out.println(i+"!");
            if (i==number){
                System.out.println("Done!");}
        }

    }
}
