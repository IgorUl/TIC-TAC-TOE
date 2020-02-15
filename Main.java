package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] field;
        System.out.print("Enter cells: ");
        field = sc.nextLine().toCharArray();
        System.out.println("---------");
        for (int i = 0; i < field.length; i += 3) {
            System.out.println("| " + field[i] + " " + field[i + 1] + " " + field[i + 2] + " |");
        }
        System.out.println("---------");
    }
}
