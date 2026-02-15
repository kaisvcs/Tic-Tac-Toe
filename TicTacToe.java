import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner getName = new Scanner(System.in);
        boolean gameRunning = true;

        String name = prompt(getName);
        System.out.println("Welcome " + name + "!");

        while (gameRunning) {
            printBoard();
            int column = getCol(scanner);
            System.out.println("column: " + column);
            gameRunning = false;
        }
    }

    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("--+---+--");
        }
    }

    public static String prompt(Scanner getName) {
        System.out.print("Please enter a name: ");
        return getName.nextLine();
    }

    public static int getCol(Scanner scanner) {
        System.out.print("Please enter a column number (1-3): ");
        return scanner.nextInt();
    }
}