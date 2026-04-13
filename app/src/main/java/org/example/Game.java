package org.example;

import java.util.Scanner;

public class Game {

    private Scanner in;
    private Board board = new Board();
    private Player player1;
    private Player player2;
    private Player startingPlayer; //This whole startingPlayer/endingPlayer scheme allows my playGame() function to remain unchanged while player positions change
    private Player endingPlayer;
    private int tieCount = 0;

    public Game(Scanner in, Player player1, Player player2) {
      this.in = in;
      this.player1 = player1;
      this.player2 = player2;
      startingPlayer = player1;
      endingPlayer = player2;
    }
    

    public void playGame() {

      board.printBoard();

      System.out.println("        " + startingPlayer.getName() + " goes first.");
      System.out.println("           " + startingPlayer.getName() + " is " + startingPlayer.getPlayerSymbol());
      System.out.println("           " + endingPlayer.getName() + " is " + endingPlayer.getPlayerSymbol());

      while(true) {

        startingPlayer.getNextMove(board, in);
        board.printBoard();

        if(board.hasWinner(startingPlayer.getPlayerSymbol())) {
          System.out.println("            " + startingPlayer.getName() + " wins!");
          startingPlayer.hasWonGame();
          addWinToUserOf(startingPlayer);
          printSessionData();
          setToEndingPlayer(startingPlayer);
          break;
        }

        if(board.hasTie(startingPlayer.getPlayerSymbol(), endingPlayer.getPlayerSymbol())) {   //I put the tie check here because startingPlayer always goes last in a tie.
            System.out.println("            It's a tie!");
            tieCount++;
            break;
        }
   
        endingPlayer.getNextMove(board, in);
        board.printBoard();

        if(board.hasWinner(endingPlayer.getPlayerSymbol())) {
          System.out.println("            " + endingPlayer.getName() + " wins!");
          addWinToUserOf(endingPlayer);
          printSessionData();
          break;
        }
      }
    }
     
     
    public boolean playAgain() {
      System.out.print("Would you like to play again? (y/n): ");
    
      while (true) {
          String userInput = in.nextLine().trim().toLowerCase();
    
          if (userInput.equals("y")) {return true;}
          if (userInput.equals("n")) {return false;}
    
          System.out.print("Invalid input. Enter 'y' or 'n': ");
      }
    }

    public Board getBoard() { //Added this getter to help unit testing
      return board;
    }

    public void setToEndingPlayer(Player winner) { //Makes the winner go last in the next game. Was I supposed to swap their symbols too? I could have. Chose not to for consistency.
        startingPlayer.resetWinBoolean(); //Resets the wonGame boolean for the next game
        Player temp = startingPlayer;
        startingPlayer = endingPlayer;
        endingPlayer = temp;
    }

    public void addWinToUserOf(Player player) { //Determines which player is starting player or ending player and adds the win to the correct player object.
      if(player == player1) {
        player1.addWin();
      } else {
        player2.addWin();
      }
    }

    public void printSessionData() { //Prints the current session data after each game
      System.out.println("Running totals:");
      System.out.println(player1.getName() + " wins: " + player1.getWinCount());
      System.out.println(player2.getName() + " wins: " + player2.getWinCount());
      System.out.println("Ties: " + tieCount);
    }

    public Player getPlayer1() { //Used in ExportToFile to grab the player wins
      return player1;
    }

    public Player getPlayer2() { //Used in ExportToFile to grab the player wins
      return player2;
    }

    public int getTieCount() { //Used in ExportToFile to grab the tie count
      return tieCount;
    }

    public Player getStartingPlayer() { //Used for unit testing
      return startingPlayer;
    }

    public Player getEndingPlayer() { //Used for unit testing
      return endingPlayer;
    }
    
}
