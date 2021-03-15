/*
  Write a program that generates a 6-by-6 two-dimensional matrix filled with
  0s and 1s, display the matrix, and check if every row and every column have
  an even number of 1s.
*/

public class E8_22 {
  public static void main(String[] args) {
    int[][] matrix = getMatrix(6);
    displayMatrix(matrix);

    checkForEvenNumberOfOnes(matrix);
  }

  public static void checkForEvenNumberOfOnes(int[][] matrix) {
    int count;

    // check rows
    for (int i = 0; i < matrix.length; i++) {
      count = 0;
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 1) { count++; }
      }
      if (count > 0 && count % 2 == 0) {
        System.out.println("row " + (i + 1) + " has an even number of 1s");
      }
    }

    // check columns
    for (int i = 0; i < matrix[0].length; i++) {
      count = 0;
      for (int j = 0; j < matrix.length; j++) {
        if (matrix[j][i] == 1) { count++; }
      }
      if (count > 0 && count % 2 == 0) {
        System.out.println("column " + (i + 1) + " has an even number of 1s");
      }
    }
  }

  public static int[][] getMatrix(int size) {
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
}
