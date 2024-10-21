import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';
    static boolean gameRunning = true;

    public static void main(String[] args) {
        initializeBoard();
        Scanner scanner = new Scanner(System.in);

        while (gameRunning) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (row, column): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (isValidMove(row, col)) {
                makeMove(row, col);
                if (checkWin() || checkDraw()) {
                    gameRunning = false;
                } else {
                    switchPlayer();
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        printBoard();

        if (checkWin()) {
            System.out.println("Player " + currentPlayer + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    static boolean isValidMove(int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ');
    }

    static void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }

    static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    static boolean checkWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')) {
            return true;
        }

        return false;
    }

    static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}