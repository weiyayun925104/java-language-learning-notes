/*
  Implement the following method that returns the maximum element in an array.

  public static <E extends Comparable<E>> E max(E[] list)
*/

public class E19_05 {
  public static void main(String[] args) {
    Integer[] list = {1, 15, 200, 3, 4, 10};
    System.out.println(max(list));
  }

  public static <E extends Comparable<E>> E max(E[] list) {
    E max = list[0];
    for (int i = 1; i < list.length; i++) {
      if (list[i].compareTo(max) > 0) { max = list[i]; }
    }
    return max;
  }
}
