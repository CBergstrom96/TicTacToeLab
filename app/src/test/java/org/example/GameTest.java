package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

public class GameTest {
    @Test
    void validMoveReturnsTrueForY() {
      Scanner in = new Scanner("Y");
      Game game = new Game(in);
      assertTrue(game.playAgain());
    }
    @Test
    void validMoveReturnsFalseForN() {
      Scanner in = new Scanner("N");
      Game game = new Game(in);
      assertFalse(game.playAgain());
    }
    @Test
    void validMoveHandlesInvalidInputsAndThenReturnsTrue() {
        Scanner in = new Scanner("8\n%\nY");
        Game game = new Game(in);
        assertTrue(game.playAgain());
    }
}

