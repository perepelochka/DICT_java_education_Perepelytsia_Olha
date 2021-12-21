package TicTacToe;
import java.util.*;


public class TicTacToe {
    public static Scanner in = new Scanner(System.in);

    private static String[] cells = new String[]{"_","_","_","_","_","_","_","_","_"};
    private static final Map<String, Integer> coordinate = new HashMap<>() {};
    private static int [][] win = new int[][]{{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6}};

    public static void main(String[] args) {
        coordinate.put("1 1", 0);coordinate.put("1 2", 1);coordinate.put("1 3", 2);coordinate.put("2 1", 3);
        coordinate.put("2 2", 4);coordinate.put("2 3", 5);coordinate.put("3 1", 6);coordinate.put("3 2", 7);
        coordinate.put("3 3", 8);
        while (true) {
            System.out.println("Enter coordinates:");
            String choice = in.nextLine();
            if (!permissible(choice)){
                System.out.println("Enter Coordinates from 1 to 3");
                continue;
            }
            if (!Objects.equals(cells[coordinate.get(choice)], "_")){
                System.out.println("This cell is occupied! Choose another one!");
                return;
            }
            if (succession(cells)%2==1){
                cells[coordinate.get(choice)]="X";
            }
            else {
                cells[coordinate.get(choice)]="O";
            }
            System.out.println("---------\n" +
                    "| " + cells[0] + " " + cells[1] + " " + cells[2] + " |\n" +
                    "| " + cells[3] + " " + cells[4] + " " + cells[5] + " |\n" +
                    "| " + cells[6] + " " + cells[7] + " " + cells[8] + " |\n" +
                    "---------");
            statusOfGame(cells);
        }
    }
    public static boolean checkCells() {
        int O = 0, X = 0;
        for (int i = 0; i < 9; i++) {
            if (Objects.equals(cells[i], "O")) {
                O += 1;
            } else if (Objects.equals(cells[i], "X")) {
                X += 1;
            }
        }
        return Math.abs(O - X) > 1 || Math.abs(X - O) > 1;
    }
    public static void statusOfGame(String[] cells) {
        if (checkCells()) {
            System.out.println("It's Impossible");
            System.exit(0);
        }
        else if (checkEmpt()==0) {
            System.out.println("Draw");
        }
        for (int[] i : win) {
            if (cells[i[0]] == cells[i[1]] && cells[i[1]] == cells[i[2]] && cells[i[0]] != "_") {
                System.out.println(cells[i[0]] + " wins");
                System.exit(0);
            }
        }
    }
    public static int checkEmpt(){
        int num_cells = 0;
        for (String i: cells){
            if(Objects.equals(i, "_")){
                num_cells+=1;
            }
        }
        return num_cells;
    }

    public static boolean permissible(String choise) {
        String permissibleValue  = "123";
        String[] value = choise.split(" ");
        for (int i = 0; i < 2; i++) {
            if (!permissibleValue.contains(value[i])) {
                return false;
            }
        }
        return true;
    }
    public static int succession (String[] cells){
        int counter = 0;
        for (String i : cells) {
            if (Objects.equals(i, "_")) {
                counter += 1;
            }
        }
        return counter;
    }
}
