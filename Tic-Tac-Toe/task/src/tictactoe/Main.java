package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int emptyCells = 11;
        String startCells = "_________";
        String currentSymbol = "X";

        String[][] cellsMatrix = new String[3][3];
        Scanner scanner = new Scanner(System.in);

        fillCells(cellsMatrix, startCells.split(""));
        while (checkWin(cellsMatrix, currentSymbol, --emptyCells)) {
            printCells(cellsMatrix);

            System.out.print("Enter the coordinates: ");
            while (checkCoordinates(cellsMatrix, scanner, currentSymbol)) {
                System.out.print("Enter the coordinates: ");
            }
            currentSymbol = getCurrentSymbol(currentSymbol);
        }
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

    static boolean checkCoordinates(String[][] cellsMatrix, Scanner scanner, String currentSymbol) {
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
            cellsMatrix[j][i] = currentSymbol;
            return false;
        }
    }

    static boolean checkWin(String[][] cellsMatrix, String currentSymbol, int emptyCells) {

        currentSymbol = getCurrentSymbol(currentSymbol);
        if ((cellsMatrix[0][0].equals(currentSymbol) && cellsMatrix[0][1].equals(currentSymbol) && cellsMatrix[0][2].equals(currentSymbol))
                || (cellsMatrix[1][0].equals(currentSymbol) && cellsMatrix[1][1].equals(currentSymbol) && cellsMatrix[1][2].equals(currentSymbol))
                || (cellsMatrix[2][0].equals(currentSymbol) && cellsMatrix[2][1].equals(currentSymbol) && cellsMatrix[2][2].equals(currentSymbol))
                || (cellsMatrix[0][0].equals(currentSymbol) && cellsMatrix[1][0].equals(currentSymbol) && cellsMatrix[2][0].equals(currentSymbol))
                || (cellsMatrix[0][1].equals(currentSymbol) && cellsMatrix[1][1].equals(currentSymbol) && cellsMatrix[2][1].equals(currentSymbol))
                || (cellsMatrix[0][2].equals(currentSymbol) && cellsMatrix[1][2].equals(currentSymbol) && cellsMatrix[2][2].equals(currentSymbol))
                || (cellsMatrix[0][0].equals(currentSymbol) && cellsMatrix[1][1].equals(currentSymbol) && cellsMatrix[2][2].equals(currentSymbol))
                || (cellsMatrix[2][0].equals(currentSymbol) && cellsMatrix[1][1].equals(currentSymbol) && cellsMatrix[0][2].equals(currentSymbol))) {

            printCells(cellsMatrix);
            System.out.printf("%s wins", currentSymbol);
            return false;
        } else if (emptyCells == 0) {
            System.out.println("Game not finished");
            return false;
        } else {
            return true;
        }
    }

    static String getCurrentSymbol(String currentSymbol) {
        if ("X".equals(currentSymbol)) {
            return "O";
        } else {
            return "X";
        }
    }
}