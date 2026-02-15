import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static char markerX = 'X';
    private static char markerO = 'O';
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        //String name = prompt(scanner);
        //System.out.println("Welcome " + name + "!");

        while (gameRunning) {
            printBoard();
            int col = getCol(scanner) - 1;
            int row = getRow(scanner) - 1;

            if (row >= 0 && row <= 2 && col >= 0 && col <= 2 && board[row][col] == ' ') {
                board[row][col] = markerX;
                printBoard();
            }

            int col2 = getCol(scanner) - 1;
            int row2 = getRow(scanner) - 1;

            if (row2 >= 0 && row2 <= 2 && col2 >= 0 && col <= 2 && board[row2][col2] == ' ') {
                board[row2][col2] = markerO;
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