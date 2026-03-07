package org.example;

public class Board {

    private char[][] board = new char[][] {{'1', '2', '3'},
                                           {'4', '5', '6'},
                                           {'7', '8', '9'}};

                              
    public void printBoard() {
        System.out.println("\n         " + board[0][0] + "  |  " + board[0][1] + "  |  " + board[0][2]);
        System.out.println("        ----+-----+----");
        System.out.println("         " + board[1][0] + "  |  " + board[1][1] + "  |  " + board[1][2]);
        System.out.println("        ----+-----+----");
        System.out.println("         " + board[2][0] + "  |  " + board[2][1] + "  |  " + board[2][2] + "\n");
    }


    public char getBoardCell(int row, int column) {
        return board[row][column];
    }


    public void setBoardCell(int row, int column, char symbol) {
        this.board[row][column] = symbol;
    }
        

    public boolean hasWinner(char symbol) {
        for(int i = 0; i < 3; i++) {
            if(board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
        }
        for(int j = 0; j < 3; j++) {
            if(board[0][j] == symbol && board[1][j] == symbol && board[2][j] == symbol) {
                return true;
            }
        }
        if(board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if(board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }
        return false;
    }

        
    public boolean hasTie(char player1Symbol, char player2Symbol) {
      for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
          if(board[i][j] != player1Symbol && board[i][j] != player2Symbol) {
            return false; //Returns false (no tie) the first time it finds a space without a player symbol
          }
        }
      }
      return true;
    }
    

    public boolean isValidMove(String userInput) {
        switch(userInput) {
            case "1":
                return this.board[0][0] == '1';
            case "2":
                return this.board[0][1] == '2';
            case "3":
                return this.board[0][2] == '3';
            case "4":
                return this.board[1][0] == '4';
            case "5":
                return this.board[1][1] == '5';
            case "6":
                return this.board[1][2] == '6';
            case "7":
                return this.board[2][0] == '7';
            case "8":
                return this.board[2][1] == '8';
            case "9":
                return this.board[2][2] == '9';
            default:
                return false;
        }
    }
}
