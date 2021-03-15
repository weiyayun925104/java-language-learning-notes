/*
  Write a program that randomly fills in 0s and 1s into an n-by-n matrix, prints
  the matrix, and finds the rows and columns with the most 1s.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class E11_09 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int[][] matrix = getMatrix(input);
    displayMatrix(matrix);

    ArrayList<Integer> rows = new ArrayList<>();
    ArrayList<Integer> cols = new ArrayList<>();

    int maxOnesRow = -1;
    int count;
    // check rows for maximum 1s
    for (int i = 0; i < matrix.length; i++) {
      count = 0;
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 1) { count++; }
      }
      if (count > maxOnesRow) { maxOnesRow = count; }
    }

    int maxOnesCol = -1;
    // check columns for maximum 1s
    for (int j = 0; j < matrix[0].length; j++) {
      count = 0;
      for (int i = 0; i < matrix.length; i++) {
        if (matrix[i][j] == 1) { count++; }
      }
      if (count > maxOnesCol) { maxOnesCol = count; }
    }

    // since there may be more than one row and column w/ the maximum
    // find all rows with maximum 1s
    for (int i = 0; i < matrix.length; i++) {
      count = 0;
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 1) { count++; }
      }
      if (count == maxOnesRow) { rows.add(i); }
    }

    // find all columns with maximum 1s
    for (int j = 0; j < matrix[0].length; j++) {
      count = 0;
      for (int i = 0; i < matrix.length; i++) {
        if (matrix[i][j] == 1) { count++; }
      }
      if (count == maxOnesCol) { cols.add(j); }
    }

    System.out.print("The largest row index: ");
    displayList(rows);

    System.out.print("The largest column index: ");
    displayList(cols);
  }

  public static int[][] getMatrix(Scanner input) {
    System.out.print("Enter the array size n: ");
    int size = input.nextInt();
    int[][] matrix = new int[size][size];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] = (int)(Math.random() * 2);
      }
    }
    return matrix;
  }

  public static void displayMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void displayList(ArrayList<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i));
      if (i == list.size() - 1) { break; }
      System.out.print(", ");
    }
    System.out.println();
  }
}
