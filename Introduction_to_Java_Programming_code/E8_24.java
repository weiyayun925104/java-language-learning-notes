/*
  Listing 8.4 checks whether a solution is valid by checking whether every
  number is valid in the board. Rewrite the program by checking whether every
  row, every column, and every small box has the numbers 1 to 9.
*/

import java.util.Scanner;

public class E8_24 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    if (isValid(getInput(input))) {
      System.out.println("Valid solution");
    } else {
      System.out.println("Invalid solution");
    }
  }

  public static int[][] getInput(Scanner input) {
    System.out.println("Enter a Sudoku puzzle solution:");
    int[][] su = new int[9][9];
    for (int i = 0; i < su.length; i++) {
      for (int j = 0; j < su[i].length; j++) {
        su[i][j] = input.nextInt();
      }
    }
    return su;
  }

  public static boolean isValid(int[][] su) {
    // check entire board for valid range of entries (1-9)
    for (int i = 0; i < su.length; i++) {
      for (int j = 0; j < su[i].length; j++) {
        int value = su[i][j];
        if (value < 1 || value > 9) { return false; }
      }
    }

    // check rows
    for (int i = 0; i < su.length; i++) {
      // perform a count of each possible value
      int[] counts = new int[su.length];
      for (int j = 0; j < su[i].length; j++) {
        int value = su[i][j];
        counts[value - 1]++;
      }
      // if all counts are not 1, then the row is invalid
      if (!isCorrectCount(counts)) { return false; }
    }

    // check columns
    for (int i = 0; i < su[0].length; i++) {
      // perform a count of each possible value
      int[] counts = new int[su.length];
      for (int j = 0; j < su.length; j++) {
        int value = su[j][i];
        counts[value - 1]++;
      }
      // if all counts are not 1, then the column is invalid
      if (!isCorrectCount(counts)) { return false; }
    }

    // check small boxes
    for (int i = 0; i < su.length; i += 3) { // 3 "big rows"
      for (int j = 0; j < su.length; j += 3) { // 3 "big columns"
        int[] counts = new int[su.length];
        for (int k = i; k < i + 3; k++) { // 3 rows
          for (int m = j; m < j + 3; m++) {
            int value = su[k][m];
            counts[value - 1]++;
          }
        }
        if (!isCorrectCount(counts)) { return false; }
      }
    }

    return true;
  }

  public static void displayCounts(int[] counts) {
    for (int i = 0; i < counts.length; i++) {
      System.out.print(counts[i] + " ");
    }
    System.out.println();
  }

  public static boolean isCorrectCount(int[] counts) {
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] != 1) { return false; }
    }
    return true;
  }
}
