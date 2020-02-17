package tictactoe;

public class Main {

    public static void main(String[] args) {

        Field field = new Field();
        field.initField();
        field.showField();
        field.checkUserInput();
        field.showField();
//        if (checkLine(field, 'X') && checkLine(field, 'O')) {
//            System.out.println("Impossible");
//        } else if (checkLine(field, 'X')) {
//            System.out.println("X wins");
//        } else if (checkLine(field, 'O')) {
//            System.out.println("O wins");
//        } else if (Math.abs(countChar(field, 'X') - countChar(field, 'O')) > 1) {
//            System.out.println("Impossible");
//        } else if (isFull(field)) {
//            System.out.println("Draw");
//        } else {
//            System.out.println("Game not finished");
//        }

    }

}
