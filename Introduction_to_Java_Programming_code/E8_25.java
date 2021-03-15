/*
  An n x n matrix is called a positive Markov matrix if each element is positive
  and the sum of the elements in each column is 1. Write the following method
  to check whether a matrix is a Markov matrix.

  public static boolean isMarkovMatrix(double[][] m)

  Write a test program that prompts the user to enter a 3 x 3 matrix of double
  values and tests whether it is a Markov matrix.
*/

import java.util.Scanner;

public class E8_25 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    double[][] matrix = getInput(input);

    if (isMarkovMatrix(matrix)) {
      System.out.println("It is a Markov matrix");
    } else {
      System.out.println("It is not a Markov matrix");
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

  public static boolean isMarkovMatrix(double[][] m) {
    // check for all positive values
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        if (m[i][j] <= 0) { return false; }
      }
    }

    // check that each column adds up to 1
    for (int i = 0; i < m[0].length; i++) {
      double sum = 0.0;
      for (int j = 0; j < m.length; j++) {
        sum += m[j][i];
      }
      if (sum != 1) { return false; }
    }

    return true;
  }
}
