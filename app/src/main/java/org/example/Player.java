package org.example;

import java.util.Scanner;

public class Player {

    private final char playerSymbol;
    private String name;
    private int winCount;
    private boolean wonGame = false;
    
    public Player(char playerSymbol, String name) {
        this.playerSymbol = playerSymbol;
        this.name = name;
        this.winCount = 0;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public String getName() { //Added names to players to make the output sheet easier to differentiate
        return name;
    }

    public int getWinCount() {
        return winCount;
    }

    public void addWin() {
        this.winCount++;
    }

    public void hasWonGame() { //Used to temporarily mark the player as winner so Game knows to switch player positions
        this.wonGame = true;
    }

    public void resetWinBoolean() { //Resets the boolean so it can be used next game
        this.wonGame = false;
    }

    public void getNextMove(Board board, Scanner in) {
        System.out.print("   " + name + ", place your " + playerSymbol + " (1-9): ");
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
                    System.out.print("Invalid input. " + name + ", Place your " + playerSymbol + " on an open cell on the board (1-9): ");
                }
        }
    }

}
