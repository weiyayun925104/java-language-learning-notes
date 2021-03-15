/*
  Write a method that returns the index of the smallest element in an array
  of integers. If the number of such elements is greater than 1, return the
  smallest index. Use the following header:

  public static int indexOfSmallestElement(double[] array)

  Write a test program that prompts the user to enter ten numbers, invokes this
  method to return the index of the smallest element, and displays the index.
*/

import java.util.Scanner;

public class E7_10 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter ten numbers: ");

    double[] nums = new double[10];
    for (int i = 0; i < 10; i++) {
      nums[i] = input.nextDouble();
    }

    int index = indexOfSmallestElement(nums);

    System.out.println("Index of smallest element: " + index);
  }

  public static int indexOfSmallestElement(double[] array) {
    double smallest = array[0];
    int indexOfSmallest = 0;
    for (int i = 1; i < array.length; i++) {
      if (array[i] < smallest) {
        smallest = array[i];
        indexOfSmallest = i;
      }
    }
    return indexOfSmallest;
  }
}
