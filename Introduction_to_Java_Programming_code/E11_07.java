/*
  Write the following method that shuffles the elements in an ArrayList of
  Integers.

  public static void shuffle(ArrayList<Integer> list)
*/

import java.util.ArrayList;

public class E11_07 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }

    shuffle(list);

    for (int n: list) {
      System.out.print(n + " ");
    }
    System.out.println();
  }

  public static void shuffle(ArrayList<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
      int randomIndex = (int)(Math.random() * list.size());
      int temp = list.get(i);
      list.set(i, list.get(randomIndex));
      list.set(randomIndex, temp);
    }
  }
}
