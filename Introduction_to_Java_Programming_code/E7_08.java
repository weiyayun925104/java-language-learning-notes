/*
  Write two overloaded methods that return the average of an array with the
  following headers:

  public static int average(int[] array)
  public static double average(double[] array)

  Write a test program that prompts the user to enter ten double values,
  invokes this method, and displays the average value.

  Note: This exercise doesn't really make sense, since the average of an array
  of integers is likely to be a floating point number, so I made the return
  value from average(int[] array) a double and just used the double version
  of the method to get the result.
*/

import java.util.Scanner;

public class E7_08 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter ten double values: ");

    double[] nums = new double[10];
    for (int i = 0; i < 10; i++) {
      nums[i] = input.nextDouble();
    }

    System.out.println("Average: " + average(nums));
  }

  public static double average(int[] array) {
    double[] d = new double[array.length];
    for (int i = 0; i < array.length; i++) {
      d[i] = array[i];
    }
    return average(d);
  }

  public static double average(double[] array) {
    double sum = 0.0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }
    return sum / array.length;
  }
}
