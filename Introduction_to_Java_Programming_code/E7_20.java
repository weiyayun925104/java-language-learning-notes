/*
  In Section 7.11, you used selection sort to sort an array. The selection-sort
  method repeatedly finds the smallest number in the current array and swaps it
  with the first. Rewrite this program by finding the largest number and
  swapping it with the last. Write a test program that reads in ten double
  numbers, invokes the method, and displays the sorted numbers.
*/

import java.util.Scanner;

public class E7_20 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter ten numbers: ");

    double[] nums = new double[10];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = input.nextDouble();
    }

    selectionSort(nums);

    for (double num: nums) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  public static void selectionSort(double[] arr) {
    int currentTail = arr.length - 1;
    while (currentTail > 0) {
      double max = arr[currentTail];
      int maxIndex = currentTail;

      for (int i = 0; i < currentTail; i++) {
        if (arr[i] > max) {
          max = arr[i];
          maxIndex = i;
        }
      }

      if (max > arr[currentTail]) {
        double temp = arr[currentTail];
        arr[currentTail] = max;
        arr[maxIndex] = temp;
      }

      currentTail--;
    }
  }
}
