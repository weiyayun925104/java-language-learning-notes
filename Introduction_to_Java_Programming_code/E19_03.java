/*
  Write the following method that returns a new ArrayList. The new list contains
  the non-duplicate elements from the original list.

  public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
*/

import java.util.ArrayList;

public class E19_03 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(10);
    list.add(42);
    list.add(14);
    list.add(14);
    list.add(72);
    list.add(10);
    list.add(42);

    for (int i: removeDuplicates(list)) {
      System.out.println(i);
    }
  }

  public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
    ArrayList<E> noDupes = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      E elem = list.get(i);
      if (!noDupes.contains(elem)) {
        noDupes.add(elem);
      }
    }
    return noDupes;
  }
}
