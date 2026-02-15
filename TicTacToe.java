import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        String name = prompt(scanner);
        System.out.println("Welcome " + name + "!");

        while (gameRunning) {
            printBoard();
            int col = getCol(scanner);
            int row = getRow(scanner);

            if (row >= 1 && row <= 3 && col >= 1 && col <= 3 && board[row][col] == ' ') {
                board[col - 1][row - 1] = currentPlayer;
                printBoard();
            }

            gameRunning = false;
        }
    }

    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("--+---+--");
        }
    }

    public static String prompt(Scanner scanner) {
        System.out.print("Please enter a name: ");
        return scanner.nextLine();
    }

    public static int getCol(Scanner scanner) {
        System.out.print("Please enter a column number (1-3): ");
        return scanner.nextInt();
    }

    public static int getRow(Scanner scanner) {
        System.out.print("Please enter a row number (1-3): ");
        return scanner.nextInt();
    }
}