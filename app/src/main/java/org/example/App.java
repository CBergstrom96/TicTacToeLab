package org.example;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    while(true) {
      Game game = new Game(in);

      game.playGame();
      
      if (!game.playAgain()) {
        System.out.println("Goodbye!");
        break;
      }
    }
}

}
