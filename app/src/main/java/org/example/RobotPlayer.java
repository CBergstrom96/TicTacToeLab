package org.example;

import java.util.Scanner;
import java.util.Random;

public class RobotPlayer extends Player {
    
    public RobotPlayer(char playerSymbol, String name) {
        super(playerSymbol, name);
    }

    @Override
    public void getNextMove(Board board, Scanner in) {
        if(board.isEmpty()) { rollRandomCorner(board); return; } //First move? Random corner.
        if(board.isValidMove("5")) { placeMoveAtPosition("5", board, getPlayerSymbol()); return; }//Take center if open
        if(madeWinningMove(board)) return; //Makes the winning move if possible, if not, goes to next function
        if(deniedOpponent(board)) return; //Denies the opponent if possible, if not, goes to next function
        rollRandomMove(board); //If all else fails, place a random move
    }

    private void rollRandomCorner(Board board) {
        String[] corners = new String[] {"1", "3", "7", "9"};
        while(true) {
            String randomCorner = corners[new Random().nextInt(corners.length)]; //Generates a new number until it is a valid move
            if(board.isValidMove(randomCorner)) {
                placeMoveAtPosition(randomCorner, board, getPlayerSymbol());
                return;
            }
        }
    }

    //I'm sure there was a better way to check wins but I like this approach 
    private boolean madeWinningMove(Board board) {
        Board testBoard = new Board(); //Creates a new virtual board to test wins against, so original board is not mutated
        for(int i = 1; i <= 9; i++) {
            testBoard = board.copy(); //Wipes testBoard every loop iteration so moves placed don't stack up
            String move = String.valueOf(i);
            if(testBoard.isValidMove(move)) {
                placeMoveAtPosition(move, testBoard, getPlayerSymbol()); //Places move on virtual board. If move wins:
                if(testBoard.hasWinner(getPlayerSymbol())) {
                    placeMoveAtPosition(move, board, getPlayerSymbol()); //Places winning move on real board
                    return true; //Returns true if a piece was placed
                }
            }
        }
        return false; //False if no piece was placed
    }

    private boolean deniedOpponent(Board board) {
        Board testBoard = new Board(); //Creates a virtual board to test opponent wins against
        char opponentSymbol = getOpponent().getPlayerSymbol(); //Grabs opponent symbol so the robot can place those instead of its own
        for(int i = 1; i <= 9; i++) {
            testBoard = board.copy(); //Wipes testBoard every loop iteration so moves placed don't stack up
            String move = String.valueOf(i);
            if(testBoard.isValidMove(move)) {
                placeMoveAtPosition(move, testBoard, opponentSymbol); //Places opponent symbol on virtual board. If move wins:
                if(testBoard.hasWinner(opponentSymbol)) {
                    placeMoveAtPosition(move, board, getPlayerSymbol()); //Block the player move on the real board
                    return true; //Returns true if a piece was placed
                }
            }
        }
        return false; //False if no piece was placed
    }

    private void rollRandomMove(Board board) {
        while(true) {
            int randomNumber = (new Random().nextInt(8) + 1);
            String move = String.valueOf(randomNumber);
            if(board.isValidMove(move)) {
                placeMoveAtPosition(move, board, getPlayerSymbol());
                return;
            }
        }

    }

    //This function is useful because random number generators generate numbers, not board cells. This converts from one to the other.
    //I needed to use a char symbol in the params because sometimes the robot wants to place an opponents symbol, as seen above.
    private void placeMoveAtPosition(String move, Board board, char symbol) {
        switch(move) {
            case "1":
                board.setBoardCell(0, 0, symbol);
                break;
            case "2":
                board.setBoardCell(0, 1, symbol);
                break;
            case "3":
                board.setBoardCell(0, 2, symbol);
                break;
            case "4":
                board.setBoardCell(1, 0, symbol);
                break;
            case "5":
                board.setBoardCell(1, 1, symbol);
                break;
            case "6":
                board.setBoardCell(1, 2, symbol);
                break;
            case "7":
                board.setBoardCell(2, 0, symbol);
                break;
            case "8":
                board.setBoardCell(2, 1, symbol);
                break;
            case "9":
                board.setBoardCell(2, 2, symbol);
                break;
            }
    }


}
