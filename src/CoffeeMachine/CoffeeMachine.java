package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int disposableCups = 9;
    private int money = 550;
    private static final Scanner scanner = new Scanner(System.in);

    private void status() {
        System.out.println("The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                coffeeBeans + " of coffee beans\n" +
                disposableCups + " of disposable cups\n" +
                money + " of money");
    }

    private void buy() {
        int waterForEspresso = 250;
        int beansForEspresso = 16;
        int costOfEspresso = 4;
        int waterForLatte = 350;
        int milkForLatte = 75;
        int beansForLatte = 20;
        int costOfLatte = 7;
        int waterForCappuccino = 200;
        int milkForCappuccino = 100;
        int beansForCappuccino = 12;
        int costOfCappuccino = 6;
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino");
        String kindOfCoffee = scanner.next();

        switch (kindOfCoffee) {
            case "1":
                water -= waterForEspresso;
                coffeeBeans -= beansForEspresso;
                money += costOfEspresso;
                disposableCups -= 1;
                break;
            case "2":
                water -= waterForLatte;
                milk -= milkForLatte;
                coffeeBeans -= beansForLatte;
                money += costOfLatte;
                disposableCups -= 1;
                break;
            case "3":
                water -= waterForCappuccino;
                milk -= milkForCappuccino;
                coffeeBeans -= beansForCappuccino;
                money += costOfCappuccino;
                disposableCups -= 1;
                break;
        }
        status();
    }

    private void fill() {
        System.out.println("Write how many ml of water you want to add:");
        int fillWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int fillMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int fillCoffeeBeans = scanner.nextInt();
        System.out.println("Write how many disposable coffee cups you want to add:");
        int fillCups = scanner.nextInt();
        water += fillWater;
        milk += fillMilk;
        coffeeBeans += fillCoffeeBeans;
        disposableCups += fillCups;
        status();
    }

    private void take() {
        System.out.println("I gave you " + money);
        money = 0;
        status();
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.status();
        System.out.println("Write action (buy, fill, take):");
        String action=scanner.next();
        if (action.equals("buy")) {
            coffeeMachine.buy();
        } else if (action.equals("fill")) {
            coffeeMachine.fill();
        } else if (action.equals("take")){
            coffeeMachine.take();
        }
    }
}


