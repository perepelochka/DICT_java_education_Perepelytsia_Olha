package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static Scanner in = new Scanner(System.in);

    public static boolean if_Win_X = false, if_Win_O = false;

    public static void main(String[] args) {
        System.out.println("X O X\n" +
                "O X O\n" +
                "X X O");
        System.out.print("Enter cells:");
        String cells = in.nextLine();
        for (int i = 0; i < cells.length(); i++) {
            char c = cells.charAt(i);
            if ((!Character.isDigit(c)) && (!Character.isWhitespace(c))) {
                if (c == 'X' || c == 'O' || c == '_') {
                    System.out.println("---------\n" + "| " + cells.charAt(0) + " " + cells.charAt(1) + " " + cells.charAt(2) + " |\n" +
                            "| " + cells.charAt(3) + " " + cells.charAt(4) + " " + cells.charAt(5) + " |\n" +
                            "| " + cells.charAt(6) + " " + cells.charAt(7) + " " + cells.charAt(8) + " |\n" + "---------");
                    statusOfGame(cells);
                } else {
                    System.out.println(" Enter Only 'X' or 'O' or '_'");
                    break;
                }
                break;
            }

        }
        public static boolean check_amount (String cells){
            int O = 0, X = 0;
            for (int i = 0; i < 9; i++) {
                if (cells.charAt(i) == "O".charAt(0)) {
                    O += 1;
                } else if (cells.charAt(i) == "X".charAt(0)) {
                    X += 1;
                }
            }
            return Math.abs(O - X) > 1 || Math.abs(X - O) > 1;
        }
        public static void statusOfGame (String cells){
            if (cells.charAt(0) == 'X' && cells.charAt(1) == 'X' && cells.charAt(2) == 'X' || cells.charAt(3) == 'X' &&
                    cells.charAt(4) == 'X' && cells.charAt(5) == 'X' || cells.charAt(6) == 'X' && cells.charAt(7) == 'X' &&
                    cells.charAt(8) == 'X' || cells.charAt(0) == 'X' && cells.charAt(3) == 'X' && cells.charAt(6) == 'X' ||
                    cells.charAt(1) == 'X' && cells.charAt(4) == 'X' && cells.charAt(7) == 'X' || cells.charAt(2) == 'X' &&
                    cells.charAt(5) == 'X' && cells.charAt(8) == 'X' || cells.charAt(0) == 'X' && cells.charAt(4) == 'X' &&
                    cells.charAt(8) == 'X' || cells.charAt(2) == 'X' && cells.charAt(4) == 'X' && cells.charAt(6) == 'X') {
                if_Win_X = true;
            }
            if (cells.charAt(0) == 'O' && cells.charAt(1) == 'O' && cells.charAt(2) == 'O' || cells.charAt(3) == 'O' &&
                    cells.charAt(4) == 'O' && cells.charAt(5) == 'O' || cells.charAt(6) == 'O' && cells.charAt(7) == 'O' &&
                    cells.charAt(8) == 'O' || cells.charAt(0) == 'O' && cells.charAt(3) == 'O' && cells.charAt(6) == 'O' ||
                    cells.charAt(1) == 'O' && cells.charAt(4) == 'O' && cells.charAt(7) == 'O' || cells.charAt(2) == 'O' &&
                    cells.charAt(5) == 'O' && cells.charAt(8) == 'O' || cells.charAt(0) == 'O' && cells.charAt(4) == 'O' &&
                    cells.charAt(8) == 'O' || cells.charAt(2) == 'O' && cells.charAt(4) == 'O' && cells.charAt(6) == 'O') {
                if_Win_O = true;
            }
            if (check_amount(cells) || (if_Win_O && if_Win_X)) {
                System.out.println("It's Impossible");
                System.exit(0);
            }
            if (if_Win_O) {
                System.out.println("O wins");
                System.exit(0);
            }
            if (if_Win_X) {
                System.out.println("X wins");
                System.exit(0);
            }
            if (cells.contains("_")) {
                System.out.println("Game not finished");
            } else {
                System.out.println("Draw");
            }
        }
    }
}