package org.example;

import java.util.Scanner;
import java.util.Random;

public class RobotPlayer extends Player {
    
    public RobotPlayer(char playerSymbol, String name) {
        super(playerSymbol, name);
    }

    @Override
    public void getNextMove(Board board, Scanner in) {
        if(boardIsEmpty(board)) {rollRandomCorner(board); return;} //First move? Random corner.
        if(board.isValidMove("5")) {placeMoveAtPosition("5", board); return;} //If the center is open, take it.
        //Attempts to win logic here
        //Attempts to block logic here
        //Else random move
    }

    private boolean boardIsEmpty(Board board) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board.getBoardCell(i, j) == 'X' || board.getBoardCell(i, j) == 'O') {
                    return false;
                }
            }
        }
        return true;
    }

    private void rollRandomCorner(Board board) {
        String[] corners = new String[] {"1", "3", "7", "9"};
        while(true) {
            String randomCorner = corners[new Random().nextInt(corners.length)];
            if(board.isValidMove(randomCorner)) {
                placeMoveAtPosition(randomCorner, board);
                return;
            }
        }
    }

    //This function is useful because random number generators generate numbers, not board cells. This converts from one to the other.
    private void placeMoveAtPosition(String move, Board board) {
        switch(move) {
            case "1":
                board.setBoardCell(0, 0, getPlayerSymbol());
                break;
            case "2":
                board.setBoardCell(0, 1, getPlayerSymbol());
                break;
            case "3":
                board.setBoardCell(0, 2, getPlayerSymbol());
                break;
            case "4":
                board.setBoardCell(1, 0, getPlayerSymbol());
                break;
            case "5":
                board.setBoardCell(1, 1, getPlayerSymbol());
                break;
            case "6":
                board.setBoardCell(1, 2, getPlayerSymbol());
                break;
            case "7":
                board.setBoardCell(2, 0, getPlayerSymbol());
                break;
            case "8":
                board.setBoardCell(2, 1, getPlayerSymbol());
                break;
            case "9":
                board.setBoardCell(2, 2, getPlayerSymbol());
                break;
            }
    }


}
