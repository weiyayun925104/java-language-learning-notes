/*
  Write a method that shuffles the rows in a two-dimensional int array using
  the following header:

  public static void shuffle(int[][] m)

  Write a program that shuffles the following matrix:

  int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
*/

public class E8_18 {
  public static void main(String[] args) {
    int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
    shuffle(m);

    for (int i = 0; i < m.length; i++) {
      System.out.println(formatArr(m[i]));
    }
  }

  public static String formatArr(int[] arr) {
    StringBuilder s = new StringBuilder("( ");
    for (int i = 0; i < arr.length; i++) {
      s.append(arr[i] + " ");
    }
    s.append(")");
    return s.toString();
  }

  public static void shuffle(int[][] m) {
    for (int i = 0; i < m.length; i++) {
      int randomIndex = (int)(Math.random() * m.length);
      int[] temp = m[i];
      m[i] = m[randomIndex];
      m[randomIndex] = temp;
    }
  }
}
