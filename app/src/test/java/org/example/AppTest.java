package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  @Test
  void getBoardCellFunctionWorks() {
    Game game = new Game();
    assertEquals(' ', game.board.getBoardCell(0, 0));
  }


  @Test
  void setBoardCellFunctionWorks() {
    Game game = new Game();
    game.board.setBoardCell(0, 0, 'X');
    assertEquals('X', game.board.getBoardCell(0, 0));
  }

  @Test
  void player1WinsAnd2Loses() {
    Game game = new Game();
    game.board.setBoardCell(0, 0, 'X');
    game.board.setBoardCell(0, 1, 'X');
    game.board.setBoardCell(0, 2, 'X');
    game.board.hasWinner('X');
    assertTrue(game.board.hasWinner('X'));
    assertFalse(game.board.hasWinner('O'));
  }

  @Test
  void boardIsTie() {
    Game game = new Game();
    game.board.setBoardCell(0, 0, 'X');
    game.board.setBoardCell(0, 1, 'X');
    game.board.setBoardCell(0, 2, 'O');
    game.board.setBoardCell(1, 0, 'O'); //X X O
    game.board.setBoardCell(1, 1, 'O'); //O O X
    game.board.setBoardCell(1, 2, 'X'); //X O X
    game.board.setBoardCell(2, 0, 'X');
    game.board.setBoardCell(2, 1, 'O');
    game.board.setBoardCell(2, 2, 'X');
    assertTrue(game.board.hasTie('X', 'O'));
  }

  @Test
  void emptySpaceIsNotValidMove() {
    Game game = new Game();
    assertFalse(game.board.isValidMove(" "));
  }

  @Test
  void TenIsInvalidMove() {
    Game game = new Game();
    assertFalse(game.board.isValidMove("10"));
  }

  @Test
  void nonNumbersAreInvalidMoves() {
    Game game = new Game();
    assertFalse(game.board.isValidMove("%"));
  }

  @Test
  void occupiedSpaceIsNotValidMove() {
    Game game = new Game();
    game.board.setBoardCell(0, 0, 'X');
    assertFalse(game.board.isValidMove("1"));
  }

  @Test
  void validMoveIsValid() {
    Game game = new Game();
    assertTrue(game.board.isValidMove("1"));
  }

  @Test
  void boardCorrectlyPlacesXInTopLeft() {
    Game game = new Game();
    game.board.setBoardCell(0, 0, 'X');
    assertEquals('X', game.board.getBoardCell(0, 0));
  }
}
