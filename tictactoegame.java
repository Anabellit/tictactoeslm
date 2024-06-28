import java.util.Scanner;

public class tictactoegame {

    private char[][] board;
    private char currentPlayer;

    public tictactoegame() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {

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
            playGame(scanner);


            System.out.print("Möchten Sie ein neues Spiel spielen? (ja/nein): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();

            if (!playAgain.equals("ja")) {
                gameRunning = false;
            } else {

                initializeBoard();
                currentPlayer = 'X';
                System.out.println("\nNeues Spiel gestartet!");
            }
        }

        System.out.println("Vielen Dank fürs Spielen!");
        scanner.close();
    }

    private void playGame(Scanner scanner) {
        boolean gameEnded = false;

        while (!gameEnded) {
            printBoard();
            System.out.println("Spieler " + currentPlayer + ", gib deine Zugkoordinaten ein (Zeile Spalte):");

            // Eingabe als String einlesen und in Zeile und Spalte aufteilen
            String input = scanner.nextLine().trim();
            String[] coordinates = input.split("\\s+");

            if (coordinates.length != 2) {
                System.out.println("Ungültige Eingabe! Bitte gib Zeile und Spalte durch Leerzeichen getrennt ein.");
                continue;
            }

            int row, col;
            try {
                row = Integer.parseInt(coordinates[0]) - 1;
                col = Integer.parseInt(coordinates[1]) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe! Bitte gib gültige Zahlen für Zeile und Spalte ein.");
                continue;
            }

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                if (checkWin()) {
                    printBoard();
                    System.out.println("Spieler " + currentPlayer + " hat gewonnen!");
                    gameEnded = true;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("Das Spiel endet unentschieden!");
                    gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Ungültiger Zug! Bitte gib gültige Koordinaten ein.");
            }
        }
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

    private boolean checkWin() {
        // Überprüfe Zeilen und Spalten
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }
        // Überprüfe Diagonalen
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
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
