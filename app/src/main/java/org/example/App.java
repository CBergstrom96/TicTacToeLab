package org.example;
import java.util.Scanner;

public class App {

  //The switch remains incomplete, but I hope you can see where I am going with the program. Case 2 and 3 not finished. 

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Welcome to Tic Tac Toe!");

    while(true) {//Loop that encapsulates whole app, bringing you back to the switch statement

      System.out.println("Choose game mode:\n");
      System.out.println("1. Human vs Human");
      System.out.println("2. Human vs Computer");
      System.out.println("3. Computer vs Human");
      System.out.println("4. Exit program\n");
      System.out.print("Your choice: ");
    
      int userChoice;

      //This block ensures user input is valid before proceeding
      while (true) {
        String input = in.nextLine();
        try {
            userChoice = Integer.parseInt(input.trim());
            if (userChoice >= 1 && userChoice <= 4) break;

        } catch (Exception exception) {}

        System.out.print("Invalid input. Please enter a number from 1 to 4. Try again: ");
      }
  
      switch (userChoice) {
        case 1: //CASE 1: my old code, moved into switch statement.
          System.out.println("You chose Human vs Human. X goes first.");
  
          HumanPlayer player1 = new HumanPlayer('X', "Player 1");
          HumanPlayer player2 = new HumanPlayer('O', "Player 2");
          Game game = new Game(in, player1, player2);
  
          while(true) {
  
            game.playGame();
        
            if (!game.playAgain()) {
              break;
            }
            game.getBoard().clear();
  
          }
          ExportToFile.scoreSheet(game);
          break;

        case 2: //
          System.out.println("You chose Human vs Computer. X goes first.");

          HumanPlayer humanPlayer = new HumanPlayer('X', "Player");
          RobotPlayer robotPlayer = new RobotPlayer('O', "Computer");
          Game humanVsRobotGame = new Game(in, humanPlayer, robotPlayer);

      }
    }
  }

}
