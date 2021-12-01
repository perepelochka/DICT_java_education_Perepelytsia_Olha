package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int water_per_cup = 200;
        int milk_per_cup = 50;
        int coffeeBeans_per_cup = 15;

        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffee_beans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        int possible_cups_by_water = water / water_per_cup;
        int possible_cups_by_milk = milk / milk_per_cup;
        int possible_cups_by_coffee = coffee_beans / coffeeBeans_per_cup;
        int possible_cups = Math.min(Math.min(possible_cups_by_water, possible_cups_by_milk), possible_cups_by_coffee);
        int remaining_cups = possible_cups - cups;
            if (cups == possible_cups) {
                System.out.println("Yes, I can make that amount of coffee.");
            } else if (cups < possible_cups) {
                System.out.println("Yes, I can make that amount of coffee (and even " + remaining_cups + " more than that).");
            } else {
                System.out.println("No, I can make only " + possible_cups + " cups of coffee.");
            }
        }
    }


