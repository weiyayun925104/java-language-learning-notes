/*
  Write the following method that sorts an ArrayList of numbers.

  public static void sort(ArrayList<Number> list)
*/

import java.util.ArrayList;

public class E13_03 {
  public static void main(String[] args) {
    // generate a list of Number objects from 0-14
    ArrayList<Number> list = new ArrayList<>();
    for (int i = 0; i < 15; i++) {
      list.add(i);
    }

    // shuffle the list
    shuffle(list);

    displayList(list);

    // sort the list
    sort(list);

    displayList(list);
  }

  public static void sort(ArrayList<Number> list) {
    boolean changed;
    do {
      changed = false;
      for (int i = 0; i < list.size() - 1; i++) {
        Number a = list.get(i);
        Number b = list.get(i + 1);
        if (a.doubleValue() > b.doubleValue()) {
          list.set(i, b);
          list.set(i + 1, a);
          changed = true;
        }
      }
    } while (changed);
  }

  public static void shuffle(ArrayList<Number> list) {
    for (int i = 0; i < list.size(); i++) {
      int randomIndex = (int)(Math.random() * list.size());
      Number temp = list.get(i);
      list.set(i, list.get(randomIndex));
      list.set(randomIndex, temp);
    }
  }

  public static void displayList(ArrayList<Number> list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + " ");
    }
    System.out.println();
  }
}
