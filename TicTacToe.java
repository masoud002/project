
import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}
    };
    
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        while (!gameEnded) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (1-9): ");
            int move = scanner.nextInt();

            if (isValidMove(move)) {
                placeMove(move, currentPlayer);
                if (hasWon(currentPlayer)) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameEnded = true;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("The game is a draw!");
                    gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move, try again.");
            }
        }

        scanner.close();
    }

    public static void printBoard() {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static boolean isValidMove(int position) {
        int[] coords = getCoordinates(position);
        return coords != null && board[coords[0]][coords[1]] == ' ';
    }

    public static void placeMove(int position, char player) {
        int[] coords = getCoordinates(position);
        board[coords[0]][coords[1]] = player;
    }

    public static int[] getCoordinates(int position) {
        return switch (position) {
            case 1 -> new int[]{0, 0};
            case 2 -> new int[]{0, 2};
            case 3 -> new int[]{0, 4};
            case 4 -> new int[]{2, 0};
            case 5 -> new int[]{2, 2};
            case 6 -> new int[]{2, 4};
            case 7 -> new int[]{4, 0};
            case 8 -> new int[]{4, 2};
            case 9 -> new int[]{4, 4};
            default -> null;
        };
    }

    public static boolean hasWon(char player) {
        return (checkLine(player, 0, 0, 0, 2, 0, 4) || // row 1
                checkLine(player, 2, 0, 2, 2, 2, 4) || // row 2
                checkLine(player, 4, 0, 4, 2, 4, 4) || // row 3
                checkLine(player, 0, 0, 2, 0, 4, 0) || // col 1
                checkLine(player, 0, 2, 2, 2, 4, 2) || // col 2
                checkLine(player, 0, 4, 2, 4, 4, 4) || // col 3
                checkLine(player, 0, 0, 2, 2, 4, 4) || // diag
                checkLine(player, 0, 4, 2, 2, 4, 0));  // anti-diag
    }

    public static boolean checkLine(char player, int r1, int c1, int r2, int c2, int r3, int c3) {
        return board[r1][c1] == player && board[r2][c2] == player && board[r3][c3] == player;
    }

    public static boolean isBoardFull() {
        for (int pos = 1; pos <= 9; pos++) {
            int[] coords = getCoordinates(pos);
            if (board[coords[0]][coords[1]] == ' ') return false;
        }
        return true;
    }
}
