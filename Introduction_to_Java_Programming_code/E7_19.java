/*
  Write the following method that returns true if the list is already sorted in
  increasing order.

  public static boolean isSorted(int[] list)

  Write a test program that prompts the user to enter a list and displays
  whether the list is sorted or not. The first number in the input indicates
  thenumber of the elements in the list. This number is not part of the list.
*/

import java.util.Scanner;

public class E7_19 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter list: ");
    int numOfElements = input.nextInt();

    int[] list = new int[numOfElements];
    for (int i = 0; i < list.length; i++) {
      list[i] = input.nextInt();
    }

    StringBuilder result = new StringBuilder();
    if (isSorted(list)) {
      result.append("The list is already sorted");
    } else {
      result.append("The list is not sorted");
    }

    System.out.println(result);
  }

  public static boolean isSorted(int[] list) {
    boolean sorted = true;
    for (int i = 0; i < list.length - 1; i++) {
      if (list[i] > list[i + 1]) {
        sorted = false;
        break;
      }
    }
    return sorted;
  }
}
