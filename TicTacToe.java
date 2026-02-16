import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static char markerX = 'X';
    private static char markerO = 'O';
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        while (gameRunning) {
            System.out.println("__________________\n");
            printBoard();
            int row = getRow(scanner) - 1; // adjust user input to array index
            int col = getCol(scanner) - 1;

            board[row][col] = markerX;
            if (isBoardFull() == true) {
                System.out.println("__________________\n");
                printBoard();
                System.out.println("It's a Tie!");
                gameRunning = false;
            } else if (checkWin() == true) {
                System.out.println("__________________\n");
                printBoard();
                System.out.println("Win!");
                gameRunning = false;
                } 
        }
    }

    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("--+---+--");
        }
    }

    public static int getRow(Scanner scanner) {
        int row;
        while (true) {
            System.out.print("Row number (1-3): ");

            if(!scanner.hasNextInt()) {                         // Check user input for integer                    
                System.out.println("Please enter a number.");
                scanner.next();                                 // discard invalid input
                continue;
            }

            row = scanner.nextInt();
        
            if (row >= 1 && row <= 3) {
                return row;
            } else if (row == 4) {
                System.exit(0);
            } else {
                System.out.println("Invalid Input");
            }
        }
    }
    
    public static int getCol(Scanner scanner) {
        int col;
        while (true) {
            System.out.print("Column number (1-3): ");

            if(!scanner.hasNextInt()) {                             // Check user input for integer            
                System.out.println("Please enter a number.");
                scanner.next();                                    
                continue;
            }

            col = scanner.nextInt();
        
            if (col >= 1 && col <= 3) {
                return col;
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }

    public static boolean checkWin() {                      // check all possible options for wins
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == markerX && board[i][1] == markerX && board[i][2] == markerX) return true;
            if (board[0][i] == markerX && board[1][i] == markerX && board[i][2] == markerX) return true;
            if (board[0][0]== markerX && board[1][1] == markerX && board[2][2] == markerX) return true;
            if (board[0][2]== markerX && board[1][1] == markerX && board[2][0] == markerX) return true;
        }

        return false;
    } 

}