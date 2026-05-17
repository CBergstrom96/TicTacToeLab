package org.example;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Welcome to Tic Tac Toe!");

    System.out.println("Choose game mode:\n");
    System.out.println("1. Human vs Human");
    System.out.println("2. Human vs Computer");
    System.out.println("3. Computer vs Human");
    System.out.print("Your choice: ");
    
    int userChoice;

    //This block ensures user input is valid before proceeding
    while (true) {
      String input = in.nextLine();
      try {
          userChoice = Integer.parseInt(input.trim());
          if (userChoice >= 1 && userChoice <= 3) break;
      } catch (Exception exception) {}

      System.out.print("Invalid input. Please enter a number from 1 to 3. Try again: ");
    }
  
    switch (userChoice) {
      case 1: //CASE 1: my old code, moved into switch statement.
        System.out.println("You chose Human vs Human.");
  
        Player player1 = new HumanPlayer('X', "Player 1");
        Player player2 = new HumanPlayer('O', "Player 2");
        Game HvHgame = new Game(in, player1, player2);
  
        while(true) {
  
          HvHgame.playGame();
        
          if (!HvHgame.playAgain()) {
            break;
          }
          HvHgame.getBoard().clear();
  
        }

        ExportToFile.scoreSheet(HvHgame);
        break;

      case 2:
        System.out.println("You chose Human vs Robot.");

        Player humanPlayer1 = new HumanPlayer('X', "Human");
        Player robotPlayer2 = new RobotPlayer('O', "Robot");
        Game HvRgame = new Game(in, humanPlayer1, robotPlayer2);
  
        while(true) {
  
          HvRgame.playGame();
        
          if (!HvRgame.playAgain()) {
            break;
          }
          HvRgame.getBoard().clear();
  
        }

        ExportToFile.scoreSheet(HvRgame);
        break;

      case 3:
        System.out.println("You chose Robot vs Human.");

        Player robotPlayer1 = new RobotPlayer('X', "Robot");
        Player humanPlayer2 = new HumanPlayer('O', "Human");
        Game RvHgame = new Game(in, robotPlayer1, humanPlayer2);
  
        while(true) {
  
          RvHgame.playGame();
        
          if (!RvHgame.playAgain()) {
            break;
          }
          RvHgame.getBoard().clear();
  
        }

        ExportToFile.scoreSheet(RvHgame);
        break;
    }
    
  }
  

}
