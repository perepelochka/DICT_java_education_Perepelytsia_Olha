package CoffeeMachine;
import java.util.Scanner;

public class CoffeeMachine {
    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int cups = 9;
    private int money = 550;

    public boolean enoughCups = true;

    private final static Scanner scanner = new Scanner(System.in);
    public Status currentStatus = Status.CHOOSING_AN_ACTION;

    public boolean isRunning = true;

    enum Status {
        CHOOSING_AN_ACTION, CHOOSING_A_COFFEE, FILLING_MACHINE, TAKING_MONEY
    }

    private void writeAction() {
        String action = scanner.next();
        switch (action) {
            case "buy":
                currentStatus = Status.CHOOSING_A_COFFEE;
                break;
            case "fill":
                currentStatus =Status.FILLING_MACHINE;
                break;
            case "take":
                currentStatus = Status.TAKING_MONEY;
                break;
            case "remaining":
                remaining();
                break;
            case "exit":
                isRunning = false;
                break;
        }
    }

    public void programRuns(Status status) {
        switch (status) {
            case CHOOSING_AN_ACTION:
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                writeAction();
                break;
            case CHOOSING_A_COFFEE:
                buy();
                currentStatus = Status.CHOOSING_AN_ACTION;
                break;
            case FILLING_MACHINE:
                fill();
                currentStatus = Status.CHOOSING_AN_ACTION;
                break;
            case TAKING_MONEY:
                take();
                currentStatus = Status.CHOOSING_AN_ACTION;
                break;
        }
    }

    enum Kind {
        ESPRESSO(250, 0, 16, 4),
        LATTE(350, 75, 20, 7),
        CAPPUCCINO(200, 100, 12, 6);

        private final int waterForKind;
        private final int milkForKind;
        private final int beansForKind;
        private final int costForKind;

        Kind(int waterForKind, int milkForKind, int beansForKind, int costForKind) {
            this.waterForKind = waterForKind;
            this.milkForKind = milkForKind;
            this.beansForKind = beansForKind;
            this.costForKind = costForKind;
        }

        public int getWaterForKind() {
            return waterForKind;
        }
        public int getMilkForKind() {
            return milkForKind;
        }
        public int getBeansForKind() {
            return beansForKind;
        }
        public int getCostForKind() {
            return costForKind;
        }
    }

    private void espresso() {
        boolean enoughForEspresso = water >= Kind.ESPRESSO.getWaterForKind() &&
                coffeeBeans >= Kind.ESPRESSO.getBeansForKind() && enoughCups;

        if (enoughForEspresso) {
            water -= Kind.ESPRESSO.getWaterForKind();
            coffeeBeans -= Kind.ESPRESSO.getBeansForKind();
            money += Kind.ESPRESSO.getCostForKind();
            cups -= 1;
            System.out.println("I have enough resources, making you a coffee!");
        } else if (Kind.ESPRESSO.getWaterForKind() > water) {
            System.out.println("Sorry, not enough water!");
        } else if (Kind.ESPRESSO.getBeansForKind() > coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
        }
    }

    private void latte() {
        boolean enoughForLatte = water >= Kind.LATTE.getWaterForKind()
                && milk >= Kind.LATTE.getMilkForKind()
                && coffeeBeans >= Kind.LATTE.getBeansForKind() && enoughCups;

        if (enoughForLatte) {
            water -= Kind.LATTE.getWaterForKind();
            milk -= Kind.LATTE.getMilkForKind();
            coffeeBeans -= Kind.LATTE.getBeansForKind();
            money += Kind.LATTE.getCostForKind();
            cups -= 1;
            System.out.println("I have enough resources, making you a coffee!");
        } else if (Kind.LATTE.getWaterForKind() > water) {
            System.out.println("Sorry, not enough water!");
        } else if (Kind.LATTE.getMilkForKind() > milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (Kind.LATTE.getBeansForKind() > coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
        }
    }

    private void cappuccino() {
        boolean enoughForCappuccino = water >= Kind.CAPPUCCINO.getWaterForKind()
                && milk >= Kind.LATTE.getMilkForKind()
                && coffeeBeans >= Kind.CAPPUCCINO.getBeansForKind() && enoughCups;

        if (enoughForCappuccino) {
            water -= Kind.CAPPUCCINO.getWaterForKind();
            milk -= Kind.CAPPUCCINO.getMilkForKind();
            coffeeBeans -= Kind.CAPPUCCINO.getBeansForKind();
            money += Kind.CAPPUCCINO.getCostForKind();
            cups -= 1;
            System.out.println("I have enough resources, making you a coffee!");
        } else if (Kind.CAPPUCCINO.getWaterForKind() > water) {
            System.out.println("Sorry, not enough water!");
        } else if (Kind.CAPPUCCINO.getMilkForKind() > milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (Kind.CAPPUCCINO.getBeansForKind() > coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
        }
    }

    private void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino," +
                " back – to main menu:");
        String kind = scanner.next();

        switch (kind) {
            case "1":
                espresso();
                break;
            case "2":
                latte();
                break;
            case "3":
                cappuccino();
                break;
            case "back":
                break;
        }
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
        cups += fillCups;
    }

    private void take(){
        System.out.println("I gave you " + money);
        money = 0;
    }

    private void remaining() {
        System.out.println("The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                coffeeBeans + " of coffee beans\n" +
                cups + " of disposable cups\n" +
                money + " of money");
    }
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        while (coffeeMachine.isRunning) {
            coffeeMachine.programRuns(coffeeMachine.currentStatus);
        }
    }
}


