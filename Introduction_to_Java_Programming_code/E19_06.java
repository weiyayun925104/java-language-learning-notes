/*
  Write a generic method that returns the maximum element in a two-
  dimensional array.

  public static <E extends Comparable<E>> E max(E[][] list)
*/

public class E19_06 {
  public static void main(String[] args) {
    Integer[][] list = {{1, 2, 3}, {0, 200, 0}, {54, 22, 1}};
    System.out.println(max(list));
  }

  public static <E extends Comparable<E>> E max(E[][] list) {
    E max = list[0][0];
    for (int i = 0; i < list.length; i++) {
      for (int j = 0; j < list[i].length; j++) {
        if (list[i][j].compareTo(max) > 0) { max = list[i][j]; }
      }
    }
    return max;
  }
}
