/*
  Write the following method that sorts an ArrayList:

  public static <E extends Comparable<E>> void sort(ArrayList<E> list)
*/

import java.util.ArrayList;

public class E19_09 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      list.add((int)(Math.random() * 50));
    }

    System.out.println(list);
    sort(list);
    System.out.println(list);
  }

  public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
    for (int i = 0; i < list.size(); i++) {
      E min = list.get(i);
      int minIndex = i;
      for (int j = i + 1; j < list.size(); j++) {
        if (list.get(j).compareTo(min) < 0) {
          min = list.get(j);
          minIndex = j;
        }
      }
      if (minIndex != i) {
        E temp = list.get(i);
        list.set(i, min);
        list.set(minIndex, temp);
      }
    }
  }
}
