import java.util.Scanner;

public class tictactoegame {

    private char[][] board;
    private char currentPlayer;

    public tictactoegame() {
        board = new char[3][3]; // 3x3 Spielfeld für Tic-Tac-Toe
        currentPlayer = 'X'; // Spieler X beginnt
        initializeBoard();
    }

    private void initializeBoard() {
        // Initialisiere das Spielfeld mit leeren Feldern
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        System.out.println("Willkommen bei Tic-Tac-Toe!");
        System.out.println("Spieler X beginnt.");

        while (gameRunning) {
            printBoard();
            System.out.println("Spieler " + currentPlayer + ", gib deine Zugkoordinaten ein (Zeile Spalte):");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;

                if (checkForWin()) {
                    printBoard();
                    System.out.println("Herzlichen Glückwunsch! Spieler " + currentPlayer + " hat gewonnen!");
                    gameRunning = false;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("Unentschieden! Das Spiel endet.");
                    gameRunning = false;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Ungültiger Zug! Bitte gib gültige Koordinaten ein.");
            }
        }

        scanner.close();
    }

    private void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    private boolean checkForWin() {
        // Überprüfe horizontale und vertikale Linien
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
            if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }

        // Überprüfe diagonale Linien
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        tictactoegame game = new tictactoegame();
        game.startGame();
    }
}
