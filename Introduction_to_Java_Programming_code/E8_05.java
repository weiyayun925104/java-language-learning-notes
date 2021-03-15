/*
  Write a method to add two matrices. The header of the method is as follows:

  public static double[][] addMatrix(double[][] a, double[][] b)

  In order to be added, the two matrices must have the same dimensions and the
  same or compatible types of elements.
*/

import java.util.Scanner;

public class E8_05 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    double[][] a = readMatrix("matrix1", input);
    double[][] b = readMatrix("matrix2", input);

    displayMatrix(a);
    System.out.println("+");
    displayMatrix(b);
    System.out.println("=");
    displayMatrix(addMatrix(a, b));
  }

  public static void displayMatrix(double[][] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        System.out.printf("%3.1f ", a[i][j]);
      }
      System.out.println();
    }
  }

  public static double[][] readMatrix(String name, Scanner input) {
    System.out.print("Enter " + name + ": ");
    double[][] matrix = new double[3][3];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = input.nextDouble();
      }
    }
    return matrix;
  }

  public static double[][] addMatrix(double[][] a, double[][] b) {
    if (a.length != b.length || a[0].length != b[0].length) {
      System.out.println("Matrices must have the same dimensions.");
      System.exit(1);
    }

    double[][] result = new double[a.length][a[0].length];

    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[i].length; j++) {
        result[i][j] = a[i][j] + b[i][j];
      }
    }

    return result;
  }
}
