package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    void getBoardCellFunctionWorks() {
      Board board = new Board();
      assertEquals('1', board.getBoardCell(0, 0));
    }
  
  
    @Test
    void setBoardCellFunctionWorks() {
      Board board = new Board();
      board.setBoardCell(0, 0, 'X');
      assertEquals('X', board.getBoardCell(0, 0));
    }

    @Test
    void boardCorrectlyPlacesXInTopRight() {
      Board board = new Board();
      board.setBoardCell(0, 2, 'X');
      assertEquals('X', board.getBoardCell(0, 2));
    }

    @Test
    void player1WinsAnd2Loses() {
      Board board = new Board();
      board.setBoardCell(0, 0, 'X');
      board.setBoardCell(0, 1, 'X');
      board.setBoardCell(0, 2, 'X');
      board.hasWinner('X');
      assertTrue(board.hasWinner('X'));
      assertFalse(board.hasWinner('O'));
    }
  
    @Test
    void boardIsTie() {
      Board board = new Board();
      board.setBoardCell(0, 0, 'X');
      board.setBoardCell(0, 1, 'X');
      board.setBoardCell(0, 2, 'O');
      board.setBoardCell(1, 0, 'O'); //X X O
      board.setBoardCell(1, 1, 'O'); //O O X
      board.setBoardCell(1, 2, 'X'); //X O X
      board.setBoardCell(2, 0, 'X');
      board.setBoardCell(2, 1, 'O');
      board.setBoardCell(2, 2, 'X');
      assertTrue(board.hasTie('X', 'O'));
    }
  
    @Test
    void emptySpaceIsNotValidMove() {
      Board board = new Board();
      assertFalse(board.isValidMove(" "));
    }
  
    @Test
    void TenIsInvalidMove() {
      Board board = new Board();
      assertFalse(board.isValidMove("10"));
    }
  
    @Test
    void nonNumbersAreInvalidMoves() {
      Board board = new Board();
      assertFalse(board.isValidMove("%"));
    }
  
    @Test
    void occupiedSpaceIsNotValidMove() {
      Board board = new Board();
      board.setBoardCell(0, 0, 'X');
      assertFalse(board.isValidMove("1"));
    }
  
    @Test
    void validMoveIsValid() {
      Board board = new Board();
      assertTrue(board.isValidMove("1"));
    }

    @Test
    void clearBoardClearsBoard() {
      Board board = new Board();
      board.setBoardCell(0, 0, 'X');
      board.clear();
      assertEquals('1', board.getBoardCell(0, 0));
    }
    
}
