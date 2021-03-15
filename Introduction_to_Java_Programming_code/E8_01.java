/*
  Write a method that returns the sum of all the elements in a specified
  column in a matrix using the following header:

  public static double sumColumn(double[][] m, int columnIndex)

  Write a test program that reads a 3-by-4 matrix and displays the sum of each
  column.
*/

import java.util.Scanner;

public class E8_01 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a 3-by-4 matrix row by row:");

    double[][] matrix = new double[3][4];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = input.nextDouble();
      }
    }

    for (int i = 0; i < matrix[0].length; i++) {
      double sum = sumColumn(matrix, i);
      System.out.println("Sum of the elements at column " + i + " is " + sum);
    }
  }

  public static double sumColumn(double[][] m, int columnIndex) {
    double sum = 0.0;
    if (columnIndex >= 0 && columnIndex < m[0].length) {
      for (int i = 0; i < m.length; i++) {
        sum += m[i][columnIndex];
      }
    }
    return sum;
  }
}
