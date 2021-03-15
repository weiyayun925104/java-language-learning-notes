/*
  Write the following method that merges two sorted lists into a new sorted
  list.

  public static int[] merge(int[] list1, int[] list2)

  Implement the method in a way that takes at most list1.length + list2.length
  comparisons. Write a test program that prompts the user to enter two sorted
  lists and displays the merged list. Note that the first number in the input
  indicates the number of the elements in the list. This number is not part of
  the list.
*/

import java.util.Scanner;

public class E7_31 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int[] list1 = getList("list1", input);
    int[] list2 = getList("list2", input);

    int[] mergedList = merge(list1, list2);

    displayList(mergedList);
  }

  public static void displayList(int[] list) {
    System.out.print("The merged list is ");
    for (int n: list) {
      System.out.print(n + " ");
    }
    System.out.println();
  }

  public static int[] getList(String name, Scanner input) {
    System.out.print("Enter " + name + ": ");
    int[] list = new int[input.nextInt()];
    for (int i = 0; i < list.length; i++) {
      list[i] = input.nextInt();
    }
    return list;
  }

  public static int[] merge(int[] list1, int[] list2) {
    int[] merged = new int[list1.length + list2.length];

    // maintain indices on each array
    int i = 0;
    int j = 0;
    int k = 0;

    // This is a smelly work-around for including coverage of both ragged and
    // equal-length arrays without running into out-of-bounds exceptions when
    // indexing into an array whose index has reached its length.
    while (k < merged.length) {
      if (i == list1.length) {
        merged[k] = list2[j];
        k++;
        j++;
      } else if (j == list2.length) {
        merged[k] = list1[i];
        k++;
        i++;
      } else if (list1[i] <= list2[j]) {
        merged[k] = list1[i];
        k++;
        i++;
      } else {
        merged[k] = list2[j];
        k++;
        j++;
      }
    }

    return merged;
  }
}
