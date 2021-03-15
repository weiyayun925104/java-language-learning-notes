/*
  The two-dimensional arrays m1 and m2 are identical if they have the same
  contents. Write a method that returns true if m1 and m2 are identical, using
  the following header:

  public static boolean equals(int[][] m1, int[][] m2)

  Write a test program that prompts the user to enter two 3 x 3 arrays of
  integers and displays whether the two are identical.
*/

import java.util.Scanner;
import java.util.Arrays;

public class E8_29 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int[][] m1 = getInput("list1", input);
    int[][] m2 = getInput("list2", input);

    if (equals(m1, m2)) {
      System.out.println("The two arrays are identical");
    } else {
      System.out.println("The two arrays are not identical");
    }
  }

  public static int[][] getInput(String name, Scanner input) {
    System.out.print("Enter " + name + ": ");
    int[][] matrix = new int[3][3];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = input.nextInt();
      }
    }
    return matrix;
  }

  public static boolean equals(int[][] m1, int[][] m2) {
    if (m1.length != m2.length) { return false; }

    sort(m1);
    sort(m2);

    for (int i = 0; i < m1.length; i++) {
      if (!Arrays.equals(m1[i], m2[i])) { return false; }
    }

    return true;
  }

  public static void sort(int[][] m) {
    boolean changed;
    do {
      changed = false;
      for (int i = 0; i < m.length - 1; i++) {
        subSort(m[i]);
        subSort(m[i + 1]);
        if (m[i][0] > m[i + 1][0]) {
          int[] temp = m[i];
          m[i] = m[i + 1];
          m[i + 1] = temp;
          changed = true;
        }
      }
    } while (changed);
  }

  public static void subSort(int[] m) {
    boolean changed;
    do {
      changed = false;
      for (int i = 0; i < m.length - 1; i++) {
        if (m[i] > m[i + 1]) {
          int temp = m[i];
          m[i] = m[i + 1];
          m[i + 1] = temp;
          changed = true;
        }
      }
    } while (changed);
  }

  public static void displayMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
