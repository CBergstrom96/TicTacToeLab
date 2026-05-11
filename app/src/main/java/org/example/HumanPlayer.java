package org.example;

import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(char playerSymbol, String name) {
        super(playerSymbol, name);
    }

    @Override
    public void getNextMove(Board board, Scanner in) {
        System.out.print("   " + getName() + ", place your " + getPlayerSymbol() + " (1-9): ");
        while(true) {
            String userInput = in.nextLine();
            if(board.isValidMove(userInput)) {
                switch(userInput) {
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
                    break;
                } else {
                    board.printBoard();
                    System.out.print("Invalid input. " + getName() + ", Place your " + getPlayerSymbol() + " on an open cell on the board (1-9): ");
                }
        }
    }
    
}
