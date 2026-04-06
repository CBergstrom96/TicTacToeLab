package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

public class GameTest {
    @Test
    void playAgainReturnsTrueForY() {
      Player player1 = new Player('X', "Joe");
      Player player2 = new Player('O', "Jane");
      Scanner in = new Scanner("Y");
      Game game = new Game(in, player1, player2);
      assertTrue(game.playAgain());
    }
    @Test
    void playAgainReturnsFalseForN() {
      Player player1 = new Player('X', "Joe");
      Player player2 = new Player('O', "Jane");
      Scanner in = new Scanner("N");
      Game game = new Game(in, player1, player2);
      assertFalse(game.playAgain());
    }
    @Test
    void validMoveHandlesInvalidInputsAndThenReturnsTrue() {
        Player player1 = new Player('X', "Joe");
        Player player2 = new Player('O', "Jane");
        Scanner in = new Scanner("8\n%\nY");
        Game game = new Game(in, player1, player2);
        assertTrue(game.playAgain());
    }

    @Test
    void loserGoesFirstInNextGame() {
        Player player1 = new Player('X', "Joe");
        Player player2 = new Player('O', "Jane");
        Scanner in = new Scanner("Y");
        Game game = new Game(in, player1, player2);
        game.setToEndingPlayer(player1);
        assertEquals(player2, game.getStartingPlayer());
    }

    @Test
    void addsWinToCorrectUser() {
        Player player1 = new Player('X', "Joe");
        Player player2 = new Player('O', "Jane");
        Scanner in = new Scanner("Y");
        Game game = new Game(in, player1, player2);
        game.addWinToUserOf(player1);
        game.addWinToUserOf(player1);
        game.addWinToUserOf(player1);
        game.addWinToUserOf(player2);
        game.addWinToUserOf(player1);
        assertEquals(4, player1.getWinCount()); //Also verifies getWinCount() from Player.java
        assertEquals(1, player2.getWinCount());
    }
}

