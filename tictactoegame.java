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

            // Eingabe als String einlesen und in Zeile und Spalte aufteilen
            String input = scanner.nextLine().trim();
            String[] coordinates = input.split("\\s+");

            if (coordinates.length != 2) {
                System.out.println("Ungültige Eingabe! Bitte gib Zeile und Spalte durch Leerzeichen getrennt ein.");
                continue; // Zurück zur Eingabeaufforderung
            }

            int row, col;
            try {
                row = Integer.parseInt(coordinates[0]) - 1;
                col = Integer.parseInt(coordinates[1]) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe! Bitte gib gültige Zahlen für Zeile und Spalte ein.");
                continue; // Zurück zur Eingabeaufforderung
            }

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                System.out.println("Spieler " + currentPlayer + " muss einen Zug machen.");
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
