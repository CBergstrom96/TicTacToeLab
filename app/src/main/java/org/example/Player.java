package org.example;

import java.util.Scanner;

public class Player {

    private final char playerSymbol;
    
    public Player(char playerSymbol) {
        this.playerSymbol = playerSymbol;

    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }


    public void getNextMove(Board board, Scanner in) {
        System.out.print("Player " + playerSymbol + ", enter your move (1-9): ");
        while(true) {
            String userInput = in.nextLine();
            if(board.isValidMove(userInput)) {
                switch(userInput) {
                    case "1":
                        board.setBoardCell(0, 0, playerSymbol);
                        break;
                    case "2":
                        board.setBoardCell(0, 1, playerSymbol);
                        break;
                    case "3":
                        board.setBoardCell(0, 2, playerSymbol);
                        break;
                    case "4":
                        board.setBoardCell(1, 0, playerSymbol);
                        break;
                    case "5":
                        board.setBoardCell(1, 1, playerSymbol);
                        break;
                    case "6":
                        board.setBoardCell(1, 2, playerSymbol);
                        break;
                    case "7":
                        board.setBoardCell(2, 0, playerSymbol);
                        break;
                    case "8":
                        board.setBoardCell(2, 1, playerSymbol);
                        break;
                    case "9":
                        board.setBoardCell(2, 2, playerSymbol);
                        break;
                    }
                    break;
                } else {
                    board.printBoard();
                    System.out.print("Invalid input. Player " + playerSymbol + ", Enter an open cell on the board (1-9): ");
                }
        }
    }

}
