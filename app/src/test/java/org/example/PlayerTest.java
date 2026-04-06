package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;

public class PlayerTest {
    @Test
    void getPlayerSymbolFunctionWorks() {
        Player player1 = new Player('X', "Joe");
        Player player2 = new Player('O', "Jane");
        assertEquals('X', player1.getPlayerSymbol());
        assertEquals('O', player2.getPlayerSymbol());
    }

    @Test
    void getPlayerMovePlacesValidMoveCorrectly() {
        Board board = new Board();
        Player player1 = new Player('X', "Joe");
        @SuppressWarnings("unused")
        Player player2 = new Player('O', "Jane");
        assertEquals('1', board.getBoardCell(0, 0));
        String testInput = "1";
        Scanner in = new Scanner(testInput);
        player1.getNextMove(board, in);
        assertEquals('X', board.getBoardCell(0, 0));
    }
}
