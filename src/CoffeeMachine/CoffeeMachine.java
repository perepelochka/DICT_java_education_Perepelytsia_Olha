package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int cups= scanner.nextInt();
        int water=200;
        int milk=50;
        int coffeeBeans=15;
        int waterForCups=cups*water;
        int milkForCups=cups*milk;
        int coffeeBeansForCups=cups*coffeeBeans;
        System.out.println("For " + cups  + "of coffee you will need:\n" +waterForCups+
                " ml of water\n" + milkForCups+
                " ml of milk\n" + coffeeBeansForCups+
                " g of coffee beans");
    }
}
