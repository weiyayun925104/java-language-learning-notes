/*
  Write the following method that tests whether the array has four consecutive
  numbers with the same value.

  public static boolean isConsecutiveFour(int[] values)

  Write a test program that prompts the user to enter a series of integers and
  displays if the series contains four consecutive numbers with the same value.
  Your program should first prompt the user to enter the input size.
*/

import java.util.Scanner;

public class E7_30 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    boolean consecutiveFour = isConsecutiveFour(getList(input));

    StringBuilder s = new StringBuilder();
    if (consecutiveFour) {
      s.append("The list has consecutive fours");
    } else {
      s.append("The the list has no consecutive fours");
    }
    System.out.println(s);
  }

  public static boolean isConsecutiveFour(int[] values) {
    boolean consecutiveFour = false;
    if (values.length >= 4) {
      int currentConsecutive = values[0];
      int consecutiveCount = 1;
      for (int i = 1; i < values.length; i++) {
        if (values[i] == currentConsecutive) {
          consecutiveCount++;
        } else {
          currentConsecutive = values[i];
          consecutiveCount = 1;
        }
        if (consecutiveCount == 4) {
          consecutiveFour = true;
          break;
        }
      }
    }
    return consecutiveFour;
  }

  public static int[] getList(Scanner input) {
    System.out.print("Enter the number of values: ");
    int[] list = new int[input.nextInt()];
    System.out.print("Enter the values: ");
    for (int i = 0; i < list.length; i++) {
      list[i] = input.nextInt();
    }
    return list;
  }
}
