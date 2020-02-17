package tictactoe;

import java.util.Scanner;



public class Main {

    public static boolean checkLine(char[][] arrCh, char ch) {
        for (int i = 0; i < arrCh.length; i++) {
            if ((arrCh[i][0] == ch && arrCh[i][1] == ch && arrCh[i][2] == ch) ||
                    (arrCh[0][i] == ch && arrCh[1][i] == ch && arrCh[2][i] == ch)) {
                return true;
            }
        }
        return (arrCh[0][0] == ch && arrCh[1][1] == ch && arrCh[2][2] == ch) ||
                (arrCh[2][0] == ch && arrCh[1][1] == ch && arrCh[0][2] == ch);
    }

    public static boolean isFull(char[][] arrCh) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (arrCh[i][j] == '_') {
                    return false;
                }
        return true;
    }

    public static int countChar(char[][] arrCh, char ch) {
        int count = 0;
        for (int i = 0; i < arrCh.length; i++) {
            for (int j = 0; j < arrCh[i].length; j++) {
                if (arrCh[i][j] == ch) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[][] field = new char[3][3];
        System.out.print("Enter cells: ");
        String str = sc.nextLine();
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = str.charAt(k++);
            }
        }
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for ( int j = 0; j < 3; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
        if (checkLine(field, 'X') && checkLine(field, 'O')) {
            System.out.println("Impossible");
        } else if (checkLine(field, 'X')) {
            System.out.println("X wins");
        } else if (checkLine(field, 'O')) {
            System.out.println("O wins");
        } else if (Math.abs(countChar(field, 'X') - countChar(field, 'O')) > 1) {
            System.out.println("Impossible");
        } else if (isFull(field)) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }

    }

}
