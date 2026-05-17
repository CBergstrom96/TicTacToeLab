package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

public class RobotPlayerTest {
    @Test void robotChoosesCornerFirst() {
        Board board = new Board();
        Player robot = new RobotPlayer('X', "Robot");
        Player human = new HumanPlayer('O', "Joe");
        Scanner in = new Scanner("Y");
        Game game = new Game(in, robot, human);
        assertFalse(
            board.getBoardCell(0, 0) == 'X' ||
            board.getBoardCell(0, 2) == 'X' ||
            board.getBoardCell(2, 0) == 'X' ||
            board.getBoardCell(2, 2) == 'X'
        );
        robot.getNextMove(board, in); //Robot makes move
        assertTrue(
            board.getBoardCell(0, 0) == 'X' ||
            board.getBoardCell(0, 2) == 'X' ||
            board.getBoardCell(2, 0) == 'X' ||
            board.getBoardCell(2, 2) == 'X'
        );
    }

    @Test void robotChoosesMiddleSecond() {
        Board board = new Board();
        Player robot = new RobotPlayer('X', "Robot");
        Player human = new HumanPlayer('O', "Joe");
        Scanner in = new Scanner("Y");
        Game game = new Game(in, robot, human);
        board.setBoardCell(0, 0, 'O');
        assertFalse(board.getBoardCell(1, 1) == 'X');
        robot.getNextMove(board, in); //Robot makes move
        assertTrue(board.getBoardCell(1, 1) == 'X');
    }

    @Test void robotChoosesWin() {
        Board board = new Board();
        Player robot = new RobotPlayer('X', "Robot");
        Player human = new HumanPlayer('O', "Joe");
        Scanner in = new Scanner("Y");
        Game game = new Game(in, robot, human);
        board.setBoardCell(0, 1, 'X');
        board.setBoardCell(1, 1, 'X');
        board.setBoardCell(0, 0, 'O');
        board.setBoardCell(1, 0, 'O'); //Player is about to win, but robot can win first
        assertFalse(board.getBoardCell(2, 1) == 'X');
        robot.getNextMove(board, in); //Robot makes move
        assertTrue(board.getBoardCell(2, 1) == 'X');
    }

    @Test void robotBlocksWin() {
        Board board = new Board();
        Player robot = new RobotPlayer('X', "Robot");
        Player human = new HumanPlayer('O', "Joe");
        Scanner in = new Scanner("Y");
        Game game = new Game(in, robot, human);
        board.setBoardCell(0, 1, 'O');
        board.setBoardCell(1, 1, 'O');
        assertFalse(board.getBoardCell(2, 1) == 'X');
        robot.getNextMove(board, in); //Robot makes move
        assertTrue(board.getBoardCell(2, 1) == 'X');
    }
}
