
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
                // Weitere Logik wird später hinzugefügt
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
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

    public static void main(String[] args) {
        tictactoegame game = new tictactoegame();
        game.startGame();
    }
}
