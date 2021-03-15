/*
  Suppose you are given a 6-by-6 matrix filled with 0s and 1s. All rows and all
  columns have an even number of 1s. Let the user flip one cell (i.e. flip
  from 1 to 0 or from 0 to 1) and write a program to find which cell was
  flipped. Your program should prompt the user to enter a 6-by-6 array with 0s
  and 1s and find the first row r and first column c where the even number
  of the 1s property is violated (i.e. the number of 1s is not even). The
  flipped cell is at (r, c).
*/

import java.util.Scanner;

public class E8_23 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int[][] matrix = getInput(input);
    int[] flippedCell = findFlippedCell(matrix);

    System.out.println("The flipped cell is at " + getLocString(flippedCell));
  }

  public static String getLocString(int[] loc) {
    return "(" + loc[0] + ", " + loc[1] + ")";
  }

  public static int[] findFlippedCell(int[][] matrix) {
    // return an array containing row and column indices of the flipped cell
    int[] flippedCell = new int[2];

    // check rows
    for (int i = 0; i < matrix.length; i++) {
      int count = 0;
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 1) { count++; }
      }
      if (count % 2 != 0) { flippedCell[0] = i; }
    }

    // check columns
    for (int i = 0; i < matrix[0].length; i++) {
      int count = 0;
      for (int j = 0; j < matrix.length; j++) {
        if (matrix[j][i] == 1) { count++; }
      }
      if (count % 2 != 0) { flippedCell[1] = i; }
    }

    return flippedCell;
  }

  public static int[][] getInput(Scanner input) {
    System.out.println("Enter a 6-by-6 matrix row by row:");
    int[][] matrix = new int[6][6];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = input.nextInt();
      }
    }
    return matrix;
  }
}
