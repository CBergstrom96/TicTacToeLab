package org.example;

import java.util.Scanner;

public abstract class Player { //I abstracted this class because the only difference between a human and robot player is the getNextMove function.

    private final char playerSymbol;
    private String name;
    private int winCount;
    private boolean wonGame;
    
    public Player(char playerSymbol, String name) {
        this.playerSymbol = playerSymbol;
        this.name = name;
        this.winCount = 0;
        this.wonGame = false;
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

    public abstract void getNextMove(Board board, Scanner in);
        

}
