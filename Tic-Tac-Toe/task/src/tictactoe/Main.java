package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[][] cellsMatrix = new String[3][3];

        System.out.print("Enter cells: ");

        Scanner scanner = new Scanner(System.in);
        fillCells(cellsMatrix, scanner.nextLine().split(""));
        printCells(cellsMatrix);

        System.out.print("Enter the coordinates: ");
        while (checkCoordinates(cellsMatrix, scanner)) {
            System.out.print("Enter the coordinates: ");
        }

        printCells(cellsMatrix);
    }

    static void fillCells(String[][] cellsMatrix, String[] cellsArray) {
        int i = 0;
        int j = 2;

        for (int k = cellsArray.length - 1; k >= 0; k--) {
            cellsMatrix[i][j] = cellsArray[k];

            if (--j < 0) {
                j = 2;
                i++;
            }
        }
    }

    static void printCells(String[][] cellsMatrix) {
        System.out.println("---------");
        for (int i = 2; i >= 0; i--) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.printf("%s ", cellsMatrix[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    static boolean checkCoordinates(String[][] cellsMatrix, Scanner scanner) {
        int i, j;

        while(!scanner.hasNextInt()) {
            System.out.println("You should enter numbers!");
            System.out.print("Enter the coordinates: ");
            scanner.next();
        }
        i = scanner.nextInt();
        j = scanner.nextInt();

        if (--i > 2 || --j > 2) {
            System.out.println("Coordinates should be from 1 to 3!");
            return true;
        } else if (cellsMatrix[j][i].equals("X") || cellsMatrix[j][i].equals("O")) {
            System.out.println("This cell is occupied! Choose another one!");
            return true;
        } else {
            cellsMatrix[j][i] = "X";
            return false;
        }
    }
}