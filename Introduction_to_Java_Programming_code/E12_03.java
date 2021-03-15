/*
  Write a program that meets the following requirements:

  - Creates an array with 100 randomly chosen integers.
  - Prompts the user to enter the index of the array, then displays the
    corresponding element value. If the specified index is out of bounds,
    display the message Out of Bounds.
*/

import java.util.Scanner;

public class E12_03 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int[] nums = getRandomInts(100);

    System.out.print("Enter an array index: ");
    int index = -1;
    try {
      index = input.nextInt();
    } catch (Exception e) {
      System.out.println("Error: incorrect input format.");
      System.exit(1);
    }

    try {
      System.out.println("The value is " + nums[index]);
    } catch (Exception e) {
      System.out.println("Out of Bounds");
      System.exit(2);
    }
  }

  public static int[] getRandomInts(int size) {
    int[] nums = new int[size];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = (int)(Math.random() * size);
    }
    return nums;
  }
}
