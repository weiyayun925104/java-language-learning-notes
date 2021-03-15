/*
  The arrays list1 and list2 are strictly identical if their corresponding
  elements are equal. Write a method that returns true if list1 and list2 are
  strictly identical, using the following header:

  public static boolean equals(int[] list1, int[] list2)

  Write a test program that prompts the user to enter two lists of integers
  and displays whether the two are strictly identical. Note that the first
  number in the input indicates the number of elements in the list. This number
  is not part of the list.
*/

import java.util.Scanner;

public class E7_26 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int[] list1 = getList("list1", input);
    int[] list2 = getList("list2", input);

    StringBuilder s = new StringBuilder();
    if (equals(list1, list2)) {
      s.append("The lists are strictly identical");
    } else {
      s.append("The lists are not strictly identical");
    }
    System.out.println(s);
  }

  public static boolean equals(int[] list1, int[] list2) {
    boolean equal = true;
    if (list1.length != list2.length) {
      equal = false;
    } else {
      for (int i = 0; i < list1.length; i++) {
        if (list1[i] != list2[i]) {
          equal = false;
          break;
        }
      }
    }
    return equal;
  }

  public static int[] getList(String name, Scanner input) {
    System.out.print("Enter " + name + ": ");
    int[] list = new int[input.nextInt()];
    for (int i = 0; i < list.length; i++) {
      list[i] = input.nextInt();
    }
    return list;
  }
}
