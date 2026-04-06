package org.example;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    Player player1 = new Player('X', "Joe");
    Player player2 = new Player('O', "Jan");
    Game game = new Game(in, player1, player2);

    System.out.println("Welcome to Tic Tac Toe! X goes first.");

    while(true) {

      game.playGame();
      
      if (!game.playAgain()) {
        System.out.println("Goodbye!");
        break;
      }

      game.getBoard().clear();

    }

    ExportToFile.scoreSheet(game);
}

}
