/*
  Given a square matrix with elements 0 or 1, write a program to find the
  maximum square submatrix whose elements are all 1s. Your program should
  prompt the user to enter the number of rows in the matrix. The program then
  displays the location of the first element in the maximum square submatrix
  and the number of rows in the matrix.

  Your program should implement and use the following method to find the
  maximum square submatrix:

  public static int[] findLargestBlock(int[][] m)

  The return value is an array that consists of three values. The first two
  values are the row and column indices for the first element in the submatrix,
  and the third value is the number of rows in the submatrix.
*/

import java.util.Scanner;

public class E8_35 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int[][] matrix = getInput(input);
    int[] submatrix = findLargestBlock(matrix);

    System.out.println("The maximum square submatrix is at " +
      "(" + submatrix[0] + ", " + submatrix[1] + ") with size " + submatrix[2]);
  }

  public static int[][] getInput(Scanner input) {
    System.out.print("Enter the number of rows in the matrix: ");
    int size = input.nextInt();

    System.out.println("Enter the matrix row by row:");
    int[][] m = new int[size][size];
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        m[i][j] = input.nextInt();
      }
    }

    return m;
  }

  public static void displayMatrix(int[][] m) {
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        System.out.print(m[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static int[] findLargestBlock(int[][] m) {
    // set up an auxilliary array
    int[][] s = new int[m.length][m[0].length];

    // copy over the first column from m
    for (int i = 0; i < s.length; i++) {
      s[i][0] = m[i][0];
    }

    // copy over the first row from m
    for (int i = 0; i < s[0].length; i++) {
      s[0][i] = m[0][i];
    }

    // using the first column and first row as a basis, search for the rightmost
    // lowest corner of the largest submatrix. if the value in m is 0, it will
    // stay 0 in s. if the value is 1, check the left, above, and left-above
    // diagonal values in s, and assign the minimum of those + 1. in this way,
    // values belonging to the square submatrix will grow larger, with the
    // largest among them being the rightmost lowest corner, and indicating the
    // submatrix's size.
    for (int i = 1; i < m.length; i++) {
      for (int j = 1; j < m[i].length; j++) {
        if (m[i][j] == 1) {
          s[i][j] = Math.min(s[i][j - 1],
            Math.min(s[i - 1][j], s[i - 1][j - 1])) + 1;
        } else {
          s[i][j] = 0;
        }
      }
    }

    // find the largest value and its coordinates in the aux. array
    int largest = -1;
    int x = 0;
    int y = 0;
    for (int i = 0; i < s.length; i++) {
      for (int j = 0; j < s[i].length; j++) {
        if (s[i][j] > largest) {
          largest = s[i][j];
          x = i;
          y = j;
        }
      }
    }

    // calculate the coordinate of the upper-left corner of the submatrix
    x -= (largest - 1);
    y -= (largest - 1);

    // return coord and submatrix size, in that order
    return new int[]{x, y, largest};
  }
}
