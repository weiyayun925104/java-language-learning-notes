/*
  Write a program that prompts the user to enter the length of a square matrix,
  randomly fills in 0s and 1s, prints the matrix, and finds the rows, columns,
  and diagonals with all 0s or 1s.
*/

import java.util.Scanner;

public class E8_14 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int[][] m = getInput(input);
    displayMatrix(m);
    System.out.println(exploreMatrix(m));
  }

  public static String exploreMatrix(int[][] m) {
    boolean noSameRow = true;
    boolean noSameCol = true;
    boolean noSameMajorDiag = true;
    boolean noSameMinorDiag = true;
    StringBuilder s = new StringBuilder();

    // check rows
    for (int i = 0; i < m.length; i++) {
      int status = hasAllZeroesOrOnes(m[i]);
      if (status == 0 || status == 1) {
        noSameRow = false;
        if (status == 1) {
          s.append("All 1s on row " + i + "\n");
        } else {
          s.append("All 0s on row " + i + "\n");
        }
      }
    }

    // check columns
    for (int i = 0; i < m[0].length; i++) {
      int[] col = new int[m.length];
      for (int j = 0; j < m.length; j++) {
        col[j] = m[j][i];
      }
      int status = hasAllZeroesOrOnes(col);
      if (status == 0 || status == 1) {
        noSameCol = false;
        if (status == 1) {
          s.append("All 1s on column " + i + "\n");
        } else {
          s.append("All 0s on column " + i + "\n");
        }
      }
    }

    // check major diagonal
    int[] diag = new int[m[0].length];
    for (int i = 0, j = 0; i < m.length && j < m[i].length; i++, j++) {
      diag[j] = m[i][j];
    }
    int status = hasAllZeroesOrOnes(diag);
    if (status == 0 || status == 1) {
      noSameMajorDiag = false;
      if (status == 1) {
        s.append("All 1s on major diagonal\n");
      } else {
        s.append("All 0s on major diagonal\n");
      }
    }

    // check minor diagonal
    diag = new int[m[0].length];
    for (int i = m.length - 1, j = 0; i >= 0 && j < m[0].length; i--, j++) {
      diag[j] = m[i][j];
    }
    status = hasAllZeroesOrOnes(diag);
    if (status == 0 || status == 1) {
      noSameMinorDiag = false;
      if (status == 1) {
        s.append("All 1s on minor diagonal\n");
      } else {
        s.append("All 0s on minor diagonal\n");
      }
    }

    if (noSameRow) { s.append("No same numbers on a row\n"); }
    if (noSameCol) { s.append("No same numbers on a column\n"); }
    if (noSameMajorDiag) {
      s.append("No same numbers on the major diagonal\n");
    }
    if (noSameMinorDiag) {
      s.append("No same numbers on the minor diagonal\n");
    }

    return s.toString();
  }

  public static int[][] getInput(Scanner input) {
    System.out.print("Enter the size for the matrix: ");
    int size = input.nextInt();

    return getMatrix(size);
  }

  public static int[][] getMatrix(int size) {
    int[][] m = new int[size][size];
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        m[i][j] = (int)(Math.random() * 2);
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

  public static int hasAllZeroesOrOnes(int[] m) {
    // 1: has all ones
    // 0: has all zeroes
    // -1: has neitehr all ones nor all zeroes
    for (int i = 1; i < m.length; i++) {
      if (m[i] != m[i - 1]) { return -1; }
    }

    return m[0];
  }
}
