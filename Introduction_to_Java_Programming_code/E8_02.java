/*
  Write a method that sums all the numbers in the major diagonal in an n x n
  matrix of double values using the following header:

  public static double sumMajorDiagonal(double[][] m)

  Write a test program that reads a 4-by-4 matrix and displays the sum of all
  its elements on the major diagonal.
*/

import java.util.Scanner;

public class E8_02 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a 4-by-4 matrix row by row:");

    double[][] matrix = new double[4][4];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = input.nextDouble();
      }
    }

    double sum = sumMajorDiagonal(matrix);

    System.out.println("Sum of the elements in the major diagonal is " + sum);
  }

  public static double sumMajorDiagonal(double[][] m) {
    double sum = 0.0;
    if (m.length == m[0].length) {
      for (int i = 0; i < m.length; i++) {
        sum += m[i][i];
      }
    }
    return sum;
  }
}
