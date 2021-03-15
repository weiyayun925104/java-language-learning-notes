/*
  Write a program that prompts the user to enter three integers and display
  the integers in non-decreasing order.
*/

import java.util.Scanner;
import java.util.Arrays;

public class E3_08 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter three integers: ");
    int a = input.nextInt();
    int b = input.nextInt();
    int c = input.nextInt();

    int[] sorted = sortThree(a, b, c);

    for (int num: sorted) {
      System.out.printf("%d ", num);
    }
    System.out.println();
  }

  private static int[] sortThree(int a, int b, int c) {
    int[] nums = new int[]{a, b, c};
    Arrays.sort(nums);
    return nums;
  }
}
