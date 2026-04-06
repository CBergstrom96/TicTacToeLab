package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ExportToFile {
    
    public static void scoreSheet(Game game) {
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();
        try (PrintWriter writer = new PrintWriter(new File("Score Sheet.txt"))) {
            writer.println("Gameplay session results:");
            writer.println(player1.getName() + " has: " + player1.getWinCount() + " wins");
            writer.println(player2.getName() + " has: " + player2.getWinCount() + " wins");
            writer.println("There were: " + game.getTieCount() + " ties.");
            System.out.println("Score sheet saved to Score Sheet.txt");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while saving the score sheet.");
        }
    }
    
}
