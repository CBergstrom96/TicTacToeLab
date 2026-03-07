package org.example;

import java.util.Scanner;

public class Game {

    Scanner in = new Scanner(System.in);
    Board board = new Board();
    Player player1 = new Player('X');
    Player player2 = new Player('O');
    

    public void playGame() {
      System.out.println("Welcome to Tic Tac Toe!");
      System.out.println("Player 1 is " + player1.getPlayerSymbol());
      System.out.println("Player 2 is " + player2.getPlayerSymbol());
      board.printBoard();

      while(true) {
        player1.getNextMove(board, in);
        board.printBoard();

        if(board.hasWinner(player1.getPlayerSymbol())) {
          System.out.println("Player " + player1.getPlayerSymbol() + " wins!");
          break;
        }

        if(board.hasTie(player1.getPlayerSymbol(), player2.getPlayerSymbol())) {   //I put the tie check here because player 1 always goes last in a tie.
            System.out.println("It's a tie!");
            break;
        }
   
        player2.getNextMove(board, in);
        board.printBoard();

        if(board.hasWinner(player2.getPlayerSymbol())) {
          System.out.println("Player " + player2.getPlayerSymbol() + " wins!");
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
    
}
