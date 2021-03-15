/*
  In a game of tic-tac-toe, two players take turns marking an available cell in
  a 3 x 3 grid with their respective tokens (either X or O). When one player
  has placed three tokens in a horizontal, vertical, or diagonal row on the
  grid, the game is over and that player has won. A draw (no winner) occurs
  when all the cells on the grid have been filled with tokens and neither
  player has achieved a win. Create a program for playing tic-tac-toe.

  The program prompts two players to enter an X token and O token alternately.
  Whenever a token is entered, the program redisplays the board on the console
  and determines the status of the game (win, draw, or continue).
*/

import java.util.Scanner;

public class E8_09 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    playGame(input);
  }

  public static void playGame(Scanner input) {
    int[][] board = getNewBoard();
    boolean gameOver;
    boolean xTurn = true;

    do {
      gameOver = false;
      String token = xTurn ? "X" : "O"; // set the current player's token

      displayBoard(board);

      // get input
      int row;
      int column;
      do {
        System.out.print("Enter a row (0, 1, or 2) for player " + token + ": ");
        row = input.nextInt();
        System.out.print("Enter a column (0, 1, or 2) for player " + token +
          ": ");
        column = input.nextInt();
      } while ((row > 2 || row < 0) || (column > 2 || column < 0) ||
        (board[row][column] != -1));

      // mark the board with the player's token
      board[row][column] = xTurn ? 1 : 0;

      // check the game status
      int status = getGameStatus(board);
      if (status == -1) {
        xTurn = !xTurn;
      } else {
        displayBoard(board);
        gameOver = !gameOver;
        if (status == 1) {
          System.out.println(token + " player won");
        } else {
          System.out.println("It's a draw");
        }
      }
    } while (!gameOver);
  }

  public static int getGameStatus(int[][] board) {
    // -1 for continue, zero for draw , and 1 for winner

    // check rows
    for (int i = 0; i < board.length; i++) {
      int xCount = 0;
      int oCount = 0;
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 1) { xCount++; }
        if (board[i][j] == 0) { oCount++; }
        if (xCount == 3 || oCount == 3) { return 1; }
      }
    }

    // check columns
    for (int i = 0; i < board[0].length; i++) {
      int xCount = 0;
      int oCount = 0;
      for (int j = 0; j < board.length; j++) {
        if (board[j][i] == 1) { xCount++; }
        if (board[j][i] == 0) { oCount++; }
        if (xCount == 3 || oCount == 3) { return 1; }
      }
    }

    // check diagonals
    int xCount = 0;
    int oCount = 0;
    for (int i = 0, j = 0; i < board.length && j < board[i].length; i++, j++) {
      if (board[i][j] == 1) { xCount++; }
      if (board[i][j] == 0) { oCount++; }
      if (xCount == 3 || oCount == 3) { return 1; }
    }

    xCount = 0;
    oCount = 0;
    for (int i = board.length - 1, j = 0; i >= 0 && j < board[i].length;
      i--, j++) {
      if (board[i][j] == 1) { xCount++; }
      if (board[i][j] == 0) { oCount++; }
      if (xCount == 3 || oCount == 3) { return 1; }
    }

    // check entire board. any -1 at this point means the game should continue.
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == -1) { return -1; }
      }
    }

    // otherwise it's a draw
    return 0;
  }

  public static int[][] getNewBoard() {
    int[][] board = new int[3][3];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = -1;
      }
    }
    return board;
  }

  public static void displayBoard(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      System.out.println("-------------");
      for (int j = 0; j < board[i].length; j++) {
        String token = " ";
        if (board[i][j] == 1) { token = "X"; }
        if (board[i][j] == 0) { token = "O"; }
        System.out.print("| " + token + " ");
      }
      System.out.println("|");
    }
    System.out.println("-------------");
  }
}
