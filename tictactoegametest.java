import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class tictactoegametest {

    private tictactoegame game;

    @BeforeEach
    public void setUp() {
        game = new tictactoegame();
    }

    @Test
    public void testInitializeBoard() {
        // Positive Test Case
        game.initializeBoard();
        char[][] board = game.getBoard();
        assertEquals('-', board[0][0]);
        assertEquals('-', board[2][2]);

        // Negative Test Case
        board[0][0] = 'X';
        assertNotEquals('-', board[0][0]);
    }

    @Test
    public void testIsValidMove() {
        // Positive Test Case
        assertTrue(game.isValidMove(0, 0));
        assertTrue(game.isValidMove(2, 2));

        // Negative Test Case
        game.getBoard()[0][0] = 'X';
        assertFalse(game.isValidMove(0, 0));
        assertFalse(game.isValidMove(3, 0));
    }



    @Test
    public void testIsBoardFull() {
        // Positive Test Case - Board Full
        char[][] board = game.getBoard();
        board[0][0] = 'X';
        board[0][1] = 'O';
        board[0][2] = 'X';
        board[1][0] = 'X';
        board[1][1] = 'O';
        board[1][2] = 'X';
        board[2][0] = 'O';
        board[2][1] = 'X';
        board[2][2] = 'O';
        assertTrue(game.isBoardFull());

        // Negative Test Case - Board Not Full
        board[2][2] = '-';
        assertFalse(game.isBoardFull());
    }
}
