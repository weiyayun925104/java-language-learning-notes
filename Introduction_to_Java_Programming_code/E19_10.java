/*
  Write the following method that returns the largest element in an ArrayList:

  public static <E extends Comparable<E>> E max(ArrayList<E> list)
*/

import java.util.ArrayList;

public class E19_10 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      list.add((int)(Math.random() * 50));
    }

    System.out.println(list);
    System.out.println(max(list));
  }

  public static <E extends Comparable<E>> E max(ArrayList<E> list) {
    E max = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i).compareTo(max) > 0) {
        max = list.get(i);
      }
    }
    return max;
  }
}
