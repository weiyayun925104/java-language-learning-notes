/*
  Write a method to sort a two-dimensional array using the following header:

  public static void sort(int[][] m)

  The method performs a primary sort on rows and a secondary sort on columns.
  For example, the following array

  {{4, 2}, {1, 7}, {4, 5}, {1, 2}, {1, 1}, {4, 1}}

  will be sorted to

  {{1, 1}, {1, 2}, {1, 7}, {4, 1}, {4, 2}, {4, 5}}
*/

public class E8_16 {
  public static void main(String[] args) {
    int[][] matrix = {{4, 2}, {1, 7}, {4, 5}, {1, 2}, {1, 1}, {4, 1}};
    printMatrix(matrix);

    sort(matrix);
    printMatrix(matrix);
  }

  public static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      System.out.print(elemString(matrix[i]) + " ");
    }
    System.out.println();
  }

  public static String elemString(int[] elem) {
    return "{" + elem[0] + ", " + elem[1] + "}";
  }

  public static void sort(int[][] m) {
    boolean changed;

    do {
      changed = false;
      for (int i = 0; i < m.length - 1; i++) {
        if (m[i][0] >= m[i + 1][0]) {
          if(m[i][0] == m[i + 1][0] && m[i][1] < m[i + 1][1]) {
            continue;
          }
          int[] temp = m[i];
          m[i] = m[i + 1];
          m[i + 1] = temp;
          changed = true;
        }
      }
    } while (changed);
  }
}
