/*
  Write the following method that sorts an ArrayList of numbers:

  public static void sort(ArrayList<Integer> list)

  Write a test program that prompts the user to enter 5 numbers, stores them in
  an array list, and displays them in increasing order.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class E11_11 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    ArrayList<Integer> list = getNumbers(input);
    sort(list);

    for (int n: list) {
      System.out.print(n + " ");
    }
    System.out.println();
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
    System.out.print("Enter five integers: ");
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      list.add(input.nextInt());
    }
    return list;
  }
}
