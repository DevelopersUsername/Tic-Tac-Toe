package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int index = 0;
        int emptyCells = 0;
        int XCells = 0;
        int OCells = 0;
        boolean XWins = false;
        boolean OWins = false;

        System.out.print("Enter cells: ");

        Scanner scanner = new Scanner(System.in);
        String[] cellsArray = scanner.nextLine().split("");

        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.printf("%s ", cellsArray[index]);
                switch (cellsArray[index]) {
                    case " ":
                    case "_":
                        emptyCells++;
                        break;
                    case "X":
                        XCells++;
                        break;
                    case "O":
                        OCells++;
                        break;
                }
                index++;
            }
            System.out.println("|");
        }

        boolean Impossible = (Math.abs(XCells - OCells) > 1);

        if ((cellsArray[0].equals("X") && cellsArray[1].equals("X") && cellsArray[2].equals("X")) ||
                (cellsArray[1].equals("X") && cellsArray[4].equals("X") && cellsArray[7].equals("X")) ||
                (cellsArray[0].equals("X") && cellsArray[3].equals("X") && cellsArray[6].equals("X")) ||
                (cellsArray[0].equals("X") && cellsArray[4].equals("X") && cellsArray[8].equals("X")) ||
                (cellsArray[2].equals("X") && cellsArray[4].equals("X") && cellsArray[6].equals("X")) ||
                (cellsArray[2].equals("X") && cellsArray[5].equals("X") && cellsArray[8].equals("X")) ||
                (cellsArray[6].equals("X") && cellsArray[7].equals("X") && cellsArray[8].equals("X"))) {
            XWins = true;
        }
        if ((cellsArray[0].equals("O") && cellsArray[1].equals("O") && cellsArray[2].equals("O")) ||
                (cellsArray[1].equals("O") && cellsArray[4].equals("O") && cellsArray[7].equals("O")) ||
                (cellsArray[0].equals("O") && cellsArray[3].equals("O") && cellsArray[6].equals("O")) ||
                (cellsArray[0].equals("O") && cellsArray[4].equals("O") && cellsArray[8].equals("O")) ||
                (cellsArray[2].equals("O") && cellsArray[4].equals("O") && cellsArray[6].equals("O")) ||
                (cellsArray[2].equals("O") && cellsArray[5].equals("O") && cellsArray[8].equals("O")) ||
                (cellsArray[6].equals("O") && cellsArray[7].equals("O") && cellsArray[8].equals("O"))) {
            OWins = true;
        }

        System.out.println("---------");

        if (emptyCells > 0 && !Impossible && !XWins && !OWins) {
            System.out.println("Game not finished");
        } else if (!XWins && !OWins && !Impossible) {
            System.out.println("Draw");
        } else if (XWins && !OWins && !Impossible) {
            System.out.println("X wins");
        } else if (OWins && !XWins && !Impossible) {
            System.out.println("O wins");
        } else {
            System.out.println("Impossible");
        }
    }
}