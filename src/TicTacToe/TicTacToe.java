package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("X O X\n" +
                "O X O\n" +
                "X X O");
        System.out.print("Enter cells:");
        String cells = in.nextLine();
        for(int i=0;i<cells.length();i++)
        {
            char c = cells.charAt(i);
            if((!Character.isDigit(c))&&(!Character.isWhitespace(c))) {
                if (c == 'X' || c == 'O' || c== '_') {
                    System.out.println("---------\n" + "| " + cells.charAt(0) + " " + cells.charAt(1) + " " + cells.charAt(2) + " |\n" +
                            "| " + cells.charAt(3) + " " + cells.charAt(4) + " " + cells.charAt(5) + " |\n" +
                            "| " + cells.charAt(6) + " " + cells.charAt(7) + " " + cells.charAt(8) + " |\n" + "---------");
                    break;
                } else {
                    System.out.println("Enter Only 'X' or 'O' or '_'");
                    break;
                }
            } else {
                System.out.println("Enter Only 'O' or 'X' or '_' Symbols");
            }
            break;
        }
    }
}
