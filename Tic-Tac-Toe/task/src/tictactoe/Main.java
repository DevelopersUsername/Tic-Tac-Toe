package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int index = 0;
        System.out.print("Enter cells: ");

        Scanner scanner = new Scanner(System.in);
        String[] cellsArray = scanner.nextLine().split("");

        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.printf("%s ", cellsArray[index]);
                index++;
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
