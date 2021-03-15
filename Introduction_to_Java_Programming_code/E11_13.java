/*
  Write a method that removes the duplicate elements from an array list of
  integers using the following header:

  public static void removeDuplicate(ArrayList<Integer> list)

  Write a test program that prompts the user to enter 10 integers to a list and
  displays the distinct integers separated by exactly one space.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class E11_13 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    ArrayList<Integer> list = getNumbers(input);
    removeDuplicate(list);
    displayList(list);
  }

  public static void removeDuplicate(ArrayList<Integer> list) {
    // copy list
    ArrayList<Integer> copy = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      copy.add(list.get(i));
    }

    // sort the copy
    sort(copy);

    // iterate through the copy and track duplicates
    ArrayList<Integer> duplicates = new ArrayList<>();
    int currentNum = copy.get(0);
    for (int i = 1; i < copy.size(); i++) {
      if (copy.get(i) == currentNum && !duplicates.contains(currentNum)) {
        duplicates.add(copy.get(i));
      } else {
        currentNum = copy.get(i);
      }
    }

    // remove duplicates from original array list
    for (int i = 0; i < duplicates.size(); i++) {
      int dup = duplicates.get(i);
      int count = 0;
      // count duplicates of this value
      for (int j = 0; j < list.size(); j++) {
        if (list.get(j) == dup) { count++; }
      }
      // remove all but one of them
      while (count > 1) {
        list.remove(list.indexOf(dup));
        count--;
      }
    }
  }

  public static void sort(ArrayList<Integer> list) {
    boolean changed;
    do {
      changed = false;
      for (int i = 0; i < list.size() - 1; i++) {
        int a = list.get(i);
        int b = list.get(i + 1);
        if (a > b) {
          int temp = a;
          list.set(i, b);
          list.set(i + 1, temp);
          changed = true;
        }
      }
    } while (changed);
  }

  public static ArrayList<Integer> getNumbers(Scanner input) {
    System.out.print("Enter ten integers: ");
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      list.add(input.nextInt());
    }
    return list;
  }

  public static void displayList(ArrayList<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + " ");
    }
    System.out.println();
  }
}
