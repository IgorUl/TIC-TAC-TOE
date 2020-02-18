package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Field {

    Scanner sc = new Scanner(System.in);
    char[][] field = new char[3][3];

    public boolean checkLine(char[][] arrCh, char ch) {
        for (int i = 0; i < arrCh.length; i++) {
            if ((arrCh[i][0] == ch && arrCh[i][1] == ch && arrCh[i][2] == ch) ||
                    (arrCh[0][i] == ch && arrCh[1][i] == ch && arrCh[2][i] == ch)) {
                return true;
            }
        }
        return (arrCh[0][0] == ch && arrCh[1][1] == ch && arrCh[2][2] == ch) ||
                (arrCh[2][0] == ch && arrCh[1][1] == ch && arrCh[0][2] == ch);
    }

    public boolean isFull(char[][] arrCh) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (arrCh[i][j] == ' ') {
                    return false;
                }
        return true;
    }

    public int countChar(char[][] arrCh, char ch) {
        int count = 0;
        for (char[] chars : arrCh) {
            for (char aChar : chars) {
                if (aChar == ch) {
                    count++;
                }
            }
        }
        return count;
    }

    public void initField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.field[i][j] = ' ';
            }
        }
    }

    public void checkWin() {
        if (checkLine(this.field, 'X') && checkLine(this.field, 'O')) {
            System.out.println("Impossible");
            System.exit(0);
        } else if (checkLine(this.field, 'X')) {
            System.out.println("X wins");
            System.exit(0);
        } else if (checkLine(this.field, 'O')) {
            System.out.println("O wins");
            System.exit(0);
        } else if (Math.abs(countChar(this.field, 'X') - countChar(this.field, 'O')) > 1) {
            System.out.println("Impossible");
            System.exit(0);
        } else if (isFull(this.field)) {
            System.out.println("Draw");
            System.exit(0);
        }
    }

    public void showField() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(this.field[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public void game() {
        char curTurn = 'X';
        while (true) {
            switch (curTurn) {
                case 'X':
                    checkUserInput('X');
                    showField();
                    checkWin();
                    curTurn = 'O';
                    break;
                case 'O':
                    checkUserInput('O');
                    showField();
                    checkWin();
                    curTurn = 'X';
                    break;
            }
        }
    }

    public void checkUserInput(char ch) {
        boolean check = false;
        while (!check) {
            System.out.print("Enter the coordinates: ");
            try {
                int row = sc.nextInt();
                int column = Integer.parseInt(sc.nextLine().strip());
                if (row < 1 || row > 3 || column < 1 || column > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (this.field[3 - column][row - 1] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                this.field[3 - column][row - 1] = ch;
                check = true;
            } catch (InputMismatchException | NumberFormatException e) {
                sc.nextLine();
                System.out.println("You should enter numbers!");
                check = false;
            }
        }
    }
}


