/*
  Implement the following method to sort the columns in a two-dimensional
  array. A new array is returned and the original array is intact.

  public static double[][] sortColumns(double[][] m)

  Write a test program that prompts the user to enter a 3 x 3 matrix of
  double values and displays a new column-sorted matrix.
*/

import java.util.Scanner;

public class E8_27 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    double[][] matrix = getInput(input);

    double[][] sorted = sortColumns(matrix);

    displayMatrix(sorted);
  }

  public static double[][] sortColumns(double[][] m) {
    // make a working copy of m
    double[][] copy = new double[m.length][m[0].length];
    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = m[i][j];
      }
    }

    // sort the copy on columns
    for (int i = 0; i < copy[0].length; i++) {
      boolean changed;
      do {
        changed = false;
        for (int j = 0; j < copy.length - 1; j++) {
          if (copy[j][i] > copy[j + 1][i]) {
            double temp = copy[j][i];
            copy[j][i] = copy[j + 1][i];
            copy[j + 1][i] = temp;
            changed = true;
          }
        }
      } while (changed);
    }

    return copy;
  }

  public static double[][] getInput(Scanner input) {
    System.out.println("Enter a 3-by-3 matrix row by row: ");
    double[][] matrix = new double[3][3];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = input.nextDouble();
      }
    }
    return matrix;
  }

  public static void displayMatrix(double[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.printf("%6.4f ", matrix[i][j]);
      }
      System.out.println();
    }
  }
}
