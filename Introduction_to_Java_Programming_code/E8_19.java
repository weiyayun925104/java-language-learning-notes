/*
  Write the following method that tests whether a two-dimensional array has
  four consecutive numbers of the same value, either horizontally, vertically,
  or diagonally.

  public static boolean isConsecutiveFour(int[][] values)

  Write a test program that prompts the user to enter the number of rows and
  columns of a two-dimensional array and then the values in the array and
  displays true if the array contains four consecutive numbers with the same
  value, either horizontally, vertically, or diagonally.
*/

import java.util.Scanner;

public class E8_19 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int[][] matrix = getInput(input);

    System.out.println(isConsecutiveFour(matrix));
  }

  public static boolean isConsecutiveFour(int[][] values) {
    int count;
    int consecNum;

    // check rows
    for (int i = 0; i < values.length; i++) {
      count = 1;
      consecNum = values[i][0];
      for (int j = 1; j < values[i].length; j++) {
        if (values[i][j] == consecNum) { count++; }
        else { count = 1; consecNum = values[i][j]; }
        if (count >= 4) { return true; }
      }
    }

    // check columns
    for (int i = 0; i < values[0].length; i++) {
      count = 1;
      consecNum = values[0][i];
      for (int j = 1; j < values.length; j++) {
        if (values[j][i] == consecNum) { count++; }
        else { count = 1; consecNum = values[j][i]; }
        if (count == 4) { return true; }
      }
    }

    // check left-rising diagonals
    for (int i = 0; i < values.length; i++) {
      count = 1;
      consecNum = values[i][0];
      for (int j = i + 1, k = 1; j < values.length && k < values[j].length;
        j++, k++) {
        if (values[j][k] == consecNum) { count++; }
        else { count = 1; consecNum = values[j][k]; }
        if (count == 4) { return true; }
      }
    }

    for (int i = 1; i < values[0].length; i++) {
      count = 1;
      consecNum = values[0][i];
      for (int j = 1, k = i + 1; j < values.length && k < values[j].length;
        j++, k++) {
        if (values[j][k] == consecNum) { count++; }
        else { count = 1; consecNum = values[j][k]; }
        if (count == 4) { return true; }
      }
    }

    // check right-rising diagonals
    for (int i = 0; i < values.length; i++) {
      count = 1;
      consecNum = values[i][values[i].length - 1];
      for (int j = i + 1, k = values[i].length - 2; j < values.length &&
        k >= 0; j++, k--) {
        if (values[j][k] == consecNum) { count++; }
        else { count = 1; consecNum = values[j][k]; }
        if (count == 4) { return true; }
      }
    }

    for (int i = values[0].length - 2; i >= 0; i--) {
      count = 1;
      consecNum = values[0][i];
      for (int j = 1, k = i - 1; j < values.length && k >= 0; j++, k--) {
        if (values[j][k] == consecNum) { count++; }
        else { count = 1; consecNum = values[j][k]; }
        if (count == 4) { return true; }
      }
    }

    return false;
  }

  public static void displayMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static int[][] getInput(Scanner input) {
    System.out.print("Enter number of rows and columns: ");
    int[][] matrix = new int[input.nextInt()][input.nextInt()];
    System.out.println("Enter the values:");
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = input.nextInt();
      }
    }
    return matrix;
  }
}
