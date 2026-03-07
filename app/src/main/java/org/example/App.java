package org.example;

public class App {

  public static void main(String[] args) {

    while(true) {
      Game game = new Game();

      game.playGame();
      
      if (!game.playAgain()) {
        System.out.println("Goodbye!");
        break;
      }
    }
}

}
