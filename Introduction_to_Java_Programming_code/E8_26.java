/*
  Implement the following method to sort the rows in a two-dimensional array.
  A new array is returned and the original array is intact.

  public static double[][] sortRows(double[][] m)

  Write a test program that prompts the user to enter a 3 x 3 matrix of double
  values and displays a new row-sorted matrix.
*/

import java.util.Scanner;

public class E8_26 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    double[][] m = getInput(input);
    double[][] sorted = sortRows(m);
    System.out.println();

    System.out.println("The row-sorted array is");
    displayMatrix(sorted);
  }

  public static void displayMatrix(double[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static double[][] getInput(Scanner input) {
    System.out.println("Enter a 3-by-3 matrix row by row:");
    double[][] matrix = new double[3][3];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = input.nextDouble();
      }
    }
    return matrix;
  }

  public static double[][] sortRows(double[][] m) {
    // make a working copy of m
    double[][] copy = new double[m.length][m[0].length];
    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = m[i][j];
      }
    }

    // sort the rows of copy
    for (int i = 0; i < copy.length; i++) {
      sort(copy[i]);
    }

    return copy;
  }

  public static void sort(double[] arr) {
    boolean changed;
    do {
      changed = false;
      for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i] > arr[i + 1]) {
          double temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
          changed = true;
        }
      }
    } while (changed);
  }
}
