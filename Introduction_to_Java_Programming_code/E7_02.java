/*
  Write a program that reads ten integers and displays them in the reverse
  of the order in which they were read.
*/

import java.util.Scanner;

public class E7_02 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter ten integers: ");
    int[] nums = new int[10];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = input.nextInt();
    }

    for (int i = nums.length - 1; i >= 0; i--) {
      System.out.print(nums[i] + " ");
    }
    System.out.println();
  }
}
