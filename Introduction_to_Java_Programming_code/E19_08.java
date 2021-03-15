/*
  Write the following method that shuffles an ArrayList:

  public static <E> void shuffle(ArrayList<E> list)
*/

import java.util.ArrayList;

public class E19_08 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }

    shuffle(list);

    System.out.println(list);
  }

  public static <E> void shuffle(ArrayList<E> list) {
    for (int i = 0; i < list.size(); i++) {
      int randomIndex = (int)(Math.random() * list.size());
      if (i != randomIndex) {
        E temp = list.get(i);
        list.set(i, list.get(randomIndex));
        list.set(randomIndex, temp);
      }
    }
  }
}
